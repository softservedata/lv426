package com.softserve.edu.opencart.pages.user.mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class MailSidebarPart {

    private WebElement unreadLink;
    protected WebDriver driver;

    public MailSidebarPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        unreadLink = driver.findElement(By.id("unread"));
    }

    // Page Object
    //UnreadLink
    public WebElement getUnreadLink() {
        return unreadLink;
    }

    public void clickUnreadLink() {
        getUnreadLink().click();
    }

    //Business Logic
    public UnreadMailPage gotoUnreadMail() {
        clickUnreadLink();
        return new UnreadMailPage(driver);
    }

}
