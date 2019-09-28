package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.Discount;
import com.softserve.edu.opencart.data.DiscountRepository;
import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.shop.FinalPriceComponentContainer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.tools.PriceUtils.getCurrency;

public class DiscountTest extends UserTestRunner {
    private Discount discount;

    private double total;


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
        FinalPriceComponentContainer finalPriceTable =  loadArsenApplication()
                .successfulSearch(product)
                .addProductToCartByProductCriteriaComponent(product)
                .gotoShoppingCartPage()
                .tryToChangeSomething()
                .changeCountOfSomeOrderByName(product.getProduct(), String.valueOf(discount.getQuantity()))
                .tryToChangeSomething()
                .getFinalPricaContainer();


        total = getCurrency(finalPriceTable.getCashSumByTitle("Total:").getPrice());


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
