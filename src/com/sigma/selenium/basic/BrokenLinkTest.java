package com.sigma.selenium.basic;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		//links--- //a href<http://google.com>
		//images--//img<http://www.test.com>
		
		//1. get the list of all the links and images:
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Size of all the links and images:" +linksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2.iterate linksList: exclude all the links/images- doesn't have any href attributes		
		for(int i=0; i<linksList.size(); i++){
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href")!=null &&  (!linksList.get(i).getAttribute("href").contains("javascript"))){
				activeLinks.add(linksList.get(i));
				
			}
		}
		//get the size of activeLinks list
		System.out.println("size of active links and images---->"+activeLinks.size());
		//3.check the href url. with http connection api
				//200--ok
				//404---not found
				//500---internal error
				//400--bad request

		for(int j=0; j<activeLinks.size(); j++){
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage(); // OK
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"---->"+response);
		}
		
		
		
		
	}

}
