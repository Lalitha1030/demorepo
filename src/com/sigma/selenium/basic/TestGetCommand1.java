package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestGetCommand1 {
	WebDriver driver;
	
	public void invokeBrowser(){
		
		try {
			/*
			 System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.18.0-win32\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			*/
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			getCommands();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void getCommands(){
		try {
			driver.get("https://www.amazon.com");
			
			String TitleOfThePage = driver.getTitle();
			System.out.println("Title of the page is:" + " "+ TitleOfThePage);
			//String PageSource = driver.getPageSource();
			//System.out.println("Source of the Page:" +" "+ PageSource);
			driver.findElement(By.linkText("Today's Deals")).click();
			String CurrentUrl = driver.getCurrentUrl();
			System.out.println("Current URL is:" +" "+ CurrentUrl);
			
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGetCommand1 myObj  = new TestGetCommand1();
		myObj.invokeBrowser();
		
	}

}
