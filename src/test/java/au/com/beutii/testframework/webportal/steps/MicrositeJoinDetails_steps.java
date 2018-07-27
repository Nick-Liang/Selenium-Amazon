//Author : Satheesh Marripudi
package au.com.beutii.testframework.webportal.steps;
import org.openqa.selenium.support.PageFactory;
import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.webportal.MicrositeJoin_PO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MicrositeJoinDetails_steps extends StepsBase{
	@Given("^I am on HCF microsite home page$")
	public void i_am_on_microsite_home_page() {
		
		String micrositeURL = ctx().get(CTX.CONFIGURATION, Configuration.class).getMicrositeURL();
		getWD().get(micrositeURL);
		
		ctx().put(PageFactory.initElements(getWD(), MicrositeJoin_PO.class));
		//ctx().get(MicrositeJoin_PO.class).health.isDisplayed();
		System.out.println("Home page loaded"); //TODO: add actual assert
		WDUtil.sleep(2000);
	}
	
	@Given("^I am on HCF microsite\"([^\"]*)\" home page$")
	public void i_am_on_microsite_page(String micrositeURL) {	
		
		getWD().get(micrositeURL);
		
		ctx().put(PageFactory.initElements(getWD(), MicrositeJoin_PO.class));
		//ctx().get(MicrositeJoin_PO.class).health.isDisplayed();
		System.out.println("Home page loaded"); //TODO: add actual assert
		WDUtil.sleep(2000);
	}

	@When("^I select scale\"([^\"]*)\", state\"([^\"]*)\" and click on View covers button$")
	public void i_select_scale_state_and_click_on_View_covers_button(String scale, String state) {
		ctx().get(MicrositeJoin_PO.class).selectScale(scale);
		ctx().get(MicrositeJoin_PO.class).selectState(state);
		ctx().get(MicrositeJoin_PO.class).clickViewCoversBtn();
	}

	@Then("^I should see View all covers page$")
	public void i_should_see_View_all_covers_page() {
		ctx().get(MicrositeJoin_PO.class).validateViewCoversPage(); 
	}
	
	@Given("^I am on View all covers page$")
	public void i_am_on_View_all_covers_page() {
		ctx().get(MicrositeJoin_PO.class).validateViewCoversPage(); 
	}

	@When("^I update scale\"([^\"]*)\" and state\"([^\"]*)\"$")
	public void i_update_scale_and_state(String scale, String state) {
		ctx().get(MicrositeJoin_PO.class).updateScale(scale);
		ctx().get(MicrositeJoin_PO.class).updateState(state);
		ctx().get(MicrositeJoin_PO.class).clickUpdateBtn();
	}

	@When("^select only show cover which includes \"([^\"]*)\", price by\"([^\"]*)\" and sort by\"([^\"]*)\"$")
	public void select_only_show_cover_which_includes_price_by_and_sort_by(String cover, String arg2, String arg3) {
		ctx().get(MicrositeJoin_PO.class).selectCover(cover);
		ctx().get(MicrositeJoin_PO.class).selectPriceBy(arg2);
		ctx().get(MicrositeJoin_PO.class).selectSortBy(arg3);
	}

	@When("^click on View cover details of \"([^\"]*)\" product$")
	public void click_on_View_cover_details_of_product(String product) {
		ctx().get(MicrositeJoin_PO.class).viewCoverDetails(product);
	   
	}

	@Then("^I should see Cover summary page$")
	public void i_should_see_Cover_summary_page() {
		ctx().get(MicrositeJoin_PO.class).validateCoverSummaryPage();
	}

	@Given("^I am on product Cover Sumary Page$")
	public void i_am_on_product_Cover_Sumary_Page() {
		ctx().get(MicrositeJoin_PO.class).validateCoverSummaryPage();
	}

	@When("^I clicks on Email quote button$")
	public void i_clicks_on_Email_quote_button() {
		ctx().get(MicrositeJoin_PO.class).clickEmailQuoteBtn();
	}

	@When("^I enter email address, clicks on Send$")
	public void i_enter_email_address_clicks_on_Send() {
		ctx().get(MicrositeJoin_PO.class).enterEmail("jthumati@hcf.com.au");
		ctx().get(MicrositeJoin_PO.class).clickSendBtn();
	}

	@Then("^I Should see Thank you message$")
	public void i_Should_see_Thank_you_message() {
		ctx().get(MicrositeJoin_PO.class).validateEmailconfirmationMsg();
	}

	@Then("^I click on Join Now to see Getting started page$")
	public void i_click_on_Join_Now() {
		ctx().get(MicrositeJoin_PO.class).clickJoinNow();
	}

}