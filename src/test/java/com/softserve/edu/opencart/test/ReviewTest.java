package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReviewTest extends UserTestRunner {

    @DataProvider
    public Object[][] reviewData(){
        return new Object[][]{
                { ReviewRepository.getDefault(), UserRepository.get().getHahahaUser(),
                        ProductRepository.getIMac(), ReviewRepository.getNewReview() }
        };
    }



    @Test (dataProvider = "reviewData")
    public void checkReviewEnabling (Reviews review, User user, Product product){
    loadMartaApplication()
            .gotoLoginPage()
            .successfulLogin(user)
            .successfulSearch(product)
            .gotoProductInfo(product)
            .sendReview(review);

    loadMartaAdminLoginPage()
            .goToAdminHomePage()
            .goToReviewPage()
            .gotoEditReview()
            .enableReview();

    }


}
