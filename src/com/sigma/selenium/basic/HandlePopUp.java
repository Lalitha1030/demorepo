package com.sigma.selenium.basic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlePopUp {
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//		
//		driver.findElement(By.name("proceed")).click();
//		Thread.sleep(5000);
//		Alert alert = driver.switchTo().alert();
//		System.out.println(alert.getText());
//		String text = alert.getText();
//		if(text.equals("Please enter a valid user name")){
//			System.out.println("correct alert message");
//		}else{
//			System.out.println("in-correct alert message");
//		}
//		
//		
//		alert.accept();
//		
//		
//		driver.quit();
//		
		//1. alerts -- JavaScript Pop Up---Alert API (accept, dismiss)
		//2. File upload pop up ----Browse Button(type = file, sendKeys(path))
		//3. Browser Window Popup ---Advertisement pop up(windowHandler API - getWindowHandler() )
		
		driver.get("http://popuptest.com/goodpopups.html");
		
		//driver.findElement(By.xpath("/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/font[1]/b[1]/a[3]")).click();
		driver.findElement(By.xpath("html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[1]/font[1]/b[1]/a[4]")).click();
		Thread.sleep(5000);
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Parent window id:  " +parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child window id:  " +childWindowId);
		
		driver.switchTo().window(childWindowId);
		
		System.out.println("Child Window Pop Up title: " +driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent Window Title: " + driver.getTitle());
		driver.quit();
		
	}
}
