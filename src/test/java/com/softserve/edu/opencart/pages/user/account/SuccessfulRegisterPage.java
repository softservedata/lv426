package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulRegisterPage extends AccountSidebarLoggedPart {

    private WebElement continueButton;

    SuccessfulRegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='account']"));
    }

    // Page Object

    // continueButton
    private WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    private void clickContinueButton() {
        getContinueButton().click();
    }

    // Business Logic

    public MyAccountPage gotoContinue() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }
}

