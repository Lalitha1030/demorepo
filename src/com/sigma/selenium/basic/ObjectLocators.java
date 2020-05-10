package com.sigma.selenium.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ObjectLocators {
	
	public static void main(String[] args){
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror%3Fstatuscode%3D500");
		
		//1. xpath:-----2
		//absolute xpath(from--html to body to div1 to div 5 to a tag---)(proper hierarchy we are getting) not recomended
		//only relative xpath shoud be used
		
//		//driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		//driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("smitha1");
//		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("soma1");
//		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("soma1");
//		//driver.quit();
//		
		//2. id:------1
		
		//driver.findElement(By.id("firstname")).sendKeys("smitha1");
		//driver.findElement(By.id("lastname")).sendKeys("soma1");
		
		//3.name-------3
		
//		driver.findElement(By.name("firstname")).sendKeys("smitha1");
//		driver.findElement(By.name("lastname")).sendKeys("soma1");
		
		//4.LinkText this is only for links------1
//		driver.findElement(By.linkText("Sign in")).click();
		
		//5. partialLinkText not recomended-------2
//		driver.findElement(By.partialLinkText("Sign")).click();
		
		//6. CSSSelector--------2
		// if id is there-----#id;
		//if class is there-----.class
//		driver.findElement(By.cssSelector("#firstname")).sendKeys("smitha");
		
		//7.className not recomended--------4
//		driver.findElement(By.className("fld wide wide fld regular-text bold-text float-box")).click();
		
		//8.
		
		
		
		
	}

	
}
