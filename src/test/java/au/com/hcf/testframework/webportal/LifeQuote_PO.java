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

public class LifeQuote_PO extends BasePageObject{

	public LifeQuote_PO(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ctl00_ctl05_rdoTypeSingle']")
	public WebElement cashBackTypeSingle;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ctl00_ctl05_rdoTypeFamily']")
	public WebElement cashBackTypeFamily;
	
	@FindBy(how=How.XPATH, using="//a[@id='ctl00_cphMainContent_ctl00_ctl05_cmdCalculate']")
	public WebElement cashBackCalculateQuote;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'popupHeaderSummary')]")
	public WebElement myQuoteSummaryPopup;
	
	@FindBy(how=How.XPATH, using="//a[@id='ctl00_cphMainContent_ctl00_ctl05_lnkEmailQuote']")
	public WebElement emailQuoteBtn;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ctl00_ctl05_txtEmail']")
	public WebElement emailAddress;
	
	@FindBy(how=How.XPATH, using="//a[@id='ctl00_cphMainContent_ctl00_ctl05_lnkSendQuote']")
	public WebElement sendQuoteBtn;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'ThankYouQuote')]/div/p/strong")
	public WebElement emailConfirmMsg;

	public void clickOnGetaQuoteButton() {
		WebElement getaQuoteButton = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='lnkQuoteProduct']")));
		getaQuoteButton.click();
	}
	
	public void validateMyQuotePopup() {
		String text = driver.findElement(By.xpath("//div[@class='title' and contains(text(), 'My quote')]")).getText();
		Assert.assertEquals("My Quote", text);	
	}
	
	public void selectCoverType(String coverType) {
		if(coverType.equalsIgnoreCase("single")){
			cashBackTypeSingle.click();
		}
		else if(coverType.equalsIgnoreCase("family")){
			cashBackTypeFamily.click();
		}
	}
	
	public void clickCalculateQuoteBtn() {
		cashBackCalculateQuote.click();
	}
	
	public void validateQuoteSummary(String totalPremium) {
		WDUtil.sleep(1000);
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='quoteSummary']")));
		
		String actualTotalPremium = driver.findElement(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_ctl05_divPriceTotal']/span[@class='dollar priceBox']")).getText();
		System.out.println(actualTotalPremium);
		
		Assert.assertEquals(totalPremium, actualTotalPremium);		
	}
	
	public void validateQuoteSummaryPopup() {
		WDUtil.sleep(1000);
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='quoteSummary']")));		
		
		Assert.assertEquals("My Quote Summary", myQuoteSummaryPopup.getText());		
	}
	
	public void clickEmailQuote() {
		emailQuoteBtn.click();
	}
	
	public void enterEmail() {
		WDUtil.sleep(1000);
		emailAddress.sendKeys("jthumati@hcf.com.au");
	}
	
	public void clickSendEmailBtn() {
		sendQuoteBtn.click();
		WDUtil.sleep(1000);
	}
	
	public void validateEmailConfirmationMsg() {		
		WDUtil.sleep(1000);
		(new WebDriverWait(driver, 40))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Email quote')]")));		
		
		Assert.assertEquals("Your quote has been sent to the email address provided", emailConfirmMsg.getText());		
	}
	
}
