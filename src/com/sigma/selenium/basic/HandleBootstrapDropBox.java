package com.sigma.selenium.basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleBootstrapDropBox {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.26.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect')]")).click();
		
		//List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//li//a//label"));
		//list.size();
		//System.out.println(list.size());
		
	// selecting all the check boxed
		/*
		for(int i =0; i<=list.size(); i++){
			System.out.println(list.get(i).getText());
			if (list.get(i).getAttribute("class").equalsIgnoreCase("active")){
				//if(!driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected()){
					//driver.findElement(By.xpath("//input[@type='checkbox']")).click();
				
					list.get(i).click();
			}
				//list.get(i).click();
		*/
		List<WebElement> element = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect')]//li"));
		for(WebElement ele:element){
			//System.out.println(ele.getAttribute("class").equalsIgnoreCase("active"));
			if(ele.getAttribute("class").equalsIgnoreCase("active")){
				System.out.println(ele.getText());
			}
			else{
				ele.click();
				System.out.println(ele.getText());
			}
//		//Selecting only one option(Angular)		
//		for(int i = 0; i <= list.size(); i++){
//			System.out.println(list.get(i).getText());
//			//if (list.get(i).getText().equals("Angular")){
//		if (list.get(i).getText().contains("Angular")){
//				list.get(i).click();
//				break;
			
//			}
//			//list.get(i).getText().contains("Angular");
			
//		
//		for(WebElement listElement : list){
//			System.out.println(listElement.getAttribute("class").equalsIgnoreCase("active"));
//			if (listElement.getAttribute("class").equalsIgnoreCase("active")){
//				System.out.println(listElement.getText());
//			}else
//			{
//			listElement.click();
//			}
//		}
//		
		
	}
	}
}
	



