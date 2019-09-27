package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.ReturnsStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturnsFilter extends ReturnsPage{
    private WebDriver driver;

    private WebElement returnsId;
    private WebElement customer;
    private WebElement model;
    private WebElement dateAdd;
    private WebElement orderId;
    private WebElement product;
    private WebElement returnStatus;
    private WebElement dateMod;
    private WebElement filterButton;

    public ReturnsFilter(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        returnsId = driver.findElement(By.id("input-return-id"));
        orderId = driver.findElement(By.id("input-order-id"));
        customer = driver.findElement(By.id("input-customer"));
        product = driver.findElement(By.id("input-product"));
        model = driver.findElement(By.id("input-model"));
        returnStatus = driver.findElement(By.id("input-return-status"));
        dateAdd = driver.findElement(By.id("input-date-added"));
        dateMod = driver.findElement(By.id("input-date-modified"));
        filterButton = driver.findElement(By.id("button-filter"));
    }

     public void setReturnsId (String text) {
        returnsId.click();
        returnsId.clear();
        returnsId.sendKeys(text);
     }

    public void setOrderId (String text) {
        orderId.click();
        orderId.clear();
        orderId.sendKeys(text);
    }
    public void setCustomer (String text) {
        customer.click();
        customer.clear();
        customer.sendKeys(text);
    }

    public void setProduct (String text) {
        product.click();
        product.clear();
        product.sendKeys(text);

    }
    public void setModel (String text) {
        model.click();
        model.clear();
        model.sendKeys(text);
    }
    public void setDateAdd (String text) {
        dateAdd.click();
        dateAdd.clear();
        dateAdd.sendKeys(text);
    }
    public void setDateMod (String text) {
        dateMod.click();
        dateMod.clear();
        dateMod.sendKeys(text);
    }
    public void setCompleteStatus () {
        returnStatus.findElement(By.xpath(ReturnsStatus.COMPLETE.getValue()));
        returnStatus.click();
    }
    public void setPendingStatus () {
        returnStatus.findElement(By.xpath(ReturnsStatus.PENDING.getValue()));
        returnStatus.click();
    }
    public void setAwaitingStatus () {
        returnStatus.findElement(By.xpath(ReturnsStatus.AWAITING.getValue()));
        returnStatus.click();
    }
    public void clickFilterButton() {
        filterButton.click();
    }

}
