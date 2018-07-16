//Author : Satheesh Marripudi
package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RebatePage_PO extends BasePackageStepObject{

	public RebatePage_PO(WebDriver driver) {
		super(driver, "step_2");
	}


	@FindBy(how=How.XPATH, using="//select[@ng-model='steps.registeredAs']")
	public WebElement registerfield;

	@FindBy(how=How.XPATH, using="//div[@type='hospital']//div[@class='slick-track']")
	public WebElement hospitalcoverpage;


	public Boolean verifyRebatepage()
	{
		return registerfield.isDisplayed();
	}


	public void selectRegisteredAs(String registered) {
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@ng-model='steps.registeredAs']")));
		Select select = new Select(driver.findElement(By.xpath("//select[@ng-model='steps.registeredAs']")));
		select.selectByVisibleText(registered);

	}

	public void selectAnnualIncome(String annualincome) {
		Select select = new Select((new WebDriverWait(driver, 40))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='form-element']/span/select[@ng-model='steps.annualIncome']"))));
		select.selectByVisibleText(annualincome);

	}

	public void verifyRebate(String actualtext){
		String actuatext = driver.findElement(By.xpath("//div[contains(@ng-class,'no tier')]/label")).getText();
		System.out.println(actuatext);
		//need to write code for comparing two values actual rebate with Expected Rebate
	}

	//TODO: Nikolay: why is it here if hospital cover is mapped in another PO class?
	public void validateHospitalCoverSectionLoaded(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section.section.package_step.step_3.slider-step.hospital-step.extra-step.open")));
	}


	public void selectTier(String tier) {
		// TODO: Nikolay: implement!
	}

}