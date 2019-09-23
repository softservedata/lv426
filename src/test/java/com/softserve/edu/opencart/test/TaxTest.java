package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxTest extends UserTestRunner{

    @DataProvider
    public Object[][] searchData() {
        return new Object[][] {
                {GeoZoneRepository.getDefault(), TaxRateRepository.getFixed(), TaxClassRepository.getFixed()}
        };
    }


    @Test(dataProvider = "searchData")
    public void checTax(GeoZone geoZone, TaxRate taxRate, TaxClass taxClass) {
        loadAdminLoginPage()
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
    public void tearDown(GeoZone geoZone, TaxRate taxRate, TaxClass taxClass) {
        loadAdminLoginPage()
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
