package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSidebarGuestPart extends AccountSidebarPart {

	private WebElement loginRight;
	private WebElement registerRight;
	private WebElement forgottenPasswordRight;

	public AccountSidebarGuestPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		loginRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]"));
		registerRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/register')]"));
		forgottenPasswordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/forgotten')]"));
	}

	// Page Object

	// loginRight
	// registerRight
	// forgottenPasswordRight

	// Functional

	// Business Logic
}
