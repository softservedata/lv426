
package com.softserve.edu.opencart.pages.user.common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductPage extends BreadCrumbPart{

    protected WebDriver productLayout;
    public WebElement reviewButton;
    private WebElement productDescription;
    private ProductsContainerComponent productsContainer;
    private ProductComponent productComponent;

    public ProductReviewComponent productReview;



    public ProductPage() {

        super();
        this.productLayout= productLayout;
        initElements();
    }


    public void initElements() {
        reviewButton = productLayout.findElement(By.xpath("//li[contains(@class,'' )]//a[contains(text(),'Reviews')]"));
        productDescription=productLayout.findElement(By.xpath("//ul[contains(@class, \"nav nav-tabs\")]//a[contains(text(), 'Description')]"));
    }
    public WebElement getReviewButton () {

        return reviewButton;
        }

    public ProductsContainerComponent getProductComponentsContainer() {

        return productsContainer;
    }

    public WebElement getProductDescription() {
        return productDescription;
    }


    public void clickReview(){
        getReviewButton().click();
    }
    public void addProductToWishList(){
        getProductComponentsContainer().clickProductComponentAddToWishButtonByName(productComponent.getNameText());
    }

    public void productDescriptionclick(){
        getProductDescription().click();
    }

    public void sendReview(){
        productReview.clickReview();
        productReview.clickInputNameBox();
        productReview.clearInputNameBox();
        productReview.setInputNameBox("name");
        productReview.clickInputReviewBox();
        productReview.clearInputReviewBox();
        productReview.setInputReviewBox("I'm absolutely satisfied and will buy one more as a present");
        productReview.clickRatingButton();
        productReview.clickContinueReviewButton();

    }
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














