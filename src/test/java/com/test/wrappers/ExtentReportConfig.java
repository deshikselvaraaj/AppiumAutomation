package com.test.wrappers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfig {
	
	private static ExtentReports reports;
	
	public static ExtentReports reportConfig()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Appium Automation Test Result");
		reporter.config().setDocumentTitle("Extent Reports Result");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester", "MX Techies");		
		
		return reports;
	}

}
