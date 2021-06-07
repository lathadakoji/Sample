package com.automation_framework.utility;
import com.automation_framework.utility.CommonUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.automation_framework.locators.Locators;
import com.automation_framework.pageclass.LoginPageClass;

public class CommonBusinessRequirements extends CommonUtilities{
	
	public CommonBusinessRequirements(WebDriver driver) {
		super(driver);
	}
	
	CommonUtilities common = PageFactory.initElements(driver, CommonUtilities.class);
	public void SignupToVdezi(String userName, String password, String confirmpassword ) throws Exception{
		
		
		driver.findElement(By.xpath(Locators.email)).clear();
		driver.findElement(By.xpath(Locators.email)).sendKeys(userName);
		
		driver.findElement(By.xpath(Locators.password)).clear();
		driver.findElement(By.xpath(Locators.password)).sendKeys(password);
		
		driver.findElement(By.xpath(Locators.confirmpassword)).clear();
		driver.findElement(By.xpath(Locators.confirmpassword)).sendKeys(confirmpassword);
		common.clickOnXpath(Locators.chckb);
		common.clickOnXpath(Locators.registr);
		
		String ExpectedSignUpStatus = "This email is already is in use.";
		
		Thread.sleep(1000);
		WebElement Alert = common.pollDOMUntilElementVisibility(By.xpath(Locators.Signupstatus), 5);

		String SignupStatus = driver.findElement(By.xpath(Locators.Signupstatus)).getText();

		if(ExpectedSignUpStatus.equalsIgnoreCase(SignupStatus))
		{
		System.out.println("Email already in Use");
		Thread.sleep(5000);
		common.clickOnXpath(Locators.signin);
		}
		else{
		System.out.println("Sign up Error ");
		}
	}
	
	public void logInToVdezi(String userName, String password ) throws Exception{
		
		driver.findElement(By.xpath(Locators.email)).clear();
		driver.findElement(By.xpath(Locators.email)).sendKeys(userName);
		
		driver.findElement(By.xpath(Locators.password)).clear();
		driver.findElement(By.xpath(Locators.password)).sendKeys(password);
		
		common.clickOnXpath(Locators.Login);
		
	}

}
