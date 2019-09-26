package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.ProductName;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;

import org.testng.annotations.DataProvider;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class WishListTest extends UserTestRunner {
    private final String DELETE_FROM_WISHLIST_ALERT = "Success: You have modified your wish list!";
    private  String ADD_TO_CART_ALERT (String nameOfProduct){
        return  "Success: You have added "+ nameOfProduct +"to your shopping cart!";}
    private final String SERVER_URL = "https://demo.opencart.com/index.php?route=common/home";
    @DataProvider
    public Object[][] validUser() {
        return new Object[][] {
                { UserRepository.get().getHahahaUser() },
        };
    }

  /*  @Test(dataProvider = "validUser")
    public void addItemToWishList(IUser validUser, Product product) {
        loadApplication().gotoLoginPage()
                .successfulLogin(validUser)
                .searchGood(product)
                .getProductsCriteria()
                .clickProductComponentAddToWishButtonByName(product.getNameText());

    }

   */

    @Test(dataProvider = "validUser")
    public void GetIntoWishList(IUser validUser){
        List<String> pageName = loadApplication()
                .gotoWishListPage(validUser)
                .getBreadCrumbComponentNames();
        Assert.assertEquals(pageName.get(1),"Wish List");
    }

    @Test(dataProvider = "validUser")
    public void deletingFromWishList(IUser validUser, ProductName productName) {
        String actual = loadApplication().gotoLoginPage()
                .successfulLogin(validUser)
                .gotoWishListRight()
                .deleteItemFromWishList(productName.IPHONE.toString())
                .getSuccessfulDeletingFromWishListAlertText();
        Assert.assertEquals(actual, DELETE_FROM_WISHLIST_ALERT);
    }

    @Test(dataProvider = "validUser")
    public void addingFromWishListToShoppingCart(IUser validUser, ProductName productName) {
        String actual = loadApplication().gotoLoginPage()
                .successfulLogin(validUser)
                .gotoWishListRight()
                .addItemFromWishListToShoppingCart(productName.IPHONE.toString())
                .getSuccessfulAddingToShoppingCartFromWishListAlertText();
        Assert.assertEquals(actual, ADD_TO_CART_ALERT(productName.IPHONE.toString()));
    }


}
