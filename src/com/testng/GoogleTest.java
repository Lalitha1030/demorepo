package com.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		//System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver_win32//chromedriver.exe");
		//driver = new ChromeDriver();
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
	
	@Test(priority=1)
	public void googleTitleTest(){
		
			String title = driver.getTitle();
			System.out.println("Page Title is:" + " " +title);
		
	}
	@Test(priority=2,groups="Logo Test")
	public void googleLogoTest(){
		boolean b = driver.findElement(By.xpath("//*[@id='lga']")).isDisplayed();
		System.out.println("Google Logo displayed:"+" "+b);
	}
	
	@Test(priority=3,groups="LinkTest")
	public void mailLinkTest(){
		boolean b = driver.findElement(By.linkText("mail")).isDisplayed();
		//System.out.println("Gmail link displayed:"+" "+b);
	}
	@Test(priority=4,groups="Test")
	public void Test1(){
		System.out.println("Test1");
	}
	
	@Test(priority=5,groups="Test")
	public void Test2(){
		System.out.println("Test2");
	}
	
	@Test(priority=6,groups="Test")
	public void Test3(){
		System.out.println("Test3");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
