package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;

import com.softserve.edu.opencart.pages.user.account.WishListAlertPage;
import com.softserve.edu.opencart.pages.user.account.WishListPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessAlertPage;
import org.testng.annotations.DataProvider;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static com.softserve.edu.opencart.pages.user.account.WishListAlertPage.DELETE_FROM_WISHLIST_ALERT;
import static com.softserve.edu.opencart.pages.user.search.SearchSuccessAlertPage.ADD_TO_WISHLIST_ALERT;


public class WishListTest extends UserTestRunner {
    @DataProvider
    public Object[][] validUser() {
        return new Object[][] {
                { UserRepository.get().getBeataUser(), ProductRepository.getIPhone()},
        };
    }

    @Test(dataProvider = "validUser")
    public void addItemToWishList(IUser validUser, Product product) {
        SearchSuccessAlertPage searchSuccessAlertPage = loadBeataApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .successfulSearch(product)
                .addToWishButtonByName(product);
        Assert.assertTrue(searchSuccessAlertPage.getAddToWishListAlert().contains(ADD_TO_WISHLIST_ALERT));
        searchSuccessAlertPage.log
    }

        @Test(dataProvider = "validUser")
        public void getIntoWishList (IUser validUser){
            WishListPage wishListPage = loadBeataApplication()
                    .gotoWishListPage(validUser);
            List<String> pageName = wishListPage
                    .getBreadCrumbComponentNames();
            Assert.assertEquals(pageName.get(2), "Wish List");
            wishListPage.logout();
        }

        @Test(dataProvider = "validUser")
        public void deletingFromWishList (IUser validUser, Product product){
            WishListAlertPage wishListAlertPage =
                    loadBeataApplication()
                            .gotoLoginPage()
                            .successfulLogin(validUser)
                            .gotoWishListRight()
                            .deleteItemFromWishList(product);
            Assert.assertTrue(wishListAlertPage.getMessage().contains(DELETE_FROM_WISHLIST_ALERT));
            wishListAlertPage.logout();

        }

        @Test(dataProvider = "validUser")
        public void addingFromWishListToShoppingCart (IUser validUser, Product product){
            WishListAlertPage wishListAlertPage = loadBeataApplication()
                    .gotoLoginPage()
                    .successfulLogin(validUser)
                    .gotoWishListRight()
                    .addItemFromWishListToShoppingCart(product);
            Assert.assertTrue(wishListAlertPage.getMessage().contains(wishListAlertPage.addToCartAlert(product)));
            wishListAlertPage.logout();
        }

    }

