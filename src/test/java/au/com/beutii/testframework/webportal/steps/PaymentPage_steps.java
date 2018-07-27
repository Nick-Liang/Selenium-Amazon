package au.com.beutii.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.PaymentDetails_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentPage_steps extends StepsBase{
	
	String baseURL = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
	
	@Given("^I am on Payment Details page$")
	public void i_am_on_Payment_Details_page() {
		PaymentDetails_PO page = ctx().put(PageFactory.initElements(getWD(), PaymentDetails_PO.class));
		page.checkPaymentPageLoaded();
	}

	@When("^I select Payment Mode$")
	public void i_select_Payment_Mode() {
		ctx().get(PaymentDetails_PO.class).selectpaymentMethod();
	}
	
	@When("^I select First Payment Mode as Pay now$")
	public void i_select_first_Payment_Mode() {
		//already selected ctx().get(PaymentDetails_PO.class).selectPaynow();
	}

	@When("^I select Type of card \"([^\"]*)\" , debit frequencey \"([^\"]*)\" and Nominated Debit day$")
	public void i_select_Type_of_card_debit_frequencey_and_Nominated_Debit_day(String cardtype, String debitfrequency){
		PaymentDetails_PO page = ctx().get(PaymentDetails_PO.class);
		page.selectCreditforFirstMonthPay();		
		page.selectDebitFrequency(debitfrequency);
		page.selectnominatedDebitDay();
		page.setCardHolderName("Hello");
		page.selectCardType(cardtype);
		page.setCardHolderNumber("2223000048400011");
		page.setCreditCardExpiryMonth("Feb");
		page.setCreditCardExpiryYear("2018");		
		page.selectnominateYourBankAccount();
		page.authorisePayment();	
		
	}
	
	@When("^I select Type of card \"([^\"]*)\" and card details for one-off payment$")
	public void i_select_Type_of_card_and_details_for_oneoff_payment(String cardtype){
		PaymentDetails_PO page = ctx().get(PaymentDetails_PO.class);
		page.payNowSetCardHolderName("Test");		
		page.payNowSelectCardType(cardtype);
		page.paynowSetCardHolderNumber("5105105105105100");
		page.payNowSetCreditCardExpiryMonth("Feb");
		page.payNowSetCreditCardExpiryYear("2018");
		page.payNowSetCreditCardCVV("321");		
	}
	
	@When("^I select regular payment frequency \"([^\"]*)\" and Nominated Debit day$")
	public void i_select_regular_payment_frequencey_and_Nominated_Debit_day(String debitfrequency){
		PaymentDetails_PO page = ctx().get(PaymentDetails_PO.class);
				
		page.selectDebitFrequency(debitfrequency);
		page.selectnominatedDebitDay();				
		page.selectnominateYourBankAccount();
		page.authorisePayment();
				
	}
	
	@When("^I select regular payment frequency \"([^\"]*)\" and wish to pay by Ezipay direct debit$")
	public void i_select_regular_payment_frequencey_and_pay_by_Ezipay_direct_debit(String debitfrequency){
		PaymentDetails_PO page = ctx().get(PaymentDetails_PO.class);
				
		page.selectDebitFrequency(debitfrequency);
		page.selectnominatedDebitDay();	
		page.enterEzipayAccountDetails();
		page.selectClaimsPaidintoAccount();
		page.authorisePayment();		
		
	}
	
	
	@Then("^I should see welcome message$")
	public void i_should_see_welcome_message() {
		
		if (baseURL.indexOf("uat2.hcf.com.au")> 0){
			ctx().get(PaymentDetails_PO.class).clickContinueOnPaymentDetails();
			ctx().get(PaymentDetails_PO.class).checkJoiningMessage();			
			}
		else{ 
			System.out.println("Production - Discontinue on Payment details page");
		}
		
	}	
}