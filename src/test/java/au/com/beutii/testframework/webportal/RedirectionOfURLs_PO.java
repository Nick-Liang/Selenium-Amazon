package au.com.beutii.testframework.webportal;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;

public class RedirectionOfURLs_PO extends BasePageObject{

	public RedirectionOfURLs_PO(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(how=How.XPATH, using="//div[@id='MemSection']//div[@class='navbar-header']/span")
	public WebElement memberSectionHeader;
	

	public void memberSectionHomepage() {
		WDUtil.sleep(1000);
		Assert.assertEquals("Online member services", memberSectionHeader.getText());
	}
		
	public void contactUspage() {
		WDUtil.sleep(1000);
		Assert.assertEquals("Contact us | HCF", driver.getTitle());		
		System.out.println(driver.getTitle());
	}
	
	public void noGapServices() {
		WDUtil.sleep(1000);
		Assert.assertEquals("No-gap services | HCF", driver.getTitle());		
		System.out.println(driver.getTitle());
	}
	
	public void hcfAppspage() {
		WDUtil.sleep(1000);
		Assert.assertEquals("Mobile apps | HCF", driver.getTitle());
		System.out.println(driver.getTitle());		
	}
	
	public void gp2upage() {
		WDUtil.sleep(1000);
		Assert.assertEquals("GP2U | HCF", driver.getTitle());
		System.out.println(driver.getTitle());		
	}
	
	public void aboutUspage() {
		WDUtil.sleep(1000);
		Assert.assertEquals("About HCF | HCF", driver.getTitle());
		System.out.println(driver.getTitle());		
	}
	
	public void branches() {
		WDUtil.sleep(1000);
		Assert.assertEquals("Find a branch | HCF", driver.getTitle());
		System.out.println(driver.getTitle());		
	}
	
	public void providerPortal() {
		WDUtil.sleep(1000);
		Assert.assertEquals("HCF Provider Portal Services", driver.getTitle());
		System.out.println(driver.getTitle());		
	}
	
	public void researchFoundation() {
		WDUtil.sleep(1000);
		Assert.assertEquals("HCF Research Foundation | HCF", driver.getTitle().trim());
		System.out.println(driver.getTitle());		
	}
	
	public void chronicConditions() {
		WDUtil.sleep(1000);
		Assert.assertEquals("Manage chronic conditions | HCF", driver.getTitle().trim());
		System.out.println(driver.getTitle());		
	}
	
	public void noMatch() {			
		System.out.println(driver.getTitle());	
		Assert.fail("There is no matching desired page");
	}
}
