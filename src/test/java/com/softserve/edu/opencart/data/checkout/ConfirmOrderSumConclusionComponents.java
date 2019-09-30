package com.softserve.edu.opencart.data.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrderSumConclusionComponents {
    private WebElement element;
    private WebDriver driver;

    public ConfirmOrderSumConclusionComponents(WebElement element, WebDriver driver) {
        this.element = element;
        this.driver = driver;
    }
    //Page object

    private WebElement getWebTitle(){
        return element.findElement(By.xpath("./td/strong"));
    }

    private WebElement getWebPrice(){
        return element.findElement(By.xpath("./td[last()]"));
    }

    //functional

    public String getTitleConfirmTable(){
        return getWebTitle().getText();
    }

    public String getPriceConfirmTable(){
        return getWebPrice().getText();
    }

}
