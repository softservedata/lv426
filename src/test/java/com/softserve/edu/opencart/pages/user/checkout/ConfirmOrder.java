package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrder extends CheckOutPage{

    private WebDriver driver;
    private WebElement element;

    public ConfirmOrder(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

    }
}
