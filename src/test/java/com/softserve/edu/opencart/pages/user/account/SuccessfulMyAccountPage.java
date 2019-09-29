package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulMyAccountPage extends MyAccountPage {
    public static final String EXPECTED_CHANGE_MESSAGE = "Success: Your password has been successfully updated.";
    private WebElement alertSuccess;

    public SuccessfulMyAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertSuccess = driver.findElement(By.cssSelector(".alert.alert-success"));
    }

    // Page Object

    // alertWarning
    public WebElement getAlertSuccess() {
        return alertSuccess;
    }

    public String getAlertSuccessText() {
        return getAlertSuccess().getText();
    }
}

