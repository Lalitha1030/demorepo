package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class Navigations {
	
		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("marrionette", true);
			//WebDriver driver = new FirefoxDriver(capabilities);
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.get("https://www.google.com/");
			
			//back and forward simulation
			
			driver.navigate().to("https://www.amazon.com/");
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().forward();
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().refresh();
			
		
	}
}
