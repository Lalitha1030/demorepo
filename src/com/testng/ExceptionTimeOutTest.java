package com.testng;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	/* 
	@Test(invocationTimeOut=2, expectedExceptions=NumberFormatException.class)
	public void infinitLoopTest(){
		int i=1;
		while(i==1){
			System.out.println(i+1);
		}
		
	}
	*/
	@Test(expectedExceptions = NumberFormatException.class)
	
	public void test1(){
		String x = "100A";
		int a =  Integer.parseInt(x);
		System.out.println(a);
	}
}
