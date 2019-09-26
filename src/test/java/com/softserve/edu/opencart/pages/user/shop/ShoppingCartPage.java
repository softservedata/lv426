package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.shop.FinalPriceTable;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.checkout.CheckOutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        shoppingCartTableTitle = driver.findElement(By.xpath("//div[@id='content']/h1"));
        useCouponDropDown = driver.findElement(By.xpath("//a[contains(text(),'Use Coupon Code ')]"));
        giftCertificationDropDown = driver.findElement(By.xpath("//a[contains(text(),'Use Gift')]"));
        checkoutButton = driver.findElement(By.cssSelector("div.pull-right a[class=\"btn btn-primary\"]"));
        continueShoppingButton = driver.findElement(By.cssSelector("div.pull-left a"));
        shippingAndTaxes = driver.findElement(By.xpath("//div[contains(@class,'panel panel-default')]" +
                "//a[contains(text(),'Estimate Shipping & Taxes')]"));
        update = driver.findElement(By.cssSelector("button[type=submit]"));
        delete = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//tbody//td/div/span/button[contains(@class,'btn btn-danger')]"));
        for (WebElement elements : driver.findElements(By.cssSelector(FINAL_PRICE_TABLE_CSSSELECTOR))) {
            new FinalPriceTable(elements,driver);
        }
    }

    // Page Object

    // Functional

    //returns with hooks
    public String getWeightOfOrdering() {
        return shoppingCartTableTitle.getText().replaceAll("\\D+\\s", "");
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
        shippingAndTaxes.click();
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
        continueShoppingButton.click();
        return new HomePage(driver);
    }

    public CheckOutPage checkoutButtonClick() {
        checkoutButton.click();
        return new CheckOutPage(driver);
    }

    public DiscountComponent useCouponClick() {
        useCouponDropDown.click();
        return new DiscountComponent(driver);
    }

    public DiscountComponent giftCertificationClick() {
        giftCertificationDropDown.click();
        return new DiscountComponent(driver);
    }
    public ShoppingCartContainerComponent tryToChangeSomething(){
        return new ShoppingCartContainerComponent(driver);
    }

    // Business Logic
}
