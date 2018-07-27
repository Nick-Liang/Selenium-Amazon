package au.com.beutii.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;

public class GettingStartedPage_PO extends BasePageObject {
	public GettingStartedPage_PO(WebDriver driver) {
		super(driver);

	}

	//Updated xpath 11/30/2016
	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_chkIsMedicare']")
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_chkIsMedicare']")
	public WebElement chkMedicare;
	
	//Updated xpath 11/30/2016
	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_chkIsMember']")
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_chkIsMember']")
	public WebElement chkMember;


	@FindBy(how=How.XPATH, using=".//*[@id='ctl00_cphMainContent_lknGSNext']")
	public WebElement getStartedLink;
	
	//@FindBy(how=How.XPATH, using="//div[@class='guideRadioButtonItem guideFieldHorizontalAlignment  isMember']/div/input[@aria-label='NO']")
	@FindBy(how=How.XPATH, using="//div[@class='guideRadioButtonItem guideFieldHorizontalAlignment  yd_ismember']/div/input[@aria-label='NO']")
	public WebElement selIsMember;
	
	@FindBy(how=How.XPATH, using="//div[@class='guideRadioButtonItem guideFieldHorizontalAlignment  yd_all_listed_in_medicare']/div/input[@aria-label='YES']")
	public WebElement selMedicare;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'guideFieldNode  guideTextBox yd_email')]/div/input[@type='email']")
	public WebElement emailAddress;
	
	@FindBy(how=How.XPATH, using="//div[@class='guideRadioButtonItem guideFieldHorizontalAlignment  yd_stay_intouch']/div/input[@aria-label='YES']")
	public WebElement selStayTouch;	

	@FindBy(how=How.XPATH, using="//a[@id='getting-started-step-cta']/span[@class='btn-txt navNextButton']")
	public WebElement contToPersonalDetails;


	public void IsGettingStartedpageloaded(){
		WDUtil.waitNewWindow(driver, "Getting started");
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ctl00_cphMainContent_lknGSNext']")));		
	}

	public void chkIsMedicare() {
		WDUtil.sleep(500);		
		chkMedicare.click();		
	}

	public void chkIsMember() {
		//WebElement chkrebpolicy = driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_ucGovtRebate_rbtnIsCovered_0']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chkMember);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(chkMember));	
		chkMember.click();		
	}

	public void clickGetstartedButton() {
		WDUtil.sleep(500);
		getStartedLink.click();
	}
	
	//Functions for new application form
	
	public void newIsGettingStartedpageloaded(){
				
		(new WebDriverWait(driver, 2000))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='guideRadioButtonItem guideFieldHorizontalAlignment  yd_ismember']")));		
	}
	
	public void selectIsMember() {
		
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(selIsMember));	
		selIsMember.click();		
	}
	
	public void selectIsMedicare() {
		WDUtil.sleep(500);		
		selMedicare.click();		
	}
	
	public void enterEmail() {
		WDUtil.sleep(500);		
		emailAddress.sendKeys("jthumati@hcf.com.au");
		emailAddress.sendKeys(Keys.TAB);
		WDUtil.sleep(2000);
	}
	
	public void selectStayInTouch() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selStayTouch);
		WDUtil.sleep(2000);		
		selStayTouch.click();		
	}

	public void clickContinueToPersonalBtn() {
		WDUtil.sleep(500);
		contToPersonalDetails.click();
	}
}


