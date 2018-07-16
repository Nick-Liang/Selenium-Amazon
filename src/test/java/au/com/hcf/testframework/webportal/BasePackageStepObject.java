package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.selenium.base.BasePageObject;

public class BasePackageStepObject extends BasePageObject{
	protected final String panelXPath;	
	public BasePackageStepObject(WebDriver driver, String stepId) {
		super(driver);
		panelXPath = "//section[contains(@class,'"+stepId+"') and contains(@class,'open')]";
		setSynchronisationMarker(By.xpath(panelXPath+"/descendant::h3[not(@class)]"));
	}

	public void clickNextButton(){
		clickButton("Next");
		WDUtil.sleep(500);		
	}
	
	protected void clickButton(String text){
		WDUtil.sleep(800);
		WebElement next = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(panelXPath+"/descendant::a[contains(@class,'button') and not(@disabled) and contains(text(),'"+text+"')]")));
		//WDUtil.sleep(800); //animation :(
		(new WebDriverWait(driver, 800))
		.until(ExpectedConditions.elementToBeClickable(next));
		next.click();
	}
	
}
