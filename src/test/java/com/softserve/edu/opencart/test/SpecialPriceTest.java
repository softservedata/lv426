package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.data.Special;
import com.softserve.edu.opencart.data.SpecialRepository;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.DataEditProductPage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class SpecialPriceTest extends UserTestRunner {
    private Special specialPrice;
    private double productPrice;
    private Map<String, Double> newPrice = new HashMap<>();

    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {ProductRepository.getIphone()}
        };
    }

    @BeforeClass
    public void setUp() {
        specialPrice = SpecialRepository.getDefault();
        DataEditProductPage dataEditProductPage = loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToDataEditProductPage();

        productPrice = dataEditProductPage.getPriceOfProduct();

        dataEditProductPage
                .goToSpecialEditProductPage()
                .addNewSpecialPrice(specialPrice);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test(dataProvider = "searchData")
    public void testOfSpecialTest(Product product) {
        specialPrice = SpecialRepository.getDefault();
        ProductComponent component = loadArsenApplication()
                .successfulSearch(product)
                .getProductsCriteria()
                .getProductComponentByName(product);


        newPrice = component.getNewPrices();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(newPrice.get("NewPrice"), specialPrice.getPrice());
        softAssert.assertEquals(newPrice.get("OldPrice"), productPrice);
        softAssert.assertAll();


    }

    @AfterClass
    public void tearDown() {
        loadArsenAdminLoginPage()
                .goToAdminHomePage()
                .goToProductPage()
                .goToIphoneEditPage()
                .goToSpecialEditProductPage()
                .deleteLastSpecialTableComponent();


    }
}
