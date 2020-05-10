package com.testng;

import java.util.concurrent.TimeUnit;

//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class GoogleTitleTest {

	WebDriver driver;
	
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.18.0-win32\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		driver = new FirefoxDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	/*@Test
	public void googleTitleTest(){
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title,"Google123", "Title is not matched");
		
	}*/

	@Test
	public void closeBrowser(){
		driver.quit();
	}
	
	
}
