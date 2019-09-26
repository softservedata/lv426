package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListAlertPage extends SearchSuccessPage {

    public static final String DELETE_FROM_WISHLIST_ALERT = " Success: You have modified your wish list!";
    public WishListAlertPage(WebDriver driver) {
        super(driver);
    }
    public String getMessage() {
        return driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
    }
    public String addToCartAlert(Product product){
        return  "Success: You have added "+ product.getName()+" to your shopping cart!" ;
    }
}
