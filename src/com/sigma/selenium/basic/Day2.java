package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class Day2 {
	WebDriver driver;
	JavascriptExecutor jse; 
	public void invokeBrowser(){
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.18.0-win32\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
			
			driver.get("https:\\www.edureka.co");
			searchCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void searchCourse(){
	try {
		//driver.findElement(By.id("search-inp")).sendKeys("java course");
		driver.findElement(By.xpath("//input[@id='search-inp']")).sendKeys("java course");
		Thread.sleep(2000);
		
		driver.findElement(By.id("search-button-top")).click();
		driver.findElement(By.id("jr_filter_2")).click();
		//driver.findElement(By.id("filterdropdown").;//.xpath("//label[contains(text(), "Weekend")]");
		jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 1000)");
		WebElement searchText = driver.findElement(By.xpath("//input[@id='search-inp']"));
		Thread.sleep(2000);
		System.out.println(searchText.getAttribute("value"));
		System.out.println(searchText.isEnabled());
		searchText.clear();
		driver.quit();
		Thread.sleep(2000);
		System.out.println(searchText.getAttribute("value"));
		// driver.findElement(By.xpath("label["//contains(text(), "Weekend")]"))
		
	} 
	catch (InterruptedException e) {
	
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Day2 myObject = new Day2();
		myObject.invokeBrowser();
		

	}

}
