package com.sigma.selenium.basic;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropBoxPart2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.macys.com/account/createaccount?cm_sp=my_account-_-sign_in-_-create_account");
		WebElement month1 = driver.findElement(By.xpath("//*[@id='ca-profile-birth-month']"));
		WebElement day1 = driver.findElement(By.xpath("//*[@id='ca-profile-birth-day']"));
		
		Select select1 = new Select(month1);
		//select1.selectByIndex(4);				  // this method is not recomended	
		select1.selectByVisibleText("March");     // this method is recomended 
		
		System.out.println(select1.isMultiple());
		List<WebElement> listMonth = select1.getOptions();
		System.out.println(listMonth.size());
		int totalMonths = listMonth.size()-1;
		System.out.println("Total Months:" +totalMonths);
		
		for(int i=0; i <= totalMonths; i++){
			String monthVal =listMonth.get(i).getText();
		System.out.println(monthVal);	
		
		if(monthVal.equals("October")){
			listMonth.get(i).click();
			break;
			
		}
		
			
			
		}
		

	}

}
