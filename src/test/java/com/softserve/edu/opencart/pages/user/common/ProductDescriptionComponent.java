package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDescriptionComponent extends ProductPage {

    protected WebDriver productLayout;
    public WebElement descriptionField;





    public WebElement DescriptionButton;

    public ProductDescriptionComponent(WebDriver productLayout){
        super(productLayout);
        //this.productLayout=productLayout;
        initElements();
    }

    public void  initElements(){
        descriptionField = productLayout.findElement(By.id("tab-description"));

    }

    public WebElement getDescriptionField() {
        return descriptionField;
    }

    public void setDescriptionField(WebElement descriptionField) {
        this.descriptionField = descriptionField;
    }
}
