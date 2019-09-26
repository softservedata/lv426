package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage extends BreadCrumbPart {

    private WebDriver driver;
    private WebElement element;


    public CheckOutPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

    }
}
