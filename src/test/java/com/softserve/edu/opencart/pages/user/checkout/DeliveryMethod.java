package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DeliveryMethod extends CheckOutPage {
    private WebElement element;

    public DeliveryMethod(WebDriver driver) {
        super(driver);
    }


    //Functional
    private WebElement getWebFlatRateCheckBox() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input[name=\"shipping_method\"]")));
        return driver.findElement(By.cssSelector("input[name=\"shipping_method\"]"));
    }

    private WebElement getWebTextAreaDeliver() {
        return driver.findElement(By.cssSelector("textarea.form-control"));
    }

    private WebElement getWebDeliveryMethodContinueButton() {
        return driver.findElement(By.cssSelector("input#button-shipping-method"));
    }

    public void confirmFlatRateCheckBox() {
        try {
            getWebFlatRateCheckBox().click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (org.openqa.selenium.ElementClickInterceptedException ex) {
        }
            getWebFlatRateCheckBox().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void clickTextAreaDeliveryMethod() {
        getWebTextAreaDeliver().click();
    }

    public void clearTextAreaDeliveryMethod() {
        getWebTextAreaDeliver().clear();
    }

    public void clickDeliveryMethodContinueButton() {
        getWebDeliveryMethodContinueButton().click();
    }

    //Page object

    public void setTextAreaDeliver(String textForDelivery) {
        getWebTextAreaDeliver().sendKeys(textForDelivery);
    }

    //Business logic

    public PaymentMethod deliveryMethodFullyComplete(String text) {
        confirmFlatRateCheckBox();
        clickTextAreaDeliveryMethod();
        clearTextAreaDeliveryMethod();
        setTextAreaDeliver(text);
        clickDeliveryMethodContinueButton();
        return new PaymentMethod(driver);
    }


}
