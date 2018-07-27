package au.com.beutii.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PackagesHospitalCover_PO extends BasePackageStepObject{

	public PackagesHospitalCover_PO(WebDriver driver) {
		super(driver, "step_4");
	}

	@FindBy(how=How.XPATH, using="//div[@type='packages']//div[@class='slick-track']/div[2]/div/div//a")
	public WebElement coverageSelection;
	
	public void ValidateExcessSectionLoaded(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.section.package_step.step_5.excess-step.open")));
	}
	
	/*public void selectPackageType(String healthPackage){
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
	}*/
	
	public void selectHospitalPackageCover(String hospitalPackage){
		(new WebDriverWait(driver, 120))
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
	}

}
//Author : Satheesh Marripudi