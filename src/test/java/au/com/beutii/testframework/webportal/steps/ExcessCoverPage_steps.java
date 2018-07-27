//Author : Satheesh Marripudi
package au.com.beutii.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.ExcessCover_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExcessCoverPage_steps extends StepsBase{
	@Given("^I am on hospital excess page$")
	public void i_am_on_hospital_excess_page() {
		ExcessCover_PO excessPO = ctx().put(PageFactory.initElements(getWD(), ExcessCover_PO.class));
		excessPO.ValidateExcessSectionLoaded();   	
	}

	@When("^I select hospital excess\"([^\"]*)\" and click Next button\\.$")
	public void i_select_hospital_excess_and_click_Next_button(String arg1) {
		ExcessCover_PO excessPO = ctx().get(ExcessCover_PO.class);
		excessPO.selectExcess(arg1);
		excessPO.clickNextButton();

	}

	@Then("^I should see Cover Summary page$")
	public void i_should_see_Cover_Summary_page() {
		ctx().get(ExcessCover_PO.class).IsCoverSummaryPageDisplayed();
	}


}