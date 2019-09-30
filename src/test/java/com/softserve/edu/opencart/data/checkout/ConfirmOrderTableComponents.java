package com.softserve.edu.opencart.data.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrderTableComponents {

    private WebDriver driver;
    private WebElement element;

    public ConfirmOrderTableComponents(WebElement element, WebDriver driver) {
        this.driver = driver;
        this.element = element;
    }


    private WebElement getWebProductName(){
        return driver.findElement(By.xpath("//div[@class='panel-body']//tbody/tr/td/a"));
    }

    private WebElement getWebModel(){
        return driver.findElement(By.xpath("//div[@class='panel-body']//tbody/tr/td/a/../" +
                "following-sibling::td[@class=\"text-left\"]"));
    }
    private WebElement getWebQuantity(){
        return driver.findElement(By.xpath("//div[@class='panel-body']//tbody/tr/td[@class='text-right'][1]"));
    }
    private WebElement getWebUnitPrice(){
        return driver.findElement(By.xpath("//div[@class='panel-body']//tbody/tr/td[@class='text-right'][2]"));
    }
    private WebElement getWebTotal(){
        return driver.findElement(By.xpath("//div[@class='panel-body']//tbody/tr/td[@class='text-right'][3]"));
    }


    public String getProductNameFromConfirmPage(){
        return getWebProductName().getText();
    }
    public String getModelFromConfirmPage(){
        return getWebModel().getText();
    }
    public String getQuantityFromConfirmPage(){
        return getWebQuantity().getText();
    }
    public String getUnitPriceFromConfirmPage(){
        return getWebUnitPrice().getText();
    }
    public String getTotalFromConfirmPage(){
        return getWebTotal().getText();
    }

}
