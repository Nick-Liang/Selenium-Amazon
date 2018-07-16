package au.com.hcf.testframework.webportal.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.PetInsuranceQuote_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PetInsuranceQuote_steps extends StepsBase{
	
	String redirectURL;
			
	@Given("^I am on Pet insurance home page$")
	public void i_am_on_Pet_insurance_page() {
		String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();		
		url = url+"/insurance/pet";	
		getWD().get(url);
		getWD().switchTo().window(getWD().getWindowHandle());
		ctx().put(PageFactory.initElements(getWD(), PetInsuranceQuote_PO.class));
	}
	
	@When("^I click on Get a quote button on pet insurance$")
	public void i_click_Get_a_quote_button() {		
		ctx().get(PetInsuranceQuote_PO.class).clickOnGetaQuoteButton();
	}

	@Then("^I should see HCF Pet sure home page$")
	public void i_should_see_my_quote_page() {		
		    
		ctx().get(PetInsuranceQuote_PO.class).validatePetsurePage();
	}	
	
	@Then("^I should see pet modal window asking if already an HCF member$")	
	public void i_should_see_pet_modal_window_asking_if_already_an_HCF_member() {
		
		Assert.assertTrue(
				"ARE YOU ALREADY AN HCF MEMBER window should be present on the page", 
				ctx().get(PetInsuranceQuote_PO.class).validatePetAlertwindow()
			);
	}

	@Given("^I select Yes on pet modal window$")
	public void i_select_Yes_on_pet_modal_window() {
		ctx().get(PetInsuranceQuote_PO.class).alertSelectYes();
	}

	@When("^I enter member number and click on Get a quote button on pet modal window$")
	public void i_enter_member_number_and_click_on_Get_a_quote_button_pet_window() {
		ctx().get(PetInsuranceQuote_PO.class).alertEnterMemberNum("19");
	}

}