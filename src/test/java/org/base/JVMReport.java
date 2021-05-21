package org.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVMReport extends Base {
	
	public static void generateReport(String json) {
		
    File file=new File("D:\\eclipse-workspace\\CucumberPractice\\src\\test\\resources");
    Configuration configuration=new Configuration(file, "CucumberPractice");
    configuration.addClassifications("Sprint","54");
    configuration.addClassifications("Browser", "Chrome");
    configuration.addClassifications("Platform", "Windows10");
    List<String>li=new ArrayList<String>();
    li.add(json);
    ReportBuilder builder=new ReportBuilder(li, configuration);
    builder.generateReports();
	
	}
}
