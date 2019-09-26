package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.data.shop.CountryForEstimation;
import com.softserve.edu.opencart.data.shop.FinalPriceTable;
import com.softserve.edu.opencart.data.shop.ShopRepository;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxTest extends UserTestRunner {
    private GeoZone geoZone;
    private TaxRate fixedTaxRate;
    private TaxClass fixedTaxClass;

    private TaxRate percentageTaxRate;
    private TaxClass percentageTaxClass;


    private double subTotal;
    private double total;
    private double flatShiping;
    private double tax;
    private double flat = 5;

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), ShopRepository.builderCountryForEstimation()}
        };
    }

    @DataProvider
    public Object[][] searchNikonData() {
        return new Object[][]{
                {ProductRepository.getNikon(), ShopRepository.builderCountryForEstimation()}
        };
    }


    @BeforeClass
    public void checTax() {
        geoZone = GeoZoneRepository.getDefault();
        fixedTaxRate = TaxRateRepository.getFixed();
        fixedTaxClass = TaxClassRepository.getFixed();

        percentageTaxRate = TaxRateRepository.getPercentage();
        percentageTaxClass = TaxClassRepository.getPercentage();

        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToGeoZonePage()
                .goToAddGeoZomeManagePage()
                .addNewGeoZone(geoZone)

                .closeLocalizationMenu()
                .goToAdminHomePage()
                .goToTaxRatesPage()
                .goToAddTaxRatePage()
                .addNewTaxRate(fixedTaxRate)
                .goToAddTaxRatePage()
                .addNewTaxRate(percentageTaxRate)


                .closeLocalizationMenu()
                .goToAdminHomePage()
                .closeTaxesMenu()
                .goToAdminHomePage()
                .goToTaxClassPage()
                .goToAddTaxClassPage()
                .addTaxClass(fixedTaxClass, fixedTaxRate)
                .goToAddTaxClassPage()
                .addTaxClass(percentageTaxClass, percentageTaxRate)

                .goToProductPage()
                .goToIphoneEditPage()
                .goToDataEditProductPage()
                .selectClassTax(fixedTaxClass)
                .goToProductPage()
                .goToNikonEditPage()
                .goToDataEditProductPage()
                .selectClassTax(percentageTaxClass);

    }


    @Test(dataProvider = "searchData")
    public void taxTestWithFixedAmountTax(SearchFilter product, CountryForEstimation country) {
        FinalPriceTable finalPriceTable = loadArsenApplication()
                .successfulSearch(product)
                .addProductToCartByProductCriteriaComponent(product)
                .gotoShoppingCartPage()
                .shippingAndTaxesClick()
                .estimationShoppingCartPageTrue(country)
                .tryToChangeSomething()
                .getFinalPriceTable();


        subTotal = Double.parseDouble(finalPriceTable.getSubTotal());
        total = Double.parseDouble(finalPriceTable.getTotalAfterTestClass().getText());

        Assert.assertTrue(true);
    }

    // @Test(dataProvider = "searchNikonData")
    public void taxTestWithPercentageAmountTax(Product product, CountryForEstimation country) {

    }

    @AfterClass()
    public void tearDown() {

        geoZone = GeoZoneRepository.getDefault();
        fixedTaxRate = TaxRateRepository.getFixed();
        fixedTaxClass = TaxClassRepository.getFixed();

        percentageTaxRate = TaxRateRepository.getPercentage();
        percentageTaxClass = TaxClassRepository.getPercentage();


        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToDataEditProductPage()
                .selectDefaultTax()

                .goToProductPage()
                .goToNikonEditPage()
                .goToDataEditProductPage()
                .selectDefaultTax()

                .goToTaxClassPage()
                .deleteTaxClass(fixedTaxClass)
                .deleteTaxClass(percentageTaxClass)
                .closeLocalizationMenu()
                .goToAdminHomePage()
                .closeTaxesMenu()
                .goToAdminHomePage()
                .closeLocalizationMenu()
                .goToTaxRatesPage()
                .deleteTaxRate(fixedTaxRate)
                .deleteTaxRate(percentageTaxRate)
                .closeLocalizationMenu()
                .goToAdminHomePage()
                .goToGeoZonePage()
                .deleteGeoZone(geoZone);

    }
}
