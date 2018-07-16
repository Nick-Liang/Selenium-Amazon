//Author : Satheesh Marripudi				
package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.HospitalCover_PO;
import au.com.hcf.testframework.webportal.RebatePage_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HospitalCover_steps extends StepsBase{
	@Given("^I am on HOSPITAL COVER page$")
	public void i_am_on_HOSPITAL_COVER_page() {
		ctx().put(PageFactory.initElements(getWD(), RebatePage_PO.class));
		ctx().get(RebatePage_PO.class).validateHospitalCoverSectionLoaded();
	}

	@When("^I select Hospital cover\"([^\"]*)\", Extras\"([^\"]*)\" and click Next button\\.$")
	public void i_select_Hospital_cover_Extras_and_click_Next_button(String hospitalcover, String extras) {
		HospitalCover_PO hospitalCover = ctx().put(PageFactory.initElements(getWD(), HospitalCover_PO.class));
		WDUtil.sleep(2200);
		hospitalCover.selectHospitalCover(hospitalcover);
		WDUtil.sleep(2200);
		hospitalCover.selectExtraCover(extras);
		WDUtil.sleep(2200);
		hospitalCover.clickNextButton();
		WDUtil.sleep(2200);

	}

	@Then("^I should see EXCESS page$")
	public void i_should_see_EXCESS_page() {
		HospitalCover_PO hopitalCover = ctx().put(PageFactory.initElements(getWD(), HospitalCover_PO.class));
		hopitalCover.ValidateExcessSectionLoaded();
	}

}