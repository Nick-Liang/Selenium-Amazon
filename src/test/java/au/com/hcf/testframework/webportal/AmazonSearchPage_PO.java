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

public class AmazonSearchPage_PO extends BasePageObject{

	public AmazonSearchPage_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.ID, using="searchTemplate")
	public WebElement searchPageTemplate;

}

