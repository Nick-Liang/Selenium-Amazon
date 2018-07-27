package au.com.beutii.testframework.webportal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import au.com.beutii.testframework.selenium.base.BasePageObject;

public class ReCalculation_PO extends BasePageObject{

	public ReCalculation_PO(WebDriver driver) {
		super(driver);
	}


	private boolean isAttributePresentInElement(WebElement element, String attribute){
		Boolean attributePresent = false;
		try{
			String attributeValue = element.getAttribute(attribute);
			if(attributeValue != null){
				System.out.println("WebElement : " + element + " has checked attribute -cover selected");
				attributePresent = true;
			}
		}catch(Exception e){

		}
		return attributePresent;
	}

	private Boolean getCheckOrUncheck(String check){
		Boolean checkField = true;
		if(check.toLowerCase().equals("true") || check.toLowerCase().equals("yes") || check.toLowerCase().equals("check")){
			checkField = true;
		}

		if(check.toLowerCase().equals("false") || check.toLowerCase().equals("no") || check.toLowerCase().equals("uncheck")){
			checkField = false;
		}
		return checkField;
	}

	public void selectPartnerHeldHospitalCover(String check){
		Boolean checkField = getCheckOrUncheck(check);
		//WebElement checkbox = driver.findElement(By.xpath("//div[@name='ctl00$cphMainContent$chkIscontinuousCover']/label/input"));
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='ctl00_cphMainContent_chkIscontinuousCover']"));
		
		if(isAttributePresentInElement(checkbox, "checked")){
			if(checkField){
			}else{
				driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_chkIscontinuousCover']")).click();
				//Updated code 12/01/2016 kbg
				//checkbox.click();
			}

		}else{
			if(checkField){
				driver.findElement(By.xpath("//label[@for='ctl00_cphMainContent_chkIscontinuousCover']")).click();
				//checkbox.click();
			}else{
			}
		}
	}
	//@FindBy(how=How.XPATH, using="//div[@class='productSummary']/div[2]/span[@class='amount']")
	@FindBy(how=How.XPATH, using="//*[@id='sticky-product-summary']/section/div[1]/div[4]/div[2]")
	public WebElement amountPayperMonth;

	public String getActualMonthlyPay(){
		String Actualpay = amountPayperMonth.getText();
		System.out.println("Monthly pay is " + Actualpay );
		return Actualpay;
	}

	public String getExpectedMonthlyPay(String expectedPay){
		//Updated code 12/01/2016 kbg
		//String ExpectedPay = amountPayperMonth.getText();
		String ExpectedPay = expectedPay;
		return ExpectedPay;
	}

}

//Author : Satheesh Marripudi