package com.softserve.edu.opencart.pages.user.account;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulLoginPage extends LoginPage {

	private WebElement unsuccessfulLogin;

	public UnsuccessfulLoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		unsuccessfulLogin = driver.findElement(By.cssSelector("div.alert.alert-danger"));
	}

	// Page Object

	public WebElement getUnsuccessfulLogin() {
		return unsuccessfulLogin;
	}

	// Functional

	public String getUnsuccessfulLoginText() {
		return getUnsuccessfulLogin().getText();
	}

	// Business Logic
}
