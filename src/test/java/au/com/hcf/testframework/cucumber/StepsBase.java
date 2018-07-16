package au.com.hcf.testframework.cucumber;

import org.openqa.selenium.WebDriver;

public abstract class StepsBase {	
	/**
	 * Retrieve WebDriver object from context. Used to shorten frequently used context operations with short method.
	 * @return
	 */
	protected WebDriver getWD(){
		return ctx().get(CTX.WEB_DRIVER, WebDriver.class);
	}
	
	/**
	 * A pair method for getWD()
	 * @param driver
	 */
	protected void setWD(WebDriver driver) {
		ctx().put(CTX.WEB_DRIVER, driver);
	}
	
	public ContextStorage ctx(){
		return ContextStorage.getThreadLocalInstance();
	}

}
