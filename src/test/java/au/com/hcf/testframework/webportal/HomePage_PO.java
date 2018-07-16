package au.com.hcf.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import au.com.hcf.testframework.selenium.base.BasePageObject;

public class HomePage_PO extends BasePageObject{

	public HomePage_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.CSS, using="span.heading")
	public WebElement health;

	@FindBy(how=How.XPATH, using="//a[text()='Customise cover']")
	public WebElement customiseCover;

	@FindBy(how=How.XPATH, using="//a[text()='Insurance']")
	public WebElement insuranceMenu;

	public void clickHealthMenu() {
		WebElement healthmenu = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.heading")));
		healthmenu.click();
	}

	public void clickLinkUnderTwoLevelMenu(String mainMenu, String subMenu, String linkText){
		WebElement mainMenuLink = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='navbar']/ul/li/a[contains(text(),'"+mainMenu+"')]"
			)));

		//click main menu
		new Actions(driver).moveToElement(mainMenuLink).build().perform();
		mainMenuLink.click();
		(new WebDriverWait(driver, 5)) //wait animation to finish
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='navbar']/ul/li[contains(@class,'is-hover')]/a[contains(text(),'"+mainMenu+"')]")));
		
		
		//click submenu
		WebElement subMenuLink = (new WebDriverWait(driver, 5))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='lvl2link' and contains(text(),'"+subMenu+"')]")));
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(subMenuLink));
		new Actions(driver).moveToElement(subMenuLink).build().perform();
		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='navbar']/ul/li[a[contains(text(),'"+mainMenu+"')]]"+
				"/descendant::div[@class='dd-level2-inner' and a[contains(text(),'"+subMenu+"')]]/div[@class='dropdown-lvl2']"
			))); //wait animation to finish
		
		//click a link
		WebElement linkUnderSubmenu = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown-lvl2']/descendant::a[contains(text(),'"+linkText+"')]")));
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(linkUnderSubmenu));
		new Actions(driver).moveToElement(linkUnderSubmenu).click().build().perform();
						
	}

	public void clickCustomiseCoverMenu(){
		WebElement customisecovermenu = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Customise cover']")));
		customisecovermenu.click();
	}

}

