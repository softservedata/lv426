package com.softserve.edu.opencart.pages.user.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.opencart.pages.user.account.PasswordResetPage;

public class PasswordResetMail extends MailSidebarPart {
    private WebElement passwordResetLink;

    public PasswordResetMail(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        passwordResetLink = driver.findElement(By.cssSelector("a[href*='http://192.168.238.129/opencart/upload/']"));//todo
    }

    // Page Object
    //PasswordResetLink
    public WebElement getPasswordResetLink() {
        return passwordResetLink;
    }

    public void clickPasswordResetLink() {
        getPasswordResetLink().click();
    }

    //Business Logic
    public PasswordResetPage gotoResetPasswordPage() {
        clickPasswordResetLink();
        return new PasswordResetPage(driver);
    }
}
