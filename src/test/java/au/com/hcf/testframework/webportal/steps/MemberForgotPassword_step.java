package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.CTX;
import au.com.hcf.testframework.cucumber.Configuration;
import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.HomePage_PO;
import au.com.hcf.testframework.webportal.MemberForgotPassword_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MemberForgotPassword_step extends StepsBase{	

	@When("^I click on Forgot password$")
		public void i_click_on_Forgot_Password_link() {
			ctx().put(PageFactory.initElements(getWD(), MemberForgotPassword_PO.class));
			ctx().get(MemberForgotPassword_PO.class).clickMemberForgotPasswordLink();
		}
	
	@When("^I enter membership number \"([^\"]*)\", First Name \"([^\"]*)\", Surname \"([^\"]*)\", Date of birth \"([^\"]*)\"and click Continue$")
		public void i_enter_membership_number_First_Name_Surname_Date_of_birth_and_click_Continue(String membernumber, String memberFirstname, String memberSurname, String DOB) {
			ctx().get(MemberForgotPassword_PO.class).inputMembershipNumber(membernumber);
			ctx().get(MemberForgotPassword_PO.class).inputMemberFirstname(memberFirstname);
			ctx().get(MemberForgotPassword_PO.class).inputMemberSurname(memberSurname);
			
			String [] arrDOB = DOB.split(" ");
			ctx().get(MemberForgotPassword_PO.class).selectDOBDay(arrDOB[0]);
			ctx().get(MemberForgotPassword_PO.class).selectDOBMonth(arrDOB[1]);
			ctx().get(MemberForgotPassword_PO.class).selectDOBYear(arrDOB[2]);
			ctx().get(MemberForgotPassword_PO.class).clickContinueButton();				
		}
	
	
	@When("^I answer \"([^\"]*)\" security question$")
		public void i_answer_security_question(String arg1) {		
			ctx().get(MemberForgotPassword_PO.class).answerSecurityQust(arg1); 
			ctx().get(MemberForgotPassword_PO.class).clickContinueButton();	
		}

	@When("^I enter my pasword \"([^\"]*)\" and submit$")
	public void i_enter_my_pasword_and_submit(String arg1) {		
		ctx().get(MemberForgotPassword_PO.class).inputNewPassword(arg1);
		ctx().get(MemberForgotPassword_PO.class).reEnterPassword(arg1);
		ctx().get(MemberForgotPassword_PO.class).clickSubmitButton();	
	}

	@Then("^I get password reset successful message$")
	public void i_get_password_reset_successful_message() {
		ctx().get(MemberForgotPassword_PO.class).validateSuceessMessage();
	}
	
	@Then("^I click on Go to online member services$")
	public void i_click_on_Go_to_online_member_services() {
		ctx().get(MemberForgotPassword_PO.class).clickGotoOnlineMemServices();	   
	}

	@Given("^I am on HCF Member services home page$")
	public void i_am_on_HCF_Member_services_home_page() {
		ctx().put(PageFactory.initElements(getWD(), MemberForgotPassword_PO.class));
		ctx().get(MemberForgotPassword_PO.class).validateMemberHomepage();	    
	}

	@When("^I select Security Settings option under Settings menu$")
	public void i_select_Security_Settings_option_under_Settings_menu() {
		ctx().get(MemberForgotPassword_PO.class).selectSecuritySettingsOption();
	}

	@When("^I enter current password \"([^\"]*)\", new paasword \"([^\"]*)\" and submit$")
	public void i_enter_current_password_new_paasword_and_submit(String currentPWD, String newPWD) {
		ctx().get(MemberForgotPassword_PO.class).changePassword(currentPWD,newPWD);
	}

	@Then("^I navigate to Member secion login page$")
	public void i_navigate_to_Member_secion_login_page() {
		ctx().get(MemberForgotPassword_PO.class).validateMemberLoginpage();
	}	
	
//negetive test case steps	
	@When("^I leave membership number, first name, surname, DOB fields as blank and click contine$")
	public void i_leave_membership_number_firstName_surname_DOB_as_blank_and_click_continue() {		
		ctx().get(MemberForgotPassword_PO.class).clickContinue();		
	}
	
	@Then("^I see inline error message for each field on forgot password page$")
	public void i_see_inline_error_message_for_each_field() {
		ctx().get(MemberForgotPassword_PO.class).verifyBalnkFieldsMsg();
	}

	@Given("^I am on Forgot password page$")
	public void i_am_on_forgot_password_page() {		
		ctx().get(MemberForgotPassword_PO.class).forgotPassword.isDisplayed();
		System.out.println("You are on Forgot password page"); //TODO: add actual assert
		WDUtil.sleep(2000);
	}	
		
	
	@When("^I enter invalid characters \"([^\"]*)\" in membership number field and press tab$")
	public void i_enter_invalid_characters_in_membership_number_field_and_press_tab(String invalidMemberNumber) {
		ctx().get(MemberForgotPassword_PO.class).inputMembershipNumber(invalidMemberNumber);
	}
	
	@Then("^I see inline message as membership number is invalid$")
	public void I_see_inline_message_as_membership_number_is_invalid() {
		ctx().get(MemberForgotPassword_PO.class).VerifyInvalidMembernumberMsg();
	}
	
	@When("^I enter invalid membership number \"([^\"]*)\" and enter first name, surname and DOB$")
	public void i_enter_invalid_membership_number(String memberNum) {
		ctx().get(MemberForgotPassword_PO.class).inputMembershipNumber(memberNum);
		ctx().get(MemberForgotPassword_PO.class).inputMemberFirstname("test");
		ctx().get(MemberForgotPassword_PO.class).inputMemberSurname("test");
		
		String DOB = "22 April 1974";
		String [] arrDOB = DOB.split(" ");		
		System.out.println(arrDOB[0]); 
		ctx().get(MemberForgotPassword_PO.class).selectDOBDay(arrDOB[0]);		
		ctx().get(MemberForgotPassword_PO.class).selectDOBMonth(arrDOB[1]);
		ctx().get(MemberForgotPassword_PO.class).selectDOBYear(arrDOB[2]);
		WDUtil.sleep(500);
		ctx().get(MemberForgotPassword_PO.class).clickContinueButton();	
	}
	
	@Then("^I see membership number is invalid message on top$")
	public void I_see_membership_number_is_invalid_message_on_top() {
		ctx().get(MemberForgotPassword_PO.class).validateInvalidMemberMsgOnTop();
	}

}