package com.softserve.edu.opencart.pages.user.addressbook;

import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBookPage extends AccountSidebarLoggedPart {

	/** This variable for address information on page */
	private WebElement addressText;

	/** This variable for button Edit on page */
	private WebElement editButton;

	/** This variable for button Delete on page */
	private WebElement deleteButton;

	/** This variable for button New Address on page */
	private WebElement newAddressButton;

/*	*//** This variable for catching message about success update *//*
	private WebElement updateText;

	*//** This variable for catching message with warning *//*
	private WebElement warningText;*/

	public AddressBookPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		addressText = driver.findElement(By.className("text-left"));
		editButton = driver.findElement(By.linkText("Edit"));
		deleteButton = driver.findElement(By.xpath("//a[contains(@class,'btn btn-danger')]"));
		newAddressButton = driver.findElement(By.linkText("New Address"));
	//	updateText = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]"));
	//	warningText = driver.findElement(By.xpath("//div[contains(@class,'alert alert-warning')]"));
	}

	// Page Object

	// Functional
	/** This method click on button Edit */
	public void editClick() {
		editButton.click();
	}

	/** This method click on button Delete  */
	public void deleteClick() {
		deleteButton.click();
	}

	/** This method click on button New Address  */
	public void newAddressClick() {
		newAddressButton.click();
	}

	// Business Logic
}
