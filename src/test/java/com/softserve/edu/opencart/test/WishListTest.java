package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;

import com.softserve.edu.opencart.pages.user.account.WishListAlertPage;
import com.softserve.edu.opencart.pages.user.account.WishListPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessAlertPage;
import org.testng.annotations.DataProvider;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class WishListTest extends UserTestRunner {
    @DataProvider
    public Object[][] validUser() {
        return new Object[][] {
                { UserRepository.get().getHahahaUser(), ProductRepository.getDefault()},
        };
    }

    @Test(dataProvider = "validUser")
    public void addItemToWishList(IUser validUser, Product product) {
        SearchSuccessAlertPage searchSuccessAlertPage = loadApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .successfulSearch(product)
                .addToWishButtonByName(product);
        Assert.assertTrue(searchSuccessAlertPage.getAddToWishListAlert().contains(searchSuccessAlertPage.ADD_TO_WISHLIST_ALERT));
    }

        @Test(dataProvider = "validUser")
        public void getIntoWishList (IUser validUser){
            WishListPage wishListPage = loadApplication()
                    .gotoWishListPage(validUser);
            List<String> pageName = wishListPage
                    .getBreadCrumbComponentNames();
            Assert.assertEquals(pageName.get(2), "Wish List");
        }

        @Test(dataProvider = "validUser")
        public void deletingFromWishList (IUser validUser, Product product){
            WishListAlertPage shoppingCartAlertPage =
                    loadApplication()
                            .gotoLoginPage()
                            .successfulLogin(validUser)
                            .gotoWishListRight()
                            .deleteItemFromWishList(product);
            Assert.assertTrue(shoppingCartAlertPage.getMessage().contains(shoppingCartAlertPage.DELETE_FROM_WISHLIST_ALERT));
        }

        @Test(dataProvider = "validUser")
        public void addingFromWishListToShoppingCart (IUser validUser, Product product){
            WishListAlertPage shoppingCartAlertPage = loadApplication()
                    .gotoLoginPage()
                    .successfulLogin(validUser)
                    .gotoWishListRight()
                    .addItemFromWishListToShoppingCart(product);
            Assert.assertTrue(shoppingCartAlertPage.getMessage().contains(shoppingCartAlertPage.addToCartAlert(product)));
        }

    }

