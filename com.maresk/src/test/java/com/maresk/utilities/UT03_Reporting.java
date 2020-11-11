package com.maresk.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class UT03_Reporting extends TestListenerAdapter {
	
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentlog;

	public void onTestStart(ITestResult result) {
		
		String currenttimestamp = new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		String Extentreportname = "MareskAssignment_Test_Report_" + currenttimestamp + ".html";
		htmlReporter = new ExtentSparkReporter("../com.maresk/Reports/" + Extentreportname);
		try {
			htmlReporter.loadXMLConfig("../com.maresk/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("User_Name", "Assignment");
		extent.setSystemInfo("Application","BlazeDemo");
		
		htmlReporter.config().setDocumentTitle(" Web Application Automation Assignment");
		htmlReporter.config().setReportName("BlazeDemo Testcases Automation ");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestFailure(ITestResult tr) {
		extentlog = extent.createTest(tr.getName());
		extentlog.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
	}

	public void onTestSkipped(ITestResult tr) {
		extentlog = extent.createTest(tr.getName());
		extentlog.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}

	public void onTestSuccess(ITestResult tr) {
		extentlog = extent.createTest(tr.getName());
		extentlog.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	 public void onFinish(ITestContext testContext) {
		 extent.flush();
		 
	 }

}
