package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LockedUserLoginPage extends LoginPage {
    public static final String EXPECTED_LOCKED_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    //
    //private WebElement alertWarning;

    public LockedUserLoginPage(WebDriver driver) {
        super(driver);
        //initElements();
    }

//    private void initElements() {
//        alertWarning = driver.findElement(By.cssSelector("div.alert.alert-danger"));
//    }

    // Page Object

    // alertWarning
    public WebElement getAlertWarning() {
        return driver.findElement((By.xpath("//div[contains(text(),'Warning: Your account has exceeded allowed number of login attempts.')]")));
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }

}
