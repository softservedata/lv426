package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessReviewPage extends ProductReviewComponent {

    public static final String EXPECTED_MESSAGE = "Thank you for your review. It has been submitted to the webmaster for approval.";

    public SuccessReviewPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMessage() {
        return driver.findElement(By.cssSelector("alert alert-success"));
    }

    public String getText() {
        return getMessage().getText();
    }
}
