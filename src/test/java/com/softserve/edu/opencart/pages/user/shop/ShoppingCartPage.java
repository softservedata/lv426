package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.shop.FinalPriceComponentContainer;
import com.softserve.edu.opencart.data.shop.FinalPriceTableComponent;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.checkout.CheckOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BreadCrumbPart {
    private WebElement productTable;
    private FinalPriceTableComponent finalPriceTableComponent;
    //
    private WebElement closeFatalAlertButton;
    private WebElement closeSuccessAlertButton;
    //alerts
    private WebElement fatalAlert;
    private WebElement successAlert;
    //price table
    private String FINAL_PRICE_TABLE_CSSSELECTOR = "div[class=\"col-sm-4 col-sm-offset-8\"] table tbody tr";
    private List<FinalPriceTableComponent> finalPriceTableComponentElements;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        finalPriceTableComponentElements = new ArrayList<>();
        for (WebElement elements : driver.findElements(By.cssSelector(FINAL_PRICE_TABLE_CSSSELECTOR))) {
            finalPriceTableComponentElements.add(new FinalPriceTableComponent(elements,driver));
        }
    }

    // Page Object

    public void refreshShoppingCart(){
        driver.navigate().refresh();
    }

    public HomePage gotoHomePageFromShoppingCart() {
        clickLogo();
        return new HomePage(driver);
    }

    private WebElement getWebTitleOfEmptyCart(){
        return driver.findElement(By.cssSelector("div#content h1"));
    }

    private WebElement getWebBodyOfEmptyCart(){
        return driver.findElement(By.cssSelector("div#content  p"));
    }
    //
    private WebElement getWebContinueEmptyCartButton(){
        return driver.findElement(By.cssSelector("div[class=\"buttons clearfix\"] div.pull-right a"));
    }

    private WebElement getWebShoppingCartTableTitle(){
        return driver.findElement(By.xpath("//div[@id='content']/h1"));
    }

    private WebElement getWebUseCouponDropDown(){
        return driver.findElement(By.xpath("//a[contains(text(),'Use Coupon Code ')]"));
    }

    private WebElement getWebGiftCertificationDropDown(){
        return driver.findElement(By.xpath("//a[contains(text(),'Use Gift')]"));
    }

    private WebElement getWebCheckoutButton(){
        return driver.findElement(By.cssSelector("div.pull-right a[class=\"btn btn-primary\"]"));
    }

    private WebElement getWebContinueShoppingButton(){
        return driver.findElement(By.cssSelector("div.pull-left a"));
    }

    private WebElement getWebShippingAndTaxes(){
        return driver.findElement(By.xpath("//div[contains(@class,'panel panel-default')]" +
                "//a[contains(text(),'Estimate Shipping & Taxes')]"));
    }

    private WebElement getWebUpdate(){
        return driver.findElement(By.cssSelector("button[type=submit]"));
    }

    private WebElement getWebDelete(){
        return driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//tbody//td/div/span/button[contains(@class,'btn btn-danger')]"));
    }

    // Functional

    public String getBodyOfEmptyCart(){
        return getWebBodyOfEmptyCart().getText();
    }

    public String getTitleOfEmptyCart(){
        return getWebTitleOfEmptyCart().getText();
    }

    public List<FinalPriceTableComponent> getFinalPriceTableComponentElements(){
        return finalPriceTableComponentElements;
    }

    public FinalPriceComponentContainer getFinalPricaContainer(){
        return new FinalPriceComponentContainer(getFinalPriceTableComponentElements());
    }

    //returns with hooks
    public String getWeightOfOrdering() {
        return getWebShoppingCartTableTitle().getText().replaceAll("\\D+\\s", "");
    }

    public ShoppingCartPage closeOneDangerAlert() {
        closeFatalAlertButton = driver.findElement(By.cssSelector("div[class=\"alert alert-danger\"] button.close"));
        closeFatalAlertButton.click();
        return new ShoppingCartPage(driver);
    }
    public ShoppingCartPage closeOneSucccessAlert(){
        closeSuccessAlertButton = driver.findElement(By.cssSelector("div[class=\"alert alert-success\"] button.close"));
        closeSuccessAlertButton.click();
        return new ShoppingCartPage(driver);
    }

    public ShippingTaxesComponent shippingAndTaxesClick() {
        getWebShippingAndTaxes().click();
        return new ShippingTaxesComponent(driver);
    }

    public String getTextFromWarnAlert() {
        fatalAlert = driver.findElement(By.cssSelector("div[class=\"alert alert-danger\"]"));
        return fatalAlert.getText();
    }

    public String getTextFtomSuccessAlert() {
        successAlert = driver.findElement(By.cssSelector("div[class=\"alert alert-success\"]"));
        return successAlert.getText();
    }

    public HomePage continueShoppingButtonClick() {
        getWebContinueShoppingButton().click();
        return new HomePage(driver);
    }

    public CheckOutPage checkoutButtonClick() {
        getWebCheckoutButton().click();
        return new CheckOutPage(driver);
    }

    public DiscountComponent useCouponClick() {
        getWebUseCouponDropDown().click();
        return new DiscountComponent(driver);
    }

    public DiscountComponent giftCertificationClick() {
        getWebGiftCertificationDropDown().click();
        return new DiscountComponent(driver);
    }
    public ShoppingCartContainerComponent tryToChangeSomething(){
        return new ShoppingCartContainerComponent(driver);
    }

    public FinalPriceTableComponent getFinalPriceTableComponent(){
        return finalPriceTableComponent;
    }

    // Business Logic
}
