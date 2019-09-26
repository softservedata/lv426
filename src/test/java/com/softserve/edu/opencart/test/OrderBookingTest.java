package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.shop.CountryForEstimation;
import com.softserve.edu.opencart.data.shop.DiscountUsageCode;
import com.softserve.edu.opencart.data.shop.FinalPriceTable;
import com.softserve.edu.opencart.data.shop.ShopRepository;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import com.softserve.edu.opencart.pages.user.shop.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class OrderBookingTest extends UserTestRunner {

    private WebDriver driver;
    private WebElement element;
    protected final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final String SERVER_URL_BY_MAX = "http://192.168.163.136/opencart/upload";
    private ShoppingCartPage shoppingCartPage;
    private FinalPriceTable finalPriceTable;
    private ProductComponent productComponent;
    private ProductsContainerComponent productsContainerComponent;


    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), ShopRepository.builderCountryForEstimation(),
                        ShopRepository.builderCodesForBoth()}

        };
    }

    @Test(dataProvider = "searchData")
    public void orderBookingAndCartManipulationTest(SearchFilter searchFilter,
                                                    CountryForEstimation countryForEstimation,
                                                    DiscountUsageCode discount) {
        ShoppingCartPage shoppingCartPage =
                loadApplication()
                .successfulSearch(searchFilter)
                .addProductToCartByProductCriteriaComponent(searchFilter.getProduct().getName())
                .gotoShoppingCartPage()
                .shippingAndTaxesClick()
                .estimationShoppingCartPageTrue(countryForEstimation)
                .giftCertificationClick()
                .giftCertificationInputsAndApplying(discount)
                .useCouponClick()
                .couponCodeInputsAndApplying(discount)
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(searchFilter.getProduct().getName(),
                        searchFilter.getProduct().getPrice(Currencies.US_DOLLAR));

        assertEquals(shoppingCartPage.tryToChangeSomething()
                .listOfCartOrders()
                .getOrderFromTableByName(searchFilter.getProduct().getName())
                .getTotal(), shoppingCartPage.getFinalPriceTable().getTotalAfterSubTotal());


    }
}
