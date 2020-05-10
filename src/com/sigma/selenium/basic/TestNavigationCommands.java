package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestNavigationCommands {
    WebDriver driver;

    public void invokeBrowser(){
    	try {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			navigateCommands();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    public void navigateCommands(){
    	try {
			driver.navigate().to("http://www.flipkart.com");
			driver.findElement(By.xpath("//button[text()='✕']")).click();
			driver.findElement(By.xpath("//span[starts.with(text(), 'Appliances')]")).click();
			driver.findElement(By.xpath("//span[contains(text(), 'Microwave Ovens')]")).click();
			Thread.sleep(2000);
			
			driver.navigate().back();
			Thread.sleep(2000);
			driver.navigate().forward();
			Thread.sleep(2000);
			driver.navigate().refresh();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static void main(String[] args) {
	 	TestNavigationCommands myObj = new TestNavigationCommands();
	 	myObj.invokeBrowser();

	}

}
