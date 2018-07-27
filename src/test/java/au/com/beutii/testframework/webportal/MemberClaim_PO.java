//Author : Satheesh Marripudi
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


public class MemberClaim_PO extends BasePageObject{

	public MemberClaim_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.LINK_TEXT, using="Member login")
	public WebElement memberloginlink;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_MainContent_txtClient']")
	public WebElement membershipnumber;

	@FindBy(how=How.XPATH, using="/html/body/form/div[3]/div[2]/section[2]/div/h1")
	public WebElement memberHomepage;

	public void checkMemberHomepageisdisplayed(){ //TODO redo this terrible thing :)
		(new WebDriverWait(driver, 100))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/form/div[3]/div[2]/section[2]/div")));
		///html/body/form/div[3]/div[2]/section[2]/div/h1
		
		Assert.assertEquals("HCF :: MemberHome ::", driver.getTitle());
	}

	public void clickMakeOnLineClaimButton()
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Make an Online Claim")));
		driver.findElement(By.linkText("Make an Online Claim")).click();  
	}

	public void selectProvideType() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlProvidertype']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlProvidertype']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlProvidertype']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<=count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlProvidertype']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("DENTAL SERVICES")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}

	public void selectState() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlLocation']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlLocation']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlLocation']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlLocation']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("QLD")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}

	public void clickSubmitButton(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_imgbtnContinue']")));
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_imgbtnContinue']")).click();
	}

	public void selectProviderPostcode() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='PCODE']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='PCODE']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='PCODE']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='PCODE']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("4000")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}

	public void selectProviderSurname() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='PROVIDER_NAME']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='PROVIDER_NAME']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='PROVIDER_NAME']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='PROVIDER_NAME']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("ALBERT, JC (080553BH)")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}

	public void clickContinueOnSelectProvider(){
		driver.findElement(By.linkText("Continue")).click();

	}


	public void selectPatientName() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlPatient']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlPatient']")).click();
		WDUtil.sleep(2000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlPatient']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<=count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlPatient']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.trim().equalsIgnoreCase("KATHY SMITH")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}

	public void selectItem() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlItems']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlItems']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlItems']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlItems']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("115 - REMOVAL OF CALCULUS SUBSEQUENT VISIT")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}

	public void selectDate() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlDay']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlDay']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlDay']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlDay']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("28")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}   

	public void selectMonth() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlMonth']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlMonth']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlMonth']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlMonth']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("Nov")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}
	}    

	public void selectYear() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlYear']")));
		WDUtil.sleep(1000);
		driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlYear']")).click();
		WDUtil.sleep(1000);
		int count = driver.findElements(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlYear']/following-sibling::div/ul/li")).size();
		System.out.println("Count is : " + count);
		for (int i=1;i<count;i++)
		{
			WebElement element = driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlYear']/following-sibling::div/ul/li["+ i +"]/a"));
			String text = element.getAttribute("data-normalized-text");
			text = text.split(">")[1];
			text = text.split("<")[0];
			System.out.println(text);
			if(text.equalsIgnoreCase("2016")){
				element.click();
				WDUtil.sleep(1000);
				break;
			}
		}

	}     

	public void inputAmountCharged(){

		driver.findElement(By.name("ctl00$ContentPlaceHolder1$txtAmountCharged")).sendKeys("2");

	}

	public void clickAddItem() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_imgbtnAddItem']")));
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_imgbtnAddItem']")).click();
		WDUtil.sleep(3000);
		Boolean addconfirm = driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_divItemAdd']")).isDisplayed();
		if(addconfirm)
		{
			System.out.println("Add Item displyed");
		}
	}

	public void clickConfirmButtonOnSelectItem(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_imgbtnConfirm']")));
		driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_imgbtnConfirm']")).click();

	}

	public void clickAgreeOnConfirmationPage(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_chkAgree']")));
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_chkAgree']")).click();
		//*[@id="ctl00_ContentPlaceHolder1_chkAgree"]
	}

	public void clickSubmitClaim(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.id("imgSubmitClaim")));
		driver.findElement(By.id("imgSubmitClaim")).click();
	}

}