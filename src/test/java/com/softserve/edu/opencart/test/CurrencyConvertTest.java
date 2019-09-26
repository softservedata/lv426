package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.adminpanel.CurrencyPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static com.softserve.edu.opencart.tools.PriceUtils.getMultiply;

public class CurrencyConvertTest extends UserTestRunner {
    private double priceInDolar;
    private double priceInUA;
    private double priceInPhound;
    private double priceInEuro;
    private ICurrency currency = CurrencyRepository.get().getNewUACurrency();
    private Map<String, Double> map = new HashMap<>();

    @DataProvider
    public Object[][] currencyData() {
        return new Object[][]{
                {ProductRepository.getIphone(), CurrencyRepository.get().getNewUACurrency()}
        };
    }


    @BeforeClass
    public void addNewCurrency() {

        CurrencyPage currencyPage = loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToCurrencyPage();

        map = currencyPage.getConvertValue();


        currencyPage
                .goToAddNewCurrencyPage()
                .addNewCurrency(currency);
    }


    @Test(dataProvider = "currencyData")
    public void checkIfOldCurrencyWasConventedCorrectly(Product product, ICurrency currency) {
        SearchSuccessPage searchSuccessPage = loadArsenApplication()
                .successfulSearch(product);

        priceInDolar = searchSuccessPage
                .getProductsCriteria()
                .getProductComponentByName(product)
                .getCurrentPrice();


        priceInEuro = searchSuccessPage
                .chooseCurrency(Currencies.EURO)
                .getProductsCriteria()
                .getProductComponentByName(product)
                .getCurrentPrice();
        Assert.assertEquals(priceInEuro, getMultiply(priceInDolar, map.get("Euro")));


        priceInPhound = searchSuccessPage
                .chooseCurrency(Currencies.POUND_STERLING)
                .getProductsCriteria()
                .getProductComponentByName(product)
                .getCurrentPrice();
        Assert.assertEquals(priceInPhound, getMultiply(priceInDolar, map.get("Pound Sterling")));


    }


    @Test(dataProvider = "currencyData")
    public void checkIfUACurrencyIsVisibleInDropdownList(Product product, ICurrency currency) {
        SearchSuccessPage searchSuccessPage = loadArsenApplication()
                .successfulSearch(product);


        priceInDolar = searchSuccessPage
                .getProductsCriteria()
                .getProductComponentByName(product)
                .getCurrentPrice();

        priceInUA = searchSuccessPage
                .chooseCurrency(Currencies.UA)
                .getProductsCriteria()
                .getProductComponentByName(product)
                .getCurrentPrice();

        Assert.assertEquals(priceInUA, getMultiply(priceInDolar, currency.getValue()));


    }


    @AfterClass
    public void tearDown() {

        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToCurrencyPage()
                .deleteCurrency(currency);
    }

}
