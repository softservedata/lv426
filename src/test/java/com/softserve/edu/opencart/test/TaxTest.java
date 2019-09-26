package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.data.shop.CountryForEstimation;
import com.softserve.edu.opencart.data.shop.ShopRepository;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxTest extends UserTestRunner {
    private GeoZone geoZone;
    private TaxRate taxRate;
    private TaxClass taxClass;

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {ProductRepository.getIphone(), ShopRepository.builderCountryForEstimation()}
        };
    }


    @BeforeClass
    public void checTax() {
        geoZone = GeoZoneRepository.getDefault();
        taxRate = TaxRateRepository.getFixed();
        taxClass = TaxClassRepository.getFixed();

        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToGeoZonePage()
                .goToAddGeoZomeManagePage()
                .addNewGeoZone(geoZone)

                .closeLocalizationMenu()
                .goToAdminHomePage()
                .goToTaxRatesPage()
                .goToAddTaxRatePage()
                .addNewTaxRate(taxRate)

                .closeLocalizationMenu()
                .goToAdminHomePage()
                .closeTaxesMenu()
                .goToAdminHomePage()
                .goToTaxClassPage()
                .goToAddTaxClassPage()
                .addTaxClass(taxClass, taxRate)

                .goToProductPage()
                .goToIphoneEditPage()
                .goToDataEditProductPage()
                .selectClassTax(taxClass);

    }



    @Test(dataProvider = "searchData")
    public void taxTestWithFixedAmountTax(Product product, CountryForEstimation country) {
        loadArsenApplication()
                .successfulSearch(product)
                .addProductToCartByProductCriteriaComponent(product.getName())
                .gotoShoppingCartPage()
                .shippingAndTaxesClick()
                .estimationShoppingCartPageTrue(country);

    }

    @AfterClass()
    public void tearDown() {

        geoZone = GeoZoneRepository.getDefault();
        taxRate = TaxRateRepository.getFixed();
        taxClass = TaxClassRepository.getFixed();

        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToDataEditProductPage()
                .selectDefaultTax()
                .goToTaxClassPage()
                .deleteTaxClass(taxClass)
                .closeLocalizationMenu()
                .goToAdminHomePage()
                .closeTaxesMenu()
                .goToAdminHomePage()
                .closeLocalizationMenu()
                .goToTaxRatesPage()
                .deleteTaxRate(taxRate)
                .closeLocalizationMenu()
                .goToAdminHomePage()
                .goToGeoZonePage()
                .deleteGeoZone(geoZone);

    }
}
