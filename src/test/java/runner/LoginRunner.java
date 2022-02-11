package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features= {"/Users/ashwiniramamurthy/eclipse-workspace/SfPomAndCucumber/src/test/resources/SalesFeature/login.feature"},glue={"steps"})

public class LoginRunner extends AbstractTestNGCucumberTests {

}
