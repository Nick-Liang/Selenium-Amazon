package au.com.beutii.testframework.webportal.steps;
//Author : Satheesh Marripudi

import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.selenium.WDUtil;
import au.com.beutii.testframework.webportal.AmazonProductPage_PO;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class SendEmail_steps extends StepsBase{

	@When("^All tests are completed$")
	public void I_click_add_to_cart() {
		ctx().put(PageFactory.initElements(getWD(), AmazonProductPage_PO.class));
		WDUtil.sleep(2000);
	}

	@Then("^I should see add cart successful page$")
	public void I_should_see_add_cart_successful_page() {
		Assert.assertTrue("Search page has to be displayed", ctx().get(AmazonProductPage_PO.class).addSuccessfully.isDisplayed());
	}

}