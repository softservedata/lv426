package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.shop.FinalPriceTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BreadCrumbPart {
    private WebElement productTable;
    //
    private WebElement closeFatalAlertButton;
    private WebElement closeSuccessAlertButton;
    private WebElement shoppingCartTableTitle;
    private WebElement shippingAndTaxes;
    private WebElement useCouponDropDown;
    private WebElement giftCertificationDropDown;
    private WebElement continueShoppingButton;
    private WebElement checkoutButton;
    //shopping cart table
    public WebElement update;
    public WebElement delete;
    //alerts
    private WebElement fatalAlert;
    private WebElement successAlert;
    //price table
    private String FINAL_PRICE_TABLE_CSSSELECTOR = "div[class=\"col-sm-4 col-sm-offset-8\"] table tbody";

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        closeFatalAlertButton = driver.findElement(By.cssSelector("div[class=\"alert alert-danger\"] button.close"));
        closeSuccessAlertButton = driver.findElement(By.cssSelector("div[class=\"alert alert-success\"] button.close"));
        shoppingCartTableTitle = driver.findElement(By.xpath("//div[@id='content']/h1"));
        useCouponDropDown = driver.findElement(By.xpath("//a[contains(text(),'Use Coupon Code ')]"));
        giftCertificationDropDown = driver.findElement(By.xpath("//a[contains(text(),'Use Gift')]"));
        checkoutButton = driver.findElement(By.cssSelector("div.pull-right a[class=\"btn btn-primary\"]"));
        continueShoppingButton = driver.findElement(By.cssSelector("div.pull-left a"));
        shippingAndTaxes = driver.findElement(By.xpath("//div[contains(@class,'panel panel-default')]" +
                "//a[contains(text(),'Estimate Shipping & Taxes')]"));
        update = driver.findElement(By.xpath("button[type=submit]"));
        delete = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//tbody//td/div/span/button[contains(@class,'btn btn-danger')]"));
        fatalAlert = driver.findElement(By.cssSelector("div[class=\"alert alert-danger\"]"));
        successAlert = driver.findElement(By.cssSelector("div[class=\"alert alert-success\"]"));
        for (WebElement elements : driver.findElements(By.cssSelector(FINAL_PRICE_TABLE_CSSSELECTOR))) {
            new FinalPriceTable(elements);
        }
    }

    // Page Object

    // Functional

        //returns with hooks
    public String getWeightOfOrdering(){
        return shoppingCartTableTitle.getText().replaceAll("\\D+\\s","");
    }

    public void closeOneAlert(){
        closeFatalAlertButton.click();
    }

    public void shippingAndTaxesClick() {
        shippingAndTaxes.click();
    }

    public String getTextFromWarnAlert() {
        return fatalAlert.getText();
    }

    public String getTextFtomSuccessAlert() {
        return successAlert.getText();
    }

    public void continueShoppingButtonClick() {
        continueShoppingButton.click();
    }

    public void checkoutButtonClick() {
        checkoutButton.click();
    }

    public void useCouponeClick() {
        useCouponDropDown.click();
    }

    public void giftCertificationClick() {
        giftCertificationDropDown.click();
    }

    // Business Logic
}
