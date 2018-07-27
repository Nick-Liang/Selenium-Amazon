package au.com.beutii.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;

public class EmailQuote_PO extends BasePageObject{

	public EmailQuote_PO(WebDriver driver) {
		super(driver);
	}
		
	public void clickEmailinQuote() {
		WDUtil.sleep(3000);
		driver.findElement(By.linkText("Email quote")).click();
		WDUtil.sleep(2000);
	}
	
	public void fillEmailandQuote(String email,String mobile) {
		WebElement emailfield = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='email']")));
		emailfield.sendKeys(email);
		
		
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(mobile);
	
	}

	public void clickSendButtonOnEmailQuote() {
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/div/div/div[1]/form/button")).click();
		WDUtil.sleep(1000);
		
	}
	
	public void thankYouMessage(){
		
		WebElement el = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='animation-window']/descendant::div[contains(@class,'message')]/h2[contains(text(),'Thank You')]"
			)));
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(el));
		String thanks = el.getText(); 

		if(thanks.contains("Thank"))
		{//TODO Nikolay fix, that's not exactly validation (partly fixed by changing xpath to one containing the message)... and it didn't work because of the upper case of text on the page
			System.out.println("Thank you Message displayed");
		}
}

}

//Author : Satheesh Marripudi