package au.com.beutii.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;
import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.LifeQuote_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LifeQuote_steps extends StepsBase{
	
	String redirectURL;
			
	@Given("^I am on HCF life insurance \"([^\"]*)\" page$")
	public void i_am_on_life_page(String arg1) {
		String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
		String arg = arg1.replace(" ", "-");
		url = url+"/life-insurance"+"/"+arg;	
		getWD().get(url);
		getWD().switchTo().window(getWD().getWindowHandle());
		ctx().put(PageFactory.initElements(getWD(), LifeQuote_PO.class));
	}
	
	@When("^I click on Get a quote button$")
	public void i_click_Get_a_quote_button() {		
		ctx().get(LifeQuote_PO.class).clickOnGetaQuoteButton();
	}

	@Then("^I should see My Quote popup$")
	public void i_should_see_my_quote_page() {		
		
		//Validate My Quote popup
		ctx().get(LifeQuote_PO.class).validateMyQuotePopup();
	}
	
	@Given("^I select cover type \"([^\"]*)\"$")
	public void i_select_cover_type(String arg1){
		ctx().get(LifeQuote_PO.class).selectCoverType(arg1);
	    
	}

	@When("^I click on Calculate quote button$")
	public void i_click_on_calculate_quote_button(){
		ctx().get(LifeQuote_PO.class).clickCalculateQuoteBtn();
	}

	@Then("^I should get My Quote Summary with total premium amount\"([^\"]*)\"$")
	public void i_should_get_My_Quote_Summary_with_total_premium_amount(String arg1){
		ctx().get(LifeQuote_PO.class).validateQuoteSummary(arg1);
	}
	
	@Given("^I am on life my quote summary$")
	public void i_am_on_life_my_quote_summary() {
		ctx().get(LifeQuote_PO.class).validateQuoteSummaryPopup();
	}

	@When("^I click on life email quote button$")
	public void i_click_on_life_email_quote_button() {
		ctx().get(LifeQuote_PO.class).clickEmailQuote();
	    
	}

	@When("^enter email address, click on send button$")
	public void enter_email_address_click_on_send_button() {
		ctx().get(LifeQuote_PO.class).enterEmail();
		ctx().get(LifeQuote_PO.class).clickSendEmailBtn();
	}

	@Then("^I should see life email quote confirmation message$")
	public void i_should_see_life_email_quote_confirmation_message() {
		ctx().get(LifeQuote_PO.class).validateEmailConfirmationMsg();
	}

}