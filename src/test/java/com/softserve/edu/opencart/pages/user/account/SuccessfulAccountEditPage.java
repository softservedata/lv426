package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulAccountEditPage extends MyAccountPage {

    public static final String EXPECTED_SUCCESS_EDIT_MESSAGE = "Success: Your account has been successfully updated.";
    //
    private WebElement alertWarning;

    public SuccessfulAccountEditPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertWarning = driver.findElement(By.cssSelector("div.alert.alert-success"));
    }

    // Page Object

    // alertWarning
    public WebElement getAlertWarning() {
        return alertWarning;
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }

    // Functional

    // Business Logic
}
