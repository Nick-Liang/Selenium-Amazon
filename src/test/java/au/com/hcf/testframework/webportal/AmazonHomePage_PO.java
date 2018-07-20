package au.com.hcf.testframework.webportal;

import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.selenium.base.BasePageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
		if(StringUtils.isNotBlank(searchBox.getAttribute("value"))){
			searchBox.sendKeys(Keys.chord(Keys.CONTROL, "a"), keywords);
		}else{
			searchBox.sendKeys(keywords);
		}
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		new Actions(driver).moveToElement(searchButton).click().build().perform();
	}

}

