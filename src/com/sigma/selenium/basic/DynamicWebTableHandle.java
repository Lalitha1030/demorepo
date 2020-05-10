package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		 		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", loginBtn);
		
    	driver.switchTo().frame("mainpanel");
    	Thread.sleep(2000);
    	
    	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
    	//*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
    	//*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
    	//*[@id='vContactsForm']/table/tbody/tr[6/td[2]/a
    	//*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a
    	
    	//method-1
    	String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
    	String after_xpath = "]/td[2]/a";
    	
    	for(int i=4; i<16; i++){
    		String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
    		System.out.println(name);
    		if(name.contains("vinayak latpate")){
    			driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]/input")).click();
    		}
    	}
    	
    	//Method-2:
//    	
    	//driver.findElement(By.xpath("//a[contains(text(), 'niraj')]parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
    	//driver.findElement(By.xpath("//a[contains(text(), 'akash reddy')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
    	
	}

}
