package au.com.hcf.testframework.webportal.steps;

import org.openqa.selenium.support.PageFactory;

import au.com.hcf.testframework.cucumber.StepsBase;
import au.com.hcf.testframework.webportal.FindABranch_PO;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;

public class LocateABranch_steps extends StepsBase{
	@When("^try to find branch for \"([^\"]*)\"$")
	public void try_to_find_branch_for(String arg1) {
		ctx().put(PageFactory.initElements(getWD(), FindABranch_PO.class));
		ctx().get(FindABranch_PO.class).checkFindYourNearestHGFBranchInvitationIsDisplayed();
		ctx().get(FindABranch_PO.class).enterPostCode(arg1);
	}

	@Then("^the first nearest branch is \"([^\"]*)\"$")
	public void the_first_nearest_branch_is(String arg1) {
		Assert.assertEquals(
				"Check the branch name", 
				arg1,
				ctx().get(FindABranch_PO.class).getClosestBranchName()
				);
	}    
}
