package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;


public class DayChromeTest {

	public static void main(String[] args) throws InterruptedException {
		try {
			/*  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//capabilities.setCapability("marionette", true);
			WebDriver driver = new ChromeDriver();  */
			
			Screen screen = new Screen();
			Pattern image1 = new Pattern("C:\\Images\\todaysdeals.PNG");
			Pattern image2 = new Pattern("C:\\Images\\alldeals.PNG");
					
					System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);
					WebDriver driver = new FirefoxDriver(capabilities);
					
					
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
					
					driver.get("http://www.amazon.com");
					
					
					screen.click(image1);
					screen.click(image2);
					driver.close();
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
