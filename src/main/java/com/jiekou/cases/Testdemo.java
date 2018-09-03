package com.jiekou.cases;

import org.testng.TestNG;

public class Testdemo {
	public static void main(String[] args) {
		TestNG testNG=new TestNG();
		testNG.setTestClasses(new Class[] {LoginCase.class});
		testNG.run();
	}
	
}
