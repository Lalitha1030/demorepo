package com.sigma.selenium.basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BootstrapDropBoxPart2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://v4-alpha.getbootstrap.com/components/dropdowns/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='dropdownMenuButton']")).click();
		
		//List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu')] and [@aria-labelledby='dropdownMenuButton']//a"));
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));
		System.out.println(list.size());
		
		for (int i=0; i<=list.size(); i++){
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().equals("Another action")){
				list.get(i).click();
				break;
			}
			
		}
	}

}
