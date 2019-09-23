package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.ConfirmOrderTableComponents;
import com.softserve.edu.opencart.data.checkout.ConfirmOrderTableContainer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ConfirmOrder extends CheckOutPage{

    private WebDriver driver;
    private WebElement element;
    private String CONFIRM_ORDER_TABLE_COMPONENTS_CSSSELECTOR = "div.panel-body tbody tr";
    private WebElement confirmCheckoutContinueButton;
    private List<ConfirmOrderTableComponents> listWithInfo;


    public ConfirmOrder(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        listWithInfo = new ArrayList<>();
        confirmCheckoutContinueButton = driver.findElement(By.cssSelector("input#button-confirm"));
        for(WebElement current : driver.findElements(By.cssSelector(CONFIRM_ORDER_TABLE_COMPONENTS_CSSSELECTOR))){
            listWithInfo.add(new ConfirmOrderTableComponents(current));
            listOrderInfo();
        }
    }
    
    public ConfirmOrderTableContainer listOrderInfo(){
        return new ConfirmOrderTableContainer(listWithInfo);
    }

    public void confirmCheckoutButtonClick(){
        confirmCheckoutContinueButton.click();
    }
}
