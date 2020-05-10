package com.sigma.selenium.basic;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe" );
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.macys.com/account/createaccount?cm_sp=my_account-_-sign_in-_-create_account");
		WebElement month = driver.findElement(By.xpath("//*[@id='ca-profile-birth-month']"));
		WebElement day = driver.findElement(By.xpath("//select[@id='ca-profile-birth-day']"));
		//WebElement year = driver.findElement(By.xpath())
//		Select select1 = new Select(month);
//		select1.selectByVisibleText("January");
//		Select select2 = new Select(day);
//		select2.selectByVisibleText("04");
		
		String dob = "02-January-1999";
		String dobArr[] = dob.split("-");
						
		//selectValueFromDropDown(month, "January");
		//selectValueFromDropDown(day, "02");
		selectValueFromDropDown(month, dobArr[1]);
		selectValueFromDropDown(day, dobArr[0]);
		//selectValueFromDropDown(year,dobArr[2]);
		
	}
	
	public static void selectValueFromDropDown(WebElement element, String value){
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

}
