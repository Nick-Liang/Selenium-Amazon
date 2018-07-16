package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.WDUtil;

public class ExcessCover_PO extends BasePackageStepObject{

	public ExcessCover_PO(WebDriver driver) {
		super(driver, "step_4");
	}

	public void ValidateExcessSectionLoaded(){
		WebElement myDynamicElement = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.section.package_step.step_4.excess-step.open")));
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(myDynamicElement));
	}	


	public void selectExcess(String excess) {
		int count = 0;
		String excessLabel = "";
		String classAttribute = "";
		
		count = driver.findElements(By.xpath("//div[@class='radio-group excess-radio-group']/div")).size();		
		for(int i = 1; i <= count; i++){
			WebElement element = driver.findElement(By.xpath("//div[@class='radio-group excess-radio-group']/div["+i+"]/label"));
			excessLabel = element.getText();
			System.out.println("excess text is : " + excess );
			
			if(excessLabel.equalsIgnoreCase(excess)){
				classAttribute = driver.findElement(By.xpath("//div[@class='radio-group excess-radio-group']/div["+i+"]")).getAttribute("class");
				if(!classAttribute.toLowerCase().contains("selected")){				
					WDUtil.sleep(500);														
					element.click();					
					break;
				}
			}
		}
	}

	public Boolean IsCoverSummaryPageDisplayed(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'total-cost')]")));
		return driver.findElement(By.xpath("//div[contains(@class,'total-cost')]")).isDisplayed();

	}

}

//Author : Satheesh Marripudi