package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		
		//Absolute xpath
		////html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/form[1]/div[3]/div[1]/input[1]
		//1. performance issue
		//2. not reliable
		//3. canbe changed at any time in future
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("women jewelry");
		//driver.findElement(By.xpath("//input[@name='field-keywords']")).sendKeys("women jewelry");
		driver.findElement(By.xpath("//input[contains(@name,'field-keywords')]")).sendKeys("women jewelry");
		Thread.sleep(5000);
		//dynamic id: input
		//id = test_123
		//(By.id("test_123)
		//id= test_456
		//id = test_789
		//id = test_test_7890_test
		
		// d= 1234_test_t
		//id = 235_test_t
		//id = test_test_7890_test_t
		
//		driver.findElement(By.xpath("//input[contains(@id='test_']")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[starts-with(@id='test_')]")).sendKeys("Test");
//		driver.findElement(By.xpath("//input[ends-with(@id='_test_t')]")).sendKeys("Test");
		
		//for links: custom xpath
	    //all the links are represted by <a> html tag
		
		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
		
	}

}
