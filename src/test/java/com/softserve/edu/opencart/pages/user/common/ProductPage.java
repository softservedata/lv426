
package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage extends ProductComponent{
    protected WebDriver productLayout;


    private ProductsContainerComponent productsContainer;
    private ProductDescriptionComponent productDescription;
    public ProductReviewComponent productReview;

    public ProductPage(WebElement productLayout) {
        super(productLayout);
    }

    public ProductPage() {
        super();
    }

    /*public ProductPage(WebDriver productLayout){
        this.productLayout=productLayout;
        initElements();
    }

    public ProductPage() {

    }

    public void initElements(){
        productsContainer = new ProductsContainerComponent(productLayout);

    }

     */


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














