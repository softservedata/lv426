package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends AccountSidebarLoggedPart {
	private WebElement passwordField;
	private WebElement confirmPasswordField;
	private WebElement continueButton;

	public ChangePasswordPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		passwordField = driver.findElement(By.id("input-password"));
		confirmPasswordField = driver.findElement(By.id("input-password"));
		continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
	}

	// Page Object

	//PasswordField
	public WebElement getPasswordField() {
		return passwordField;
	}

	public void clearPasswordField() {
		getPasswordField().clear();
	}

	public void clickPasswordField() {
		getPasswordField().click();
	}

	public void setPasswordField(String text) {
		getPasswordField().sendKeys(text);
	}
	//ConfirmPasswordField
	public WebElement getConfirmPasswordField() {
		return confirmPasswordField;
	}

	public void clearConfirmPasswordField() {
		getConfirmPasswordField().clear();
	}

	public void clickConfirmPasswordField() {
		getConfirmPasswordField().click();
	}

	public void setConfirmPasswordField(String text) {
		getConfirmPasswordField().sendKeys(text);
	}

	//continueButton
	public WebElement getContinueButton() {
		return continueButton;
	}
	public void clickContinueButton() {
		getContinueButton().click();
	}

	//Functional
	//PasswordField
	private void fillPasswordField(String text) {
		clickPasswordField();
		clearPasswordField();
		setPasswordField(text);
	}
	private void fillConfirmPasswordField(String text) {
		clickConfirmPasswordField();
		clearConfirmPasswordField();
		setConfirmPasswordField(text);
	}

	// Business Logic
	public MyAccountPage changePassword(String password, String confirmPassword){
		fillPasswordField(password);
		fillConfirmPasswordField(confirmPassword);
		clickContinueButton();
		return new MyAccountPage(driver);
	}
}
