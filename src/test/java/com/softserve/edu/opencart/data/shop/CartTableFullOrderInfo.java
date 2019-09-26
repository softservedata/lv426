package com.softserve.edu.opencart.data.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartTableFullOrderInfo {
    private WebDriver driver;
    private WebElement element;
    //
    private WebElement productName;
    private WebElement model;
    private WebElement quantity;
    private WebElement unitPrice;
    private WebElement total;

    public CartTableFullOrderInfo(WebElement element, WebDriver driver){
        this.element = element;
        this.driver = driver;
        initElements();
    }

    private void initElements(){
        productName = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//td[contains(@class,'text-left')]/a[contains(text(),'')]"));
        model = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//tbody//td[contains(text(),'roduct')]"));
        quantity = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//tbody//td/div/input"));
        unitPrice = driver.findElement(By.xpath("//div[contains(@class,'table-responsive')]" +
                "/table[contains(@class,'table table-bordered')]" +
                "//tbody/tr/td/div/../following-sibling::td[contains(@class,'text-right')][1]"));
        total = driver.findElement(By.xpath("//div[contains(@class,'table-responsive')]" +
                "/table[contains(@class,'table table-bordered')]//tbody/tr/td[5]" +
                "//../following-sibling::td[contains(@class,'text-right')]"));
    }

    public WebElement getProductNameWeb() {
        return productName;
    }

    public WebElement getModelWeb() {
        return model;
    }

    public WebElement getQuantityWeb() {
        return quantity;
    }

    public WebElement getUnitPriceWeb() {
        return unitPrice;
    }

    public WebElement getTotalWeb() {
        return total;
    }

    //Functional
    public String getProductName(){
        return getProductNameWeb().getText();
    }

    public String getModel(){
        return getModelWeb().getText();
    }

    public String getQuantity(){
        return getQuantityWeb().getText();
    }

    public String getTotal(){
        return getTotalWeb().getText();
    }
}
