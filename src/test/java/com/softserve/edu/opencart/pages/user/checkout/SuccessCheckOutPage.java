package com.softserve.edu.opencart.pages.user.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SuccessCheckOutPage extends ConfirmOrder{

    public SuccessCheckOutPage(WebDriver driver) {
        super(driver);
    }

    //Page Object

    private WebElement getWebCheckoutFinishedBodyFirst() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("div#content  p:first-of-type")));
        return driver.findElement(By.cssSelector("div#content  p:first-of-type"));
    }

    private WebElement getWebCheckoutFinishedBodySecond() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver,5)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("div#content p a")));
        return driver.findElement(By.cssSelector("div#content  p a"));
    }

    private WebElement getWebCheckoutFinishedBodyThird() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver,5)).until(ExpectedConditions
        .visibilityOf(driver.findElement(By.cssSelector("div#content  p:last-of-type"))));
        return driver.findElement(By.cssSelector("div#content  p:last-of-type"));
    }

    private WebElement getWebCheckoutFinishedContinueButton() {
        return driver.findElement(By.cssSelector("div.pull-right a[class=\"btn btn-primary\"]"));
    }

    private WebElement getWebCheckoutFinishedTitle() {
        (new WebDriverWait(driver,5)).until(ExpectedConditions
        .elementToBeClickable(By.cssSelector("div#content h1")));
        return driver.findElement(By.cssSelector("div#content h1"));
    }
    //functional
    public String getCheckoutFinishedTitle(){
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getWebCheckoutFinishedTitle().getText();
    }

    public String getCheckoutFinishedBodyFirstLine(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getWebCheckoutFinishedBodyFirst().getText();
    }

    public String getCheckoutFinishedBodySecondLine(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getWebCheckoutFinishedBodySecond().getText();
    }

    public String getCheckoutFinishedBodyThirdLine(){
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return getWebCheckoutFinishedBodyThird().getText();
    }

    public String getCheckoutFinishedContinueButton(){
        return getWebCheckoutFinishedContinueButton().getText();
    }

    public void gotoStoreOwnerComparePage(){
        getWebCheckoutFinishedBodySecond().click();
    }

    public void clickCheckoutFinishedContinueButton(){
        getWebCheckoutFinishedContinueButton().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

}
