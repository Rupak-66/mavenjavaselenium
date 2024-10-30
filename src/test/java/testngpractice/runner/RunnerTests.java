package testngpractice.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@api", features = {"src/test/resources"}, glue = {"testngpractice/stepdefinations"}, plugin = {"pretty", "html:target/cucumber-report.html"})
public class RunnerTests extends AbstractTestNGCucumberTests {


}