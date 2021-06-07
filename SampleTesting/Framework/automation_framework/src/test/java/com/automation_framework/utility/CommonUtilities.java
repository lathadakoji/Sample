package com.automation_framework.utility;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.model.Log;

public class CommonUtilities extends BaseTest{
	
	public static WebDriver driver;
	
	public CommonUtilities(WebDriver driver) {
		CommonUtilities.driver=driver;
	}
	
	public static String takeScreenshot() {
		String dateName = dateFormat.format(new Date());
		String screenshotPath = System.getProperty("user.in") + "\\Screenshots\\"+dateName+".png";
		try {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File(screenshotPath));
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
		
		return  screenshotPath;

	}
	
	public void clickOnXpath(String xpath) throws Exception{
		boolean flag = false;
		for(int i=1; i<=15; i++){
			if(driver.findElements(By.xpath(xpath)).size() > 0){
				flag = true;
				driver.findElement(By.xpath(xpath)).click();
				break;
			}else{
				Thread.sleep(500);
			}
		}
		if(flag == false){
			Assert.fail("Element did not appear");
		}
//		driver.findElement(By.xpath(xpath)).click();
	}
	
	public WebElement pollDOMUntilElementVisibility(By by,int numberOfPollAttemtps)throws Exception{

		WebElement we = null;
		boolean isElementPresent = false;
		int pollIter = 0;

		do {
			try{
				System.out.println("Trying to find element by polling to DOM in attempt " + pollIter);
				we = driver.findElement(by);
			}catch(NoSuchElementException e){
				Thread.sleep(5000);
				continue;
			}
			if( we != null){
				isElementPresent = true;
				break;
			}
			pollIter++;
		}while(isElementPresent == true || pollIter == numberOfPollAttemtps);

		return we;

}

	
	public void inputText(String xpath, String text){
		if(driver.findElements(By.xpath(xpath)).size() > 0){
			driver.findElement(By.xpath(xpath)).sendKeys(text);
		}else{
			Assert.fail("Element not found");
		}
	}

}
