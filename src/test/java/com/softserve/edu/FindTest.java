package com.softserve.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindTest {
	private static WebDriver driver;
	
	@BeforeClass
	//public static void setUpBeforeClass() throws Exception {
	public void setUpBeforeClass() throws Exception {
		// Precondition
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(1000); // For Presentation Only
	}

	@AfterClass
	//public static void tearDownAfterClass() throws Exception {
	public void tearDownAfterClass() throws Exception {
		// Return to previous state
		System.out.println("@AfterClass");
		Thread.sleep(4000); // For Presentation Only
		driver.quit();
	}

	//@Before
	@BeforeMethod
	public void setUp() throws Exception {
		// Precondition
		System.out.println("\t@Before method");
		driver.get("http://10.26.34.118/opencart/upload/");
		Thread.sleep(1000); // For Presentation Only
	}

	//@After
	@AfterMethod
	public void tearDown() throws Exception {
		// Return to previous state
		System.out.println("\t@After method");
		// logout
	}

	@Test
	public void SearchCss() throws Exception {
		// Precondition
		// Choose Curency
		driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.cssSelector("[name='USD']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		driver.findElement(By.cssSelector("#search > input")).click();
		driver.findElement(By.cssSelector("#search > input")).clear();
		driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		//driver.findElement(By.cssSelector("a:contains('MacBook')")).click(); // ERROR
		// Search a $("div.product-layout.product-grid h4 > a")
		// Search h4 $("div.product-layout.product-grid h4:has(> a)")
		// Search Price $("div.product-layout.product-grid h4:has(> a[href*='id=43']) + p + p")
		// Search Price $("div.product-layout.product-grid div:has(> h4 > a[href*='id=43']) > p[class='price']")
		//
		// Check
		//WebElement price = driver.findElement(By.cssSelector("div.product-layout.product-grid div:has(> h4 > a[href*='id=43']) > p[class='price']"));
		WebElement price = getElementByName("MacBook").findElement(By.cssSelector("p.price"));
		Assert.assertTrue(price.getText().contains("$602.00"));
	}
	
	private WebElement getElementByName(String name) {
		WebElement result = null;
		List<WebElement> containers = driver.findElements(By.cssSelector("div.product-layout.product-grid"));
		for (WebElement current : containers) {
			if (current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
				result = current;
				break;
			}
		}
		if (result == null) {
			// Develop Custom Exception
			throw new RuntimeException("WebElement by title/name: " 
						+ name + " not found");
		}
		return result;
	}
	
	@Test
	public void SearchXPath() throws Exception {
		// Precondition
		// Choose Curency
		driver.findElement(By.xpath("//button[@class='btn btn-link dropdown-toggle']")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//button[@name='USD']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Steps
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Check
		WebElement price = driver.findElement(By.xpath("//h4/a[text()='MacBook']/../following-sibling::p[@class='price']"));
		Assert.assertTrue(price.getText().contains("$602.00"));
	}
}
