package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfullReviewPage extends ProductReviewComponent {

    public static final String EXPECTED_NAME_MESSAGE = " Warning: Reviews Name must be between 3 and 25 characters!";
    public static final String EXPECTED_REVIEW_MESSAGE = " Warning: Reviews Text must be between 25 and 1000 characters!";
    public static final String EXPECTED_RATING_MESSAGE = " Warning: Please select a review rating!";

    //
    private WebElement nameWarning;
    private WebElement reviewWarning;
    private WebElement ratingWarning;


    public UnsuccessfullReviewPage(WebDriver productLayout) {
        super(productLayout);
        initElements();
    }

    public void initElements() {
        nameWarning = productLayout.findElement(By.xpath("//*[@id=\"form-review\"]/div/div"));
        reviewWarning=productLayout.findElement(By.xpath("//*[@id=\"form-review\"]/div/div"));
        ratingWarning=productLayout.findElement(By.xpath("//*[@id=\"form-review\"]/div/div"));
    }

    // Page Object

    // alertWarning


    public WebElement getNameWarning() {
        return nameWarning;
    }

    public WebElement getReviewWarning() {
        return reviewWarning;
    }

    public WebElement getRatingWarning() {
        return ratingWarning;
    }

    public String getNameWarningText() {
        return getNameWarning().getText();
    }

    public String getReviewWarningText() {
        return getReviewWarning().getText();
    }

    public String getRatingWarningText() {
        return getRatingWarning().getText();
    }

    // Functional

    // Business Logic
}
