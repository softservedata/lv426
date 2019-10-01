package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.common.ProductReviewComponent;
import com.softserve.edu.opencart.pages.user.common.UnsuccessfullReviewPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.common.UnsuccessfullReviewPage.*;

public class ReviewTest extends UserTestRunner {

    @DataProvider
    public Object[][] reviewData() {
        return new Object[][]{
                {UserRepository.get().getMartaUser(),
                        ProductRepository.getIMac(), ReviewRepository.getNewReview()}
        };
    }

    @DataProvider
    public Object[][] nameWarnData() {
        return new Object[][]{
                {UserRepository.get().getMartaUser(),
                        ProductRepository.getIMac(), ReviewRepository.getNameWarnReview()}
        };
    }

    @DataProvider
    public Object[][] feedbackWarnData() {
        return new Object[][]{
                {UserRepository.get().getMartaUser(),
                        ProductRepository.getIMac(), ReviewRepository.getFeedbackWarnReview()}
        };
    }


    @Test(dataProvider = "reviewData")
    public void checkReviewEnabling(User user, Product product, Reviews review) {
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

        ProductReviewComponent en = loadMartaApplication()
                .successfulSearch(product)
                .gotoProductInfo(product)
                .gotoReview();
        Assert.assertTrue(en.getNameReviewExistText().contains(CHECK_ENABLING));


    }

    @Test(dataProvider = "nameWarnData")
    public void checkNameWarning(User user, Product product, Reviews review) {
        UnsuccessfullReviewPage unstest = loadMartaApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .successfulSearch(product)
                .gotoProductInfo(product)
                .gotoReview()
                .unsuccessReview(review);
        Assert.assertTrue(unstest.getNameWarningText().contains(EXPECTED_NAME_MESSAGE));
    }

    @Test(dataProvider = "feedbackWarnData")
    public void checkFeedbackWarning(User user, Product product, Reviews review) {
        UnsuccessfullReviewPage unstest = loadMartaApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .successfulSearch(product)
                .gotoProductInfo(product)
                .gotoReview()
                .unsuccessReview(review);
        Assert.assertTrue(unstest.getReviewWarningText().contains(EXPECTED_REVIEW_MESSAGE));
    }


    @Test(dataProvider = "reviewData")
    public void checkRatingWarning(User user, Product product, Reviews review) {
        UnsuccessfullReviewPage unstest = loadMartaApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .successfulSearch(product)
                .gotoProductInfo(product)
                .gotoReview()
                .invalidReview(review);
        Assert.assertTrue(unstest.getRatingWarningText().contains(EXPECTED_RATING_MESSAGE));

    }
}

