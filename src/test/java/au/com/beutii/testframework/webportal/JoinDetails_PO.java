//Author : Satheesh Marripudi
package au.com.beutii.testframework.webportal;

import java.util.Random;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JoinDetails_PO extends BasePageObject {

	public JoinDetails_PO(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//select[@id='ctl00_cphMainContent_ucClientDetails_ddlTitle']")
	public WebElement selectPrefix;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucClientDetails_txtFirstName']")
	public WebElement firstName;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucClientDetails_txtSurname']")
	public WebElement surName;


	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_chkIscontinuousCover']")
	public WebElement tickContinousCover;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucContactDetails_txtEmail']")
	public WebElement emailAddress;

	//Updated xpath of phone field 11/30/2016 kbg
	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucContactDetails_txtMobile']")
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucContactDetails_txtPhone']")
	public WebElement mobileNo;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucAddress_txtAddr1']")
	public WebElement address;

	@FindBy(how=How.XPATH, using="//select[@id='ctl00_cphMainContent_ucAddress_ddlState']")
	public WebElement state;


	@FindBy(how=How.XPATH, using=".//*[@id='ctl00_cphMainContent_ucAddress_txtSuburb']")
	public WebElement suburbPersoanl;

	@FindBy(how=How.XPATH, using="//div[contains(@class,'ssDOBDay')]/button")
	public WebElement date;

	@FindBy(how=How.XPATH, using="//div[contains(@class,'ssDOBMonth')]/button")
	public WebElement month;

	@FindBy(how=How.XPATH, using="//div[contains(@class,'ssDOBYear')]/button")
	public WebElement year;


	@FindBy(how=How.XPATH, using="//select[@id='ctl00_cphMainContent_ucSpouse_ddlTitle']")
	public WebElement selectSpousePrefix;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucSpouse_txtFirstName']")
	public WebElement selectSpousefirstName;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucSpouse_txtSurname']")
	public WebElement selectSpousesurName;

	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlDay']")	
	public WebElement clientdobday;
	
	//added to handle client DOB 11/30/2016 kbg
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucClientDetails_txtDate']")
	public WebElement clientDOB;

	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlMonth']")
	public WebElement clientdobmonth;

	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlYear']")
	public WebElement clientdobyear;
	
	//added to handle spouse DOB 11/30/2016 kbg
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucSpouse_txtDate']")
	public WebElement spouseDOB;

	//@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlDay']")
	//public WebElement spousedobday;

	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlMonth']")
	public WebElement spousedobmonth;

	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlYear']")
	public WebElement spousedobyear;



	public void spouseDateofBirth() {
		WDUtil.sleep(100);
		//updated logic 11/30/2016 kbg
		/*spousedobday.click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlDay']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlDay']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(SDOB)){
				element.click();
				break;
			}
		}*/		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucSpouse_txtDate']")));
		
		Random rand = new Random();
		int randomYear = 1950 + rand.nextInt((2000 - 1950) + 1);
		int randomDate = 1 + rand.nextInt((28 - 1) + 1);		
		int randomMonth = 1 + rand.nextInt((12 - 1) + 1);
			
		
		String sDOB = randomDate+"/"+randomMonth+"/"+randomYear;
		spouseDOB.sendKeys(sDOB);
		spouseDOB.sendKeys(Keys.TAB);
	}

	public void sposueMonthofBirth(String SMOB) {
		WDUtil.sleep(100);
		spousedobmonth.click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlMonth']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlMonth']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(SMOB)){
				element.click();
				break;
			}
		}
	}


	public void spouseYearofBirth(String SYOB) {
		WDUtil.sleep(5000);
		spousedobyear.click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlYear']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlYear']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(SYOB)){
				element.click();
				break;
			}
		}
	}




	public void selectSpouseTitle(String Stitle) {
		WDUtil.sleep(100);
		/*selectSpousePrefix.click();
		WDUtil.sleep(2000);
		//WDUtil.sleep(2000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlTitle']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucSpouse_ddlTitle']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(Stitle)){
				element.click();
				break;
			}
		}*/
		Select oSelectSpouseTitle = new Select(selectSpousePrefix);
		oSelectSpouseTitle.selectByValue(Stitle);
	}
	
	
	
	public void selectSpouseGender(String gender) {		
		
		if(gender.equalsIgnoreCase("M"))
		{
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucSpouse_rbtnGender_0']")));			
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_ucSpouse_rbtnGender_0']")).click();
			WDUtil.sleep(100);
		}else if(gender.equalsIgnoreCase("F")){
			
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucSpouse_rbtnGender_1']")));			
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_ucSpouse_rbtnGender_1']")).click();
			WDUtil.sleep(100);
		}			
				
	}
	
	public void setSpouseFirstname() {
		
		selectSpousefirstName.clear();
		String Spfirstname = RandomStringUtils.randomAlphabetic(5);
		selectSpousefirstName.sendKeys(Spfirstname);
	}

	public void setSposueSurname() {		
		selectSpousesurName.clear();
		String Spsurname = RandomStringUtils.randomAlphabetic(4);
		selectSpousesurName.sendKeys(Spsurname);		
	}
	@FindBy(how=How.XPATH, using="//select[@id='ctl00_cphMainContent_dep_1_ddlTitle']")
	public WebElement selectDependantPrefix;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_dep_1_txtFirstName']")
	public WebElement selectDepfirstName;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_dep_1_txtSurname']")
	public WebElement selectDepsurName;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_dep_1_txtDate']")
	public WebElement DependantDOB;
	
	
	public void selectDepTitle(String Stitle) {			
		Select oSelectDepTitle = new Select(selectDependantPrefix);
		oSelectDepTitle.selectByValue(Stitle);
	}
	
	public void selectDepGender(String gender) {		
		
		if(gender.equalsIgnoreCase("M"))
		{
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_dep_1_rbtnGender_0']")));			
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_dep_1_rbtnGender_0']")).click();
			WDUtil.sleep(500);
		}else if(gender.equalsIgnoreCase("F")){
			
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_dep_1_rbtnGender_1']")));			
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_dep_1_rbtnGender_1']")).click();
			WDUtil.sleep(500);
		}			
				
	}
	public void setDepFirstname() {
		
		selectDepfirstName.clear();
		String Spfirstname = RandomStringUtils.randomAlphabetic(5);
		selectDepfirstName.sendKeys(Spfirstname);
	}

	public void setDepSurname() {		
		selectDepsurName.clear();
		String Spsurname = RandomStringUtils.randomAlphabetic(4);
		selectDepsurName.sendKeys(Spsurname);		
	}
	
	public void DepDateofBirth() {
		WDUtil.sleep(100);		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_dep_1_txtDate']")));
		
		Random rand = new Random();
		int randomYear = 2010 + rand.nextInt((2016 - 2010) + 1);
		int randomDate = 1 + rand.nextInt((28 - 1) + 1);		
		int randomMonth = 1 + rand.nextInt((12 - 1) + 1);
			
		
		String sDOB = randomDate+"/"+randomMonth+"/"+randomYear;
		DependantDOB.sendKeys(sDOB);
	}

	public void clientDateofBirth() {
		
		//Updated logic on 11/30/2016 kbg
		/*(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlDay']")));
		clientdobday.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlDay']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlDay']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(DOB)){
				element.click();
				break;
			}
		}*/
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucClientDetails_txtDate']")));
		
		Random rand = new Random();
		int randomYear = 1940 + rand.nextInt((2000 - 1940) + 1);
		int randomDate = 1 + rand.nextInt((28 - 1) + 1);		
		int randomMonth = 1 + rand.nextInt((12 - 1) + 1);
			
		
		String DOB = randomDate+"/"+randomMonth+"/"+randomYear;
		clientDOB.sendKeys(DOB);
		clientDOB.sendKeys(Keys.TAB);
		
	}

	public void clientMonthofBirth(String MOB) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlMonth']")));
		clientdobmonth.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlMonth']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlMonth']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(MOB)){
				element.click();
				break;
			}
		}
	}


	public void clientYearofBirth(String YOB) {
		clientdobyear.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlYear']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlYear']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(YOB)){
				element.click();
				break;
			}
		}
	}



	@FindBy(how=How.CSS, using="button.btn.dropdown-toggle.selectpicker.btn-default")
	public WebElement tierSelect;

	public void checkPageLoaded() {
		(new WebDriverWait(driver, 100))
		
		//updated Title object xpath throughout the code 11/30/2016
//		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlTitle']")));
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='ctl00_cphMainContent_ucClientDetails_ddlTitle']")));
		System.out.println("registration form loaded");
	}

	public void selectTitle(String title) {
		//Updated following code 11/30/2016
		/*selectPrefix.click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlTitle']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucClientDetails_ddlTitle']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(title)){
				element.click();
				break;
			}
		}*/
		
		Select oSelectTitle = new Select(selectPrefix);
		oSelectTitle.selectByValue(title);
	}

	public void selectGender(String gender) {		
		
		if(gender.equalsIgnoreCase("M"))
		{
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucClientDetails_rbtnGender_0']")));			
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_ucClientDetails_rbtnGender_0']")).click();
			WDUtil.sleep(2000);
		}else if(gender.equalsIgnoreCase("F")){
			
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucClientDetails_rbtnGender_1']")));			
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_ucClientDetails_rbtnGender_1']")).click();
			WDUtil.sleep(2000);
		}			
				
	}

	public void setFirstname() {
		firstName.clear();
		String fName = RandomStringUtils.randomAlphabetic(6);
		firstName.sendKeys("Test "+fName);
	}

	public void setSurname() {
		surName.clear();
		String sName = RandomStringUtils.randomAlphabetic(4);
		surName.sendKeys("Test "+sName);
	}

	public void setEmailAddress(String Emailid) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucContactDetails_txtEmail']")));
		emailAddress.click();
		emailAddress.sendKeys(Emailid);
	}

	public void setMobile(String Mobileno) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucContactDetails_txtPhone']")));
		mobileNo.sendKeys(Mobileno);
	}

	public void setAddress(String Addres) {
		address.sendKeys(Addres);
	}


	public void setState(String State) {
		WDUtil.sleep(1000);
		/*JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", state);
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucAddress_ddlState']/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucAddress_ddlState']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(State)){
				element.click();
				break;
			}
		}*/
		Select oSelectState = new Select(state);
		oSelectState.selectByValue(State);
	}

	public void setSuburb() {
		suburbPersoanl.sendKeys("BURWOOD");
		WDUtil.sleep(2000);
		suburbPersoanl.sendKeys(Keys.ARROW_DOWN);
		suburbPersoanl.sendKeys(Keys.ENTER);
		WDUtil.sleep(1000);
	}

	public void setDate(String dd) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'ssDOBDay')]")));
		date.click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//div[contains(@class,'ssDOBDay')]/button/following-sibling::div/ul/li")).size();
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//div[contains(@class,'ssDOBDay')]/button/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(dd)){
				element.click();
				break;
			}
		}
	}

	public void setMonth(String MM) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'ssDOBMonth')]")));
		month.click();
		int count = driver.findElements(By.xpath("//div[contains(@class,'ssDOBMonth')]/button/following-sibling::div/ul/li")).size();
		for(int i=1; i<=count;i++){
			WebElement element = driver.findElement(By.xpath("//div[contains(@class,'ssDOBMonth')]/button/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(MM)){
				element.click();
				break;
			}
		}
	}

	public void setYear(String YY){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'ssDOBYear')]/button")));
		year.click();
		int count = driver.findElements(By.xpath("//div[contains(@class,'ssDOBYear')]/button/following-sibling::div/ul/li")).size();
		for(int i=1;i<count;i++){
			WebElement element = driver.findElement(By.xpath("//div[contains(@class,'ssDOBYear')]/button/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(YY)){
				element.click();
				break;
			}

		}

	}

	
	public void setTier() {
		WDUtil.sleep(2000);
		WebElement tier = driver.findElement(By.xpath("//select[@id='ctl00_cphMainContent_ucGovtRebate_ddlRebateTier']"));
		/*WebElement tier = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlRebateTier']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tier);
		tier.click();
		WDUtil.sleep(1000);
		/*int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlRebateTier']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlRebateTier']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("Tier 2")){
				element.click();
				break;
			}
		}*/
		
		Select oSelectTier = new Select(tier);		
		oSelectTier.selectByVisibleText("Tier 2");
		
	}
	
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_rbtnRebate_1']")
	public WebElement claimGovRebateNo;
	
	public void claimRebateSelectNo(){
		WDUtil.sleep(2000);		
		claimGovRebateNo.click();
		WDUtil.sleep(2000);	
	}

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_rbtnIsCovered_0']")
	public WebElement governmentRebateCoveredYes;

	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_rbtnIsCovered_1']")
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_ucGovtRebate_rbtnIsCovered_1']")
	public WebElement governmentRebateCoveredNo;


	public void checkGovernmentRebatePolicy(){
		WDUtil.sleep(2000);
		/*WebElement chkrebpolicy = driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_ucGovtRebate_rbtnIsCovered_0']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", chkrebpolicy);
		WDUtil.sleep(2000);
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(governmentRebateCoveredNo));	*/	
		governmentRebateCoveredNo.click();
	}

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_txtMCCardNumber']")
	public WebElement medicareCardNo;

	public void inputMedicareCardNumber(String Medicareno){

		medicareCardNo.clear();
		medicareCardNo.sendKeys(Medicareno);
	}

	//@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMCExpMonth']")
	@FindBy(how=How.XPATH, using="//select[@id='ctl00_cphMainContent_ucGovtRebate_ddlMCExpMonth']")
	public WebElement medicareCardExpiryMonth;

	@FindBy(how=How.XPATH, using="//select[@id='ctl00_cphMainContent_ucGovtRebate_ddlMCExpYear']")
	public WebElement medicareCardExpiryYear;

	public void setMedicareExpiryDate(String MedExM) {
		WDUtil.sleep(2000);
		/*medicareCardExpirydate.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMCExpMonth']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMCExpMonth']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(MedExM)){
				element.click();
				break;
			}
		}*/
		
		Select oSelectMediExpMonth = new Select(medicareCardExpiryMonth);				
		oSelectMediExpMonth.selectByVisibleText(MedExM);
	}

	public void setMedicareExpiryYear(String MedExY) {
		WDUtil.sleep(2000);
		/*medicareCardExpiryMonth.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMCExpYear']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMCExpYear']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(MedExY)){
				element.click();
				break;
			}
		}*/
		
		Select oSelectMediExpYear = new Select(medicareCardExpiryYear);				
		oSelectMediExpYear.selectByVisibleText(MedExY);
	}



	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_txtMCFirstname']")
	public WebElement medicareCardFirstName;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_txtMCLastname']")
	public WebElement medicareCardSurName;

	public void setMedicareCardFirstname(String MCfirstname) {

		WDUtil.sleep(1000);
		medicareCardFirstName.clear();
		medicareCardFirstName.sendKeys(MCfirstname);
	}

	public void setMedicareSurname(String MCsurname) {
		WDUtil.sleep(1000);
		medicareCardSurName.clear();
		medicareCardSurName.sendKeys(MCsurname);
		WDUtil.sleep(1000);
	}

	//Newly added code 12/01/2016 kbg
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_txtDate']")
	public WebElement DOBOnmedicareCard;
	
	public void MedicareMemberDOB(String MedMDOB) {
		WDUtil.sleep(2000);
			
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucGovtRebate_txtDate']")));
		
		DOBOnmedicareCard.sendKeys(MedMDOB);
	}
	
	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlDay']")
	public WebElement dateofbirthOnmedicareCard;

	public void MedicareMemberDOBday(String MedMDOBdd) {
		WDUtil.sleep(2000);
		dateofbirthOnmedicareCard.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlDay']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlDay']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(MedMDOBdd)){
				element.click();
				break;
			}
		}		
		
	}

	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMonth']")
	public WebElement monthofbirthOnmedicareCard;

	public void MedicareMemberDOBmonth(String MedMDOBmm) {
		WDUtil.sleep(2000);
		monthofbirthOnmedicareCard.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMonth']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlMonth']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(MedMDOBmm)){
				element.click();
				break;
			}
		}
	}

	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlYear']")
	public WebElement yearofbirthOnmedicareCard;

	public void MedicareMemberDOByear(String MedMDOByy) {
		WDUtil.sleep(2000);
		yearofbirthOnmedicareCard.click();
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlYear']/following-sibling::div/ul/li")).size();
		WDUtil.sleep(500);
		for( int i = 1; i <= count ; i ++){
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ucGovtRebate_ddlYear']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase(MedMDOByy)){
				element.click();
				break;
			}
		}
	}

	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_rbtnGender_0']")
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_ucGovtRebate_rbtnGender_0']")
	public WebElement genderofMedicareCardHolder;

	public void checkGenderofMedicareCard() {
		WDUtil.sleep(2000);
		genderofMedicareCardHolder.click();
	}

	//@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_ucGovtRebate_rbtnMCEntitlement_0']")
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_ucGovtRebate_rbtnMCEntitlement_0']")
	public WebElement allPeopleCoveredunderMedicare;

	public void checkifAllCoveredUnderMedicare() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucGovtRebate_rbtnMCEntitlement_0']")));
		allPeopleCoveredunderMedicare.click();
	}

	public void clickNextButtononJoinDetails() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Continue")));
		driver.findElement(By.linkText("Continue")).click();
		WDUtil.sleep(1000);
	}

	public void clickNextButtononJoinDetailsConfirmation() {
		WDUtil.sleep(2000);
		driver.findElement(By.linkText("Continue")).click();
		WDUtil.sleep(2000);
	}


	public void clickDeclarationonDetailsConfirmation() {
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_ucRebateForm_chkIsConfirmOnlineRebate']")));
		myDynamicElement.click();
	}

	public void clickNextButtonononJoinDetailsDeclarationpage() {
		driver.findElement(By.linkText("Continue")).click();
		WDUtil.sleep(1000);
	}
	
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_rbtnPartnerswitchFunds_1']")
	public WebElement partnerSwitchFunds;
	
	public void partnerSwitchFundsNo() {
		partnerSwitchFunds.click();
		WDUtil.sleep(1000);
	}

	public void SwitchingFunds(String fundsswitch) {

		if(fundsswitch.contains("no"))
		{
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_rbtnswitchFunds_1']")));	
			//driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_rbtnswitchFunds_1']")).click();
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_rbtnswitchFunds_1']")).click();
			WDUtil.sleep(2000);
		}else if(fundsswitch.contains("yes"))
		{
			(new WebDriverWait(driver, 30))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_rbtnswitchFunds_0']")));	
			driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_rbtnswitchFunds_0']")).click();
			WDUtil.sleep(1000);
			driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_txtNameOfExistingFund']")).sendKeys("Hellloooo");
			driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_txtExistingFundNumber']")).sendKeys("100000000");
			WDUtil.sleep(1000);
			driver.findElement(By.xpath("//label[@id='lblTerminateMembership']")).click();
			WDUtil.sleep(1000);
		}
	}

	public void nameOfExistingFund(String existingfund) {
		driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_txtNameOfExistingFund']")).sendKeys(existingfund);
	}

	public void memberShipID(String membershipId) {
		driver.findElement(By.xpath("//input[@id='ctl00_cphMainContent_txtExistingFundNumber']")).sendKeys(membershipId);
	}

	@FindBy(how=How.XPATH, using="//label[@id='ctl00_cphMainContent_ucRebateForm_lblIsConfirmOnlineRebate']")
	public WebElement rebateConfirmation;

	public void declarationPageConfiramtion() {	
				
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='ctl00_cphMainContent_lblIsUnderstand']")));	
		
		WebElement declaration = driver.findElement(By.xpath("//label[@id='ctl00_cphMainContent_lblIsUnderstand']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", declaration);
		
		(new WebDriverWait(driver, 1000))
		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Continue")));
		
		if (driver.findElements( By.xpath("//label[@id='ctl00_cphMainContent_ucRebateForm_lblIsConfirmOnlineRebate']")).size()!= 0){		
				
			boolean rebateConfirm = rebateConfirmation.isDisplayed();
			
			if(rebateConfirm){
				rebateConfirmation.click();		
			}
		}
		
		driver.findElement(By.xpath("//label[@id='ctl00_cphMainContent_lblIsUnderstand']")).click();
		WDUtil.sleep(1000);
	}
	
	@FindBy(how=How.XPATH, using="//label[@for='ctl00_cphMainContent_chkEmployeeDec']")
	public WebElement emplymentConfirmation;

	public void declarationPageEmploymentConfiramtion() {	
		
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Continue")));
		
		WebElement empDeclaration = driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_chkEmployeeDec']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", empDeclaration);
		
		emplymentConfirmation.click();
		WDUtil.sleep(1000);
	}

	public void clickNextButtononononDeclarationnpage() {
		WDUtil.sleep(1000);
		driver.findElement(By.linkText("Continue")).click();
		WDUtil.sleep(1000);
	}

	//Functions for new applications form
	@FindBy(how=How.XPATH, using="//input[@id='pd_res_suburb']")
	public WebElement suburbPersona;
	
	@FindBy(how=How.XPATH, using="//div[@class='guideRadioButtonItem guideFieldHorizontalAlignment  pd_is_postal_add_same_as_res']")
	public WebElement postalDetailsSame;

	public void checkPersonalDetPageLoaded() {
		(new WebDriverWait(driver, 100))		
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='guideRadioButtonItem guideFieldHorizontalAlignment  pd_gender']")));
		System.out.println("Personal details form is loaded");
	}
	
	public void selectSuburb(String suburb) {
		suburbPersona.sendKeys(suburb);
		WDUtil.sleep(2000);
		suburbPersona.sendKeys(Keys.ARROW_DOWN);
		suburbPersona.sendKeys(Keys.ENTER);
		WDUtil.sleep(1000);
		
	}
}