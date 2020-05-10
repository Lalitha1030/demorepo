package com.sigma.selenium.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadPropFile {
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("/Users/kollas/workspace1/SeleniumProj/src/com/sigma/selenium/basic/configN.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		String url = prop.getProperty("URL");
		System.out.println(url);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("chrome")){ 
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\internetexplorerdriver\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
	}

}
