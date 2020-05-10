package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//1. isDisplayed() method: applicable for all the elements
		driver.get("https://register.freecrm.com/register//");   // enter URL
		boolean b1 = driver.findElement(By.xpath("//button[@name='action']")).isDisplayed(); //for SignUp button
		System.out.println(b1);     //true

		//2. isEnabled() method:
				boolean b2 = driver.findElement(By.xpath("//button[@name='action']")).isEnabled();
		System.out.println(b2);		//true
		
		//select I Agree checkbox:
		 driver.findElement(By.name("terms")).click();			// ---signUp button enables now
		 boolean b3 = driver.findElement(By.xpath("//button[@name='action']")).isEnabled();
		 System.out.println(b3);	//true
			
		//3. isSelected() method: only applicable for checkbox, dropdown, radiobutton.
		  boolean b4 = driver.findElement(By.name("terms")).isSelected();
		 System.out.println(b4);  //true
		 
		 // de-select the checkbox
		 driver.findElement(By.name("terms")).click();	
		 boolean b5 = driver.findElement(By.name("terms")).isSelected();
		 System.out.println(b5);  //false
			
	}

}
