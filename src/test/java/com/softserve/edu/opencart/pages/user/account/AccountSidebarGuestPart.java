package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountSidebarGuestPart extends AccountSidebarPart {


    public AccountSidebarGuestPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
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
