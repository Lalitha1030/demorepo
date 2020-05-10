package com.sigma.selenium.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DropBoxPart3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement mont = driver.findElement(By.id("month"));
		WebElement year = driver.findElement(By.id("year"));
		
		List<WebElement> monthList = driver.findElements(By.xpath("//*[@id='month']//option"));
		System.out.println(monthList.size());
		
		for(int i=0; i <= monthList.size(); i++){
			System.out.println(monthList.get(i).getText());
			if(monthList.get(i).getText().equals("Jun")){
				monthList.get(i).click();
				break;
			}
		}

	}

}
