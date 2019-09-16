package com.softserve.edu.opencart.pages.user.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnreadMailPage extends MailSidebarPart {
    private WebElement passwordResetMail;

    public UnreadMailPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        passwordResetMail = driver.findElement(By.xpath("//*[text() = 'Your Store - Password reset request']"));
    }

    // Page Object
    //UnreadLink
    public WebElement getPasswordResetMail() {
        return passwordResetMail;
    }

    public void clickPasswordResetMail() {
        getPasswordResetMail().click();
    }

    //Business Logic
    public PasswordResetMail openMail() {
        clickPasswordResetMail();
        return new PasswordResetMail(driver);
    }
}