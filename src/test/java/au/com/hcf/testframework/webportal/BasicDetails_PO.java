package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicDetails_PO extends BasePackageStepObject{

	public BasicDetails_PO(WebDriver driver) {
		super(driver,"step_1");
	}

	@FindBy(how=How.XPATH, using="//select[@ng-model='steps.familyStatus']")
	private WebElement familyStatus;

	@FindBy(how=How.XPATH, using="//select[@ng-model='steps.location']")
	private WebElement location;

	@FindBy(how=How.XPATH, using="//select[@ng-model='steps.age']")
	private WebElement age;

	/* @FindBy(how=How.XPATH, using="//select[@ng-model='steps.age']")
   public WebElement nextstep;*/

	public void selectCoverageType(String coverageType)
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@ng-model='steps.familyStatus']")));

		Select select = new Select(driver.findElement(By.xpath("//select[@ng-model='steps.familyStatus']")));
		select.selectByVisibleText(coverageType);
	}

	public void selectLocation(String location)
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@ng-model='steps.location']")));

		Select select = new Select(driver.findElement(By.xpath("//select[@ng-model='steps.location']")));
		select.selectByVisibleText(location);
	}

	public void selectAge(String age)
	{
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@ng-model='steps.age']")));

		Select select = new Select(driver.findElement(By.xpath("//select[@ng-model='steps.age']")));
		select.selectByVisibleText(age);
	}

	public boolean isDisplayed() {		
			
		//return familyStatus.isDisplayed();
		 
		 return driver.findElements(By.xpath("//select[@ng-model='steps.familyStatus']")).size()!= 0;
	}

}
//Author : Satheesh Marripudi