package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestGetCommands {
 WebDriver driver;
 public void invokeBrowser(){
	 try {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		 DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		 capabilities.setCapability("marionette", true);
		 driver = new FirefoxDriver(capabilities);
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 getCommands();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 
	
	}
 
 	public void getCommands(){
 		 try {
 			 driver.get("http://amazon.com");
 			
			 String titleOfThePage = driver.getTitle();
			 System.out.println("Title of the page is:" + titleOfThePage);
			 driver.findElement(By.linkText("Today's Deals")).click();
			 String currentUrl = driver.getCurrentUrl();
			 System.out.println("The Current URL is:" +currentUrl);
			 //driver.manage().window().maximize();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
 		 
 	}
 	
 	public static void main(String[] args) {
		TestGetCommands myObj = new TestGetCommands();
		myObj.invokeBrowser();

	}

}
