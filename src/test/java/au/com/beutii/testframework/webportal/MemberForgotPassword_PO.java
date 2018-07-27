package au.com.beutii.testframework.webportal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;


public class MemberForgotPassword_PO extends BasePageObject{

	public MemberForgotPassword_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.LINK_TEXT, using="Forgot password")
	public WebElement memberForgotPasswordlink;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtMemberShipNumber']")
	public WebElement membershipnumber;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtFirstName']")
	public WebElement memberFirtname;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtSurName']")
	public WebElement memberSurname;	

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_btnContine']")
	public WebElement continuebutton;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtSecAnswer']")
	public WebElement securityAns;	
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtPassword']")
	public WebElement password;	
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtConfirmPassword']")
	public WebElement reEntPassword;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']")
	public WebElement submitbutton;
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_lblNotification']")
	public WebElement successMsg;
	
	@FindBy(how=How.LINK_TEXT, using="Go to online member services")
	public WebElement goToMemServicesLink;
	
	@FindBy(how=How.XPATH, using="//h1[contains(@class,'page-title')]")
	public WebElement memberHome;
	
	/*@FindBy(how=How.XPATH, using="//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][3]/a")
	public WebElement settingsLink;	
	
	@FindBy(how=How.XPATH, using="//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][3]//li[1]/a")
	public WebElement SecuritySettingsLink;	*/

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtCurrentPassword']")
	public WebElement currentPassword;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtNewPassword']")
	public WebElement newPassword;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtConfirmPassword']")
	public WebElement confirmPassword;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_btnChangePassword']")
	public WebElement btnSubmitChangePassword;
	
	@FindBy(how=How.XPATH, using="//div[starts-with(@class,'login')]//h1")
	public WebElement memberLogin;
	

	public void clickMemberForgotPasswordLink()
	{
		WDUtil.waitNewWindow(driver, "HCF Member Services");
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Forgot password")));
		memberForgotPasswordlink.click();
	}

	public void inputMembershipNumber(String membernumber){

		(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtMemberShipNumber']")));	
		membershipnumber.clear();
		membershipnumber.sendKeys(membernumber);
		membershipnumber.sendKeys(Keys.TAB);
	}

	public void inputMemberFirstname(String memberFirstname)
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtFirstName']")));		
		memberFirtname.sendKeys(memberFirstname);
	}

	public void inputMemberSurname(String Surname)
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtSurName']")));		
		memberSurname.sendKeys(Surname);	
		memberSurname.sendKeys(Keys.TAB);
	}	
	
	public void selectDOBDay(String DOBday) {	
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlDay']")));
		WDUtil.sleep(1000);
		
		//driver.findElement(By.id("SSctl00_ContentPlaceHolder1_ddlDay")).click();
		driver.findElement(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlDay']")).click();
		
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlDay']/ul/li")).size();
		System.out.println("Count is : " + count);
		
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlDay']/ul/li["+ i +"]"));
			String text = element.getText();			
			if(text.equalsIgnoreCase(DOBday)){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
		
	}	
	
	
	public void selectDOBMonth(String DOBmonth) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlMonth']")));
		WDUtil.sleep(1000);
		
		driver.findElement(By.id("SSctl00_ContentPlaceHolder1_ddlMonth")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlMonth']/ul/li")).size();
		System.out.println("Count is : " + count);
		
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlMonth']/ul/li["+ i +"]"));
			String text = element.getText();			
			if(text.equalsIgnoreCase(DOBmonth)){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}
		
	
	public void selectDOBYear(String DOByear) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlYear']")));
		WDUtil.sleep(1000);
		
		driver.findElement(By.id("SSctl00_ContentPlaceHolder1_ddlYear")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlYear']/ul/li")).size();
		System.out.println("Count is : " + count);
		
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//div[@id='SSctl00_ContentPlaceHolder1_ddlYear']/ul/li["+ i +"]"));
			String text = element.getText();			
			if(text.equalsIgnoreCase(DOByear)){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}		
	}
	
	public void clickContinueButton()	{
		(new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnContine']")));
		continuebutton.click();
		WDUtil.sleep(2000);
	}
	

	public void answerSecurityQust(String arg1) {		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtSecAnswer']")));		
		securityAns.sendKeys(arg1);
	}

	public void inputNewPassword(String arg1) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtPassword']")));		
		password.sendKeys(arg1);		
	}

	public void reEnterPassword(String arg1) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtConfirmPassword']")));		
		reEntPassword.sendKeys(arg1);		
	}

	public void clickSubmitButton() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']")));
		submitbutton.click();
		WDUtil.sleep(2000);
		
	}

	public void validateSuceessMessage() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='ctl00_ContentPlaceHolder1_lblNotification']")));
		
		String msg = successMsg.getText();
		
		if(msg.equalsIgnoreCase("Your have successfully changed your password.")){
			System.out.println("Cofirmation message is appeared");
			
		}else{
			System.out.println("Cofirmation message is NOT appeared");
			
		}		
	}

	public void clickGotoOnlineMemServices() {
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='ctl00_ContentPlaceHolder1_btnSubmit']")));
		goToMemServicesLink.click();		
		WDUtil.sleep(5000);
	}

	public void validateMemberHomepage() {
		
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(@class,'page-title')]")));
		
		String pageTitle = memberHome.getText();
		if(pageTitle.equalsIgnoreCase("Member Home")){
			System.out.println("Member Home page is appeared");}
		else{
			System.out.println("Member Home page is NOT appeared");		
		}
		
	}

	public void selectSecuritySettingsOption() {		
		
		WebElement settingsLink = driver.findElement(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][3]/a"));
		//WebElement SecuritySettingsLink = driver.findElement(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][3]//li[1]/a"));
		Actions builder = new Actions(driver);
		// Move cursor to the Main Menu Element
		builder.moveToElement(settingsLink).perform();		
		WDUtil.sleep(600);	
		
		WebDriverWait wait = new WebDriverWait(driver, 800); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][3]//li[1]/a")));  // until this submenu is found
		WDUtil.sleep(2000);	
		//identify menu option from the resulting menu display and click
		WebElement menuOption = driver.findElement(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][3]//li[1]/a"));
		menuOption.click();
	}
	

	public void changePassword(String currentPWD,String newPWD) {
		
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtCurrentPassword']")));
		
		currentPassword.sendKeys(currentPWD);
		newPassword.sendKeys(newPWD);
		confirmPassword.sendKeys(newPWD);
		btnSubmitChangePassword.click();
			
	}

	public void validateMemberLoginpage() {
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[starts-with(@class,'login')]//h1")));
		
		String pageHeader = memberLogin.getText();
		if(pageHeader.equalsIgnoreCase("Member Login")){
			System.out.println("Member Login page is appeared");}
		else{
			System.out.println("Member Login page is NOT appeared");		
		}
		
	}
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_requirmemno1']")
	public WebElement enterMemberNumMsg;
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_RequiredFitxtFirstName']")
	public WebElement enterFirstNameMsg;
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_RequiredFieldtxtSurName']")
	public WebElement enterSurnameMsg;
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_RequiredFieldVDay']")
	public WebElement selectDayMsg;
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_RequiredFieldMonth']")
	public WebElement selectMonthMsg;
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_RequiredFieldVyear']")
	public WebElement selectYearMsg;
	
	public void clickContinue(){
		
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtMemberShipNumber']")));
		
		continuebutton.click();
		
		WDUtil.sleep(500);	
		
	}
	
	public void verifyBalnkFieldsMsg() {
				
		Assert.assertEquals("Verify Error message when Membership number is blank", "Please enter membership number", enterMemberNumMsg.getText());
		
		Assert.assertEquals("Verify Error message when First name is blank", "Please enter first name", enterFirstNameMsg.getText());
		
		Assert.assertEquals("Verify Error message when Surname is blank", "Please enter surname", enterSurnameMsg.getText());
		
		Assert.assertEquals("Verify Error message when day of DOB is blank", "Please select day", selectDayMsg.getText());
		
		Assert.assertEquals("Verify Error message when month od DOB is blank", "Please select month", selectMonthMsg.getText());
		
		Assert.assertEquals("Verify Error message when year of DOB is blank", "Please select year", selectYearMsg.getText());
				
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='navbar-header']/span[contains(text(),'Forgot password')]")
	public WebElement forgotPassword;
	
	@FindBy(how=How.XPATH, using="//span[@id='ctl00_ContentPlaceHolder1_RegularExpressi1']")
	public WebElement invalidMemberNumMsg;

	public void VerifyInvalidMembernumberMsg() {
		
		Assert.assertEquals("Verify Error message when Membership number is invalid", "HCF membership number is invalid.", invalidMemberNumMsg.getText());		
		
				
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='ctl00_ContentPlaceHolder1_divValidationMsg']")
	public WebElement invalidMemberNumMsgTop;

	public void validateInvalidMemberMsgOnTop() {
		
		Assert.assertEquals("Verify message Invalid membership number on top", "Invalid membership number. Please check your HCF membership number and try again.", invalidMemberNumMsgTop.getText());		
		
				
	}
}