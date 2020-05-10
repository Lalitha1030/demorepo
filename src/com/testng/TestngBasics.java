package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngBasics {
	// Preconditions --- starting with @Before
   @BeforeSuite
   public void setup(){
	   System.out.println("setup systme property for chrome");
   }
   @BeforeTest
	public void login(){
		System.out.println("login method");	
	}
	@BeforeClass
	public void launchBrowser(){
		System.out.println("launch chrome Browser");
	}
	@BeforeMethod
	public void enterURL(){
		System.out.println("enter URL");
	}	
	
	// test cases--- starting with @Test
	@Test
	public void googleTitleTest(){
		System.out.println("Google Title Test");
	}
	
	@Test
	public void searchTest(){
		System.out.println(" Search Test");
	}
	
	// Post conditions  --- starting with @After
	
	@AfterMethod
	public void logout(){
		System.out.println("Logout from app");
	}
	@AfterClass
	public void closeBrowser(){
		System.out.println("Close Browser");
	}
	@AfterTest
	public void deletAllCookies(){
		System.out.println("Delete all Cookies");
	}
	
	@AfterSuite
	public void generateTestReport(){
		System.out.println("GenerateTestReport");
	}
	
}
