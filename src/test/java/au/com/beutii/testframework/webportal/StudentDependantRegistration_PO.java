package au.com.beutii.testframework.webportal;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;



public class StudentDependantRegistration_PO extends BasePageObject{

	public StudentDependantRegistration_PO(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(how=How.XPATH, using="//select[@id='ctl00_ContentPlaceHolder1_ddlDependantName']")
	public WebElement studentName;
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_chkAck']")
	public WebElement declarationCheck;	
	
	@FindBy(how=How.XPATH, using="//input[@id='ctl00_ContentPlaceHolder1_btnStudentDependantRegistration']")
	public WebElement submitbutton;	
	
	@FindBy(how=How.XPATH, using="//div[@id='ctl00_ContentPlaceHolder1_divsuccess']")
	public WebElement successMsg;
	
	@FindBy(how=How.XPATH, using="//div[@class='login-info']//*[@id='logoutform']/a[contains(text(),'Logout')]")
	public WebElement logoutBtn;
	
	public void selectStudentDepRegisterOption() {		
		
		WebElement actionsLink = driver.findElement(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][4]/a"));
		//WebElement SecuritySettingsLink = driver.findElement(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][3]//li[1]/a"));
		Actions builder = new Actions(driver);
		// Move cursor to the Main Menu Element
		builder.moveToElement(actionsLink).perform();		
		WDUtil.sleep(600);	
		
		WebDriverWait wait = new WebDriverWait(driver, 800); 
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][4]//li[4]/a")));  // until this submenu is found
		WDUtil.sleep(2000);	
		//identify menu option from the resulting menu display and click
		WebElement menuOption = driver.findElement(By.xpath("//ul[starts-with(@class,'main-menu')]/li[@class='dropdown'][4]//li[4]/a"));
		menuOption.click();
		WDUtil.sleep(2000);
	}	
	
	public void selectStudentName(String SstudentDepName) {
		
		Select oSelectStudent = new Select(studentName);
		List <WebElement> elementCount = oSelectStudent.getOptions();
		System.out.println(elementCount.size());
		
		//driver.findElement(By.xpath("//button[@data-id='ctl00_ContentPlaceHolder1_ddlDependantName']")).click();
		WDUtil.sleep(500); 
		oSelectStudent.selectByVisibleText(SstudentDepName);
		//oSelectStudent.selectByValue("D");
	}
	
	public void selectDeclarationCheckbox() {
		declarationCheck.click();		
	}
	
	public void clickSubmitButton() {
		submitbutton.click();		
	}
	
	public void validateRegConfirmation() {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_divsuccess']")));
		
		String msg = successMsg.getText();
		System.out.println("Displayed message is "+msg);
		
		int inde = msg.indexOf("Thank you");
		System.out.println("index is "+inde);
		
		if(msg.indexOf("Thank you. Your request is being processed the next review date is")!= -1){
			System.out.println("Cofirmation message is appeared");
			
		}else{
			System.out.println("Cofirmation message is NOT appeared");
			
		}	
		
		Assert.assertTrue("Thank you message", msg.indexOf("Thank you. Your request is being processed the next review date is")!= -1);		
		
	}
	
	public void logoutMemberSection() {
		logoutBtn.click();
		WDUtil.sleep(600);
	}
	
	
}