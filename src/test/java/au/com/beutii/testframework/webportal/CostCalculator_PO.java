package au.com.beutii.testframework.webportal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;

public class CostCalculator_PO extends BasePageObject{

	public CostCalculator_PO(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(how=How.XPATH, using="//div[@class='costCalculator-procedure-name']")
	public WebElement costCalcProcedureName;
	
	@FindBy(how=How.XPATH, using="//div[@class='costCalculator-summary']//div[@class='costCalculator-totalServiceCost-value']")
	public WebElement totalServiceCost;
	
	@FindBy(how=How.XPATH, using="//div[@class='costCalculator-summary']//div[@class='costCalculator-yourCost-value']")
	public WebElement yourcost;
	
	@FindBy(how=How.XPATH, using="//div[@class='costCalculator-error']//h1")
	public WebElement costCalcError;
	
	
	public  void validateProcedureName(String procedureName) {	
		
		WDUtil.sleep(4000);
		
		new WebDriverWait(driver, 100)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='costCalculator-procedure-name']")));
		
		WDUtil.sleep(1000);
		Assert.assertEquals(procedureName.toUpperCase(), costCalcProcedureName.getText().toUpperCase());
		
	}
	
	public  void validateTotalServiceCost(String totalCost) {		
		
		Assert.assertEquals(totalCost, totalServiceCost.getText());
		
	}
	
	public  void validateYourcost(String yourCost) {		
		
		Assert.assertEquals(yourCost, yourcost.getText());
		
	}
	
	public  void validateUnavailabilityMsg() {
		new WebDriverWait(driver, 100)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='costCalculator-error']")));
		
		Assert.assertEquals("COST INDICATOR CURRENTLY UNAVAILABLE", costCalcError.getText());
		
	}
}
