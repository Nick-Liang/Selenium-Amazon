package au.com.hcf.testframework.webportal;

import au.com.hcf.testframework.selenium.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage_PO extends BasePageObject{

	public AmazonHomePage_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.ID, using="twotabsearchtextbox")
	public WebElement searchBox;

	@FindBy(how=How.CLASS_NAME, using="nav-input")
	public WebElement searchButton;

	@FindBy(how=How.ID, using="desktop-banner")
	public WebElement topBanner;

	public void clickSearchBox() {
		searchBox.click();
	}

	public void startToSearch(String keywords){
		searchBox.sendKeys(keywords);
		WebElement navCover = (new WebDriverWait(driver, 100)).until(ExpectedConditions.presenceOfElementLocated(By.id("nav-cover")));
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(navCover));
		new Actions(driver).moveToElement(searchButton).click().build().perform();
	}

}

