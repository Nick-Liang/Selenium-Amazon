package au.com.hcf.testframework.webportal.steps;
//Author : Satheesh Marripudi

import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage_steps extends StepsBase{

	@Given("^I am on Amazon home page$")
	public void i_am_on_Amazon_home_page() {
		if(StringUtils.equals(getWD().getCurrentUrl(), "data:,")){
			String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
			getWD().get(url);
		}
		ctx().put(PageFactory.initElements(getWD(), AmazonHomePage_PO.class));
		ctx().put(PageFactory.initElements(getWD(), AmazonSearchPage_PO.class));
		ctx().put(PageFactory.initElements(getWD(), AmazonLogin_PO.class));
	}

	@When("^I click search box and type \"([^\"]+)\"$")
	public void I_click_search_box_and_type_and_search(String keywords) {
		ctx().get(AmazonHomePage_PO.class).clickSearchBox();
		ctx().get(AmazonHomePage_PO.class).startToSearch(keywords);
	}

	@Then("^I should see search result page$")
	public void I_should_see_search_result_page() {
		Assert.assertTrue("Search page has to be displayed", ctx().get(AmazonSearchPage_PO.class).searchPageTemplate.isDisplayed());
	}

	@Then("^I will scroll to \"([^\"]+)\"$")
	public void i_scroll_to_the_item(String itemName) {
		ctx().get(AmazonSearchPage_PO.class).scrollIntoView(itemName);
	}

	@Given("^I am signing out$")
	public void i_am_signing_out() {
		Assert.assertTrue(ctx().get(AmazonLogin_PO.class).amISignedIn());
		ctx().get(AmazonLogin_PO.class).hoverToSignIn();
		ctx().get(AmazonLogin_PO.class).clickSignOut();
	}
}