package com.softserve.edu.opencart.pages.user.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBookMessenges  extends AddressBookPage{

    private WebElement success;
    private WebElement warning;

    public AddressBookMessenges(WebDriver driver) {
        super(driver);
    }


    public boolean initSuccess() {
        success = driver.findElement(By.className("alert alert-success"));
        return true;
    }

    public boolean initWarning() {
        warning = driver.findElement(By.className("alert alert-warning"));
        return true;
    }

}
