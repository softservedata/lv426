package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Special;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage.LAST_ROW_IN_TABLE;

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
    }


    private void initElements() {
        tableElement = driver.findElement(By.xpath(LAST_ROW_IN_TABLE));
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
    private void setPriority(Special special) {
        priority.sendKeys(String.valueOf(special.getPriority()));
    }

    private void clickPrice() {
        price.click();
    }

    private void clearPrice() {
        price.clear();
    }

    private void setPrice(Special special) {
        price.sendKeys(String.valueOf(special.getPrice()));
    }

    private void clickStartDate() {
        startDate.click();
    }

    private void clearStartDate() {
        startDate.clear();
    }

    private void setStartDate(Special special) {
        startDate.sendKeys(String.valueOf(special.getEndData()));
    }

    private void clickEndDate() {
        startDate.click();
    }

    private void clearEndDate() {
        startDate.clear();
    }

    private void setEndDate(Special special) {
        endData.sendKeys(String.valueOf(special.getStartDate()));
    }


    private void enterPriority(Special special) {
        clickPriority();
        clearPriority();
        setPriority(special);
    }

    private void enterPrice(Special special) {
        clickPrice();
        clearPrice();
        setPrice(special);
    }
    private void enterStartDate(Special special) {
        clickStartDate();
        clearStartDate();
        setStartDate(special);
    }
    private void enterEndDate(Special special) {
        clickEndDate();
        clearEndDate();
        setEndDate(special);
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
