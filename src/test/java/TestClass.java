import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {

		/*WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		  driver.get("https://www.uat2.hcf.com.au/");
		  
		  
		  WebElement healthmenu = (new WebDriverWait(driver, 30))
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.heading")));
			healthmenu.click();
			
			Thread.sleep(2000);
			
			/*WebElement FamilySts = (new WebDriverWait(driver, 30))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@ng-model='steps.familyStatus']")));
			
			Boolean status = FamilySts.isDisplayed();
			
			System.out.println("Status is" + status);*/
			
				
			//Boolean status1 = driver.findElements(By.xpath("//select[@ng-model='steps.familyStatus']")).size()!= 0;
			
			//System.out.println("Status is" + status1);
		
		/*DateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");

		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, 5);
		
		String date1 =  dateFormat.format(c.getTime());
		System.out.println(date1);*/
		
		//randomNum = minimum + rand.nextInt((maximum - minimum) + 1);
		
		
		//String name = RandomStringUtils.randomAlphabetic(5);
		    //  System.out.println(name); ;
		  //RandomStringUtils.randomNumeric(length)  
		
		/*Random rand = new Random();
		int randomNum = 1940 + rand.nextInt((2000 - 1940) + 1);
		System.out.println(randomNum);
		
		int randomMonth = 1 + rand.nextInt((12 - 1) + 1);
		System.out.println(randomMonth);*/
		
	//	String content = "up to 12 minutes";
	
	//	boolean stat = content.matches("up to [0-9][0-9]? minutes");
		
	//	System.out.println(stat);
			
		//DesiredCapabilities capability = new DesiredCapabilities("firefox", "*", Platform.ANY);					 
		//capability.setCapability("firefox_binary","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	//	System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.19.0-win64\\geckodriver.exe");

	//	WebDriver driver = new FirefoxDriver();

		//driver.manage().window().maximize();
	//	driver.get("https://www.google.com/");
		
		/*System.setProperty("webdriver.gecko.driver","c://geckodriver-v0.19.0-win64//geckodriver.exe"); 
		WebDriver driver = new FirefoxDriver();

		String url = "http://www.google.com";*/

		/* To Maximize the window */
	//	driver.manage().window().maximize();

		/* To delete all the cookies of the browser */
		//driver.manage().deleteAllCookies();

		/* To navigate to a particular URL */
	//	driver.get(url);
		
		System.setProperty("webdriver.gecko.driver","c://geckodriver-v0.19.0-win64//geckodriver.exe"); 
		//FirefoxOptions options = new FirefoxOptions();
		//options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //Location where Firefox is installed
		
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("moz:firefoxOptions", options);
		//set more capabilities as per your requirements
 
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		
		
		

	}

}
