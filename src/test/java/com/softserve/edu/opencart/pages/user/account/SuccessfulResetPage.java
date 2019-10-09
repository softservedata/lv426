package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulResetPage extends LoginPage {
    public static final String EXPECTED_RESET_MESSAGE = "Success: Your password has been successfully updated.";
    private WebElement alertSuccess;

    public SuccessfulResetPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertSuccess = driver.findElement(By.cssSelector("div.alert.alert-success"));
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
