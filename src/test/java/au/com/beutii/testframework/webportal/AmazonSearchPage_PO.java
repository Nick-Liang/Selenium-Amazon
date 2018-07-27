package au.com.beutii.testframework.webportal;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AmazonSearchPage_PO extends BasePageObject{

	public AmazonSearchPage_PO(WebDriver driver) {
		super(driver);
	}

	@FindBy(how=How.ID, using="searchTemplate")
	public WebElement searchPageTemplate;

	@FindBy(how=How.ID, using="pagnNextString")
	public WebElement nextPageBtn;

	private int totalSacnnedPage = 20;

	public void scrollIntoView(String name){
		int pageNo = 1;
		while(pageNo <= totalSacnnedPage){
			List<WebElement> searchResults = new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@id='s-results-list-atf']//li//h2"), 48));
			for(WebElement element : searchResults){
				if(element.getText().contains(name)){
					scrollIntoViewSmoothly(element);
					WDUtil.sleep(1500);
					clickItem(element);
					return;
				}
			}
			scrollIntoViewSmoothly(nextPageBtn);
			if(!nextPageBtn.isEnabled()){
				return;
			}
			WDUtil.sleep(3000);
			clickItem(nextPageBtn);
		}
	}

	private void clickItem(WebElement element){
		new Actions(driver).moveToElement(element).click().build().perform();
	}

	private void scrollIntoViewSmoothly(WebElement element){
		new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("rhf-container")));
		((JavascriptExecutor) driver).executeScript("window.scrollTo({top: "+ (element.getLocation().y - 200) +", behavior: 'smooth'});", element);
	}
}

