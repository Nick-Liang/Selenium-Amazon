package au.com.beutii.testframework.webportal.steps;

import java.math.BigDecimal;

import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.selenium.WDUtil;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.webportal.BasicDetails_PO;
import au.com.beutii.testframework.webportal.CoverSummary_PO;
import au.com.beutii.testframework.webportal.ExcessCover_PO;
import au.com.beutii.testframework.webportal.HospitalCover_PO;
import au.com.beutii.testframework.webportal.PackagesExcessCover_PO;
import au.com.beutii.testframework.webportal.PackagesHospitalCover_PO;
import au.com.beutii.testframework.webportal.RebatePage_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PathToPurchase_steps extends StepsBase {

	@Given("^user open health insurance get-a-guote page on \"([^\"]+)\"$")
	public void userOpenHelathInsuranceGetAQuoatePaqe(String product) {
		String full_url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL()+"/insurance/health/get-a-quote/"+product;
		getWD().get(full_url);
		//get the page
		ctx().put(PageFactory.initElements(getWD(), BasicDetails_PO.class)).synchronise();
	}

    @Given("user select insurance with \"([^\"]+)\" in \"([^\"]+)\" for \"([^\"]+)\" taxed \"([^\"]+)\" with \"([^\"]+)\" on \"([^\"]+)\"")
    public void iSelectInsurance(String cover, String location, String ageGroup, String taxAs, String income, String tier){
    	BasicDetails_PO basicDetails = ctx().get(BasicDetails_PO.class);
    	//fill base details
		basicDetails.selectCoverageType(cover);
		basicDetails.selectLocation(location);
		basicDetails.selectAge(ageGroup);
		basicDetails.clickNextButton();
		WDUtil.sleep(1000);
		//
		RebatePage_PO rebatePage = ctx().put(PageFactory.initElements(getWD(), RebatePage_PO.class));
		rebatePage.synchronise();
		rebatePage.selectRegisteredAs(taxAs);
		rebatePage.selectAnnualIncome(income);
		rebatePage.selectTier(tier); //TODO: Nikolay find if it's ever selectable (rebate in similar UI element is 
		rebatePage.clickNextButton();
		WDUtil.sleep(2000);
		
    }
    
    //---------------------------------
    @Given("^user select \"([^\"]*)\"$")
    public void user_select(String packageType){
    	
    	HospitalCover_PO hospitalCover = ctx().put(PageFactory.initElements(getWD(), HospitalCover_PO.class));
    	hospitalCover.synchronise();    	
    	hospitalCover.selectPackageType(packageType);    	
    	hospitalCover.clickNextButton();  	
    	
    }
    
    @When("^user select \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_select_and(String healthPackage, String excess) {
    	
    	PackagesHospitalCover_PO packageHospitalCover = ctx().put(PageFactory.initElements(getWD(), PackagesHospitalCover_PO.class));
    	packageHospitalCover.synchronise();
    	packageHospitalCover.selectHospitalPackageCover(healthPackage);	
    	WDUtil.sleep(2000);
    	packageHospitalCover.clickNextButton();
    	
		PackagesExcessCover_PO excessPO = ctx().put(PageFactory.initElements(getWD(), PackagesExcessCover_PO.class));
		excessPO.synchronise();
		excessPO.selectExcess(excess);
		WDUtil.sleep(2000);
		excessPO.clickNextButton();
       
    }    
    //--------------------------------------
    
    @When("user select \"([^\"]+)\" with \"([^\"]+)\" and \"([^\"]+)\"") 
    public void userSelect(String product, String extra, String excess){
		//
    	HospitalCover_PO hospitalCover = ctx().put(PageFactory.initElements(getWD(), HospitalCover_PO.class));
    	hospitalCover.synchronise();    	
    	hospitalCover.selectHospitalCover(product);
    	WDUtil.sleep(1000);
		hospitalCover.selectExtraCover(extra);
		WDUtil.sleep(1000);
		hospitalCover.clickNextButton();
    	//
		ExcessCover_PO excessPO = ctx().put(PageFactory.initElements(getWD(), ExcessCover_PO.class));
		excessPO.synchronise();
		excessPO.selectExcess(excess);
		excessPO.clickNextButton();
    }
    
    @Then("price is \"([^\"]+)\", \"([^\"]+)\" plus \"([^\"]+)\"")
    public void priceIs(String totalPrice, String basePrice, String extrasPrice){
		CoverSummary_PO coverSummary = ctx().put(PageFactory.initElements(getWD(), CoverSummary_PO.class));
		coverSummary.synchronise();
		BigDecimal basePriceOnPage = new BigDecimal(coverSummary.getBasePrice());
		BigDecimal extrasPriceOnPage = new BigDecimal(coverSummary.getExtrasPrice());
		BigDecimal totalPriceOnPage = new BigDecimal(coverSummary.getSummaryPrice());
		
		BigDecimal basePriceExpected = new BigDecimal(basePrice);
		BigDecimal extrasPriceExpected = new BigDecimal(extrasPrice);
		BigDecimal totalExpected = new BigDecimal(totalPrice);
		
		if(totalExpected.intValue()==0){
			totalExpected = extrasPriceExpected.add(basePriceExpected);
		}
		
		if(basePriceExpected.intValue()==0 && extrasPriceExpected.intValue()==0){
			//0 meens they are not specified and we don't verify them
		}else{
			Assert.assertTrue("Base cover matches with expected", basePriceExpected.compareTo(basePriceOnPage) == 0);
			Assert.assertTrue("Extra cover matches with expected", extrasPriceExpected.compareTo(extrasPriceOnPage) == 0);
		}
		//Commented for DP warmup scripts 12/14/2016 - kbg
		//Assert.assertTrue("Total matches with expected", totalExpected.compareTo(totalPriceOnPage) == 0);
    }   
    
 // 	|customise-cover|single cover|nsw     |under 65 |family|< $180,001|none|Basic Hospital|Bronze Extra|$500  |$34       |$5         |
   
}
