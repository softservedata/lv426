package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSidebarLoggedPart extends AccountSidebarPart {

	//private WebElement myAccount;
	private WebElement editAccount;
	private WebElement changePassword;
	private WebElement addressBook;
	//private WebElement wishList;

	public AccountSidebarLoggedPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		//myAccount = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'My Account')]"));
		editAccount = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Edit Account')]"));
		changePassword = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Password')]"));
		addressBook = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Address Book')]"));
		//wishList = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Wish List')]"));
	}

	// Page Object

	public WebElement getEditAccount() {
		return editAccount;
	}

	public WebElement getChangePassword() {
		return changePassword;
	}

	public WebElement getAddressBook() {
		return addressBook;
	}

	// Functional

	public void clickEditAccount() {
		getEditAccount().click();
	}

	public void clickChangePassword() {
		getChangePassword().click();
	}

	public void clickAddressBook() {
		getAddressBook().click();
	}

	// Business Logic

	public EditAccountPage goToEditAccountPage() {
		clickEditAccount();
		return new EditAccountPage(driver);
	}

	public ChangePasswordPage goToChangePasswordPage() {
		clickChangePassword();
		return new ChangePasswordPage(driver);
	}

	public AddressBookPage goToAddressBookPage() {
		clickAddressBook();
		return new AddressBookPage(driver);
	}
}
