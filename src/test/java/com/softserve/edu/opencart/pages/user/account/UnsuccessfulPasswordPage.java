package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulPasswordPage extends ChangePasswordPage {
    public static final String EXPECTED_INVALID_CONFIRMATION_MESSAGE = "Password confirmation does not match password!";
    private WebElement alertWarning;

    public UnsuccessfulPasswordPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertWarning = driver.findElement(By.cssSelector("div.text-danger"));
    }
    // Page Object

    // alertWarning
    public WebElement getAlertWarning() {
        return alertWarning;
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }
}
