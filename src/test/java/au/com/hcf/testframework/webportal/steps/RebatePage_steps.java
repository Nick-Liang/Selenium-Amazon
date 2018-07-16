//Author:Satheesh Marripudi
package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.webportal.RebatePage_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RebatePage_steps extends StepsBase{
	@Given("^I am on rebate details page$")
	public void i_am_on_rebate_details_page() {
		RebatePage_PO rebatePage = ctx().put(PageFactory.initElements(getWD(), RebatePage_PO.class));
		rebatePage.verifyRebatepage(); 
	}

	@When("^I select registeredas \"([^\"]*)\", annualincome\"([^\"]*)\",displays rebate \"([^\"]*)\"$")
	public void i_select_registeredas_annualincome_displays_rebate(String registeredAs, String annualIncome, String rebateTier /*not currently used*/) {
		RebatePage_PO rebatePage = ctx().get(RebatePage_PO.class);
		rebatePage.selectRegisteredAs(registeredAs);
		rebatePage.selectAnnualIncome(annualIncome);
		//TODO: Nikolay: implement rebate selection
		rebatePage.clickNextButton();
	}

	@Then("^I should see hospital cover page$")
	public void i_should_see_hospital_cover_page() {
		ctx().get(RebatePage_PO.class).validateHospitalCoverSectionLoaded();
	}   
}