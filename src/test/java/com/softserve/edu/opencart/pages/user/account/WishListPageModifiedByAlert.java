package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListPageModifiedByAlert extends WishListPage {
    public WishListPageModifiedByAlert(WebDriver driver) {
        super(driver);
    }
    private WebElement successfulAddingToShoppingCartFromWishListAlert;
    private WebElement successfulDeletingFromWishListAlert;
    public void initElements() {
        successfulDeletingFromWishListAlert = wishListLayout.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
        successfulAddingToShoppingCartFromWishListAlert = wishListLayout.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
    }

    public WebElement getSuccessfulDeletingFromWishListAlert() {
        return successfulDeletingFromWishListAlert;
    }

    public WebElement getSuccessfulAddingToShoppingCartFromWishListAlert() {
        return successfulAddingToShoppingCartFromWishListAlert;
    }

    public String getSuccessfulDeletingFromWishListAlertText() {
        return successfulDeletingFromWishListAlert.getText();
    }


    public String getSuccessfulAddingToShoppingCartFromWishListAlertText() {
        return successfulAddingToShoppingCartFromWishListAlert.getText();
    }
}
