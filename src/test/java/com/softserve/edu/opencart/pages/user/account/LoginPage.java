package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AccountSidebarGuestPart {

	private WebElement email;
	private WebElement password;
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		email = driver.findElement(By.name("email"));
		password = driver.findElement(By.name("password"));
		loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
	}

	// Page Object

	// Functional
	
	// email
	public WebElement getEmail() {
		return email;
	}

	public void clearEmailField() {
		getEmail().clear();
	}

	public void clickEmailField() {
		getEmail().click();
	}

	public void setEmail(String email) {
		getEmail().sendKeys(email);
	}

	// password
	public WebElement getPassword() {
		return password;
	}

	public void clearPasswordField() {
		getPassword().clear();
	}

	public void clickPasswordField() {
		getPassword().click();
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	// loginButton
	public WebElement getLoginButton() {
		return loginButton;
	}

	public void clickLoginButton() {
		getLoginButton().click();
	}

	// Functional

	private void enterEmail(String email) {
		clickEmailField();
		clearEmailField();
		setEmail(email);
	}

	private void enterPassword(String password) {
		clickPasswordField();
		clearPasswordField();
		setPassword(password);
	}

	public void loginAs(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLoginButton();
	}

	// Business Logic

	//??
	public UnsuccessfulLoginPage unsuccessfulLoginPage(String email, String password){
		loginAs(email,password);
		return new UnsuccessfulLoginPage(driver);
	}
}
