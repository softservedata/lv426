package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulLoginPage extends LoginPage {
    public static final String EXPECTED_FORGOTTEN_MESSAGE = "An email with a confirmation link has been sent your email address.";
    private WebElement alertSuccess;

    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        alertSuccess = driver.findElement(By.cssSelector("div.alert.alert-success"));
    }

    //  Page Object

    //  alertWarning
    public WebElement getAlertSuccess() {
        return alertSuccess;
    }

    public String getAlertSuccessText() {
        return getAlertSuccess().getText();
    }
}
