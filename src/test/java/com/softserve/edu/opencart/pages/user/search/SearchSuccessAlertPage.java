package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSuccessAlertPage extends SearchSuccessPage {
    public static final String ADD_TO_WISHLIST_ALERT = "Success: You have added iPhone to your wish list!" ;
    public SearchSuccessAlertPage(WebDriver driver) {
        super(driver);
    }
    public String getAddToWishListAlert() {
        return driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText();
    }
}
