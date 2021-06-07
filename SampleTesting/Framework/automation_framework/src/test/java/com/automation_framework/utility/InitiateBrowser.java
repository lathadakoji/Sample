package com.automation_framework.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitiateBrowser {
	
	static WebDriver driver;
	static String chromeDriverPath = "C:\\Users\\HP\\Documents\\Sample Testing\\Framework\\automation_framework\\Driver\\chromedriver.exe";
	static String ieDriverPath = "bbb";
	static String edgeDriverPath = "C:\\Users\\HP\\Documents\\Sample Testing\\Framework\\automation_framework\\Driver\\msedgedriver.exe";
	
	public static WebDriver openBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", edgeDriverPath);
			driver = new EdgeDriver();
		}else if (browserName.equalsIgnoreCase("Firefox")) {
			
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("", ieDriverPath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

}
