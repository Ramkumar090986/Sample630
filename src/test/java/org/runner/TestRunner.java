package org.runner;

import org.base.Base;
import org.base.JVMReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources"},glue= {"org.step"},monochrome=true, dryRun=true,strict=false,plugin= {"pretty",
"html:D:\\eclipse-workspace\\CucumberPractice\\src\\test\\resources",
"junit:D:\\eclipse-workspace\\CucumberPractice\\src\\test\\resources\\fb.xml",
"json:D:\\eclipse-workspace\\CucumberPractice\\src\\test\\resources\\fb.json"})

public class TestRunner extends Base {
	
	@AfterClass
    public static void afterClass() {
		JVMReport.generateReport("D:\\eclipse-workspace\\CucumberPractice\\src\\test\\resources\\fb.json");

	}
	
	
}
