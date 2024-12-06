package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",glue = "com.stepdeftestng")
public class TestRunnerTestNGPOM  extends AbstractTestNGCucumberTests{

}
