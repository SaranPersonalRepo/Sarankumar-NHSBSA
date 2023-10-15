package com.nhs.framework.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:NHSFeatureFiles/NHS_CircumtanceChecker.feature",tags = "@Positive_England", plugin = "html:target/NHS_TestExecutionReport.html", glue = {
"classpath:com.nhs.framework.stepDefinitions" }, stepNotifications = true, monochrome = false, dryRun =false)
public class TestRunner {

}

