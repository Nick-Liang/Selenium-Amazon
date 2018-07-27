package au.com.beutii.testframework.webportal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;

public class PetInsuranceQuote_PO extends BasePageObject{

	public PetInsuranceQuote_PO(WebDriver driver) {
		super(driver);
	}
			
	@FindBy(how=How.XPATH, using="//a[@id='ctl00_cphMainContent_ctl00_ctl05_lnkEmailQuote']")
	public WebElement emailQuoteBtn;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ctl00_ctl05_txtEmail']")
	public WebElement emailAddress;	
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-pet']")
	public WebElement petlAlert;
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-pet']//a[@id='modal-member-yes']")
	public WebElement alertYesBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-pet']//input[@id='membernumber']")
	public WebElement alertInputMemberNum;
	
	@FindBy(how=How.XPATH, using="//div[@id='member-validation']/button")
	public WebElement alertGetaQuoteBtn;

	public void clickOnGetaQuoteButton() {
		WebElement getaQuoteButton = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button button-box primary icon-right       modal-pet-open fn_modal_open']")));
		getaQuoteButton.click();
		WDUtil.sleep(1500);
	}	
	
	public void validatePetsurePage() {		
		
		//Validate Petsure URL
		WDUtil.waitNewWindow(driver, "https://hcfquotetool.petsure.com.au/");
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		String expURL ="https://hcfquotetool.petsure.com.au/";
				    		    
		Assert.assertEquals(expURL,currentURL);
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//main[@id='step-1']/form/fieldset[1]/h3")));
		
		String actualText = driver.findElement(By.xpath("//main[@id='step-1']/form/fieldset[1]/h3")).getText().trim();
		System.out.println(actualText);
		
		Assert.assertEquals("Tell us about your pet" , actualText);		
	}
	
	public boolean validatePetAlertwindow()
	{
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-pet']"))); 
		return petlAlert.isDisplayed();
	}
	
	public void alertSelectYes()
	{	
		alertYesBtn.click();  
	}
	
	public void alertEnterMemberNum(String memberNum)
	{		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-pet']//input[@id='membernumber']")));  
		alertInputMemberNum.sendKeys(memberNum);		
		alertGetaQuoteBtn.click();
	}
	
}
