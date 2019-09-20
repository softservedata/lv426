package com.softserve.edu.opencart.data;

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

    public CartTableFullOrderInfo(WebElement element){
        this.element = element;
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

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getQuantity() {
        return quantity;
    }

    public WebElement getUnitPrice() {
        return unitPrice;
    }

    public WebElement getTotal() {
        return total;
    }
}
