package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Alerts {

    private WebElement alert;

    public Alerts(WebElement alert) {

        this.alert = alert;
    }

    public WebElement getAlert() {
        return alert;
    }


    public String getAlertText() {
        return alert.getText();
    }
}
