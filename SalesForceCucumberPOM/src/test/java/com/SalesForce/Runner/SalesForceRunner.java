package com.SalesForce.Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/com/SalesForce/Features/LoginFeature.feature"},
                  glue= {"com.SalesForce.steps"})

public class SalesForceRunner extends  AbstractTestNGCucumberTests {

}
