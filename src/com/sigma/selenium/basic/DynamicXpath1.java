package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DynamicXpath1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		 		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", loginBtn);
		
    	driver.switchTo().frame("mainpanel");
    	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
    	
    	driver.findElement(By.xpath("//a[contains(text(), 'abc xyz')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
 
    	//driver.findElement(By.xpath("//a[contains(text(), 'abc xyz')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
    	
    	//Link: Features
    	//a[text()='Features']
    	//a[contains(text(), 'Features')]---recomended
     	
    	//Button:
    	//button[@type='button' and @class='btn']
    	//button[contains(text(), 'SignUp')]
    	
    	//div[@class='dropdown']//button[@type='button' and @class='btn btn-secondary dropdown-toggle' and @id='dropdownMenuButton']
    	//button[@id='dropdownMenuButton']
    	
    	//a[text()='abc xyz']//parent::td[@class='datalistrow']//proceding-sibling::td[@class='datalistrow']//input
    	//*[@id='vContactsForm']/table/tbody/tr[6]/td[1]/input
	}

}
