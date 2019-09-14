package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSidebarGuestPart extends AccountSidebarPart {

	private WebElement login;
	private WebElement register;
	private WebElement forgottenPassword;

	public AccountSidebarGuestPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		login = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Login')]"));
		register = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Register')]"));
		forgottenPassword = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Forgotten Password')]"));
	}
	// Page Object

	public WebElement getLogin() {
		return login;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getForgottenPassword() {
		return forgottenPassword;
	}

	// Functional

	public void clickLogin() {
		getLogin().click();
	}

	public void clickRegister() {
		getRegister().click();
	}

	public void clickForgottenPassword() {
		getForgottenPassword().click();
	}

	// Business Logic

	public RegisterPage goToRegisterPage() {
		clickRegister();
		return new RegisterPage(driver);
	}

	public LoginPage goToLoginPage() {
		clickLogin();
		return new LoginPage(driver);
	}

	public ForgotPasswordPage goToForgotPasswordPage() {
		clickForgottenPassword();
		return new ForgotPasswordPage((driver));
	}
}
