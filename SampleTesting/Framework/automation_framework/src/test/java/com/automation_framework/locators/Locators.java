package com.automation_framework.locators;

public class Locators {
	
	//create a lead
	public static final String newSignup = "//div[text()='Sign Up']";
	public static final String email = "//input[@placeholder='Email']";
	public static final String password = "//input[@placeholder='Password']";
	public static final String confirmpassword = "//input[@placeholder='Confirm Password' and @type='password']";
	
	public static final String chckb= "//input[@type='checkbox']//parent::div";
	
	public static final String registr="//button[text()='Register']";
	
	public static final String signin="//div[text()='Sign In']";
	public static final String Signupstatus= "//app-toastr[@class='ng-star-inserted']/div/div[2]/span[2]";
	public static final String Login ="//button[text()='Sign In']";

}
