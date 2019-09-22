package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.Special;
import com.softserve.edu.opencart.data.SpecialRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SpecialPriceTest extends UserTestRunner {

    @DataProvider
    public Object[][] specialPriceData() {
        return new Object[][]{
                {SpecialRepository.getDefault()}
        };
    }

    @Test(dataProvider = "specialPriceData")
    public void setUp(Special specialPrice) {

        loadAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToSpecialEditProductPage()
                .addNewSpecialPrice(specialPrice);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(dataProvider = "specialPriceData")
    public void tearDown(Special specialPrice) {

        loadAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToSpecialEditProductPage()
                .deleteLastSpecialTableComponent();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
