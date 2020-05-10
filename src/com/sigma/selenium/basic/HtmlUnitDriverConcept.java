package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		//		WebDriver driver = new FirefoxDriver();
		
		//htmlunitdriver is not available in selenium 3.x version
		//htmlunitdriver--- to use this concept we have to downlod htmlunitdriver JAR file
		
		// Advantages :
		//1. testing is happening behind the scene --- no browser is launched
		//2. Very fast --- execution of test cases --- very fast ---- performanc of the script
		//3.Not suitable for Actions class --- user actions---mouse movement,double click, drag and drop
		//4. this is also called Ghost Driver --- Headless Browser:
				//--HtmlUnit Driver ---Java
				//--PhanthomJs -- JavaScript
		
		WebDriver driver = new HtmlUnitDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");
		System.out.println("Before login, title is :=="+driver.getTitle());
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("test@12345");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		//driver.findElement(By.)
		System.out.println("After login, title is :=="+driver.getTitle());
	}

}
