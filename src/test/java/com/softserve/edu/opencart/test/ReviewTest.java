package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.common.ProductPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReviewTest extends UserTestRunner {

    @DataProvider
    public Object[][] reviewData(){
        return new Object[][]{
                { ReviewRepository.getDefault(), UserRepository.get().getHahahaUser(), ProductRepository.getMacBook(), ReviewRepository.getNewReview() }
        };
    }



    @Test (dataProvider = "reviewData")
    public void checkReviewEnabling (Reviews review, User user, Product product){
    loadApplication()
            .gotoLoginPage()
            .successfulLogin(user)
            .successfulSearch(product)
            .getProductsCriteria()
            .getProductComponentByName(product)
            .
    }

}
