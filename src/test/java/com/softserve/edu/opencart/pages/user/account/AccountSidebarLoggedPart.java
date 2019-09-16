package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSidebarLoggedPart extends AccountSidebarPart {


    public AccountSidebarLoggedPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
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
