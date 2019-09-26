package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.shop.CountryForEstimation;
import com.softserve.edu.opencart.data.shop.DiscountUsageCode;
import com.softserve.edu.opencart.data.shop.ShopRepository;
import com.softserve.edu.opencart.pages.user.shop.ShoppingCartPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShoppingCartFunctionalTest extends UserTestRunner {

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), ShopRepository.builderCountryForEstimation(),
                        ShopRepository.builderCodesForBoth()}

        };
    }

   // @Test(dataProvider = "searchData")
    public void orderBookingAndCartManipulationTest(SearchFilter searchFilter,
                                                    CountryForEstimation countryForEstimation,
                                                    DiscountUsageCode discount) {
        ShoppingCartPage shoppingCartPage =
                loadApplication()
                .successfulSearch(searchFilter.getProduct())
                .addProductToCartByProductCriteriaComponent(searchFilter)
                .successfulSearch(searchFilter)
                ///.addProductToCartByProductCriteriaComponent(searchFilter.getProduct())
                .gotoShoppingCartPage()
                .shippingAndTaxesClick()
                .estimationShoppingCartPageTrue(countryForEstimation)
                .giftCertificationClick()
                .giftCertificationInputsAndApplying(discount)
                .useCouponClick()
                .couponCodeInputsAndApplying(discount)
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchFilter.getProduct(),
                        searchFilter.getProduct().getPrice(Currencies.US_DOLLAR));

        assertEquals(shoppingCartPage.tryToChangeSomething()
                .listOfCartOrders()
                .getOrderFromTableByName(searchFilter.getProduct().getName())
                .getTotal(), shoppingCartPage.getFinalPricaContainer().getCashSumByTitle("Total:").getPrice());


    }

//    public void
}
