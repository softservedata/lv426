package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfullReviewPage extends ProductReviewComponent {

    public static final String EXPECTED_NAME_MESSAGE = "Warning: Review Name must be between 3 and 25 characters!";
    public static final String EXPECTED_REVIEW_MESSAGE = "Warning: Review Text must be between 25 and 1000 characters!";
    public static final String EXPECTED_RATING_MESSAGE = "Warning: Please select a review rating!";


    public UnsuccessfullReviewPage(WebDriver driver) {
        super(driver);

    }


    // Page Object

    // alertWarning


    public WebElement getWarning() {
        return driver.findElement(By.cssSelector("div.alert.alert-danger"));
    }


    public String getNameWarningText() {
        return getWarning().getText();
    }

    public String getReviewWarningText() {
        return getWarning().getText();
    }

    public String getRatingWarningText() {
        return getWarning().getText();
    }

    // Functional

    // Business Logic

}
