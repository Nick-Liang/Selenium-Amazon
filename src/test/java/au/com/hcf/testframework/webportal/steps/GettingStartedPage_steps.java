package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.webportal.GettingStartedPage_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GettingStartedPage_steps extends StepsBase{
	@Given("^I am on Getting Started page$")
	public void i_am_on_Getting_Started_page() {
		ctx().put(PageFactory.initElements(getWD(), GettingStartedPage_PO.class));
		ctx().get(GettingStartedPage_PO.class).IsGettingStartedpageloaded();
	}	
	

	@When("^I Check Medical entitlement$")
	public void i_Check_Medical_entitlement() {
		ctx().get(GettingStartedPage_PO.class).chkIsMedicare();
	}

	@When("^I Check not an existing HCF Member$")
	public void i_Check_not_an_existing_HCF_Member() {
		ctx().get(GettingStartedPage_PO.class).chkIsMember();
	}

	@Then("^I Click Getting started and should see Join details page$")
	public void i_should_see_Join_details_page() {
		ctx().get(GettingStartedPage_PO.class).clickGetstartedButton();
	}
	
	//Steps for new application form
	@Given("^New I am on Getting Started page$")
	public void new_I_am_on_Getting_Started_page() {
		ctx().put(PageFactory.initElements(getWD(), GettingStartedPage_PO.class));
		ctx().get(GettingStartedPage_PO.class).newIsGettingStartedpageloaded();
	}
	
	@When("^I select not an existing HCF Member$")
	public void new_i_Check_not_an_existing_HCF_Member() {
		ctx().get(GettingStartedPage_PO.class).selectIsMember();
	}
	
	@When("^I select Medical entitlement$")
	public void i_select_Medical_entitlement() {
		ctx().get(GettingStartedPage_PO.class).selectIsMedicare();
	}
	
	@When("^I enter email address$")
	public void i_enter_email_address() {
		ctx().get(GettingStartedPage_PO.class).enterEmail();
	}
	
	@When("^I select stay in touch$")
	public void i_select_stay_touch() {
		ctx().get(GettingStartedPage_PO.class).selectStayInTouch();
	}
	
	@Then("^I Click continue to Personal details button$")
	public void i_click_continue_Personal_details_button() {
		ctx().get(GettingStartedPage_PO.class).clickContinueToPersonalBtn();
	}
}


