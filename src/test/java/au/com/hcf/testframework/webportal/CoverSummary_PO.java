package au.com.hcf.testframework.webportal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.WDUtil;


public class CoverSummary_PO extends BasePackageStepObject{

	public CoverSummary_PO(WebDriver driver) {
		super(driver,"summary-step");
	}

	@FindBy(how=How.XPATH, using="//select[@ng-model='steps.familyStatus']")
	public WebElement familyStatus;

	public void clickNextOnExcessSection(){
		driver.findElement(By.xpath("//a[@ng-click='steps.showSummaryStep($event)']")).click();
	}

	public Boolean IsCoverSummaryPageDisplayed(){
		return driver.findElement(By.xpath("//div[contains(@class,'total-cost')]")).isDisplayed();

	}

	public void validateRebateOnCoverSummary(){

		//String  rebateActual=driver.findElement(By.xpath("//div[@class='step-container result']/div[2]/h4[1]/span[2]")).getText();
		//11/30/16 Updated xpath
		String  rebateActual=driver.findElement(By.xpath("//div[@class='step-container result']/section/div/div[2]/h4[1]/span")).getText();
		System.out.println("rebateActual :" + rebateActual);
		if(rebateActual.trim().equals("23.184%"))
		{
			System.out.println("Rebate matching");
		}
		else
		{
			System.out.println("Rebate wrongly dispying on Sumary");
		}

	}

	public void validateHospitalexcessOnCoverSummary(){
		String  hospitalExcess=driver.findElement(By.xpath("//div[@class='step-container result']/div[2]/h4[2]/span[1]")).getText();
		System.out.println("Hospital Excess is:" + hospitalExcess);
		if(hospitalExcess.trim().equals("$500"))
		{
			System.out.println("hospital Excess on Cover summary matching");
		}
		else
		{
			System.out.println("hospital Excess on Cover summary Not  matching");
		}
	}

	@Override public void clickNextButton() {
		this.clickButton("Continue");
	};
	
	public void verifyPurchasePagelanding() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Purchase")));
		System.out.println("Purchase page dispayed");
	}

	public void clickPurchaseLink() {
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Purchase")));
		myDynamicElement.click();
	}

	public void clickEmailinQuote(){

		driver.findElement(By.linkText("Email quote")).click();
	}

	public void clickSendButtonOnEmailQuote() {
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div/div[1]/form/button")).click();
		WDUtil.sleep(2000);

	}

	private Pattern p = Pattern.compile("\\$([1234567890\\.,]+)");
	private String getPriceElement(int index){
		// //div[@class='row-result-content']/div[@class='column'][1]
		for(int ii=0; ii<3; ii++){
			String str = driver.findElement(By.xpath(panelXPath+"/descendant::div[@class='row-result-content']/div[@class='column']["+index+"]")).getText();
			Matcher matcher = p.matcher(str);
			if(matcher.find()){
				return matcher.group(1);
			}
			WDUtil.sleep(500); //animation :(
		}
		return "";
	}
	public String getBasePrice() {
		return getPriceElement(1);
	}

	public String getExtrasPrice() {
		return getPriceElement(2);
	}

	public String getSummaryPrice() {
		return getPriceElement(3);
	}

	public void verifyPurchageButton() {
		
		Boolean isPresent = driver.findElements(By.xpath("//div[@class='content']/a[contains(@class,'button') and contains(text(),'Purchase')]")).size() > 0;
		Assert.assertTrue(isPresent);
		if (isPresent){
			System.out.println("Purchage button is appeared on Product summary page.");			
		}else{
			System.out.println("Purchage button is NOT appeared on Product summary page.");
		}
	}
	
	
}



//Author : Satheesh Marripudi