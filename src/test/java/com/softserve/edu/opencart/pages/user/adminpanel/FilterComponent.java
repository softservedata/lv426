package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.WebDriver;

public abstract class FilterComponent {

    protected WebDriver driver;

    public FilterComponent(WebDriver driver) {
        this.driver = driver;
       // initElements();
    }


}
