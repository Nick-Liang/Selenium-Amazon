package au.com.beutii.testframework.webportal;

import au.com.beutii.testframework.selenium.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage_PO extends BasePageObject{

	public AmazonProductPage_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.ID, using="add-to-cart-button")
	public WebElement addToCartBtn;

	public void scrollTheProductPage(String name){
		clickItem(addToCartBtn);
	}

	private void clickItem(WebElement element){
		new Actions(driver).moveToElement(element).click().build().perform();
	}

	private void scrollIntoViewSmoothly(WebElement element){
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("rhf-container")));
		((JavascriptExecutor) driver).executeScript("window.scrollTo({top: "+ (element.getLocation().y - 200) +", behavior: 'smooth'});", element);
	}
}

