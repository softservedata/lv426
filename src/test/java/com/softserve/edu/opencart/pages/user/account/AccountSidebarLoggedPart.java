package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSidebarLoggedPart extends AccountSidebarPart {

	private WebElement EditAccountRight;
	private WebElement PasswordRight;
	private WebElement LogoutRight;

	public AccountSidebarLoggedPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		// TODO +++++++++
		EditAccountRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/edit')]"));
		PasswordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/password')]"));
		LogoutRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/logout')]"));

	}

	// Page Object

	// EditAccountRight
	// PasswordRight
	// LogoutRight

	// Functional

	// Business Logic
}
