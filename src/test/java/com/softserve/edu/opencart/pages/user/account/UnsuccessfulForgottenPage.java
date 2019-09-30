package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulForgottenPage extends ForgotPasswordPage {

    public static final String EXPECTED_INVALID_EMAIL_MESSAGE =
            "Warning: The E-Mail Address was not found in our records, please try again!";
    private WebElement alertWarning;

    public UnsuccessfulForgottenPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

    }
    // Page Object

    // alertWarning
    public WebElement getAlertWarning() {
        return driver.findElement(By.cssSelector(".alert.alert-danger"));
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }
}
