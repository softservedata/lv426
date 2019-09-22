package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentMethod extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;

    public PaymentMethod(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

    }
}
