package au.com.beutii.testframework.webportal.steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.TravelInsurancce_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TravelInsurance_steps extends StepsBase{

	@Given("^I am on travel home page$")
	public void i_am_on_HCF_home_page() {
		String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL()+"/insurance/travel";
		getWD().get(url);
		ctx().put(PageFactory.initElements(getWD(), TravelInsurancce_PO.class));
		
		Assert.assertTrue(
				"Travel insurance selection panel should be present on the page", 
				ctx().get(TravelInsurancce_PO.class).selectTravelInsurance()
			);
	}

	@When("^There is Travel insurance selection panel on the page$")
	public void i_navigate_through_Travel_menus() {
		Assert.assertTrue(
				"Travel insurance selection panel should be present on the page", 
				ctx().get(TravelInsurancce_PO.class).selectTravelInsurance()
			);
	}
	
	@When("^I click on Get a quote button on travel page$")
	public void i_click_Get_a_quote_button() {		
		ctx().get(TravelInsurancce_PO.class).clickOnGetaQuoteButton();
	}
	
	@Then("^I should see modal window asking if already an HCF member$")	
	public void i_should_see_modal_window_asking_if_already_an_HCF_member() {
		
		Assert.assertTrue(
				"ARE YOU ALREADY AN HCF MEMBER window should be present on the page", 
				ctx().get(TravelInsurancce_PO.class).validateTravelAlertwindow()
			);		
	}

	@Given("^I select Yes on travel modal window$")
	public void i_select_Yes_on_travel_modal_window() {
		ctx().get(TravelInsurancce_PO.class).alertSelectYes();
	}

	@When("^I enter member number and click on Get a quote button$")
	public void i_enter_member_number_and_click_on_Get_a_quote_button() {
		ctx().get(TravelInsurancce_PO.class).alertEnterMemberNum("19");
	}

	@Then("^I should navigate to HCF members travel qbe page$")
	public void i_should_navigate_to_HCF_members_travel_qbe_page() {		
		ctx().get(TravelInsurancce_PO.class).validateTravelMemberQBEpage();			
	}

	@Given("^I am on travel modal window$")
	public void i_am_on_travel_modal_window() {
		ctx().get(TravelInsurancce_PO.class).validateTravelAlertwindow();
	}

	@When("^I select No on travel modal window$")
	public void i_select_No_on_travel_modal_window() {
		ctx().get(TravelInsurancce_PO.class).alertSelectNo();
	}

	@Then("^I should navigate to HCF travel qbe page$")
	public void i_should_navigate_to_HCF_travel_qbe_page()  {
		ctx().get(TravelInsurancce_PO.class).validateTravelPublicQBEpage();
	}

	@When("^I enter invalid member number and click on Get a quote button$")
	public void i_enter_invalid_member_number_and_click_on_Get_a_quote_button() {
		ctx().get(TravelInsurancce_PO.class).alertEnterMemberNum("1396");
	}

	@Then("^I should see error message on travel modal window$")
	public void i_should_see_error_message_on_travel_modal_window() {		
		ctx().get(TravelInsurancce_PO.class).validateTravelNonMemberErrorMsg();			
	}


}