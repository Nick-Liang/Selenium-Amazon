//Author : Satheesh Marripudi
package au.com.hcf.testframework.webportal.steps;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.selenium.WDUtil;
import au.com.hcf.testframework.webportal.JoinDetails_PO;
import au.com.hcf.testframework.webportal.ReCalculation_PO;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JoinDetails_steps extends StepsBase{
	@Given("^I am on Join Details page$")
	public void i_am_on_Join_Details_page() {
		ctx().put(PageFactory.initElements(getWD(), JoinDetails_PO.class));
		ctx().get(JoinDetails_PO.class).checkPageLoaded();
	}

	@When("^I fill Title \"([^\"]*)\" , Gender \"([^\"]*)\", Firstname, Surname and tick continuous cover$")
	public void i_fill_Title_Firstname_Surename_and_tick_continuous_cover(String Title, String Gender) {
		ctx().get(JoinDetails_PO.class).selectTitle(Title.trim());
		ctx().get(JoinDetails_PO.class).selectGender(Gender);
		ctx().get(JoinDetails_PO.class).setFirstname();
		ctx().get(JoinDetails_PO.class).setSurname();
	}
	
	@When("^I fill partner Title \"([^\"]*)\" , Gender \"([^\"]*)\", Firstname, Lastname and DOB$")	
	public void i_fill_partner_Title_Firstname_Lastname_and_DOB(String Title, String Gender) {
		ctx().get(JoinDetails_PO.class).selectSpouseTitle(Title.trim());
		ctx().get(JoinDetails_PO.class).selectSpouseGender(Gender);
		ctx().get(JoinDetails_PO.class).setSpouseFirstname();
		ctx().get(JoinDetails_PO.class).setSposueSurname();
		ctx().get(JoinDetails_PO.class).spouseDateofBirth();
	}
	
	@When("^I fill dependent Title \"([^\"]*)\" , Gender \"([^\"]*)\", Firstname, Lastname and DOB$")
	public void i_fill_dependent_Title_Firstname_Lastname_and_DOB(String Title, String Gender) {
		ctx().get(JoinDetails_PO.class).selectDepTitle(Title.trim());
		ctx().get(JoinDetails_PO.class).selectDepGender(Gender);
		ctx().get(JoinDetails_PO.class).setDepFirstname();
		ctx().get(JoinDetails_PO.class).setDepSurname();
		ctx().get(JoinDetails_PO.class).DepDateofBirth();
	}
	
	@When("^I fill Title \"([^\"]*)\" , Firstname, Surname  and tick continuous cover$")
	public void i_fill_Title_Firstname_Surename_and_tick_continuous_cover(String Title) {
		ctx().get(JoinDetails_PO.class).selectTitle(Title.trim());
		ctx().get(JoinDetails_PO.class).setFirstname();
		ctx().get(JoinDetails_PO.class).setSurname();
	}

	@When("^I fill client DOB$")
	public void i_fill_client_dob_Month_year_of_Birth() {		
		ctx().get(JoinDetails_PO.class).clientDateofBirth();		
	}

	@When("^I fill Email \"([^\"]*)\" , Mobile \"([^\"]*)\"$")
	public void i_fill_Email_Mobile(String Email, String Mobile) {
		ctx().get(JoinDetails_PO.class).setMobile(Mobile);
		WDUtil.sleep(500);
		ctx().get(JoinDetails_PO.class).setEmailAddress(Email);
		
		
	}

	@When("^I fill Address \"([^\"]*)\", select state \"([^\"]*)\"$")
	public void i_fill_Address_select_state(String Address, String state) {		
		ctx().get(JoinDetails_PO.class).setAddress(Address);		
		ctx().get(JoinDetails_PO.class).setState(state);
		WDUtil.sleep(1000);
		ctx().get(JoinDetails_PO.class).setSuburb();
		WDUtil.sleep(2000);
		
		//ctx().get(JoinDetails_PO.class).setMedicareCardFirstname("Automation");
		//ctx().get(JoinDetails_PO.class).setMedicareSurname("Testing");
		//Commented following 3 lines and added one line to enter DOB 12/01/2016 kbg
		//ctx().get(JoinDetails_PO.class).MedicareMemberDOBday("04");
		//ctx().get(JoinDetails_PO.class).MedicareMemberDOBmonth("Apr");
		//ctx().get(JoinDetails_PO.class).MedicareMemberDOByear("1998");
		//ctx().get(JoinDetails_PO.class).MedicareMemberDOB("04/05/1998");		
		//ctx().get(JoinDetails_PO.class).clickNextButtononJoinDetails();
		//WDUtil.sleep(1000);
		//ctx().get(JoinDetails_PO.class).clickNextButtononJoinDetailsConfirmation();
		//WDUtil.sleep(1000);
		//ctx().get(JoinDetails_PO.class).clickDeclarationonDetailsConfirmation();
		//ctx().get(JoinDetails_PO.class).clickNextButtonononJoinDetailsDeclarationpage();
		
		//ctx().get(JoinDetails_PO.class).SwitchingFunds("yes");
		//ctx().get(JoinDetails_PO.class).nameOfExistingFund("Homeopathy");
		//ctx().get(JoinDetails_PO.class).memberShipID("400000000");

	}
	
	@When("^I Want to claim rebate and fill Medicare details$")
	public void i_I_Want_to_claim_rebate_and_fill_Medicare_details() {		
		ctx().get(JoinDetails_PO.class).setTier();
		WDUtil.sleep(2000);
		ctx().get(JoinDetails_PO.class).checkGovernmentRebatePolicy();
		WDUtil.sleep(1000);
		ctx().get(JoinDetails_PO.class).inputMedicareCardNumber("2133569725"); 
		ctx().get(JoinDetails_PO.class).setMedicareExpiryDate("Dec");
		WDUtil.sleep(1000);
		ctx().get(JoinDetails_PO.class).setMedicareExpiryYear("2019");
		WDUtil.sleep(1000);
		ctx().get(JoinDetails_PO.class).checkGenderofMedicareCard();
		ctx().get(JoinDetails_PO.class).checkifAllCoveredUnderMedicare();
	}
	
	@When("^I do not want to claim government rebate$")
	public void I_do_not_want_to_claim_government_rebate() {
		ctx().get(JoinDetails_PO.class).claimRebateSelectNo();			
	}

	@When("^I Switch Funds \"([^\"]*)\"$")
	public void i_Switch_Funds(String fundsswitch) {
		ctx().get(JoinDetails_PO.class).SwitchingFunds(fundsswitch);
		ctx().get(JoinDetails_PO.class).clickNextButtononJoinDetails();		
	}
	
	@When("^I do not switch partner funds$")
	public void i_donot_switch_partner_funds() {
		ctx().get(JoinDetails_PO.class).partnerSwitchFundsNo();		
	}

	@When("^I confirm the declaration$")
	public void i_confirm_the_declaration() {
		ctx().get(JoinDetails_PO.class).declarationPageConfiramtion();
		ctx().get(JoinDetails_PO.class).clickNextButtononononDeclarationnpage();
	}
	
	@When("^I confirm the entitlement to join the corporate plan$")
	public void i_confirm_the_entitlement_join_corporate_plan() {
		ctx().get(JoinDetails_PO.class).declarationPageEmploymentConfiramtion();		
	}

	@When("^I fill date \"([^\"]*)\",Month \"([^\"]*)\", Year \"([^\"]*)\"$")
	public void i_fill_date_Month_Year(String date, String Month, String year) {
		//JoinDetails_PO.setDate("22");
		ctx().get(JoinDetails_PO.class).setDate(date);
		ctx().get(JoinDetails_PO.class).setMonth(Month);
		ctx().get(JoinDetails_PO.class).setYear(year);
	}

	@When("^I fill choice  for: I have had the private hospital cover  \"([^\"]*)\"$")
	public void i_fill_choice_for_I_have_had_the_private_hospital_cover(String choice) {
		ctx().put(PageFactory.initElements(getWD(),ReCalculation_PO.class));
		ctx().get(ReCalculation_PO.class).selectPartnerHeldHospitalCover(choice);
	}


	//@Then("^I verify Monthly payment for the above <\"([^\"]*)\">$")
	@Then("^I verify Monthly payment for the above \"([^\"]*)\"")
	public void i_verify_Monthly_payment_for_the_above(String expectedmonthlypay) {
		String actual =  ctx().get(ReCalculation_PO.class).getActualMonthlyPay();
		String expected = ctx().get(ReCalculation_PO.class).getExpectedMonthlyPay(expectedmonthlypay);
		System.out.println("actual value is:" + actual);
		System.out.println("Expected value is:" + expected);
		Assert.assertEquals(expected, actual);
	}
	
	//Steps for new application form
	@Given("^I am on Personal Details page$")
	public void i_am_on_Personal_Details_page() {
		ctx().put(PageFactory.initElements(getWD(), JoinDetails_PO.class));
		ctx().get(JoinDetails_PO.class).checkPersonalDetPageLoaded();
	}
	
	@When("^I select Title \"([^\"]*)\" , Gender \"([^\"]*)\", Firstname, Surname$")
	public void i_select_Title_Firstname_Surename(String Title, String Gender) {
		ctx().get(JoinDetails_PO.class).selectTitle(Title.trim());
		ctx().get(JoinDetails_PO.class).selectGender(Gender);
		ctx().get(JoinDetails_PO.class).setFirstname();
		ctx().get(JoinDetails_PO.class).setSurname();
	}
	
	@When("^I fill client DOB, contact number \"([^\"]*)\"$")
	public void i_fill_client_dob_contact_number() {		
		ctx().get(JoinDetails_PO.class).clientDateofBirth();		
	}
	
	@When("^I fill Address \"([^\"]*)\" and suburb\"([^\"]*)\"$")
	public void i_fill_Address_(String Address, String suburb) {		
		ctx().get(JoinDetails_PO.class).setAddress(Address);		
		ctx().get(JoinDetails_PO.class).selectSuburb(suburb);
		WDUtil.sleep(1000);
				
		
	}
	
}