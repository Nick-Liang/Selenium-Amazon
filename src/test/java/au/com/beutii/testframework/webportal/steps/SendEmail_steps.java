package au.com.beutii.testframework.webportal.steps;
//Author : Satheesh Marripudi

import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.webportal.AmazonLogin_PO;
import au.com.beutii.testframework.webportal.AmazonProductPage_PO;
import au.com.beutii.testframework.webportal.SendEmailService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class SendEmail_steps extends StepsBase{

    @Given("^I am signing out$")
    public void i_am_signing_out() {
        Assert.assertTrue(ctx().get(AmazonLogin_PO.class).amISignedIn());
        ctx().get(AmazonLogin_PO.class).hoverToSignIn();
        ctx().get(AmazonLogin_PO.class).clickSignOut();
    }

	@When("^All tests are completed$")
	public void all_tests_are_completed() {
		ctx().put(PageFactory.initElements(getWD(), AmazonProductPage_PO.class));
		WDUtil.sleep(2000);
	}

	@Then("^I should send an email to \"([^\"]+)\", from \"([^\"]+)\", with msg \"([^\"]+)\" and password is \"([^\"]+)\"$")
	public void I_should_send_notification_email(String to, String from, String msg, String password) {
        SendEmailService sendEmailService =  SendEmailService.getInstance();
        sendEmailService.sendNotificationEmail(to, from, msg, password);
	}

}