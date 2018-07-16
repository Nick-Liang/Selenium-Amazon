package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.ContactusForm_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactusForm_steps extends StepsBase{	
	
	String baseURL = ctx().get(CTX.CONFIGURATION, Configuration.class).getBaseURL();
		
	@Given("^I am on contact us page$")
	public void i_am_on_contact_us_page() {		
		String url = baseURL+"/contact-us";
		getWD().get(url);
		
		ctx().put(PageFactory.initElements(getWD(), ContactusForm_PO.class));		
		System.out.println("Contact us page is loaded"); 
		WDUtil.sleep(2000);
	}

	@When("^I fill in firstname\"([^\"]*)\", lastname\"([^\"]*)\", email address\"([^\"]*)\", subject\"([^\"]*)\", contact me by\"([^\"]*)\", comments\"([^\"]*)\" and sumbit$")
	public void i_fill_in_firstname_lastname_email_address_subject_contact_me_by_comments_and_sumbit(String firstname, String lastname, String email, String subject, String contactBy, String comments) {
		
		ctx().get(ContactusForm_PO.class).setFirstname(firstname);
		ctx().get(ContactusForm_PO.class).setLastname(lastname);
		ctx().get(ContactusForm_PO.class).setEmailAddrs(email);
		ctx().get(ContactusForm_PO.class).selectSubject(subject);
		ctx().get(ContactusForm_PO.class).selectContactBy(contactBy);
		ctx().get(ContactusForm_PO.class).setComments(comments);
		ctx().get(ContactusForm_PO.class).clickSubmit();
	}

	@Then("^I should see thank you message$")
	public void i_should_see_thank_you_message() {
		if (baseURL.equalsIgnoreCase("https://www.hcf.com.au")){
			ctx().get(ContactusForm_PO.class).validateCaptchaErrorMsg();
			}
		else{ 
			ctx().get(ContactusForm_PO.class).validateThankyouMsg();
		}
	}
	
	@Then("^I should see current call wait time$")
	public void i_should_see_current_call_wait_time() {
		ctx().get(ContactusForm_PO.class).validateCallWaitTime(); 
	}


}