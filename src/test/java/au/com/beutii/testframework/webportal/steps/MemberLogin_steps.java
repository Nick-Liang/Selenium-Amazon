package au.com.beutii.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.MemberLogin_PO;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MemberLogin_steps extends StepsBase{

	@When("^I click  on Member Login link$")
	public void i_click_on_Member_Login_link() {
		ctx().put(PageFactory.initElements(getWD(), MemberLogin_PO.class));
		ctx().get(MemberLogin_PO.class).clickMemberLoginLink();
	}

	@When("^I enter \"([^\"]*)\" membership username\"([^\"]*)\" and password\"([^\"]*)\" on Login page$")
	public void i_enter_username_and_password_on_Login_page(String arg1,String username,String password) {
		ctx().get(MemberLogin_PO.class).inputMembershipNumber(username);
		ctx().get(MemberLogin_PO.class).inputMemberPassword(password);
		//ctx().get(MemberLogin_PO.class).inputMembershipNumber("21148708");
		//ctx().get(MemberLogin_PO.class).inputMemberPassword("staff");
		ctx().get(MemberLogin_PO.class).clickSubmitButton();
	}


	@Then("^I see Member login name and Logout on top right hand side corner$")
	public void i_see_Member_login_name_and_Logout_on_top_right_hand_side_corner() {
		PageFactory.initElements(getWD(), MemberLogin_PO.class);
	}


	@When("^I click on view messages link$")
	public void i_click_on_view_messages_link() {
		PageFactory.initElements(getWD(), MemberLogin_PO.class);

	}

	@Then("^I should see notificaiton details page$")
	public void i_should_see_notificaiton_details_page() {

	}
	
	@Then("^I see please use overseas member login message$")
	public void i_see_please_use_overseas_member_login_message() {
		ctx().get(MemberLogin_PO.class).checkOverseasMsg();
	}
}