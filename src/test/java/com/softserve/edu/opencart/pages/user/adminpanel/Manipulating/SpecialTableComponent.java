package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Special;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecialTableComponent {
    private WebDriver driver;
    private WebElement tableElement;
    private WebElement deleteButton;
    private WebElement priority;
    private WebElement price;
    private WebElement startDate;
    private WebElement endData;


    SpecialTableComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }


    private void initElements() {
        tableElement = driver.findElement(By.xpath("//table[@id='special']/tbody/tr[last()]"));
        deleteButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        priority = tableElement.findElement(By.xpath("//input[@placeholder='Priority']"));
        price = tableElement.findElement(By.xpath("//input[@placeholder='Price']"));
        startDate = tableElement.findElement(By.xpath("//input[@placeholder='Date Start']"));
        endData = tableElement.findElement(By.xpath("//input[@placeholder='Date End']"));
    }


    private void clickDeleteButton() {
        deleteButton.click();
    }

    private void clickPriority() {
        priority.click();
    }
    private void clearPriority() {
        priority.clear();
    }
    private void setPriority(int specialPriority) {
        priority.sendKeys(String.valueOf(specialPriority));
    }

    private void clickPrice() {
        price.click();
    }

    private void clearPrice() {
        price.clear();
    }

    private void setPrice(double specialPrice) {
        price.sendKeys(String.valueOf(specialPrice));
    }

    private void clickStartDate() {
        startDate.click();
    }

    private void clearStartDate() {
        startDate.clear();
    }

    private void setStartDate(String specialStartDay) {
        startDate.sendKeys(specialStartDay);
    }

    private void clickEndDate() {
        startDate.click();
    }

    private void clearEndDate() {
        startDate.clear();
    }

    private void setEndDate(String specialEndDay) {
        endData.sendKeys(specialEndDay);
    }


    private void enterPriority(Special special) {
        clickPriority();
        clearPriority();
        setPriority(special.getPriority());
    }

    private void enterPrice(Special special) {
        clickPrice();
        clearPrice();
        setPrice(special.getPrice());
    }
    private void enterStartDate(Special special) {
        clickStartDate();
        clearStartDate();
        setStartDate(special.getStartDate());
    }
    private void enterEndDate(Special special) {
        clickEndDate();
        clearEndDate();
        setEndDate(special.getEndData());
    }

    protected void fillInAllFields(Special special) {
        enterPriority(special);
        enterPrice(special);
        enterStartDate(special);
        enterEndDate(special);
    }

    protected void deleteSpecialTableComponent() {
        clickDeleteButton();
    }






}
