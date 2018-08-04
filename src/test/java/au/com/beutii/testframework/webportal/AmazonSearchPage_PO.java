package au.com.beutii.testframework.webportal;

import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.selenium.base.BasePageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
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

	private int totalSacnnedPage = 10;

	public void scrollIntoView(String name){
		int pageNo = 1;
		while(pageNo <= totalSacnnedPage){
			new WebDriverWait(driver, 5).until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@id='s-results-list-atf']//li"), 40));
			List<WebElement> spanSearchResults = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']//li//div[@class='a-column a-span12 a-text-center']"));
			List<WebElement> imgSearchResults = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']//li//div[@class='a-column a-span12 a-text-center']//img"));
			if(!spanSearchResults.isEmpty()){
				for(WebElement element : spanSearchResults){
					WDUtil.scrollIntoViewSmoothly(driver, element);
					WDUtil.sleep(500);
					if (element.getText().contains(name)) {
						WDUtil.scrollIntoViewSmoothly(driver, element);
						WDUtil.sleep(1500);
						WDUtil.clickItem(driver, element.findElement(By.xpath("../../div[position()=1]")));
						return;
					}
				}
			}else if(!imgSearchResults.isEmpty()){
				for(WebElement element : imgSearchResults){
					WDUtil.scrollIntoViewSmoothly(driver, element);
					WDUtil.sleep(500);
					if (element.getAttribute("alt").contains(name)) {
						WDUtil.scrollIntoViewSmoothly(driver, element);
						WDUtil.sleep(1500);
						WDUtil.clickItem(driver, element.findElement(By.xpath("../../../../div[@class='a-row a-spacing-small']")));
						return;
					}

				}
			}
			WDUtil.scrollIntoViewSmoothly(driver, nextPageBtn);
			WDUtil.sleep(1500);
			if(!nextPageBtn.isEnabled()){
				return;
			}
			WDUtil.clickItem(driver, nextPageBtn);
			pageNo++;
		}
		Assert.assertTrue("No result found", false);
	}
}

