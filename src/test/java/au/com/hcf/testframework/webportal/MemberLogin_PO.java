//Author : Satheesh Marripudi
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

public class MemberLogin_PO extends BasePageObject{

	public MemberLogin_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.LINK_TEXT, using="Member login")
	public WebElement memberloginlink;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtClient']")
	public WebElement membershipnumber;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_txtPassword']")
	public WebElement membershippassword;

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_imgbtnSubmit']")
	public WebElement submitbutton;

	@FindBy(how=How.LINK_TEXT, using="View message")
	public WebElement viewmessagelink;

	public void clickMemberLoginLink()
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Member login")));
		memberloginlink.click();
	}

	public void inputMembershipNumber(String membernumber)
	{
		WDUtil.waitNewWindow(driver, "HCF Member Services");

		(new WebDriverWait(driver, 10))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtClient']")));
		membershipnumber.clear();
		membershipnumber.sendKeys(membernumber);
	}

	public void inputMemberPassword(String memberpassword)
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_txtPassword']")));
		membershippassword.clear();
		membershippassword.sendKeys(memberpassword);
	}

	public void clickSubmitButton()
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_imgbtnSubmit']")));
		myDynamicElement.click();
	}

	public void verifyHomePageusername()
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='logoutform']/a[@class='login-name']")));
		String logname= myDynamicElement.getText();
		System.out.println("login name is :" + logname);

	}

	public void clickViewMessageLink()
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.linkText("viewmessagelink")));
		viewmessagelink.click();
	}
	
	public void checkOverseasMsg()
	{
		WebElement myDynamicElement = (new WebDriverWait(driver, 40))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_divValidationMsg']")));
		
		String actMsg= myDynamicElement.getText();
		String expMsg = "If you have Overseas Visitors Cover please use the overseas member login below.";
		
		Assert.assertEquals("Validate Overseas login message", expMsg, actMsg);
	}
}