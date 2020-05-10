package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestNavigateCommands1 {
	WebDriver driver;
	
	public void invokeBrowser(){
		
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marrionette", true);
			driver = new FirefoxDriver(capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			navigateCommands1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void navigateCommands1(){
		
			try {
				driver.navigate().to("https://www.flipkart.com");
				//Alert alert = driver.switchTo().alert();
				driver.findElement(By.xpath("//button[text()='✕']")).click();
				driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("Microwave Ovens");
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				//driver.findElement(By.xpath("//span[starts-with(text(),'TVs & Appliances')]")).click();
				//driver.findElement(By.xpath("//a[@title='Microwave Ovens']")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2000);
				driver.navigate().forward();
				
				//driver.findElement(By.xpath("//a[@title='Kitchen Appliances']")).click();
				//Thread.sleep(2000);
				//driver.close();
			} 
			catch (InterruptedException e) 
			//catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestNavigateCommands1 myObj = new TestNavigateCommands1();
		myObj.invokeBrowser();

	}

}
