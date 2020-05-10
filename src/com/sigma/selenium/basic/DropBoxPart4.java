package com.sigma.selenium.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DropBoxPart4 {
	
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe" );
		 driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		
//		//WebElement day = driver.findElement(By.id("day"));
//		//WebElement mont = driver.findElement(By.id("month"));
//		//WebElement year = driver.findElement(By.id("year"));
		
		
//		String monthXpath = "//*[@id='month']//option";
//		String dayXpath = "//*[@id='day']//option";
//		String yearXpath = "//*[@id='year']//option";
		
//		selectDropDownValue(monthXpath, "May");
//		selectDropDownValue(dayXpath, "10");
//		selectDropDownValue(yearXpath, "1976");
//	}
	
//	public static void selectDropDownValue(String xpathValue, String value){
//		List<WebElement> dobList = driver.findElements(By.xpath(xpathValue));
//		System.out.println(dobList.size());
//		
//		for(int i=0; i <= dobList.size(); i++){
//			System.out.println(dobList.get(i).getText());
//			if(dobList.get(i).getText().equals(value)){
//				dobList.get(i).click();
//				break;
//			}
//		}
//	}
//	
	String monthXpath = "//*[@id='month']//option";
	String dayXpath = "//*[@id='day']//option";
	String yearXpath = "//*[@id='year']//option";

	selectDropDownValue(monthXpath, "May");
	selectDropDownValue(dayXpath, "10");
	selectDropDownValue(yearXpath, "1976");
	}
	
	public static void selectDropDownValue(String xpathValue, String value){
	List<WebElement> dobList = driver.findElements(By.xpath(xpathValue));
	System.out.println(dobList.size());
	
	for(int i=0; i <= dobList.size(); i++){
		System.out.println(dobList.get(i).getText());
		if(dobList.get(i).getText().equals(value)){
			dobList.get(i).click();
			break;
		}
	}
}




	}


