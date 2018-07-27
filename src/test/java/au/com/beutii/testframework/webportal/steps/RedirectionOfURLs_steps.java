package au.com.beutii.testframework.webportal.steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.CTX;
import au.com.beutii.testframework.cucumber.Configuration;
import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.RedirectionOfURLs_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RedirectionOfURLs_steps extends StepsBase{
	
	String redirectURL;	
		
	@Given("^I have the redirection URL\"([^\"]*)\"$")
	public void i_have_the(String arg1) {
		String url = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
		redirectURL = url+"/"+arg1;	    
	}
	
	@When("^I navigate to the URL$")
	public void i_navigate_to_the_URL() {
		getWD().get(redirectURL);
		ctx().put(PageFactory.initElements(getWD(), RedirectionOfURLs_PO.class));
	}

	@Then("^I should redirect to \"([^\"]*)\"page with target URL\"([^\"]*)\"$")
	public void i_should_redirect_to(String desiredPage, String targetURL) {
		
		if(desiredPage.equalsIgnoreCase("member section")){
			ctx().get(RedirectionOfURLs_PO.class).memberSectionHomepage();		
		}
		else if(desiredPage.equalsIgnoreCase("contact us")){
			ctx().get(RedirectionOfURLs_PO.class).contactUspage();		
		}
		else if(desiredPage.equalsIgnoreCase("no gap services")){
			ctx().get(RedirectionOfURLs_PO.class).noGapServices();		
		}
		else if(desiredPage.equalsIgnoreCase("hcf apps")){
			ctx().get(RedirectionOfURLs_PO.class).hcfAppspage();		
		}
		else if(desiredPage.equalsIgnoreCase("gp2u")){
			ctx().get(RedirectionOfURLs_PO.class).gp2upage();		
		}
		else if(desiredPage.equalsIgnoreCase("about you")){
			ctx().get(RedirectionOfURLs_PO.class).aboutUspage();		
		}
		else if(desiredPage.equalsIgnoreCase("find a branch")){
			ctx().get(RedirectionOfURLs_PO.class).branches();		
		}
		else if(desiredPage.equalsIgnoreCase("Provider Portal Services")){
			ctx().get(RedirectionOfURLs_PO.class).providerPortal();		
		}
		else if(desiredPage.equalsIgnoreCase("Research Foundation")){
			ctx().get(RedirectionOfURLs_PO.class).researchFoundation();		
		}
		else if(desiredPage.equalsIgnoreCase("chronic conditions")){
			ctx().get(RedirectionOfURLs_PO.class).chronicConditions();		
		}
		else {
			ctx().get(RedirectionOfURLs_PO.class).noMatch();		
		}
		
		//Validate current page URL with target URL
		 String currentURL = getWD().getCurrentUrl();
		    System.out.println(currentURL);
		    String curURL[] =currentURL.split("hcf.com.au/");
		    		    
		    Assert.assertEquals(targetURL,curURL[1]);
	}


}