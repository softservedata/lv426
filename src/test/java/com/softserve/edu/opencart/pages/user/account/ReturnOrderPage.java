package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReturnOrderPage extends AccountSidebarLoggedPart {

    private ReturnsProductInfo productInfo;

    private ReturnsOrderInfo orderInfo;

    /** This variable for button Submit on Return Order page*/
    private WebElement submitButton;

    public ReturnOrderPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        productInfo = new ReturnsProductInfo(driver);
        orderInfo = new ReturnsOrderInfo(driver);
        this.submitButton = driver.findElement(By.xpath("//input[@class = 'btn btn-primary']"));

    }

    /** This method for click on button Submit*/
    public void submitButtonClick() {
        submitButton.click();
    }








}
