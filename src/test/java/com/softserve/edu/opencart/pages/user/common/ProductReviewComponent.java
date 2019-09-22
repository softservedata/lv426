package com.softserve.edu.opencart.pages.user.common;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ProductReviewComponent extends ProductPage {

protected WebDriver productLayout;

    public WebElement reviewButton;
    public WebElement inputNameBox;
    public WebElement inputReviewBox;
    public WebElement rating1;
    public WebElement rating2;
    public WebElement rating3;
    public WebElement rating4;
    public WebElement rating5;
    public WebElement continueReviewButton;

    public ProductReviewComponent(WebDriver productLayout){
        super();
        this.productLayout=productLayout;
        initElements();
    }

  public void initElements(){
      reviewButton = productLayout.findElement(By.xpath("//li[contains(@class,'' )]//a[contains(text(),'Reviews')]"));
      inputNameBox = productLayout.findElement(By.id("input-name"));
      inputReviewBox = productLayout.findElement(By.id("input-review"));
      rating1 = productLayout.findElement(By.xpath("//input[@name='rating' and @value='1']"));
      rating2=productLayout.findElement(By.xpath("//input[@name='rating' and @value='2']"));
      rating3=productLayout.findElement(By.xpath("//input[@name='rating' and @value='3']"));
      rating4=productLayout.findElement(By.xpath("//input[@name='rating' and @value='4']"));
      rating5=productLayout.findElement(By.xpath("//input[@name='rating' and @value='5']"));
      continueReviewButton = productLayout.findElement(By.id("button-review"));
  }

  //Page Object

    public WebElement getProductLayout() {
        return (WebElement) productLayout;
    }
    //getReviewButton
    public WebElement getReviewButton(){return reviewButton;}


    //fill name box in Review
    public WebElement getInputNameBox(){
        return inputNameBox;
    }
    public  WebElement getInputReviewBox(){
        return inputReviewBox;
    }
    public WebElement getRating1() {
        return  rating1;
    }
    public WebElement getRating2(){
        return rating2;
    }

    public WebElement getRating3(){
        return rating3;
    }

    public WebElement getRating4(){
        return rating4;
    }

    public WebElement getRating5(){
        return rating5;
    }
    public WebElement getContinueReviewButton(){
        return continueReviewButton;
    }



    //Functionality
    public void clickReview(){
        getReviewButton().click();
    }

    public void clickInputNameBox(){
        getInputNameBox().click();
    }

    public void clearInputNameBox(){
        getInputNameBox().clear();
    }

    public void setInputNameBox (String name){
        getInputNameBox().sendKeys(name);
    }


    //fill rating



    public void clickInputReviewBox(){
        getInputReviewBox().click();
    }

    public void clearInputReviewBox(){
        getInputReviewBox().clear();
    }

    public void setInputReviewBox (String review){
        getInputReviewBox().sendKeys(review);
    }

    //click rating


    public void clickRating1(){
        getRating1().click();
    }

    public void clickRating2(){
        getRating2().click();
    }
    public void clickRating3(){
        getRating3().click();
    }

    public void clickRating4(){
        getRating4().click();
    }

    public void clickRating5(){
        getRating5().click();
    }


    public void clickContinueReviewButton() {
        getContinueReviewButton().click();
    }

    //Business Logic



}
