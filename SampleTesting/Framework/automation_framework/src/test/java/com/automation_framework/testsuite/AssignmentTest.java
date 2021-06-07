package com.automation_framework.testsuite;

import java.util.Map;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation_framework.locators.Locators;
import com.automation_framework.pageclass.AutomateBrowserPageClass;
import com.automation_framework.pageclass.LoginPageClass;
import com.automation_framework.utility.BaseTest;
import com.automation_framework.utility.CommonBusinessRequirements;
import com.automation_framework.utility.ExcelDataProvider;
import com.automation_framework.utility.InitiateBrowser;
import com.aventstack.extentreports.ExtentTest;



public class AssignmentTest extends BaseTest{
	
	String sheetName = "automate brower sheet";
	String testCaseName = "AssignmentTest";
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
	public void testAutomateBrowser() throws Exception {
		BaseTest.test = BaseTest.extentReports.createTest(testCaseName);
		if (testData.get("RunMode").equalsIgnoreCase("Y")) {
			WebDriver driver = InitiateBrowser.openBrowser(testData.get("Browser"), url);
			CommonBusinessRequirements commBusRequirements = new CommonBusinessRequirements(driver);
			LoginPageClass login = PageFactory.initElements(driver, LoginPageClass.class);
		    login.clickOnXpath(Locators.newSignup);
		    login.SignupToVdezi(testData.get("Username"), testData.get("Password"), testData.get("ConfirmPassword"));
			login.logInToVdezi(testData.get("Username"), testData.get("Password"));
			
			
			
		} else {
                System.out.println("Test Data Excel is not working");
		}
	}

}
