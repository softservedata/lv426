package com.softserve.edu.opencart.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.softserve.edu.opencart.pages.user.HomePage;

public class ParallelTestRunner {
	//
	private final String SERVER_URL = "http://taqc-opencart.epizy.com";
	//
	private List<WebDriver> drivers;

	@BeforeClass
	public void beforeClass() {
		drivers = new ArrayList<>();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		for (WebDriver driver : drivers) {
			if (driver != null) {
				driver.quit();
			}
		}
	}
	
	public HomePage loadApplication() {
		System.setProperty("webdriver.chrome.driver",
				this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
		WebDriver driver = new ChromeDriver();
		drivers.add(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(SERVER_URL);
		return new HomePage(driver);
	}
}
