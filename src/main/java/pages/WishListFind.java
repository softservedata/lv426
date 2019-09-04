package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishListFind {

    private WebDriver chromeDriver;
    public WishListFind(WebDriver driver){
        this.chromeDriver = driver;
    }

    public boolean getWishList(){
        WebElement w = chromeDriver.findElement(By.id("wishlist-total"));
        return true;

    }
    public boolean ifGetWishList(){
        WishListFind wishList = new WishListFind(chromeDriver);
        if (wishList.getWishList()) {
            return true;
        }
        else {
            return false;
        }


    }





}
