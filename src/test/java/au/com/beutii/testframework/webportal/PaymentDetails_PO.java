//Author : Satheesh Marripudi			
package au.com.beutii.testframework.webportal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;

public class PaymentDetails_PO extends BasePageObject{

	public PaymentDetails_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_rbtPaymentType_0']")
	public WebElement creditCardOption;


	public void checkPaymentPageLoaded()
	{
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_rbtPayToday_0']")));
		System.out.println("Payment Details form loaded");

	}

	public void selectpaymentMethod(){
		//driver.findElement( By.xpath("//input[@id='ctl00_cphMainContent_rbtPaymentType_0']")).click();
	}

	@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlTypeOfCard']")
	//@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlOneOffCardType']")
	public WebElement selectCardType;

	public void selectCardType(String cardtype)
	{
		WDUtil.sleep(2000);
		/*selectCardType.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlTypeOfCard']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlTypeOfCard']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(cardtype)){
				element.click();
				break;
			}
		}*/
		
		Select oSelectCardType = new Select(selectCardType);
		oSelectCardType.selectByVisibleText(cardtype);		
	}


	//@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ddlCCFrequency']")
	@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlCCFrequency']")
	public WebElement selectDebitFrequencer;

	public void selectDebitFrequency(String debitfrequency) {
		(new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='ctl00$cphMainContent$ddlCCFrequency']")));
		/*selectDebitFrequenecr.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCFrequency']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCFrequency']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(debitfrequency)){
				element.click();
				break;
			}
		}*/
		Select oSelectDebtFreq = new Select(selectDebitFrequencer);
		oSelectDebtFreq.selectByVisibleText(debitfrequency);		
	}	


	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtRegularPaymentDate']")
	public WebElement selectnominatedDebitDay;

	public void selectnominatedDebitDay() {
		WDUtil.sleep(2000);
		/*selectnominatedDebitDay.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCBillingDay']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCBillingDay']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(debitday)){
				element.click();
				break;
			}
		}*/
		DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");

		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, 5);
		
		String date1 =  dateFormat.format(c.getTime());
		System.out.println(date1);
		
		selectnominatedDebitDay.sendKeys(date1);
		WDUtil.sleep(500);
		selectnominatedDebitDay.sendKeys(Keys.TAB);
		WDUtil.sleep(500);
	}	

	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtOneOffCardName']")
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtCardName']")
	public WebElement cardHolderName;

	public void setCardHolderName(String cardholdername) {
		WDUtil.sleep(1000);
		cardHolderName.clear();
		cardHolderName.sendKeys(cardholdername);
	}

	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtOneOffCardNumber']")
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtCardNumber']")
	public WebElement cardHolderNumber;

	public void setCardHolderNumber(String cardholdernumber){
		cardHolderNumber.clear();
		cardHolderNumber.sendKeys(cardholdernumber);
	}

	//@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlOneOffExpiryMonth']")
	@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlCCExpMonth']")	
	public WebElement creditCardExpiryMonth;

	public void setCreditCardExpiryMonth(String cardexpirymm) {
		WDUtil.sleep(2000);
		/*creditCardExpiryDate.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCExpMonth']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(1000);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCExpMonth']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(cardexpirymm)){
				element.click();
				break;
			}
		}*/
		Select oSelectCardExpMonth = new Select(creditCardExpiryMonth);
		oSelectCardExpMonth.selectByVisibleText(cardexpirymm);
	}

	//@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlOneOffExpiryYear']")
	@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlCCExpYear']")
	public WebElement creditCardExpiryYear;

	public void setCreditCardExpiryYear(String cardexpiryyy) {
		WDUtil.sleep(2000);
		/*creditCardExpiryYear.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCExpYear']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ddlCCExpYear']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(cardexpiryyy)){
				element.click();
				break;
			}
		}*/
		Select oSelectCardExpYear = new Select(creditCardExpiryYear);
		oSelectCardExpYear.selectByVisibleText(cardexpiryyy);

	}


	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_rbtPayToday_1']")
	public WebElement creditCardPaymentFirstMOnth;

	public void selectCreditforFirstMonthPay(){
		creditCardPaymentFirstMOnth.click();
	}
/////////////////////////////////////////////////////////////
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_rbtPayToday_0']")
	public WebElement creditCardPaynow;

	public void selectPaynow(){
		creditCardPaynow.click();
	}	

	
	@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlOneOffCardType']")
	public WebElement selectCardTypePayNow;

	public void payNowSelectCardType(String cardtype)
	{
		WDUtil.sleep(2000);				
		
		Select oSelectCardType = new Select(selectCardTypePayNow);
		oSelectCardType.selectByVisibleText(cardtype);		
	}

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtOneOffCardName']")
	public WebElement cardHolderNamePayNow;

	public void payNowSetCardHolderName(String cardholdername) {
		WDUtil.sleep(1000);
		cardHolderNamePayNow.clear();
		cardHolderNamePayNow.sendKeys(cardholdername);
	}

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtOneOffCardNumber']")	
	public WebElement cardHolderNumberPayNow;

	public void paynowSetCardHolderNumber(String cardholdernumber){
		cardHolderNumberPayNow.clear();
		cardHolderNumberPayNow.sendKeys(cardholdernumber);
	}

	@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlOneOffExpiryMonth']")	
	public WebElement creditCardExpiryMonthPayNow;

	public void payNowSetCreditCardExpiryMonth(String cardexpirymm) {
		WDUtil.sleep(2000);		
		Select oSelectCardExpMonth = new Select(creditCardExpiryMonthPayNow);
		oSelectCardExpMonth.selectByVisibleText(cardexpirymm);
	}

	@FindBy(how=How.XPATH, using="//select[@name='ctl00$cphMainContent$ddlOneOffExpiryYear']")	
	public WebElement creditCardExpiryYearPayNow;

	public void payNowSetCreditCardExpiryYear(String cardexpiryyy) {
		WDUtil.sleep(2000);
		
		Select oSelectCardExpYear = new Select(creditCardExpiryYearPayNow);
		oSelectCardExpYear.selectByVisibleText(cardexpiryyy);

	}	
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtOneOffCVV']")
	public WebElement cardCCVPayNow;

	public void payNowSetCreditCardCVV(String cardCCV) {
		WDUtil.sleep(1000);
		cardCCVPayNow.clear();
		cardCCVPayNow.sendKeys(cardCCV);
	}
	
	////////////////////////////////////////////////////////////////////////
	
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_rbtPaymentType_1']")
	public WebElement selectPayByEzipay;
	
	@FindBy(how=How.XPATH, using="//label[@id='ctl00_cphMainContent_lblIsEziPayAuthorised']")
	public WebElement EzipayAuthorisation;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtEziAccountName']")
	public WebElement accountName;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtEziAccountNumber']")
	public WebElement accountNumber;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_txtEziBSB']")
	public WebElement accountBSB;

	public void enterEzipayAccountDetails(){
		selectPayByEzipay.click();
		WDUtil.sleep(1000);
		EzipayAuthorisation.click();
		accountName.sendKeys("Test");
		accountNumber.sendKeys("1234568954");
		accountBSB.sendKeys("082133");
	}
	
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_rbtpayIntoBankAccount_0']")
	public WebElement claimsPaidIntoAccount;

	public void selectClaimsPaidintoAccount(){
		claimsPaidIntoAccount.click();
	}
	
	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_rbtpayIntoBankAccount_1']")
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_rbtpayIntoBankAccount_1']")
	public WebElement nominatebankAccount;

	public void selectnominateYourBankAccount(){
		nominatebankAccount.click();
	}


	public void authorisePayment() {
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//label[@id='ctl00_cphMainContent_lblIsAuthorised']")).click();
	}

	public void clickContinueOnPaymentDetails() {
		WDUtil.sleep(2000);
		driver.findElement(By.xpath("//a[@id='ctl00_cphMainContent_lknPayNext']")).click();
		WDUtil.sleep(5000);
		//driver.close();
	}
	
	public void checkJoiningMessage()
	{
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='ctl00_cphMainContent_spmWelcomeMsg']")));
		System.out.println("Member join is successful");
		
		String memberNum = driver.findElement(By.xpath("//span[@id='ctl00_cphMainContent_spnClientNumber']")).getText();
		System.out.println("Member number"+memberNum);
		
	}

}