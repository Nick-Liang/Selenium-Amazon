package au.com.beutii.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.beutii.testframework.cucumber.StepsBase;
import au.com.beutii.testframework.webportal.StudentDependantRegistration_PO;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StudentDependantRegistration_step extends StepsBase{	
	
	
	@When("^I select Student dependant registration option under Actions menu$")
	public void i_select_Student_dependant_registration_option_under_Actions_menu() {
		ctx().put(PageFactory.initElements(getWD(), StudentDependantRegistration_PO.class));
		ctx().get(StudentDependantRegistration_PO.class).selectStudentDepRegisterOption();
	}

	@When("^I select student name\"([^\"]*)\"$")
	public void i_select_student_name(String studentName) {
		ctx().get(StudentDependantRegistration_PO.class).selectStudentName(studentName);
	}
	
	@When("^I select declaration check box and submit$")
	public void i_select_declaration_check_box_and_submit() {
		ctx().get(StudentDependantRegistration_PO.class).selectDeclarationCheckbox();
		ctx().get(StudentDependantRegistration_PO.class).clickSubmitButton();
	}

	@Then("^I should see thank you confirmation message$")
	public void i_navigate_to_Member_secion_login_page() {
		ctx().get(StudentDependantRegistration_PO.class).validateRegConfirmation();
	}
	
	@Then("^I logout from member section$")
	public void i_logout_from_member_secion() {
		ctx().get(StudentDependantRegistration_PO.class).logoutMemberSection();
	}



}