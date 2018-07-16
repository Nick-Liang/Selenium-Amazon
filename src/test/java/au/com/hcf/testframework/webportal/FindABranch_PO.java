package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.selenium.base.BasePageObject;

public class FindABranch_PO extends BasePageObject {
	public FindABranch_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.LINK_TEXT, using="Member login")
	public WebElement memberloginlink;

	@FindBy(how=How.XPATH, using="//input[@id='input-001' and @placeholder='Enter a suburb or postcode']")
	public WebElement postCodeInput;      

	public void checkFindYourNearestHGFBranchInvitationIsDisplayed(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Find your nearest HCF branch')]")));
		WDUtil.sleep(4000);
	}

	public void enterPostCode(String postcode) {
		postCodeInput.sendKeys(postcode);
		WDUtil.sleep(1000);
		postCodeInput.sendKeys(Keys.RETURN);
		WDUtil.sleep(1000);
	}

	public String getClosestBranchName() {
		//div[@class='slick-track']/li[1]/descendant::h4
		return (new WebDriverWait(driver, 15)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slick-track']/li[1]/descendant::h4"))
				).getText();		
	}

}
