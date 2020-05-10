package com.sigma.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		 		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", loginBtn);
		
    	driver.switchTo().frame("mainpanel");
    	//Actions action = new Actions(driver);
    	//action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Calendar')]"))).build().perform();
    	//Thread.sleep(3000);
    	//driver.findElement(By.xpath("//a[contains(text(),'View Today')]")).click();
    	driver.findElement(By.xpath("//a[contains(text(),'Calendar')]")).click();
    	
       	String date = "31-September-2019";
    	String dateArray[] = date.split("-");
    	String day = dateArray[0];
    	String month = dateArray[1];
    	String year = dateArray[2];
    	
    	Select select1 = new Select(driver.findElement(By.name("slctMonth")));
    	select1.selectByVisibleText(month);
    	
    	Select select2 = new Select(driver.findElement(By.name("slctYear")));
    	select2.selectByVisibleText(year);
    	
    	//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
    	//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
    	//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
    	//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]
    	
    	String beforeXpath ="//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
    	String afterXpath = "]/td[";
    	
    	final int totalWeekDays = 7;
    	//2-1 2-2 2-3 2-4 2-5 2-6 2-7
    	//3=1 3-2 3-3 3-4 3-5 3-6 3-7
    	boolean flag = false;
    	String dayValue;
    	for(int rowNum=2; rowNum<=7; rowNum++){
    		for(int colNum=1; colNum<=totalWeekDays; colNum++){
    			try{
    			dayValue = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
    			}catch(NoSuchElementException e){
    				System.out.println("Please enter a correct date value");
    				flag = false;
    				break;
    			}
    			System.out.println(dayValue);
    			if(dayValue.equals(day)){
    				driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
    				flag = true;
    				break;
    			}
    		}
    		if(flag){
    			break;
    		}
    	}
	}

}
