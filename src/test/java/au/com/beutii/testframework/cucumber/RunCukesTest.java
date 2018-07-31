package au.com.beutii.testframework.cucumber;

import org.junit.runner.RunWith;

import au.com.beutii.testframework.selenium.WDUtil;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		glue = "au.com.beutii.testframework.webportal.steps",
		format = { 
				"pretty",
			    "html:report/site/cucumber-pretty",
			    "json:report/cucumber.json"
			    }, 
		monochrome = true,
		tags = { 
				"@Amazon"
				})
public class RunCukesTest {
	public RunCukesTest(){
		WDUtil.sleep(10);
	}
}