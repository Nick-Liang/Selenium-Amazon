//Author : Satheesh Marripudi
package au.com.beutii.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.webportal.MemberClaim_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MemberClaim_steps extends StepsBase{
	@Then("^I See Home page$")
	public void i_See_Home_page() {
		ctx().put(PageFactory.initElements(getWD(), MemberClaim_PO.class));
		ctx().get(MemberClaim_PO.class).checkMemberHomepageisdisplayed();

	}


	@Given("^I am on HCF Members Home$")
	public void i_am_on_HCF_Members_Home() {
		i_See_Home_page();
	}

	@When("^I click on Make a Claim button$")
	public void i_click_on_Make_a_Claim_button() {
		ctx().get(MemberClaim_PO.class).clickMakeOnLineClaimButton();
	}

	@When("^I enter your details: Provider details\"([^\"]*)\", Location \"([^\"]*)\" and click submit$")
	public void i_enter_your_details_Provider_details_Location_and_click_submit(String provider, String arg2) {
		PageFactory.initElements(getWD(), MemberClaim_PO.class);
		ctx().get(MemberClaim_PO.class).selectProvideType();
		ctx().get(MemberClaim_PO.class).selectState();
		ctx().get(MemberClaim_PO.class).clickSubmitButton();
		WDUtil.sleep(1000);
	}

	@When("^I enter postcode \"([^\"]*)\" , and Surname \"([^\"]*)\"$")  //TODO am... a lot more things are entered here!!! bring them to scenario level
	public void i_enter_postcode_and_Surname(String arg1, String arg2) {
		ctx().get(MemberClaim_PO.class).selectProviderPostcode();
		ctx().get(MemberClaim_PO.class).selectProviderSurname();
		ctx().get(MemberClaim_PO.class).clickContinueOnSelectProvider();
		ctx().get(MemberClaim_PO.class).selectPatientName();
		ctx().get(MemberClaim_PO.class).selectItem();
		ctx().get(MemberClaim_PO.class).selectDate();
		ctx().get(MemberClaim_PO.class).selectMonth();
		ctx().get(MemberClaim_PO.class).selectYear();
		ctx().get(MemberClaim_PO.class).inputAmountCharged();
		ctx().get(MemberClaim_PO.class).clickAddItem();
		WDUtil.sleep(1000);
		ctx().get(MemberClaim_PO.class).clickConfirmButtonOnSelectItem();
		WDUtil.sleep(2000);
		ctx().get(MemberClaim_PO.class).clickAgreeOnConfirmationPage();
		ctx().get(MemberClaim_PO.class).clickSubmitClaim();
		WDUtil.sleep(2000);
	}
}