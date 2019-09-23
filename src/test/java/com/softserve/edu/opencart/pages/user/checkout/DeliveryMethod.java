package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryMethod extends CheckOutPage {
    private WebDriver driver;
    private WebElement element;

    private WebElement flatRateCheckBox;
    private WebElement textAreaDeliver;
    private WebElement deliveryMethodContinueButton;

    public DeliveryMethod(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        flatRateCheckBox = driver.findElement(By.cssSelector("input[name=\"shipping_method\"]"));
        textAreaDeliver = driver.findElement(By.cssSelector("textarea.form-control"));
        deliveryMethodContinueButton = driver.findElement(By.cssSelector("input#button-shipping-method"));
    }

    //Functional
    public void confirmFlatRateCheckBox(){
        flatRateCheckBox.click();
    }

    public void clickTextAreaDeliveryMethod(){
        textAreaDeliver.click();
    }

    public void clearTextAreaDeliveryMethod(){
        textAreaDeliver.clear();
    }

    public void clickDeliveryMethodContinueButton(){
        deliveryMethodContinueButton.click();
    }

    //Page object

    public void setTextAreaDeliver(String textForDelivery){
        textAreaDeliver.sendKeys(textForDelivery);
    }

    //Business logic

    public void deliveryMethodFullyComplete(String text){
        confirmFlatRateCheckBox();
        clickDeliveryMethodContinueButton();
        clearTextAreaDeliveryMethod();
        setTextAreaDeliver(text);
        clickDeliveryMethodContinueButton();
    }


}
