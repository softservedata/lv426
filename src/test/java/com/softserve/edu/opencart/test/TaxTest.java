package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.data.shop.CountryForEstimation;
import com.softserve.edu.opencart.data.shop.FinalPriceComponentContainer;
import com.softserve.edu.opencart.data.shop.ShopRepository;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.DataEditProductPage;
import com.softserve.edu.opencart.pages.user.adminpanel.ProductPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.softserve.edu.opencart.tools.PriceUtils.getCurrency;
import static com.softserve.edu.opencart.tools.PriceUtils.getPercentage;

public class TaxTest extends UserTestRunner {
    private GeoZone geoZone;
    private TaxRate fixedTaxRate;
    private TaxClass fixedTaxClass;

    private TaxRate percentageTaxRate;
    private TaxClass percentageTaxClass;


    private double subTotalOfIphone;
    private double subTotalOfNikon;

    private double subTotal;
    private double total;
    private double tax;

    private double flatShiping = 5;


    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchIPhone(), ShopRepository.builderCountryForEstimation(), TaxRateRepository.getFixed()}
        };
    }

    @DataProvider
    public Object[][] searchNikonData() {
        return new Object[][]{
                {SearchFilterRepository.searchNikon(), ShopRepository.builderCountryForEstimation(), TaxRateRepository.getPercentage()}
        };
    }


    @BeforeClass
    public void checkTax() {
        geoZone = GeoZoneRepository.getDefault();
        fixedTaxRate = TaxRateRepository.getFixed();
        fixedTaxClass = TaxClassRepository.getFixed();

        percentageTaxRate = TaxRateRepository.getPercentage();
        percentageTaxClass = TaxClassRepository.getPercentage();

        ProductPage productPage = loadArsenAdminLoginPage()
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

                .goToProductPage();


        DataEditProductPage dataIPhonePage = productPage
                .goToIphoneEditPage()
                .goToDataEditProductPage();

        subTotalOfIphone = dataIPhonePage.getPriceOfProduct();

        DataEditProductPage dataNikonPage = dataIPhonePage
                .selectClassTax(fixedTaxClass)
                .goToNikonEditPage()
                .goToDataEditProductPage();

        subTotalOfNikon = dataNikonPage
                .getPriceOfProduct();

        dataNikonPage.selectClassTax(percentageTaxClass);

    }


    @Test(dataProvider = "searchData")
    public void taxTestWithFixedAmountTax(SearchFilter product, CountryForEstimation country, TaxRate taxRate) {

        FinalPriceComponentContainer finalPriceTable = getFinalPriceTable(product, country);

        subTotal = getPriceFromTable(finalPriceTable, FinalPriceTable.SUB_TOTAL.getName());
        total = getPriceFromTable(finalPriceTable, FinalPriceTable.TOTAL.getName());
        tax = getPriceFromTable(finalPriceTable, taxRate.getName());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(subTotal, subTotalOfIphone);
        softAssert.assertEquals(tax, taxRate.getRate());
        softAssert.assertEquals(total, subTotalOfIphone + taxRate.getRate() + flatShiping);
        softAssert.assertAll();

    }

    @Test(dataProvider = "searchNikonData")
    public void taxTestWithPercentageAmountTax(SearchFilter product, CountryForEstimation country, TaxRate taxRate) {

        FinalPriceComponentContainer finalPriceTable = getFinalPriceTable(product, country);
        subTotal = getPriceFromTable(finalPriceTable, FinalPriceTable.SUB_TOTAL.getName());
        total = getPriceFromTable(finalPriceTable, FinalPriceTable.TOTAL.getName());
        tax = getPriceFromTable(finalPriceTable, taxRate.getName());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(subTotal, subTotalOfNikon);
        softAssert.assertEquals(tax, getPercentage(subTotal,taxRate.getRate()));
        softAssert.assertEquals(total, subTotalOfNikon + getPercentage(subTotal,taxRate.getRate()) + flatShiping);
        softAssert.assertAll();

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


    private FinalPriceComponentContainer getFinalPriceTable(SearchFilter product, CountryForEstimation country) {

        return loadArsenApplication()
                .successfulSearch(product)
                .addProductToCartByProductCriteriaComponent(product)
                .gotoShoppingCartPage()
                .shippingAndTaxesClick()
                .estimationShoppingCartPageTrue(country)
                .tryToChangeSomething()
                .getFinalPricaContainer();

    }

    private double getPriceFromTable(FinalPriceComponentContainer priceTable, String title) {
        return getCurrency(priceTable.getCashSumByTitle(title + ":").getPrice());

    }


}
