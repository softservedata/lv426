package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Discount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage.LAST_ROW_IN_TABLE;

public class DiscountTableComponent {
    private WebDriver driver;
    private WebElement tableElement;
    private WebElement deleteButton;
    private WebElement quantity;
    private WebElement priority;
    private WebElement price;
    private WebElement startDate;
    private WebElement endData;


    DiscountTableComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        tableElement = driver.findElement(By.xpath(LAST_ROW_IN_TABLE));
        deleteButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        quantity = tableElement.findElement(By.xpath("//input[@placeholder='Quantity']"));
        priority = tableElement.findElement(By.xpath("//input[@placeholder='Priority']"));
        price = tableElement.findElement(By.xpath("//input[@placeholder='Price']"));
        startDate = tableElement.findElement(By.xpath("//input[@placeholder='Date Start']"));
        endData = tableElement.findElement(By.xpath("//input[@placeholder='Date End']"));
    }

    private void clickDeleteButton() {
        deleteButton.click();
    }
    private void clickQuantity() {
        quantity.click();
    }
    private void clearQuantity() {
        quantity.clear();
    }
    private void setQuantity(Discount discount) {
        quantity.sendKeys(String.valueOf(discount.getQuantity()));
    }

    private void clickPriority() {
        priority.click();
    }
    private void clearPriority() {
        priority.clear();
    }
    private void setPriority(Discount discount) {
        priority.sendKeys(String.valueOf(discount.getPriority()));
    }

    private void clickPrice() {
        price.click();
    }

    private void clearPrice() {
        price.clear();
    }

    private void setPrice(Discount discount) {
        price.sendKeys(String.valueOf(discount.getPrice()));
    }

    private void clickStartDate() {
        startDate.click();
    }

    private void clearStartDate() {
        startDate.clear();
    }

    private void setStartDate(Discount discount) {
        startDate.sendKeys(String.valueOf(discount.getEndData()));
    }

    private void clickEndDate() {
        startDate.click();
    }

    private void clearEndDate() {
        startDate.clear();
    }

    private void setEndDate(Discount discount) {
        endData.sendKeys(String.valueOf(discount.getStartDate()));
    }


    private void enterQuantity(Discount discount) {
        clickQuantity();
        clearQuantity();
        setQuantity(discount);
    }

    private void enterPriority(Discount discount) {
        clickPriority();
        clearPriority();
        setPriority(discount);
    }

    private void enterPrice(Discount discount) {
        clickPrice();
        clearPrice();
        setPrice(discount);
    }
    private void enterStartDate(Discount discount) {
        clickStartDate();
        clearStartDate();
        setStartDate(discount);
    }
    private void enterEndDate(Discount discount) {
        clickEndDate();
        clearEndDate();
        setEndDate(discount);
    }


    protected void fillInAllFields(Discount discount) {
        enterQuantity(discount);
        enterPriority(discount);
        enterPrice(discount);
        enterStartDate(discount);
        enterEndDate(discount);
    }

    protected void deleteComponent() {
        clickDeleteButton();
    }












}
