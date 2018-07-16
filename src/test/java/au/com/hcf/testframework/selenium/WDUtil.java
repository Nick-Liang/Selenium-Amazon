package au.com.hcf.testframework.selenium;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;

public class WDUtil {

	public static void addScreenshotToReport(Scenario scenario, WebDriver driver) {
		if(scenario==null || driver==null){
			System.out.println("Screenshot capability isn't available, scenario="+scenario+", driver="+driver);
			return;
		}
		System.out.println("Taking screeenshot");
		try {
			scenario.write("Current Page URL is " + driver.getCurrentUrl());
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println("Failed to take to take screeenshot");
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}

	private static int screnshotIndex=0;
	public static void addDebugScreenshot(WebDriver driver){
		if(driver==null){
			System.err.println("Something very wrong is happening, driver="+driver);
			return;
		}
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		try {
			FileUtils.copyFile(scrFile, new File("target/screenshot"+ Thread.currentThread().getName()+(screnshotIndex++) +".png"));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void sleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean waitNewWindow(WebDriver driver, String title) {
		for(int i=0; i<10; i++){
			WDUtil.sleep(1000);
			for(String winHandle : driver.getWindowHandles()){
				driver.switchTo().window(winHandle);
				if(driver.getTitle().equalsIgnoreCase(title)){
					return true;
				}
			}
		}
		return false;
	}

}
