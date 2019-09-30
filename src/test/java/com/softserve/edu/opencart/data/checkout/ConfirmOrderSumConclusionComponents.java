package com.softserve.edu.opencart.data.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 5)).until(ExpectedConditions
        .elementToBeClickable(getWebTitle()));
        return getWebTitle().getText();
    }

    public String getPriceConfirmTable(){
        (new WebDriverWait(driver, 5)).until(ExpectedConditions
                .elementToBeClickable(getWebPrice()));
        return getWebPrice().getText();
    }

}
