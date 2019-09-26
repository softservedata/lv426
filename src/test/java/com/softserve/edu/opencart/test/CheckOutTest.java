package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.SearchFilterRepository;
import org.testng.annotations.DataProvider;

public class CheckOutTest extends UserTestRunner{


    @DataProvider
    public Object[][] searchData() {
        return new Object[][]{
                {SearchFilterRepository.searchIPhone()}

        };
    }

//    @Test(dataProvider = "searchData")
//    public void checkoutMainTest(SearchFilter searchFilter){
//        CheckOutPage checkOutPage = loadApplication()
//                .successfulSearch(searchFilter.getProduct())
//                .gotoCheckOutPage()
//                .continueCheckout()
//                .continueCheckoutWithRegistration()
//
//
//    }
}
