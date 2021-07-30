package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "junit:Results/cucumber-reports/Cucumber.xml","json:Results/cucumber-reports/Cucumber.json"},
		features = "Feature",
		glue= "StepDefinition",
		//dryRun = true,
		tags = {"@test"}
		) 
public class OnboardApp {
 
}
