//Author : Satheesh Marripudi
package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.base.BasePageObject;


public class MediaReleases_PO extends BasePageObject{

	public MediaReleases_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.LINK_TEXT, using="Member login")
	public WebElement memberloginlink;

	public void checkMediaReleaseeNotificationSubscriptionDisplayed(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Media release email notification')]")));
	}

}