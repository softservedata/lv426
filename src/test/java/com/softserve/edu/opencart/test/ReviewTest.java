package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.common.UnsuccessfullReviewPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.common.UnsuccessfullReviewPage.EXPECTED_NAME_MESSAGE;
import static com.softserve.edu.opencart.pages.user.common.UnsuccessfullReviewPage.EXPECTED_REVIEW_MESSAGE;

public class ReviewTest extends UserTestRunner {

    @DataProvider
    public Object[][] reviewData(){
        return new Object[][]{
                {  UserRepository.get().getMartaUser(),
                        ProductRepository.getIMac(), ReviewRepository.getNewReview() }
        };
    }

    @DataProvider
    public Object[][] nameWarnData(){
        return new Object[][]{
                {  UserRepository.get().getMartaUser(),
                        ProductRepository.getIMac(), ReviewRepository.getNameWarnReview() }
        };
    }

    @DataProvider
    public Object[][]  feedbackWarnData(){
        return new Object[][]{
                {  UserRepository.get().getMartaUser(),
                        ProductRepository.getIMac(), ReviewRepository.getFeedbackWarnReview() }
        };
    }




    @Test (dataProvider = "reviewData")
    public void checkReviewEnabling ( User user, Product product,Reviews review ){
    loadMartaApplication()
            .gotoLoginPage()
            .successfulLogin(user)
            .successfulSearch(product)
            .gotoProductInfo(product)
            .gotoReview()
            //.sendReview(review);
            .successReview(review);

    loadMartaAdminLoginPage()
            .goToAdminHomePage()
            .goToReviewPage()
            .gotoEditReview()
            .enableReview();

    }

    @Test(dataProvider = "nameWarnData")
    public void checkNameWarning( User user, Product product,Reviews review ) {
        UnsuccessfullReviewPage unstest=loadMartaApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .successfulSearch(product)
                .gotoProductInfo(product)
                .gotoReview()
                .unsuccessReview(review);
        Assert.assertTrue(unstest.getNameWarningText().contains(EXPECTED_NAME_MESSAGE));
    }

    @Test(dataProvider = "feedbackWarnData")
    public void checkFeedbackWarning( User user, Product product,Reviews review ) {
        UnsuccessfullReviewPage unstest=loadMartaApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .successfulSearch(product)
                .gotoProductInfo(product)
                .gotoReview()
                .unsuccessReview(review);
        Assert.assertTrue(unstest.getReviewWarningText().contains(EXPECTED_REVIEW_MESSAGE));
    }


}
