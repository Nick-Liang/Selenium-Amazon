package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.webportal.CostCalculator_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CostCalculator_steps extends StepsBase{	
	
	String pid;
	
	@Given("^I have cost calculator procedure ID \"([^\"]*)\"$")
	public void i_have_cost_calculator_procedure_ID(String arg1) {
	   pid = arg1;
	}

	@When("^I navigate to cost calculator$")
	public void i_navigate_to_cost_calculator() {
		String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
		url = url+"/cost-calculator?pid="+pid;
		getWD().get(url);
		
		ctx().put(PageFactory.initElements(getWD(), CostCalculator_PO.class));
	}

	@Then("^I should see corresponding procedure \"([^\"]*)\" cost indicator page, total service cost \"([^\"]*)\" and your cost \"([^\"]*)\"$")
	public void i_should_see_corresponding_procedure_cost_indicator_page_total_service_cost_and_your_cost(String arg1, String arg2, String arg3) {
		ctx().get(CostCalculator_PO.class).validateProcedureName(arg1);
		ctx().get(CostCalculator_PO.class).validateTotalServiceCost(arg2);
		ctx().get(CostCalculator_PO.class).validateYourcost(arg3);
	}
	
	@Then("^I should see Cost Indicator Currently Unavailable message$")
	public void i_should_see_Cost_Indicator_Unavailable_message() {
		ctx().get(CostCalculator_PO.class).validateUnavailabilityMsg();
		
	}

}