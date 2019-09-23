package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.Discount;
import com.softserve.edu.opencart.data.DiscountRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DiscountTest extends UserTestRunner {

    @DataProvider
    public Object[][] discountData() {
        return new Object[][]{
                {DiscountRepository.getDefault()}
        };
    }

    @Test(dataProvider = "discountData")
    public void setUp(Discount discount) {

        loadAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToDicounteditProductPage()
                .addNewDiscount(discount);
    }

    @Test(dataProvider = "discountData")
    public void tearDown(Discount discount) {

        loadAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToDicounteditProductPage()
                .deleteLastDiscountTableComponent();
    }
}
