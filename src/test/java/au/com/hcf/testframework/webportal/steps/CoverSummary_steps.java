//Author : Satheesh Marripudi
package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.webportal.CoverSummary_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CoverSummary_steps extends StepsBase{
	@Given("^I am on Cover Sumary Page$")
	public void i_am_on_Cover_Sumary_Page() {
		CoverSummary_PO coverSummaryPO = ctx().put(PageFactory.initElements(getWD(), CoverSummary_PO.class));
		coverSummaryPO.validateRebateOnCoverSummary();
	}

	@When("^I validate rebate as Rebate , hospital excess as excesspay$")
	public void i_validate_rebate_as_Rebate_hospital_excess_as_excesspay() {
		ctx().get(CoverSummary_PO.class).validateHospitalexcessOnCoverSummary();

	}

	@When("^I validate hospital cover and extras$")
	public void i_validate_hospital_cover_and_extras() {
		//TODO: Nikolay: implement
		PageFactory.initElements(getWD(), CoverSummary_PO.class);
		//CoverSummary_PO.validateHospitalCoverExtrasOnCoverSummmary();
	}

	@When("^I click on Continue Button$")
	public void i_click_on_Continue_Button() {
		ctx().get(CoverSummary_PO.class).clickNextButton();
		//WDUtil.sleep(1000);
	}

	@Then("^I Should see Purchase page$")
	public void i_Should_see_Purchase_page() {
		ctx().get(CoverSummary_PO.class).verifyPurchasePagelanding();
		//    CoverSummary_PO.clickEmailinQuote();
		//    CoverSummary_PO.fillEmailandQuote("abc@gmail.com", "0400000000");
		//    CoverSummary_PO.clickSendButtonOnEmailQuote();
		//    CoverSummary_PO.thankYouMessage();
	}


	@Then("^I Click on Purchase link to see Getting Started page$")
	public void i_Click_on_Purchase_link_to_see_Getting_Started_page() {
		ctx().get(CoverSummary_PO.class).clickPurchaseLink();
	}
	
	 @Then("user clicks on Continue button and see Purchage button on Product summary page$")
		public void user_clicks_on_Continue_button_and_see_Purchage_button() {		 
			ctx().get(CoverSummary_PO.class).clickNextButton();
			ctx().get(CoverSummary_PO.class).verifyPurchasePagelanding();
			ctx().get(CoverSummary_PO.class).verifyPurchageButton();
			
		}
}