package au.com.beutii.testframework.webportal.steps;
//Author : Satheesh Marripudi

import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.webportal.AmazonLogin_PO;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage_steps extends StepsBase{

	@Given("^I am not logged in$")
	public void i_am_on_Amazon_home_page() {
		if(StringUtils.equals(getWD().getCurrentUrl(), "data:,")){
			String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
			getWD().get(url);
		}
		ctx().put(PageFactory.initElements(getWD(), AmazonLogin_PO.class));
		Assert.assertFalse(ctx().get(AmazonLogin_PO.class).amISignedIn());
	}

	@When("^I hover my mouse on sign-in area and click through to login page$")
	public void I_hover_my_mouse_over_sign_in_area() {
		ctx().get(AmazonLogin_PO.class).hoverToSignIn();
		ctx().get(AmazonLogin_PO.class).clickSignIn();
	}

	@Then("^I input my email address \"([^\"]+)\"$")
	public void I_input_my_username(String username) {
		ctx().get(AmazonLogin_PO.class).inputUserName(username);
	}

	@Then("^I input my password \"([^\"]+)\"$")
	public void I_input_my_password(String password) {
		ctx().get(AmazonLogin_PO.class).inputPassword(password);
	}

	@Then("^I should be redirect back to home page with logged in$")
	public void I_am_logged_in() {
		Assert.assertTrue(ctx().get(AmazonLogin_PO.class).amISignedIn());
	}

}