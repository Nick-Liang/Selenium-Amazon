package au.com.beutii.testframework.webportal.steps;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.selenium.WDUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends StepsBase{	
	
	@Before("@begin")
	public void init(Scenario scenario) throws MalformedURLException {
		WebDriver newWD=null;
		if(scenario.getSourceTagNames().contains("@reuseSession")){
			newWD = getWD();
		}
		
		//clear storage
		ctx().clearStorage(); 
		
		//create configuration object to be used by all scenarios
		Configuration configuration = new Configuration();
		ctx().put(CTX.CONFIGURATION, configuration);
		
		String browserName = ctx().get(CTX.CONFIGURATION, Configuration.class).getBrowserName();
		
		//start browser
		if(!scenario.getSourceTagNames().contains("@headless")){
			if(newWD==null){				
				
				if(browserName.equalsIgnoreCase("chrome")){
					String path = System.getProperty("user.dir");
					System.out.println(path);					
					
					DesiredCapabilities capability = new DesiredCapabilities("chrome", "*", Platform.ANY);
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\scripts\\chromedriver.exe");
//					newWD = new RemoteWebDriver(new URL(ctx().get(CTX.CONFIGURATION, Configuration.class).getWDS()), capability);
					newWD = new ChromeDriver(capability);
					}
				else if(browserName.equalsIgnoreCase("firefox")){					
				//	System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
					DesiredCapabilities capability = new DesiredCapabilities("firefox", "*", Platform.ANY);					 
					capability.setCapability("firefox_binary","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
					newWD = new RemoteWebDriver(new URL(ctx().get(CTX.CONFIGURATION, Configuration.class).getWDS()), capability);
					}	
			}	
			
			newWD.manage().window().maximize();			
			newWD.manage().deleteAllCookies();
			setWD(newWD);			
			
		}
	}

	@Before
	/**
	 * Delete all cookies at the start of each scenario to avoid
	 * shared state between tests
	 */
	public WebDriver openBrowser(Scenario scenario){
		//NG: not sure that it actually is required
		System.out.println("Called openBrowser");
		ctx().put(CTX.SCENARIO, scenario);
		if(getWD() == null){
			try {

			} finally{
				//TODO: Nikolay: delete those useless shutdown hooks. they are just unnecessary complexity.
				//Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup(this)));
			}
		}
		return getWD();
	}

	private class BrowserCleanup implements Runnable {
		private final Hooks hooks;
		public BrowserCleanup(Hooks hooks){
			this.hooks = hooks;
		}
		public void run() {
			//LOGGER.info("Closing the browser");
			hooks.close();
		}
	}

	public void close(){
		try {
			Scenario scenario = ctx().get(CTX.SCENARIO, Scenario.class);
			WebDriver wd = openBrowser(scenario);
			if(wd!=null && !scenario.getSourceTagNames().contains("@reuseSession")){
				wd.quit();
				setWD(null);
			}
		} catch (UnreachableBrowserException e) {
			setWD(null);
		}
	}

	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void embedScreenshot(Scenario scenario) {  
		if(scenario.isFailed()) {
			WDUtil.addScreenshotToReport(scenario, getWD());
			close();
		}

	}    

	@After("@end")
	public void KillDriver(Scenario scenario){
		if(!scenario.isFailed()) //NG: it's a bit ugly but this check is required to allow screenshot on error to be taken
			this.close();
	}    
}
//Author : Satheesh Marripudi