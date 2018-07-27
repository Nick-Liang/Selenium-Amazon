package au.com.beutii.testframework.webportal;

import java.util.List;

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


public class MicrositeJoin_PO extends BasePageObject{

	public MicrositeJoin_PO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ctl00_GetaQuote_ddlState']")
	public WebElement stateBtn;
	
	@FindBy(how=How.XPATH, using="//button[@id='ctl00_cphMainContent_ctl00_GetaQuote_btnGetQuote']")
	public WebElement viewCoversBtn;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'ctl00_cphPageHeader_ucPageHeading')]")
	public WebElement viewCoverspage;
	
	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlScale']")
	public WebElement updateScaleBtn;
	
	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlState']")
	public WebElement updateStateBtn;
	
	@FindBy(how=How.XPATH, using="//a[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_UpdateButton']")
	public WebElement updateBtn;
	
	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlPriceInterval']")
	public WebElement priceByBtn;
	
	@FindBy(how=How.XPATH, using="//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlSort']")
	public WebElement sortByBtn;
	
	@FindBy(how=How.XPATH, using="//a[@id='popUpTriggerSaveQuote']")
	public WebElement emailQuoteBtn;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtEmail']")
	public WebElement emailAddress;
	
	@FindBy(how=How.XPATH, using="//button[@id='btnSave']")
	public WebElement sendBtn;
	
	@FindBy(how=How.XPATH, using="//div[@class='popUpDialog']/a/img")
	public WebElement frameCloseBtn;	

	@FindBy(how=How.XPATH, using="//input[@id='ctl00_cphMainContent_PurchaseTabs_ProductSelection_YourQuote_btnContinue']")
	public WebElement joinNowBtn;
	
	public void checkMediaReleaseeNotificationSubscriptionDisplayed(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Media release email notification')]")));
	}
	
	public void selectScale(String scale){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='scalesList']")));
		
		List<WebElement> liElements = driver.findElements(By.xpath("//ul[@class='scalesList']/li"));
        System.out.println(liElements);

        for(int i=1; i <= liElements.size(); i++)
        {
            WebElement scaleElement = driver.findElement(By.xpath("//ul[@class='scalesList']/li[" + i + "]"));
            System.out.println(scaleElement.getText());  
            String scaleText = scaleElement.getText();
            
            if(scaleText.equalsIgnoreCase(scale)){
            	scaleElement.click();
            	break;
            }

        }        
	}
	
	public void selectState(String state){
		
		if(!state.isEmpty()){
		
			stateBtn.click();
			
			List<WebElement> liElements = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_GetaQuote_ddlState']/following-sibling::div/ul/li"));
	        System.out.println(liElements);
	
	        for(int i=1; i <= liElements.size(); i++)
	        {
	            WebElement listElement = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_GetaQuote_ddlState']/following-sibling::div/ul/li["+i+"]/a/span[1]"));
	            WebElement stateListElement = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_GetaQuote_ddlState']/following-sibling::div/ul/li["+i+"]/a"));
	            
	            System.out.println(listElement.getText());  
	            String stateText = listElement.getText();
	            
	            if(stateText.equalsIgnoreCase(state)){
	            	stateListElement.click();
	            	break;
	            }
	
	        } 
		}
        
	}
	
	public void clickViewCoversBtn(){
		viewCoversBtn.click();
		WDUtil.sleep(1000);
	}
	
	public void validateViewCoversPage(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'ctl00_cphPageHeader_ucPageHeading')]")));
		
		String pgTitle = driver.getTitle();
		System.out.println("Page title is "+pgTitle);
		String expTitle = "View all covers";		
		
		Assert.assertTrue(pgTitle.indexOf(expTitle) > 0);
		
	}
	
	public void updateScale(String scale){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlScale']")));
		
		updateScaleBtn.click();
		WDUtil.sleep(500);
		
		List<WebElement> liElements = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlScale']/following-sibling::div/ul/li"));
        System.out.println(liElements);

        for(int i=1; i <= liElements.size(); i++)
        {
            WebElement listElement1 = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlScale']/following-sibling::div/ul/li["+i+"]/a/span[1]"));
            WebElement updateScaleListElement = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlScale']/following-sibling::div/ul/li["+i+"]/a"));
            
            System.out.println(listElement1.getText());  
            String updateScaleText = listElement1.getText();
            
            if(updateScaleText.equalsIgnoreCase(scale)){
            	updateScaleListElement.click();
            	WDUtil.sleep(500);
            	break;
            }

        }    
	}
	
	public void updateState(String state){
		
		if(!state.isEmpty()){
		
			WDUtil.sleep(500);
			updateStateBtn.click();
			WDUtil.sleep(500);
			
			List<WebElement> liElements = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlState']/following-sibling::div/ul/li"));
	        System.out.println(liElements);
	
	        for(int i=1; i <= liElements.size(); i++)
	        {
	            WebElement listElement2 = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlState']/following-sibling::div/ul/li["+i+"]/a/span[1]"));
	            WebElement updateStateListElement = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlState']/following-sibling::div/ul/li["+i+"]/a"));
	            
	            System.out.println(listElement2.getText());  
	            String updateStateText = listElement2.getText();
	            
	            if(updateStateText.equalsIgnoreCase(state)){
	            	updateStateListElement.click();
	            	WDUtil.sleep(1000);
	            	break;
	            }
	
	        } 
	        
		}
	}
	
	public void clickUpdateBtn(){
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_UpdateButton']")));
		
		updateBtn.click();
		WDUtil.sleep(5000);
	}
	
	public void selectCover(String cover){
		
		(new WebDriverWait(driver, 1000))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upnlFilters']")));
		
		List<WebElement> coverCheckboxes = driver.findElements(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upnlFilters']//table[contains(@id,'chklstFeature')]/tbody/tr"));
        System.out.println(coverCheckboxes);

        for(int i=1; i <= coverCheckboxes.size(); i++)
        {
            WebElement coverLable = driver.findElement(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upnlFilters']//table[contains(@id,'chklstFeature')]/tbody/tr["+i+"]/td/label"));
            WebElement covercheckBox = driver.findElement(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upnlFilters']//table[contains(@id,'chklstFeature')]/tbody/tr["+i+"]/td/input"));
            
            System.out.println(coverLable.getText());  
            String updateStateText = coverLable.getText();
            
            if(updateStateText.equalsIgnoreCase(cover)){
            	covercheckBox.click();
            	WDUtil.sleep(1000);
            	break;
            }

        }    
	}
	
	public void selectPriceBy(String interval){
		
		(new WebDriverWait(driver, 1000))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlPriceInterval']")));
		
		priceByBtn.click();		
		WDUtil.sleep(1000);
		List<WebElement> liElements = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlPriceInterval']/following-sibling::div/ul/li"));
        System.out.println(liElements);

        for(int i=1; i <= liElements.size(); i++)
        {
            WebElement listElement3 = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlPriceInterval']/following-sibling::div/ul/li["+i+"]/a/span[1]"));
            WebElement priceByListElement = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlPriceInterval']/following-sibling::div/ul/li["+i+"]/a"));
            
            System.out.println(listElement3.getText());  
            String pricebyText = listElement3.getText();
            
            if(pricebyText.equalsIgnoreCase(interval)){
            	priceByListElement.click();
            	WDUtil.sleep(2000);
            	break;
            }

        }    
	}

	public void selectSortBy(String value){
	
		WDUtil.sleep(1000);
		sortByBtn.click();
		WDUtil.sleep(1000);
		
		List<WebElement> liElements = driver.findElements(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlSort']/following-sibling::div/ul/li"));
	    System.out.println(liElements);
	
	    for(int i=1; i <= liElements.size(); i++)
	    {
	        WebElement listElement4 = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlSort']/following-sibling::div/ul/li["+i+"]/a/span[1]"));
	        WebElement sortByListElement = driver.findElement(By.xpath("//button[@data-id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_ddlSort']/following-sibling::div/ul/li["+i+"]/a"));
	        
	        System.out.println(listElement4.getText());  
	        String sortByText = listElement4.getText();
	        
	        if(sortByText.equalsIgnoreCase(value)){
	        	sortByListElement.click();
	        	WDUtil.sleep(2000);
	        	break;
	        }
	
	    }    
	}
	
	public void viewCoverDetails(String product){	
		
		(new WebDriverWait(driver, 40))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upProducts']")));
		
		List<WebElement> rowElements = driver.findElements(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upProducts']/fieldset/div"));
        System.out.println(rowElements);

        for(int i=2; i <= rowElements.size(); i++)
        {
            WebElement productTextElement = driver.findElement(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upProducts']/fieldset/div["+i+"]/div[1]/span[1]"));
            WebElement productElement = driver.findElement(By.xpath("//div[@id='ctl00_cphMainContent_ctl00_LoadUserControlRight_ctl00_upProducts']/fieldset/div["+i+"]/div[3]/a"));
            
            System.out.println(productTextElement.getText());  
            String productText = productTextElement.getText();
            
            if(productText.equalsIgnoreCase(product)){
            	productElement.click();
            	WDUtil.sleep(500);
            	break;
            }

        }    
	}

	public void validateCoverSummaryPage(){
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@id,'ctl00_cphPageHeader_pageHead')]")));
		
		String pgTitle = driver.getTitle();
		System.out.println("Page title is "+pgTitle);
		String expTitle = "View all cover summary";		
		
		Assert.assertTrue(pgTitle.indexOf(expTitle) > 0);
		
	}
	
	public void clickEmailQuoteBtn(){
		emailQuoteBtn.click();
		WDUtil.sleep(2000);
	}
	
	public void enterEmail(String email){
		
		driver.switchTo().frame("SaveQuote");
	
		//WDUtil.waitNewWindow(driver, title)
		(new WebDriverWait(driver, 40))
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtEmail']")));
		
		emailAddress.sendKeys(email);
		WDUtil.sleep(1000);
	}
	
	public void clickSendBtn(){
		sendBtn.click();
		WDUtil.sleep(1000);
	}
	
	public void validateEmailconfirmationMsg(){
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='divMessage']")));
		
		String confirmationMsg = driver.findElement(By.xpath("//div[@id='divMessage']")).getText();		
		System.out.println("Confirmation message is "+confirmationMsg);
		String expMsg= "Thank you. Your quote has been sent to the email address provided.";
			
		Assert.assertEquals(expMsg, confirmationMsg.trim());
		
		driver.switchTo().defaultContent();	
		
		frameCloseBtn.click();
		WDUtil.sleep(500);		
			
	}
	
	public void clickJoinNow(){
		
		(new WebDriverWait(driver, 30))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='ctl00_cphMainContent_PurchaseTabs_ProductSelection_YourQuote_btnContinue']")));
		joinNowBtn.click();
		WDUtil.sleep(1000);
	}
	
	
}