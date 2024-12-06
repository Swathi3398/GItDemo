package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features",glue = "com.stepdef")
public class TestNGParallelRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
	}

}
