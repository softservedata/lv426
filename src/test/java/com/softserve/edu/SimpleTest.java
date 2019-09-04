package com.softserve.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

	//@Test
	public void testAdd1() throws Exception {
		System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		Thread.sleep(1000); // For Presentation Only
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!" + Keys.ENTER);
		System.out.println("1. Page title is: " + driver.getTitle());
		//element.sendKeys("Cheese!");
		Thread.sleep(2000); // For Presentation Only
		//
		//element.submit();
		//System.out.println("1. Page title is: " + driver.getTitle());
		Thread.sleep(1000); // For Presentation Only
		System.out.println("2. Page title is: " + driver.getTitle());
		//
		driver.findElement(By.cssSelector("a[href*='en.wikipedia.org/wiki/Cheese']")).click();
		Thread.sleep(2000); // For Presentation Only
		//
		WebElement actual = driver.findElement(By.id("siteSub"));
		Assert.assertEquals("From Wikipedia, the free encyclopedia", actual.getText());
		//
		//driver.close();
		driver.quit();
	}
	
	@Test
	public void testAdd2() throws Exception {
		System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000); // For Presentation Only
		//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://taqc-opencart.epizy.com/index.php?route=product/product&product_id=42");
		Thread.sleep(1000); // For Presentation Only
		//
		//WebElement element = driver.findElement(By.cssSelector("label:contains('Medium')"));
		//WebElement element = driver.findElement(By.xpath("//div[contains(text(), 'Medium')]"));
		//System.out.println("Contains: " + element.getText());
		/*
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='radio']/label"));
		WebElement element = null;
		for (WebElement current : elements) {
			System.out.println("Contains: " + current.getText());
			if (current.getText().contains("Medium")) {
				System.out.println("\t***Medium founded");
				element = current;
			}
		}
		Assert.assertTrue(element.getText().contains("24.00"));
		*/
		//
		WebElement element = driver.findElement(By.cssSelector(".btn.btn-default.btn-block"));
		Thread.sleep(1000); // For Presentation Only
		//element.click();
		//Thread.sleep(4000); // For Presentation Only
		//Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:\\a.png ");
		//
		//System.out.println("SET: " + driver.getWindowHandles());
		//System.out.println("SET: " + driver.switchTo().);
		//
		//driver.switchTo().activeElement().sendKeys("D:\\a.png");
		//
		//Thread.sleep(4000); // For Presentation Only
		//element.click();
		WebElement element2 = driver.findElement(By.id("input-option222"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].value = '06cff484d18b4a766be9e88f56655980a3427bb9'", element2);
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '06cff484d18b4a766be9e88f56655980a3427111'", element2);
		//
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(4000); // For Presentation Only
		//
		//driver.quit();
	}

}
