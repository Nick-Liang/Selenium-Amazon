package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.WDUtil;

public class HospitalCover_PO extends BasePackageStepObject{

	public HospitalCover_PO(WebDriver driver) {
		super(driver, "step_3");
	}

	@FindBy(how=How.XPATH, using="//div[@type='hospital']//div[@class='slick-track']/div[2]/div/div//a")
	public WebElement coverageSelection;


	public void selectHospitalCover(String hospital){
		(new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@type='hospital']//div[@class='slick-track']/div")));
		int count = 0;
		String title = "";
		count = driver.findElements(By.xpath("//div[@type='hospital']//div[@class='slick-track']/div")).size();
		for(int i = 1; i <= count; i++){
			title = driver.findElement(By.xpath("//div[@type='hospital']//div[@class='slick-track']/div["+ i +"]//div[@class='title']/h3")).getText(); 
			System.out.println("Extra text is : " + title );
			if(title.equalsIgnoreCase(hospital)){
				driver.findElement(By.xpath("//div[@type='hospital']//div[@class='slick-track']/div["+ i +"]/div/div/a")).click();
				break;
			}
		}
	}


	public void selectExtraCover(String extra) {
		int count = 0;
		String title = "";
		(new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@type='extra']//div[@class='slick-track']/div[1]")));
		count = driver.findElements(By.xpath("//div[@type='extra']//div[@class='slick-track']/div")).size();
		for(int i = 1; i <= count; i++){	
			title = driver.findElement(By.xpath("//div[@type='extra']//div[@class='slick-track']/div["+ i +"]//div[@class='title']/h3")).getText(); 
			System.out.println("Extra text is : " + title );
			if(title.equalsIgnoreCase(extra)){
				WebElement extraTile = driver.findElement(By.xpath("//div[@type='extra']//div[@class='slick-track']/div["+ i +"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", extraTile);
				WDUtil.sleep(500);
				driver.findElement(By.xpath("//div[@type='extra']//div[@class='slick-track']/div["+ i +"]/div/div/a")).click();
				break;
			}
		}

	}

	public void ValidateExcessSectionLoaded(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.section.package_step.step_4.excess-step.open")));
	}
	
	public void selectPackageType(String healthPackage){
		(new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='radio-group needs-radio-group fn_equalHeights ng-binding']")));
		int count = 0;
		String title = "";
		count = driver.findElements(By.xpath("//div[@class='radio-group needs-radio-group fn_equalHeights ng-binding']/div")).size();
		for(int i = 1; i <= count; i++){
			title = driver.findElement(By.xpath("//div[@class='radio-group needs-radio-group fn_equalHeights ng-binding']/div["+ i +"]/label")).getText(); 
			System.out.println("Health Package Type text is : " + title );
			if(title.equalsIgnoreCase(healthPackage)){
				driver.findElement(By.xpath("//div[@class='radio-group needs-radio-group fn_equalHeights ng-binding']/div["+ i +"]/label/input")).click();
				break;
			}
		}
	}
	
	/*public void selectHospitalPackageCover(String hospitalPackage){
		(new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@type='packages']//div[@class='slick-track']/div")));
		int count = 0;
		String title = "";
		count = driver.findElements(By.xpath("//div[@type='packages']//div[@class='slick-track']/div")).size();
		for(int i = 1; i <= count; i++){
			title = driver.findElement(By.xpath("//div[@type='packages']//div[@class='slick-track']/div["+ i +"]//div[@class='title']/h3")).getText(); 
			System.out.println("Hospital package text is : " + title );
			if(title.equalsIgnoreCase(hospitalPackage)){
				driver.findElement(By.xpath("//div[@type='packages']//div[@class='slick-track']/div["+ i +"]/div/div/a")).click();
				break;
			}
		}
	}*/

}
//Author : Satheesh Marripudi