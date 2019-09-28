package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturnsTableInfo {
    private WebDriver driver;
    private String elementPath;

    private WebElement returnId;
    private WebElement productId;
    private WebElement customer;
    private WebElement product;
    private WebElement model;
    private WebElement status;
    private WebElement dateAdd;
    private WebElement editButton;

    public ReturnsTableInfo(String  element, WebDriver driver) {
        this.driver = driver;
        this.elementPath = element;
    }

    public void initElements() {
        returnId = driver.findElement(By.xpath(elementPath + "/td[1]"));
        productId = driver.findElement(By.xpath(elementPath + "/td[2]"));
        customer = driver.findElement(By.xpath(elementPath + "/td[3]"));
        product = driver.findElement(By.xpath(elementPath + "/td[4]"));
        model = driver.findElement(By.xpath(elementPath + "/td[5]"));
        status = driver.findElement(By.xpath(elementPath + "/td[6]"));
        dateAdd = driver.findElement(By.xpath(elementPath + "/td[7]"));
        editButton = driver.findElement(By.xpath(elementPath + "/td[8]"));
    }

    public String getReturnId() {
        return returnId.getText();
    }
    public String getProductId() {
        return productId.getText();
    }
    public String getCustomer() {
        return customer.getText();
    }
    public String getProduct() {
        return product.getText();
    }
    public String getModel() {
        return model.getText();
    }
    public String getStatus() {
        return status.getText();
    }
    public String getDateAdd() {
        return dateAdd.getText();
    }
    public void clickEditButton() {
        editButton.click();
    }

}
