package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.CurrencyRepository;
import com.softserve.edu.opencart.data.ICurrency;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CurrencyConvertTest extends UserTestRunner {
    @DataProvider
    public Object[][] currencyData() {
        return new Object[][] {
                {CurrencyRepository.get().getNewUACurrency()}
        };
    }

    @Test(dataProvider = "currencyData")
    public void addNewCurrency(ICurrency currency) {
        loadAdminLoginPage()
                .goToAdminHomePage()
                .goToCurrencyPage()
                .goToAddNewCurrencyPage()
                .addNewCurrency(currency);
    }


    @Test(dataProvider = "currencyData")
    public void tearDown(ICurrency currency) {
        loadAdminLoginPage()
                .goToAdminHomePage()
                .goToCurrencyPage()
                .deleteCurrency(currency);
    }

}
