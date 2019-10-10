package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturnsTableInfo {
    private WebDriver driver;
    private String elementPath;
    private WebElement element;
    private WebElement returnId;
    private WebElement productId;
    private WebElement customer;
    private WebElement product;
    private WebElement model;
    private WebElement status;
    private WebElement dateAdd;
    private WebElement editButton;

    public ReturnsTableInfo(WebElement  element, WebDriver driver, String path) {
        this.driver = driver;
        this.element = element;
        this.elementPath = path;
    }

    public void initElements() {
        returnId = element.findElement(By.xpath(elementPath + "/td[1]"));
        productId = element.findElement(By.xpath(elementPath + "/td[2]"));
        customer = element.findElement(By.xpath(elementPath + "/td[3]"));
        product = element.findElement(By.xpath(elementPath + "/td[4]"));
        model = element.findElement(By.xpath(elementPath + "/td[5]"));
        status = element.findElement(By.xpath(elementPath + "/td[6]"));
        dateAdd = element.findElement(By.xpath(elementPath + "/td[7]"));
        editButton = element.findElement(By.xpath(elementPath + "/td[8]"));
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
