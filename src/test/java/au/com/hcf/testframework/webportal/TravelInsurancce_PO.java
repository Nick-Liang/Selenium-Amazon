package au.com.hcf.testframework.webportal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.selenium.base.BasePageObject;


public class TravelInsurancce_PO extends BasePageObject{

	public TravelInsurancce_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//div[@class='row-component' and div[@class='row-header']/h2[contains(text(),'Travel insurance plans')]]")
	public WebElement travelInsurancePlansPanel;
	
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'Annual multi-trip')]/parent::div//a[contains(text(),'Get a quote')]")
	public WebElement travelGetaQuoteBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-travel']")
	public WebElement travelAlert;
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-travel']//a[@id='modal-member-yes']")
	public WebElement alertYesBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-travel']//input[@id='membernumber']")
	public WebElement alertInputMemberNum;
	
	@FindBy(how=How.XPATH, using="//div[@id='member-validation']/button")
	public WebElement alertGetaQuoteBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='getQuote']//p[contains(@class,'sectiontitle')]")
	public WebElement travelQBEgetaQuote;
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-travel']//a[@id='modal-member-no']")
	public WebElement alertNoBtn;
	
	@FindBy(how=How.XPATH, using="//span[@id='membership-number-error-message']")
	public WebElement invalidMemberErrorMsg;

	public boolean selectTravelInsurance() {
		return travelInsurancePlansPanel.isDisplayed();
	}
	
	public void clickOnGetaQuoteButton()
	{		
		travelGetaQuoteBtn.click();  
		WDUtil.sleep(1000);
	}
	
	public boolean validateTravelAlertwindow()
	{
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-travel']"))); 
		return travelAlert.isDisplayed();
	}
	
	public void alertSelectYes()
	{	
		alertYesBtn.click();  
	}
	
	public void alertEnterMemberNum(String memberNum)
	{		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='modal-travel']//input[@id='membernumber']")));  
		alertInputMemberNum.sendKeys(memberNum);		
		alertGetaQuoteBtn.click();
	}
	
	public void validateTravelMemberQBEpage()
	{		
		WDUtil.waitNewWindow(driver, "HCF Members");
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='getQuote']"))); 
		
		Assert.assertEquals("HCF Members - Diamond", driver.getTitle());
		
		Assert.assertEquals("Get a Quote: Annual multi trip", travelQBEgetaQuote.getText());
		driver.close();
		
		WDUtil.waitNewWindow(driver, "Travel insurance | HCF");
		
		WDUtil.sleep(1000);
	}
	
	public void alertSelectNo()
	{		
		alertNoBtn.click();  
	}
	
	public void validateTravelPublicQBEpage()
	{	
		WDUtil.waitNewWindow(driver, "HCF Public Site");
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='getQuote']"))); 
		
		//Assert.assertEquals("HCF Public Site", driver.getTitle());
		
		Assert.assertEquals("Get a Quote: Annual multi trip", travelQBEgetaQuote.getText());
		driver.close();
		
		WDUtil.waitNewWindow(driver, "Travel insurance | HCF");	
		
		WDUtil.sleep(1000);
	}
	
	public void validateTravelNonMemberErrorMsg(){
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='membership-number-error-message']")));		
		
		Assert.assertEquals("Please enter a valid membership number. If you require assistance, please call 13 13 34.", invalidMemberErrorMsg.getText());		
		
	}
}
