package com.sigma.selenium.basic;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Day1 {
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser(){
		try {
			//System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver_win32//chromedriver.exe");
					//driver = new ChromeDriver();
					System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
					//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					//capabilities.setCapability("marionette", true);
					driver = new FirefoxDriver();
					
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					
					
				searchItem();
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchItem(){
		try {
			driver.get("https://www.amazon.com/");
			//driver.manage().window().maximize();
			//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby wipes");
			
			
			//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("women shoe");
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("women shoe");
			//driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']")).sendKeys("baby wipes");
			//driver.findElement(By.id("nav-iss-attach")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Go']")).click();
			jse = (JavascriptExecutor)driver;
			jse.executeScript("scroll(0, 1000)");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'New')]")).click();
			
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//a[contains(text(),'Next')]")).click();
			//driver.findElement(By.xpath("//span[@id = 'nav-search-submit-text']")).click();
			driver.quit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
		
	
	public static void main(String[] args) {
		
			Day1 myObj = new Day1();
			myObj.invokeBrowser();
				
	}

}
