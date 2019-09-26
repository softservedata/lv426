
package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage {
   protected WebDriver productLayout;


    private ProductsContainerComponent productsContainer;
    private ProductComponent productComponent;
    private ProductDescriptionComponent productDescription;
    public ProductReviewComponent productReview;

    public ProductPage (WebDriver driver) {

        this.productLayout=driver;
        initElements();
    }

    public void initElements(){
        productsContainer = new ProductsContainerComponent(productLayout);
        productComponent = new ProductComponent();

    }


    public ProductsContainerComponent getProductComponentsContainer() {
        return productsContainer;
    }



    public void sendReview(){
        productReview.clickReview();
        productReview.clickInputNameBox();
        productReview.clearInputNameBox();
        productReview.setInputNameBox("iva qwerty");
        productReview.clickInputReviewBox();
        productReview.clearInputReviewBox();
        productReview.setInputReviewBox("I'm absolutely satisfied and will buy one more as a present");
        productReview.clickRating5();
        productReview.clickContinueReviewButton();

    }

}














