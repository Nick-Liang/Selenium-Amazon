package au.com.hcf.testframework.webportal.steps;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.webportal.batchprice.BatchPriceTable;
import au.com.hcf.testframework.webportal.batchprice.BatchPriceTableRow;
import au.com.hcf.testframework.webportal.batchprice.BatchPriceTableRow.Status;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.jayway.restassured.RestAssured.*;


public class PathToPurchaseRest_steps extends StepsBase{
	private static final String BATCH_PRICE_TABLE = "BATCH_PRICE_TABLE";

	@Given("all combination of prices are loaded from \"(.*)\"")
	public void givenBatchPriceTableIsLoaded(String fileName) throws UnsupportedEncodingException{
		URL fileUrl = this.getClass().getResource("/"+fileName);
		File f = new File( URLDecoder.decode( fileUrl.getFile(), "UTF-8" ) );
        ctx().put(BATCH_PRICE_TABLE, new BatchPriceTable(f.getAbsolutePath()));
	}

	@When("webservice calls executed, all prices match with preloaded")
	public void whenWebServiceIsCalledForAllParameterCombinationosFromBatchPriceTable(){
		BatchPriceTable batchPriceTable = ctx().get(BATCH_PRICE_TABLE, BatchPriceTable.class);
		HashSet<String> callsHistory = new HashSet<String>();
		
		String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL()+"/hcf/pathToPurchase";
		BatchPriceTableRow row;
		int counter=0;
		while( (row = batchPriceTable.getNextNew())!=null){
			//get parameters
			String pathToPurchase="mix-and-match";
			//bundleId=11: https://www.uat2.hcf.com.au/hcf/pathToPurchase?pathToPurchaseType=ambulance-only&rebateCode=RB&scaleCode=S&stateCode=N
			if(row.hcfBundleId.equals("11")){
				pathToPurchase="ambulance-only";
			}if(row.hcfBundleId.equals("98")){
				pathToPurchase="help-me-choose";
			}
			String paramsHash = "pathToPurchaseType="+pathToPurchase+";rebateCode="+row.rebateCode+";scaleCode="+row.scaleCode+";stateCode="+row.stateCode;
			//do call
			if(!callsHistory.contains(paramsHash)){
				callsHistory.add(paramsHash);
				System.out.println("Calling pathToPurchase service "+(++counter)+": "+paramsHash);
				RequestSpecification request = given()
						.contentType(ContentType.JSON)
						.param("needs", "all")
						.param("pathToPurchaseType", pathToPurchase)
						.param("rebateCode", row.rebateCode.isEmpty() ? "3D" : row.rebateCode)
						.param("scaleCode", row.scaleCode)
						.param("stateCode", row.stateCode);
				String jsonString = request.get(url).asString();
				
				//parse response to row list
				List<BatchPriceTableRow> actualPrices = parseJsonPricesToRows(
								jsonString, 
								row.rebateCode, 
								row.scaleCode,
								row.stateCode
							);
				//compare batchPriceTable with rows received from 
				batchPriceTable.compare(actualPrices, new String[]{url,paramsHash});
			}
		}
		System.out.println("Number of REST calls executed in the test: "+callsHistory.size());
	}

	private List<BatchPriceTableRow> parseJsonPricesToRows(String jsonString, String rebateCode, char scaleCode,
			char stateCode) {
		ArrayList<BatchPriceTableRow> actualPrices = new ArrayList<BatchPriceTableRow>();
		try {
			JSONObject root = new JSONObject(jsonString);
			for(String priceSections : new String[]{"packageMapping","products"}){
				JSONArray packageMapping = root.getJSONArray(priceSections);
				for(int i=0; packageMapping!=null && i<packageMapping.length(); i++){
					JSONObject pack = packageMapping.getJSONObject(i);
					String hcfBundleId = pack.getString("hcfBundleId");
					if(pack.has("prices")){
						JSONArray prices = pack.getJSONArray("prices");
						for(int j=0; j<prices.length(); j++){
							JSONObject priceJSON = prices.getJSONObject(j);
							char excessCode = BatchPriceTableRow.exessCodeChar(priceJSON.getString("excessCode"));
							BigDecimal price = new BigDecimal(priceJSON.getString("price"));
							BatchPriceTableRow row = new BatchPriceTableRow(hcfBundleId, null, null, excessCode, stateCode, scaleCode, rebateCode, price, Status.ACTUAL);
							actualPrices.add(row);
							row.addComment(priceSections+":{"+pack.toString()+"}");
						}
					}
				}
			}
		}catch (JSONException e) {
			System.out.println("unexpected exception on parsing: "+jsonString);
			e.printStackTrace();
		}
		return actualPrices;
	}

	@Then("there is no uncovered prices in source file")
	public void verifyComparisonResults(){
		BatchPriceTable batchPriceTable = ctx().get(BATCH_PRICE_TABLE, BatchPriceTable.class);
		//report on results of BatchPriceTable comparison
		int matched=0, actual=0, mismatched=0, not_covered=0, other=0;
		for(BatchPriceTableRow row : batchPriceTable.getRowList()){
			if(row.getStatus()==Status.MISMATCH){
				System.err.println(row.toString());
				mismatched++;
			}else if(row.getStatus()==Status.NEW){
				System.out.println(row.toString());
				not_covered++;
			}else if(row.getStatus()==Status.MATCH){
				matched++;
			}else if(row.getStatus()==Status.ACTUAL){
				System.out.println(row.toString());
				actual++;
			}else{
				other++;
			}
		}

		System.out.println(
				"Matched:"+matched+
				", mismatched:"+mismatched+
				", not covered in this test (NEW - need to be verified manually)"+not_covered+
				", prices without prototype in batchPricig table:"+actual+
				", other:"+other
			);
		
		Assert.assertEquals("All prices should be verified and match", 0, mismatched);
	}
}
