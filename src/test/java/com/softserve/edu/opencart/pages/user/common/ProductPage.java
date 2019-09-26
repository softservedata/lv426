
package com.softserve.edu.opencart.pages.user.common;
import com.softserve.edu.opencart.data.Reviews;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class ProductPage extends BreadCrumbPart{
    public ProductPage(WebDriver productLayout) {
    }



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
        //Page Object


    public WebElement getProductDescription() {
        return productDescription;
    }




    public void clickReview(){
        getReviewButton().click();
    }



    public void productDescriptionclick(){
        getProductDescription().click();
    }

    public void sendReview(Reviews review ){
        productReview.clickReview();
        productReview.clickInputNameBox();
        productReview.clearInputNameBox();
        productReview.setInputNameBox(review.getName());
        productReview.clickInputReviewBox();
        productReview.clearInputReviewBox();
        productReview.setInputReviewBox(review.getReview());
        productReview.clickRatingButton(review.getRating());
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














