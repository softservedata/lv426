package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.pages.user.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLogoutPage extends AccountSidebarGuestPart {
	private WebElement continueButton;

	public AccountLogoutPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary"));
	}

	// Page Object
	public WebElement getContinueButton() {
		return continueButton;
	}
	public void clickContinueButton() {
		getContinueButton().click();
	}
	// Functional

	// Business Logic
	public HomePage logout(){
		clickContinueButton();
		return new HomePage(driver);
	}
}
