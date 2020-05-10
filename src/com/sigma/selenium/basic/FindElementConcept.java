package com.sigma.selenium.basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		//1. get the total count of links on the page
		//2. get the text of each link on the page
		
		List <WebElement> linkList =  driver.findElements(By.tagName("a"));
		//how to get the size of array list
		System.out.println(linkList.size());
		for(int i=0; i<=linkList.size(); i++){
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
			
		}
		

	}

}
