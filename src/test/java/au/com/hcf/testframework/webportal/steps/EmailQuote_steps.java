//Author : Satheesh Marripudi
package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.EmailQuote_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmailQuote_steps extends StepsBase{

	@Given("^I am on Purchase Page$")
	public void i_am_on_Purchase_Page() {
		ctx().put(PageFactory.initElements(getWD(), EmailQuote_PO.class));

	}

	@When("^I click email link$")
	public void i_click_email_link() {
		ctx().get(EmailQuote_PO.class).clickEmailinQuote();
	}

	@When("^I fill email \"([^\"]*)\" and Mobile no \"([^\"]*)\"$")
	public void i_fill_email_and_Mobile_no(String email, String mobileno) {
		ctx().get(EmailQuote_PO.class).fillEmailandQuote(email, mobileno);
	}

	@When("^I click on send button$")
	public void i_click_on_send_button() {
		WDUtil.sleep(1000);
		ctx().get(EmailQuote_PO.class).clickSendButtonOnEmailQuote();
	}

	@Then("^I Should see thankyou message window$")
	public void i_Should_see_thankyou_message_window() {
		ctx().get(EmailQuote_PO.class).thankYouMessage();
	}

}