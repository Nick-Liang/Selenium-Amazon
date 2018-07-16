package au.com.hcf.testframework.webportal;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.selenium.base.BasePageObject;

public class EAPP_Client_PO extends BasePageObject{

	public EAPP_Client_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//input[@id='GetAgentDetails_AgentId']")
	public WebElement AgenId;
	
	@FindBy(how=How.XPATH, using="//input[@id='GetAgentDetails_DealCode']")
	public WebElement DealCode;
	
	@FindBy(how=How.XPATH, using="//input[@id='GetAgentDetails_Password']")
	public WebElement Password;
	
	@FindBy(how=How.XPATH, using="//input[@id='GetAgentDetails_AgentCustomerId']")
	public WebElement AgentcustId;
	
	@FindBy(how=How.XPATH, using="//input[@id='GetAgentDetails_AgentPaymentId']")
	public WebElement AgentPaymentId;	
	
	@FindBy(how=How.XPATH, using="//input[@id='GetClientDetails_GivenName']")
	public WebElement firstName;	
	
	@FindBy(how=How.XPATH, using="//input[@id='GetClientDetails_Surname']")
	public WebElement surName;	
	
	@FindBy(how=How.XPATH, using="//input[@id='GetClientDetails_DOB']")
	public WebElement clientDOB;	
	
	@FindBy(how=How.XPATH, using="//input[@id='GetClientDetails_EmailAddress']")
	public WebElement emailAddress;	
	
	@FindBy(how=How.XPATH, using="//input[@name='btnGenerateAndCallEAPP']")
	public WebElement generateBtn;
		
	@FindBy(how=How.XPATH, using="//td[@id='resultIcon']/img[contains(@src,'small-green-check')]")
	public WebElement successMsg;	
	
	public void setAgentId(String SagentId) {

		WDUtil.sleep(1000);	
		AgenId.clear();
		AgenId.sendKeys(SagentId);
	}
	
	public void setDealCode(String SdealCode) {

		WDUtil.sleep(1000);	
		DealCode.clear();
		DealCode.sendKeys(SdealCode);
	}	
	
	public void setPassword(String Spassword) {

		WDUtil.sleep(1000);	
		Password.clear();
		Password.sendKeys(Spassword);
	}
	
	
	public void setAgentCustId(String SagentCustId) {

		WDUtil.sleep(1000);	
		AgentcustId.clear();
		AgentcustId.sendKeys(SagentCustId);
	}
	
	public void setAgentPaymentId(String SAgentPaymentId) {

		WDUtil.sleep(1000);	
		AgentPaymentId.clear();
		AgentPaymentId.sendKeys(SAgentPaymentId);
	}
	
	public void setGivename() {
		firstName.clear();
		String fName = RandomStringUtils.randomAlphabetic(6);
		firstName.sendKeys("Test "+fName);
	}

	public void setSurname() {
		surName.clear();
		String sName = RandomStringUtils.randomAlphabetic(4);
		surName.sendKeys("Test "+sName);
	}
	
	public void setDOB() {

		WDUtil.sleep(1000);	
		clientDOB.clear();
		Random rand = new Random();
		int randomYear = 1940 + rand.nextInt((2000 - 1940) + 1);
		int randomDate = 1 + rand.nextInt((28 - 1) + 1);		
		int randomMonth = 1 + rand.nextInt((12 - 1) + 1);
			
		
		String DOB = String.valueOf(randomDate)+String.valueOf(randomMonth)+String.valueOf(randomYear);
		clientDOB.sendKeys(DOB);
		clientDOB.sendKeys(Keys.TAB);
		
		
	}
	
	public void setEmailAddress(String email) {

		WDUtil.sleep(1000);	
		emailAddress.clear();
		emailAddress.sendKeys(email);
		WDUtil.sleep(1000);
	}
	
	public void clickGenerateButton() {	
		WDUtil.sleep(1000);
		generateBtn.click();
		WDUtil.sleep(5000);
	}	
	
	
	public Boolean validateSuccessMsg() {
		
		new WebDriverWait(driver, 4000)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='resultIcon']")));
		Boolean result = driver.findElement(By.xpath("//td[@id='resultIcon']/img[contains(@src,'small-green-check')]")).isDisplayed();
		return result;
	}	
	
	
}
