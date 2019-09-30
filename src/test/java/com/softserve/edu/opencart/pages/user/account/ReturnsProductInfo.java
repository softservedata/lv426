package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturnsProductInfo {

    private WebDriver driver;

    private WebElement productName;

    private WebElement productCode;

    private WebElement quantity;

    /**
     * This variable for select Reason for returning on Return Order page
     */
    private WebElement returnReason;

    private WebElement productIsOpened;
    /**
     * This variable for button Submit on Return Order page
     */

    private WebElement detail;

    private WebElement submitButton;

    public ReturnsProductInfo(WebDriver driver) {
        this.driver=driver;
        initElements();
    }

    private void initElements() {

        this.productName = driver.findElement(By.id("input-product"));
        this.productCode = driver.findElement(By.id("input-model"));
        this.quantity = driver.findElement(By.id("input-quantity"));
        this.productIsOpened = driver.findElement(
                By.xpath("//input[@name='opened' and @value='1']"));
        this.returnReason = driver.findElement(By.xpath(
                "//input[@name = 'return_reason_id' and @value = '1']"));
        this.detail = driver.findElement(By.name("comment"));
        this.submitButton = driver.findElement(
                By.xpath("//input[@class = 'btn btn-primary']"));
    }


    public void clickProductName() {
        productName.click();
    }

    public void clickProductCode() {
        productCode.click();
    }

    public void clickQuantity() {
        quantity.click();
    }

    public void clickDetail() {
        detail.click();
    }

    public void setProductName(String productName) {
        clickProductName();
        this.productName.clear();
        this.productName.sendKeys(productName);
    }

    public void setProductCode(String productCode) {
        clickProductCode();
        this.productCode.clear();
        this.productCode.sendKeys(productCode);
    }

    public void setQuantity(String quantity) {
        clickQuantity();
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public void setDetail(String detail) {
        clickDetail();
        this.detail.clear();
        this.detail.sendKeys(detail);
    }

    public void clickProductIsOpened() {
        productIsOpened.click();
    }

    /**
     * This method select first Reason for Return Order
     */
    public void clickReturnReason() {
        returnReason.click();
    }

    /**
     * This method for click on button Submit
     */
    public void clickSubmitButton() {
        submitButton.click();
    }

}
