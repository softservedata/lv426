package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingDetails extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;

    public BillingDetails(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

    }
}
