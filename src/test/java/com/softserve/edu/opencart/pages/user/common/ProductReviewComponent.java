package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.Rating;
import com.softserve.edu.opencart.data.Reviews;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ProductReviewComponent extends ProductPage {

    private final String RATING_LOCATER_XPATH = "//input[@name='rating' and @value='%s']";


    public WebElement inputNameBox;
    public WebElement inputReviewBox;
    public WebElement rateButton;
    //public WebElement rating1;
    //public WebElement rating2;
    //public WebElement rating3;
    //public WebElement rating4;
    //public WebElement rating5;
    public WebElement continueReviewButton;



    public ProductReviewComponent(WebDriver driver){
        super(driver);
        //this.productLayout=productLayout;
        initElements();
    }

    //public ProductReviewComponent() { }


    public void initElements() {
        //reviewButton = productLayout.findElement(By.xpath("//li[contains(@class,'' )]//a[contains(text(),'Reviews')]"));
        inputNameBox = driver.findElement(By.id("input-name"));
        inputReviewBox = driver.findElement(By.id("input-review"));
        //rating1 = driver.findElement(By.xpath(Rating.VERYBAD.getValue()));
        //rating1= productLayout.findElement(By.xpath("//input[@name='rating' and @value='1']"));
        //rating2=productLayout.findElement(By.xpath("//input[@name='rating' and @value='2']"));
        //rating3=productLayout.findElement(By.xpath("//input[@name='rating' and @value='3']"));
        //rating4=productLayout.findElement(By.xpath("//input[@name='rating' and @value='4']"));
        //rating5=productLayout.findElement(By.xpath("//input[@name='rating' and @value='5']"));
        continueReviewButton = driver.findElement(By.id("button-review"));
    }

    //Page Object


    public WebElement getProductLayout() {
        return (WebElement) driver;
    }

    public WebElement getContinueReviewButton() {
        return continueReviewButton;
    }

    public WebElement getRateButton(Rating rating){
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


    //Functionality


    public void clickInputNameBox() {
        getInputNameBox().click();
    }

    public void clearInputNameBox() {
        getInputNameBox().clear();
    }

    public void clickRatingButton(Rating rating){
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


    public void sendReview(Reviews review) {
        clickInputNameBox();
        clearInputNameBox();
        setInputNameBox(review.getName());
        clickInputReviewBox();
        clearInputReviewBox();
        setInputReviewBox(review.getFeedback());
        clickRatingButton(review.getRating());
        //clickContinueReviewButton();

    }

    public SuccessReviewPage successReview(Reviews review){
        sendReview(review);
        clickContinueReviewButton();
        return new SuccessReviewPage(driver);
    }

    public  UnsuccessfullReviewPage unsuccessReview(Reviews review){
        sendReview(review);
        clickContinueReviewButton();
        return new UnsuccessfullReviewPage(driver);
    }


}






