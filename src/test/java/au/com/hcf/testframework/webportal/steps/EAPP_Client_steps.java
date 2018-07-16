package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.ContactusForm_PO;
import au.com.hcf.testframework.webportal.EAPP_Client_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EAPP_Client_steps extends StepsBase{	
	
	String baseURL = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
		
	@Given("^I am on EAPP client page$")
	public void i_am_on_eapp_client_page() {		
		String url = baseURL+"/EAPP_Client";
		getWD().get(url);
		
		ctx().put(PageFactory.initElements(getWD(), EAPP_Client_PO.class));		
		System.out.println("EAPP Client page is loaded"); 
		WDUtil.sleep(2000);
	}

	@When("^I fill in agentId\"([^\"]*)\", dealCode\"([^\"]*)\", password\"([^\"]*)\", agentCustomerId\"([^\"]*)\", agentPaymentId\"([^\"]*)\"$")	
	public void I_fill_in_agentId_dealCode_password_agentCustomerId_agentPaymentId(String agentId, String dealCode, String password, String agentCustomerId, String agentPaymentId) {
		
	/*	ctx().get(EAPP_Client_PO.class).setAgentId(agentId);
		ctx().get(EAPP_Client_PO.class).setDealCode(dealCode);
		ctx().get(EAPP_Client_PO.class).setPassword(password);
		ctx().get(EAPP_Client_PO.class).setAgentCustId(agentCustomerId);
		ctx().get(EAPP_Client_PO.class).setAgentPaymentId(agentPaymentId);	*/	
	}
	
	@When("^I fill in givenName, surname, dob, emailAddress\"([^\"]*)\"$")	
	public void I_fill_in_givenName_surname_dob_emailAddress(String emailAddress) {
		
		ctx().get(EAPP_Client_PO.class).setGivename();
		ctx().get(EAPP_Client_PO.class).setSurname();
		ctx().get(EAPP_Client_PO.class).setDOB();
		ctx().get(EAPP_Client_PO.class).setEmailAddress(emailAddress);		
	}
	
	@When("^click on generate button$")	
	public void click_on_generate_button() {		
		
		ctx().get(EAPP_Client_PO.class).clickGenerateButton();		
	}

	@Then("^I should see success message$")
	public void i_should_see_success_message() {
		
		ctx().get(EAPP_Client_PO.class).validateSuccessMsg();
	}
	


}