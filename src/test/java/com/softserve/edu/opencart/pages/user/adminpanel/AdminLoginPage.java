package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {

    private WebDriver driver;

    private static final String ADMIN_NAME = "admin";
    private static final String ADMIN_PASSWORD = "Lv426_Taqc";

    private WebElement inputLoginField;
    private WebElement inputPasswordField;
    private WebElement loginButton;


    AdminLoginPage (WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        inputLoginField = driver.findElement(By.id("input-username"));
        inputPasswordField = driver.findElement(By.id("input-password"));
        loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
    }


    //page obj
    private void clickOnUserNameField() {
        inputLoginField.click();
    }

    private void clearUserNameField() {
        inputLoginField.clear();
    }

    private void clickOnPasswordField() {
        inputPasswordField.click();
    }

    private void clearPasswordField() {
        inputPasswordField.clear();
    }

    private void clickOnLoginButton() {
        loginButton.click();
    }

    //funk
    private void enterUserName() {
        clickOnUserNameField();
        clearUserNameField();
        inputLoginField.sendKeys(ADMIN_NAME);
    }

    private void enterPassword() {
        clickOnPasswordField();
        clearPasswordField();
        inputPasswordField.sendKeys(ADMIN_PASSWORD);
    }

    //BL
    /*
    public AdminHomePage goToAdminHomePage() {
        enterUserName();
        enterPassword();
        clickOnLoginButton();
        return new AdminHomePage();
    }

     */












}
