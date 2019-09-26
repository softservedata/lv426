package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DiscountTest extends UserTestRunner {
    private Discount discount;

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {DiscountRepository.getDefault(), SearchFilterRepository.searchIPhone()}
        };
    }

    @BeforeClass
    public void setUp() {
        discount = DiscountRepository.getDefault();
        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToDicounteditProductPage()
                .addNewDiscount(discount);
    }


    @Test(dataProvider = "searchData")
    public void testOfSpecialTest(Discount discount, SearchFilter product) {
        loadArsenApplication()
                .successfulSearch(product)
                .addProductToCartByProductCriteriaComponent(product)
                .gotoShoppingCartPage()
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(product.getProduct(), String.valueOf(discount.getQuantity()));


    }

    @AfterClass
    public void tearDown() {

        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToDicounteditProductPage()
                .deleteLastDiscountTableComponent();
    }
}
