package au.com.hcf.testframework.webportal.steps;
//Author : Satheesh Marripudi

import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.AmazonHomePage_PO;
import au.com.hcf.testframework.webportal.AmazonSearchPage_PO;
import au.com.hcf.testframework.webportal.BasicDetails_PO;
import au.com.hcf.testframework.webportal.HomePage_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage_steps extends StepsBase{

	@Given("^I am on Amazon home page$")
	public void i_am_on_Amazon_home_page() {
		String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
		getWD().get(url);
		ctx().put(PageFactory.initElements(getWD(), AmazonHomePage_PO.class));
	}

	@When("^I click search box and type \"([^\"]+)\"$")
	public void I_click_search_box_and_type_and_search(String keywords) {
		ctx().get(AmazonHomePage_PO.class).clickSearchBox();
		ctx().get(AmazonHomePage_PO.class).startToSearch(keywords);
	}

	@Then("^I should see search result page$")
	public void I_should_see_search_result_page() {
		ctx().put(PageFactory.initElements(getWD(), AmazonSearchPage_PO.class));
		Assert.assertTrue("Search page has to be displayed", ctx().get(AmazonSearchPage_PO.class).searchPageTemplate.isDisplayed());
	}

	@Then("^I will scroll to \"([^\"]+)\"$")
	public void i_scroll_to_the_item(String itemName) {
		ctx().get(AmazonSearchPage_PO.class).scrollIntoView(itemName);
	}

	/*@Then("^I Should see Travel insurance page$")
	public void i_Should_see_Travel_insurance_page() {
		if(getWD().getCurrentUrl().contains("travel-insurance"))
		{
			System.out.println("Travel insurance page displayed");
		}
	}

	@Then("^I Should see PET insurance page$")
	public void i_Should_see_PET_insurance_page() {
		if(getWD().getCurrentUrl().contains("pet-insurance"))
		{
			System.out.println("Pet insurance page displayed");
		}

	}

	@Then("^I Should see Levels of Insurance page$")
	public void i_Should_see_Levels_of_Insurance_page() {
		if(getWD().getCurrentUrl().contains("levels-of-health-insurance"))
		{
			System.out.println("levels-of-health-insurance page displayed");
		}
	}

	@When("^I navigate through health and customise-cover menus$")
	public void i_navigate_through_health_and_customise_cover_menus() {
		ctx().get(HomePage_PO.class).clickHealthMenu();
		System.out.println("health link dispayed");
		ctx().get(HomePage_PO.class).clickCustomiseCoverMenu();
		System.out.println("Customise Cover link has been clicked");

	}

	@When("^I navigate through \"([^\"]+)\" and \"([^\"]+)\" menu to \"([^\"]+)\"$")
	public void i_navigate_through_about_us_and_media_center_menu_to_media_releases(String menu, String submenu, String linkText) {
		ctx().get(HomePage_PO.class).clickLinkUnderTwoLevelMenu(menu, submenu, linkText);
	}


	@Then("^I should see basic details page$")
	public void i_should_see_basic_details_page() {
		BasicDetails_PO basicDetails = ctx().put(PageFactory.initElements(getWD(), BasicDetails_PO.class));
		Assert.assertTrue("Basic Details page has to be displayed", basicDetails.isDisplayed());
	}

	@Then("^I Should see Levels of Private Health care page$")
	public void i_Should_see_Levels_of_Private_Health_care_page() {
		if(getWD().getCurrentUrl().contains("private-health-care-explained"))
		{
			System.out.println("private-health-care-explained page displayed");
		}
	}*/
}