package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageWithAlert extends ProductPage{

    private WebElement successfulAddingToWishListAlert;

    public ProductPageWithAlert(WebDriver driver) {
        super(driver);

    }


    public void initElements() {
        successfulAddingToWishListAlert = driver.findElement(By.cssSelector("div .alert.alert-success.alert-dismissible"));
    }

    public WebElement getSuccessfulAddingToWishListAlert() {
        return successfulAddingToWishListAlert;
    }

    public String getSuccessfulAddingToWishListAlertText() {
        return successfulAddingToWishListAlert.getText();
    }
}
