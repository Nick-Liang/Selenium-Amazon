//Author : Satheesh Marripudi
package au.com.hcf.testframework.webportal.steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.webportal.BasicDetails_PO;
import au.com.hcf.testframework.webportal.RebatePage_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasicDetailsPage_steps extends StepsBase{

	@Given("^I am on basic details page$")
	public void i_am_on_basic_details_page() {
		BasicDetails_PO basicDetailsPO = ctx().put(PageFactory.initElements(getWD(), BasicDetails_PO.class));
		Assert.assertTrue("Basic details page has to be loaded", basicDetailsPO.isDisplayed());
	}

	@When("^I fill fmaily status\"([^\"]*)\", state\"([^\"]*)\", age\"([^\"]*)\" and click on Next button$")
	public void i_fill_fmaily_status_state_age_and_click_on_Next_button(String Family, String location, String Age) {
		BasicDetails_PO basicDetailsPO = ctx().get(BasicDetails_PO.class);
		basicDetailsPO.selectCoverageType(Family);
		basicDetailsPO.selectLocation(location);
		basicDetailsPO.selectAge(Age);
		basicDetailsPO.clickNextButton();
	}

	@Then("^i should see taxrebate page$")
	public void i_should_see_taxrebate_page() {
		RebatePage_PO rebatePage = ctx().put(PageFactory.initElements(getWD(), RebatePage_PO.class));
		rebatePage.synchronise();
		rebatePage.verifyRebatepage();
	}   
}