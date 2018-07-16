package au.com.hcf.testframework.webportal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.selenium.base.BasePageObject;

public class ContactusForm_PO extends BasePageObject{

	public ContactusForm_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//input[@id='firstName']")
	public WebElement firstname;
	
	@FindBy(how=How.XPATH, using="//input[@id='lastName']")
	public WebElement lastname;
	
	@FindBy(how=How.XPATH, using="//input[@id='emailAddress']")
	public WebElement emailAdrs;
	
	@FindBy(how=How.XPATH, using="//select[@id='subject']")
	public WebElement subject;
	
	@FindBy(how=How.XPATH, using="//select[@id='contactMeBy']")
	public WebElement contactBy;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='comments']")
	public WebElement comments;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'contact-block form')]//button[@type='submit']")
	public WebElement submit;	
	
	@FindBy(how=How.XPATH, using="//div[@id='modal-contact-us']//div[contains(@class,'message--success')]/h2")
	public WebElement successMsg;
	
	@FindBy(how=How.XPATH, using="//div[@class='error-summary']/ul/li/a")
	public WebElement captchaErrorMsg;
	
	@FindBy(how=How.XPATH, using="//div[@class='contact-block']//span[@id='wrap']/p")
	public WebElement callWaitMsg;
	
	public void setFirstname(String Sfirstname) {

		WDUtil.sleep(1000);		
		firstname.sendKeys(Sfirstname);
	}
	
	public void setLastname(String Slastname) {

		WDUtil.sleep(1000);		
		lastname.sendKeys(Slastname);
	}	
	
	public void setEmailAddrs(String SemailAdrs) {

		WDUtil.sleep(1000);		
		emailAdrs.sendKeys(SemailAdrs);
	}
	
	public void selectSubject(String Ssubject) {
		
		Select oSelectSubject = new Select(subject);
		oSelectSubject.selectByVisibleText(Ssubject);;
	}
	
	public void selectContactBy(String ScontactBy) {
		
		Select oSelectContactby = new Select(contactBy);
		oSelectContactby.selectByVisibleText(ScontactBy);;
	}
	
	public void setComments(String Scomments) {

		WDUtil.sleep(1000);		
		comments.sendKeys(Scomments);
	}
	
	public void clickSubmit() {	
		WDUtil.sleep(1000);
		submit.click();
		WDUtil.sleep(1000);
	}
	
	public void validateThankyouMsg() {
		
		new WebDriverWait(driver, 100)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal-contact-us']//div[contains(@class,'message--success')]/footer/a")));
		Assert.assertEquals("Thank you for your email.", successMsg.getText());
	}
	
	public void validateCaptchaErrorMsg() {
		
		new WebDriverWait(driver, 100)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error-summary']")));
		
		System.out.println(captchaErrorMsg.getText());
		Assert.assertEquals("Recaptcha: Please fill out the Recaptcha.", captchaErrorMsg.getText());
	}
	
	public boolean validateCallWaitTime() {	
		
		new WebDriverWait(driver, 100)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='contact-block']")));
	
		String content = callWaitMsg.getText();
		System.out.println(content);
		
		return content.matches("For claims enquiries the current wait time for your call to be answered is up to [0-9][0-9]? minutes");

	}
}
