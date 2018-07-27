package au.com.beutii.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.MediaReleases_PO;
import cucumber.api.java.en.Then;

public class StaticPages_steps extends StepsBase{
	@Then("^I see Media Releases page$")
	public void i_see_media_releases_page(){
    	ctx().put(PageFactory.initElements(getWD(), MediaReleases_PO.class));
    	ctx().get(MediaReleases_PO.class).checkMediaReleaseeNotificationSubscriptionDisplayed();
	}
}
