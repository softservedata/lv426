package com.softserve.edu;

import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstBefore {

	private String testName = "START";

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite class FirstBefore beforeSuite()");
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("@AfterSuite class FirstBefore afterSuite()");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("\t@BeforeTest class FirstBefore beforeTest()");
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		System.out.println("\t@AfterTest class FirstBefore afterTest()");
	}

	@BeforeClass
	// public void beforeClass() {
	public void beforeClass(ITestContext context) {
		// HashMap<String, String> parameters = new
		// HashMap<>(context.getCurrentXmlTest().getAllParameters());
		for (Map.Entry<String, String> entry : context.getCurrentXmlTest().getAllParameters().entrySet()) {
			System.out.println("Key: " + entry.getKey() + "  Value: " + entry.getValue());
		}
		System.out.println("\t\t@BeforeClass class FirstBefore beforeClass()");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("\t\t@AfterClass class FirstBefore afterClass()");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t\t\t@BeforeMethod class FirstBefore beforeMethod()");
		testName = "VALID";
	}

	@BeforeMethod
	public void beforeMethod2() {
		System.out.println("\t\t\t@BeforeMethod class FirstBefore beforeMethod2()");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		System.out.println("\t\t\t@AfterMethod class FirstBefore afterMethod()");
		if (!result.isSuccess()) {
			System.out.println("Test " + result.getName() + " ERROR");
		}
	}

	@DataProvider
	public Object[][] validZero() {
		System.out.println("\t\t\t\t@DataProvider class FirstBefore");
		return new Object[][] {
			{ testName },
		};
	}

	@Test(dataProvider = "validZero")
	public void zero(String name) {
		System.out.println("\t\t\t\t@Test class FirstBefore zero(); name = " + name);
	}

	@Test
	public void one() {
		System.out.println("\t\t\t\t@Test class FirstBefore one()");
	}

	@Test
	public void two() {
		System.out.println("\t\t\t\t@Test class FirstBefore two()");
	}
}
