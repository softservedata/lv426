
package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage extends BreadCrumbPart {

    public WebElement reviewButton;
    private WebElement productDescription;
    private ProductsContainerComponent productsContainer;
    private ProductComponent productComponent;

    public ProductReviewComponent productReview;


    public ProductPage(WebDriver driver) {
        super(driver);
        initElements();
    }


    public void initElements() {
        reviewButton = driver.findElement(By.xpath("//li[contains(@class,'' )]//a[contains(text(),'Reviews')]"));
        productDescription = driver.findElement(By.xpath("//ul[contains(@class, 'nav nav-tabs')]//a[contains(text(), 'Description')]"));
    }


    public WebElement getReviewButton() {
        return reviewButton;
    }

    public void clickReview() {
        getReviewButton().click();
        //return new ProductReviewComponent(driver);
    }

    public ProductsContainerComponent getProductComponentsContainer() {
        return productsContainer;
    }
    //Page Object


    public WebElement getProductDescription() {
        return productDescription;
    }


    public void productDescriptionclick() {
        getProductDescription().click();
    }


    //business logic

    public ProductReviewComponent gotoReview() {
        clickReview();
        return new ProductReviewComponent(driver);
    }
}

















