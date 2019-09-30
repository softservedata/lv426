package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonCartProductComponent {
	
	protected WebDriver driver;
	private WebElement vievButton;

	public ButtonCartProductComponent(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private WebElement getVievButton() {
		return driver.findElement(By.xpath("//p[@class='text-right']/a/strong[contains(text(),' View Cart')]"));
	}

	protected void ClickVievButton() {
		getVievButton().click();
	}




	private void initElements() {
		// init elements
	}

	// Page Object

	// Functional

	// Business Logic
}
