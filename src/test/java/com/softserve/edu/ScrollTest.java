package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollTest {

	@Test
	public void SearchFirst() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.seleniumhq.org/download/");
		Thread.sleep(1000); // For Presentation Only
		//
		WebElement linkSelite = driver.findElement(By.xpath("//h3[text()='SeLite']"));
		// Action
		//Actions action = new Actions(driver);		
		//action.moveToElement(linkSelite).perform();
		//
		// JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkSelite);
		Thread.sleep(10000); // For Presentation Only
		//
		driver.quit();
	}

}
