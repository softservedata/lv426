package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SearchTest {

	// @Test
	public void SearchOne() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://10.26.34.118/opencart/upload/");
		Thread.sleep(1000); // For Presentation Only
		//
		// WebElement element = driver.findElement(By.name("searWch"));
		// element.sendKeys("Mac");
		//
		// List<WebElement> elements = driver.findElements(By.name("search"));
		// System.out.println("elements counts: " + elements.size());
		// elements.get(0).sendKeys("Mac");
		//
		// WebElement element = (WebElement)((JavascriptExecutor)
		// driver).executeScript("return document.getElementsByName('search')[0]");
		// element.sendKeys("Mac");
		//
		driver.findElement(By.cssSelector("a[title='My Account']")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(1000); // For Presentation Only
		// 1. Select
		/*
		 * WebElement select1 = driver.findElement(By.id("input-country"));
		 * select1.click(); Thread.sleep(1000); // For Presentation Only
		 * //select1.findElement(By.cssSelector("option:contains('Ukraine')")).click();
		 * // Error, not found
		 * select1.findElement(By.cssSelector("option[value='220']")).click(); //
		 * Architecture Error, hardcode '220'
		 */
		// 2. Select
		Select select = new Select(driver.findElement(By.id("input-country")));
		select.selectByVisibleText("Ukraine");
		//
		((JavascriptExecutor) driver).executeScript("alert('Ha-Ha-Ha')");
		Thread.sleep(2000); // For Presentation Only
		driver.switchTo().alert().accept();
		//
		Thread.sleep(4000); // For Presentation Only
		//
		driver.quit();
	}

	@Test
	public void LoginOne() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://softserve.academy/");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.linkText("Log in")).click();
		//
		// Duplicate Code
		/*
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("ha-ha-ha");
		Thread.sleep(4000); // For Presentation Only
		//
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("be-be-be");
		*/
		// Architecture Error, see martin fowler refactoring
		/*
		WebElement login = driver.findElement(By.id("username"));
		login.click();
		login.clear();
		login.sendKeys("ha-ha-ha");
		Thread.sleep(4000); // For Presentation Only
		//
		driver.navigate().refresh();
		//
		login.click();
		login.clear();
		login.sendKeys("be-be-be");
		*/
		//
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("ha-ha-ha");
		Thread.sleep(4000); // For Presentation Only
		//
		driver.navigate().refresh();
		//
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("be-be-be");
		//
		Thread.sleep(4000); // For Presentation Only
		driver.quit();
	}
}
