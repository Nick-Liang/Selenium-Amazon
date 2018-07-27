package au.com.beutii.testframework.webportal;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonLogin_PO extends BasePageObject{

	public AmazonLogin_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.XPATH, using="//a[@id='nav-link-accountList']/span[@class='nav-line-1']")
	public WebElement loginNameSpan;

	@FindBy(how=How.ID, using="nav-flyout-accountList")
	public WebElement accountListMenu;

	@FindBy(how=How.XPATH, using="//div[@id='nav-flyout-ya-signin']/a")
	public WebElement signBtn;

	@FindBy(how=How.ID, using="nav-item-signout-sa")
	public WebElement signOutBtn;

	@FindBy(how=How.ID, using="ap_email")
	public WebElement usernameElement;

	@FindBy(how=How.ID, using="ap_password")
	public WebElement passwordElement;


	public boolean amISignedIn(){
		if(loginNameSpan != null){
			return !StringUtils.equals(loginNameSpan.getText(), "Hello. Sign in");
		}
		return false;
	}

	public void hoverToSignIn() {
		new Actions(driver).moveToElement(loginNameSpan).build().perform();
	}

	public void clickSignIn() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(accountListMenu));
		WDUtil.sleep(2000);
		new Actions(driver).moveToElement(signBtn).click().build().perform();
	}

	public void clickSignOut() {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(signOutBtn));
		WDUtil.sleep(2000);
		new Actions(driver).moveToElement(signOutBtn).click().build().perform();
	}

	public void inputUserName(String userName) {
		fillInAndEnter(userName, usernameElement);
	}

	public void inputPassword(String password) {
		fillInAndEnter(password, passwordElement);
	}

	private void fillInAndEnter(String value, WebElement element) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(element));
		new Actions(driver).moveToElement(element).click().build().perform();
		WDUtil.sleep(1000);
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}
}

