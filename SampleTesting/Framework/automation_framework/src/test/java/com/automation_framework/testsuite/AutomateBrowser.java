package com.automation_framework.testsuite;

import java.util.Map;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation_framework.pageclass.AutomateBrowserPageClass;
import com.automation_framework.utility.BaseTest;
import com.automation_framework.utility.ExcelDataProvider;
import com.automation_framework.utility.InitiateBrowser;
import com.aventstack.extentreports.ExtentTest;

//import pageclass.AutomateBrowserPageClass;
//import utility.BaseTest;
//import utility.ExcelDataProvider;
//import utility.InitiateBrowser;

public class AutomateBrowser extends BaseTest{
	
	String sheetName = "automate brower sheet";
	String testCaseName = "AutomateBrowserTest";
	String url;
	
	Map<String, String> testData;
	
	@BeforeTest
	public void configSetup() throws Exception {
		ExcelDataProvider excelDataProvider = new ExcelDataProvider();
		testData = excelDataProvider.getExcelTestData(sheetName, testCaseName);
		url = testData.get("URL");
	
		String[] splitUrl = url.split(Pattern.quote("@"));
		url = splitUrl[1].trim();
	}
	
	
	@Test
	public void testAutomateBrowser() {
		BaseTest.test = BaseTest.extentReports.createTest(testCaseName);
		if (testData.get("RunMode").equalsIgnoreCase("Y")) {
			WebDriver driver = InitiateBrowser.openBrowser(testData.get("Browser"), url);
			//AutomateBrowserPageClass automateBrowserPageClass = new AutomateBrowserPageClass(driver);
			//PageFactory.initElements(driver, automateBrowserPageClass);
			AutomateBrowserPageClass initElements = PageFactory.initElements(driver, AutomateBrowserPageClass.class);
			System.out.println(initElements);
			driver.findElement(By.id("blahgfresw"));
			
		} else {

		}
	}

}
