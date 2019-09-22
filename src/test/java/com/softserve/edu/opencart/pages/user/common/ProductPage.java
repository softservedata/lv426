
package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage extends ProductComponent{
    protected WebDriver productLayout;

    private WebElement successfulAddingToWishListAlert;
    private Alerts alerts;
    private ProductsContainerComponent productsContainer;
    private ProductDescriptionComponent productDescription;
    public ProductReviewComponent productReview;

    public ProductPage (WebElement driver) {
        super(driver);
        initElements();
    }

    public void initElements(){
        productsContainer = new ProductsContainerComponent(productLayout);
        productComponent = new ProductComponent();
        successfulAddingToWishListAlert = productLayout.findElement(By.cssSelector("div .alert.alert-success.alert-dismissible"));

        alerts = new Alerts(successfulAddingToWishListAlert);
    }

    public ProductPage() {
        super();
    }

    //Page Object




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
    //business logic
    public WebElement successfulAddingToWishList(){
        addProductToWishList();
        return alerts.getAlert();
    }
}














