package com.softserve.edu.opencart.pages.user.mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.softserve.edu.opencart.pages.user.account.PasswordResetPage;

import java.util.ArrayList;

public class PasswordResetMail extends MailSidebarPart {
    private WebElement passwordResetLink;

    public PasswordResetMail(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        passwordResetLink = driver.findElement(By.cssSelector("a[href*='http://192.168.238.130/opencart/upload/']"));//todo
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
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        return new PasswordResetPage(driver);
    }
}
