package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends AccountSidebarGuestPart {
    private WebElement emailField;
    private WebElement continueButton;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        emailField = driver.findElement(By.id("input-email"));
        continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
    }

    // Page Object
    //EmailField
    public WebElement getEmailField() {
        return emailField;
    }

    public void clearEmailField() {
        getEmailField().clear();
    }

    public void clickEmailField() {
        getEmailField().click();
    }

    public void setEmailField(String text) {
        getEmailField().sendKeys(text);
    }
    //ContinueButton
    public WebElement getContinueButton() {
        return continueButton;
    }
    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional
    public void fillForgottenEmailField(String text) {
        clickEmailField();
        clearEmailField();
        setEmailField(text);
    }

    // Business Logic
    public SuccessfulLoginPage sendEmailField(IUser user) {
        fillForgottenEmailField(user.geteMail());
        clickContinueButton();
        return new SuccessfulLoginPage(driver);
    }

    public UnsuccessfulForgottenPage sendIvalidEmail(IUser user) {
        fillForgottenEmailField(user.geteMail());
        clickContinueButton();
        return new UnsuccessfulForgottenPage(driver);
    }

    public void defaultLogin(IUser user)
    {}

}
