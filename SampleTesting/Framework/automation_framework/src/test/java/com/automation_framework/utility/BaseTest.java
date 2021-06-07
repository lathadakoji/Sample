package com.automation_framework.utility;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseTest {
	
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest test;
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
	
	
	
	@BeforeSuite
	public void setUp() {
		System.out.println("beforesuit");
		String dateName = dateFormat.format(new Date());
		String path = "C:\\Users\\HP\\Documents\\Sample Testing\\Framework\\automation_framework\\Reports\\"+dateName+".html";
		extentHtmlReporter = new ExtentHtmlReporter(path);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	
	@AfterMethod
	public void result(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String imagePath = CommonUtilities.takeScreenshot();
			try {
//				test.log(Status.INFO, "Failed page", (MediaEntityBuilder.createScreenCaptureFromPath(imagePath)).build());
				test.log(Status.INFO, "Failed page", (MediaEntityBuilder.createScreenCaptureFromPath(CommonUtilities.takeScreenshot())).build());
			} catch (IOException e) {
				System.out.println("Exception in result method");
			}
			test.log(Status.FAIL, result.getThrowable());
		}else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped");
			
		}else if (result.getStatus() == ITestResult.SUCCESS) {
			
		}
	}
	
	@AfterSuite
	public void tearDown() {
		extentReports.flush();
	}
	

}
