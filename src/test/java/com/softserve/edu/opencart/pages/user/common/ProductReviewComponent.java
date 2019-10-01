package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Rating;
import com.softserve.edu.opencart.data.Reviews;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductReviewComponent extends ProductPage {

    private final String RATING_LOCATER_XPATH = "//input[@name='rating' and @value='%s']";
    public static final String CHECK_ENABLING = "iva qwerty";


    public WebElement inputNameBox;
    public WebElement inputReviewBox;
    public WebElement continueReviewButton;


    public ProductReviewComponent(WebDriver driver) {
        super(driver);

        initElements();
    }


    public void initElements() {

        inputNameBox = driver.findElement(By.id("input-name"));
        inputReviewBox = driver.findElement(By.id("input-review"));
        continueReviewButton = driver.findElement(By.id("button-review"));
    }

    //Page Object


    public WebElement getProductLayout() {
        return (WebElement) driver;
    }

    public WebElement getContinueReviewButton() {
        return continueReviewButton;
    }

    public WebElement getRateButton(Rating rating) {
        return driver.findElement(By.xpath(String.format(RATING_LOCATER_XPATH, rating.getValue())));
    }
    //getReviewButton


    //fill name box in Reviews
    public WebElement getInputNameBox() {
        return inputNameBox;
    }

    public WebElement getInputReviewBox() {
        return inputReviewBox;
    }

    public WebElement getReviewExist() {
        return driver.findElement(By.xpath("//strong[contains(text(), 'iva qwerty')]"));
    }

    public String getNameReviewExistText() {
        return getReviewExist().getText();
    }


    //Functionality


    public void clickInputNameBox() {
        getInputNameBox().click();
    }

    public void clearInputNameBox() {
        getInputNameBox().clear();
    }

    public void clickRatingButton(Rating rating) {
        getRateButton(rating).click();
    }

    public void setInputNameBox(String name) {
        getInputNameBox().sendKeys(name);
    }


    //fill rating


    public void clickInputReviewBox() {
        getInputReviewBox().click();
    }

    public void clearInputReviewBox() {
        getInputReviewBox().clear();
    }

    public void setInputReviewBox(String review) {
        getInputReviewBox().sendKeys(review);
    }


    public void clickContinueReviewButton() {
        getContinueReviewButton().click();
    }

    public void fillName(Reviews review) {
        clickInputNameBox();
        clearInputNameBox();
        setInputNameBox(review.getName());
    }

    public void fillReview(Reviews review) {
        clickInputReviewBox();
        clearInputReviewBox();
        setInputReviewBox(review.getFeedback());
    }


    public void sendReview(Reviews review) {
        fillName(review);
        fillReview(review);
        clickRatingButton(review.getRating());
        //clickContinueReviewButton();

    }

    public void sendInvalidReview(Reviews review) {
        fillName(review);
        fillReview(review);

    }

    public UnsuccessfullReviewPage invalidReview(Reviews review) {
        sendInvalidReview(review);
        clickContinueReviewButton();
        return new UnsuccessfullReviewPage(driver);
    }

    public SuccessReviewPage successReview(Reviews review) {
        sendReview(review);
        clickContinueReviewButton();
        return new SuccessReviewPage(driver);
    }

    public UnsuccessfullReviewPage unsuccessReview(Reviews review) {
        sendReview(review);
        clickContinueReviewButton();
        return new UnsuccessfullReviewPage(driver);
    }


}






