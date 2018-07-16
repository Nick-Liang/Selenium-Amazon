package au.com.hcf.testframework.selenium.base;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObject {
	protected WebDriver driver;
	private By markerElementBy = null;

	public  BasePageObject(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * should be used to verify (and wait if necessary for) ui element is ready
	 */
	public void synchronise() {
		synchronise(30);
	}

	
	public void synchronise(int timoutSeconds) {
		if(markerElementBy!=null){
			WebElement element = (new WebDriverWait(driver, timoutSeconds)).until(ExpectedConditions.presenceOfElementLocated(markerElementBy));
			(new WebDriverWait(driver, timoutSeconds)).until(ExpectedConditions.visibilityOf(element));
		}else{
			//WDUtil.sleep(?);//dirty quick fix
			throw new NotImplementedException("No reference element defined in Page Object");
		}
	}
	
	protected void setSynchronisationMarker(By by){
		markerElementBy = by;
	}
	
}
