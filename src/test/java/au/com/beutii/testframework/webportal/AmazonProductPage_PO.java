package au.com.beutii.testframework.webportal;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonProductPage_PO extends BasePageObject{

	public AmazonProductPage_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.ID, using="add-to-cart-button")
	public WebElement addToCartBtn;

	@FindBy(how=How.ID, using="huc-v2-order-row-items")
	public WebElement addSuccessfully;

	public void scrollTheProductPage(String name){
		WDUtil.clickItem(driver, addToCartBtn);
	}

	public void addToCart(){
		WDUtil.clickItem(driver, addToCartBtn);
	}

}

