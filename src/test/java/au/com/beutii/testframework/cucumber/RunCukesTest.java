package au.com.beutii.testframework.cucumber;

import org.junit.runner.RunWith;

import au.com.beutii.testframework.selenium.WDUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = false, 
		features = "classpath:features", 
		glue = "au.com.beutii.testframework.webportal.steps",
		format = { 
				"pretty",
			    "html:report/site/cucumber-pretty",
			    "json:report/cucumber.json"
			    }, 
		monochrome = true,
		tags = { 
//				"~@ignore","~@NotToBeRunOnProd"
				"~@ignore",			
				
//				"@EAPP"				
//				"@DPcustomiseCoverP2P , @DPshowMePackagesP2P , @DPambulanceCoverP2P,@MemberLogin,@MemberForgotPassword, @CostCalculator, @Redirection, @PetInsurance,@MicrositeJoin,@ContactusForm,@TravelHCFmember,@TravelNotHCFmember,@Life,@MemberForgotPasswordNegetive,@MemberLoginOverseasMsg, @EAPP"
//				"@DPcustomiseCoverP2P , @DPshowMePackagesP2P , @DPambulanceCoverP2P,@CostCalculator, @Redirection, @JoinOnline,@JoinOnlineFamilyCover,@PetInsurance,@MicrositeJoin,@ContactusForm,@TravelHCFmember,@TravelNotHCFmember,@Life,@MemberLoginOverseasMsg"
//				"@JoinOnline"
//				"StudentDepRegistration"				
//				"@DPcustomiseCoverP2P , @DPshowMePackagesP2P , @DPambulanceCoverP2P,@MemberLogin,@MemberForgotPassword, @CostCalculator, @Redirection, @JoinOnline,@JoinOnlineFamilyCover,@PetInsurance,@MicrositeJoin,@ContactusForm,@TravelHCFmember,@TravelNotHCFmember,@Life,@MemberForgotPasswordNegetive,@MemberLoginOverseasMsg"
//				"@PetInsurance"
//				"@CallWaiting"
//				"@ContactusForm"
//				"@TravelHCFmember"
//				"@MemberLogin"
//				"@Life"
//				"@Redirection, @TravelHCFmember"
//				"@MemberForgotPassword",
//				"@DPcustomiseCoverP2P , @DPshowMePackagesP2P , @DPambulanceCoverP2P, @Redirection, @MemberForgotPassword, @JoinOnline",	
//				"@DPcustomiseCoverP2P",
//				"@DPshowMePackagesP2P",
//				"@DPambulanceCoverP2P",
//				"@CustomiseCover",
//				"@JoinOnline",
//				"@Notificationpage",
//				"@LocateALocalBranch",
//				"@PathToPurchase",
//				"@ReCalculation",
//				"@HomePage",
				"@Amazon",
//				"@PathToPurchaseREST",
//				"@SwitchingFunds"
//				"@StaticMediaRelease",
//				"@SwitchingFunds",
//				"@CustomiseCover"
//				"@EmailQuote",
//				"@MemberClaim",
//				"@Travel",
//				"@HomePage,@LocateALocalBranch,@StaticMediaRelease",			
				})
public class RunCukesTest {
	public RunCukesTest(){
		WDUtil.sleep(10);
	}
}