package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.shop.CountryForEstimation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingTaxesComponent extends ShoppingCartPage {

    private WebDriverWait explicitWait;

    private Select countryForShippingAndTaxes;
    private Select regionForShippingAndTaxes;
    private WebElement postcodeForShippingAndTaxes;
    private WebElement getQuotesButton;
    //alerts elements
    private WebElement taxConfirmAlert;
    private WebElement cancelButtonTaxAlert;
    private WebElement applyButtonTaxAlert;
    private WebElement flatRateInAlert;

    public ShippingTaxesComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        postcodeForShippingAndTaxes = driver.findElement(By.cssSelector("#input-postcode"));
        getQuotesButton = driver.findElement(By.cssSelector("button[id=\"button-quote\"]"));
    }

    // Page Object

    // Functional

    public void selectCountryForEstimation(String countryName) {
        countryForShippingAndTaxes = new Select(driver.findElement(By.cssSelector("#input-country")));
        driver.findElement(By.cssSelector("#input-country")).click();
        countryForShippingAndTaxes.selectByVisibleText(countryName);
    }

    public void selectRegionForEstimation(String regionName) {
        regionForShippingAndTaxes = new Select(driver.findElement(By.cssSelector("#input-zone")));
        driver.findElement(By.cssSelector("#input-zone")).click();
        regionForShippingAndTaxes.selectByVisibleText(regionName);
    }

    private void postCodeClick() {
        postcodeForShippingAndTaxes.click();
    }

    private void postCodeClear() {
        postcodeForShippingAndTaxes.clear();
    }

    private void setPostCode(String postcode) {
        postcodeForShippingAndTaxes.sendKeys(postcode);
    }


    public void getQuotesClick() {
        getQuotesButton.click();
    }


    //Tax alert
    public String getFlatRateFromAlert() {
        flatRateInAlert = driver.findElement(By.cssSelector("div.modal-content label"));
        return flatRateInAlert.getText();
    }

    public void applyTaxRateInAlert() {
        applyButtonTaxAlert = driver.findElement(By.cssSelector("div.modal-footer  input"));
        applyButtonTaxAlert.click();
    }

    public ShoppingCartPage taxConfirmInAlertClick() {
        taxConfirmAlert = driver.findElement(By.cssSelector("div.modal-content label input"));
        taxConfirmAlert.click();
        return new ShoppingCartPage(driver);
    }

    public void cancelEstimationAlertClick() {
        cancelButtonTaxAlert = driver.findElement(By.cssSelector("div.modal-footer  button"));
        cancelButtonTaxAlert.click();
    }

    // Business Logic
    public void inputPostCodeForEstimation(String postcode) {
        postCodeClick();
        postCodeClear();
        setPostCode(postcode);
    }

    // In this case, there is not any taxes
    public ShoppingCartPage estimationShoppingCartPageFals(CountryForEstimation countryForEstimation) {
        selectCountryForEstimation(countryForEstimation.getCountryName());
        selectRegionForEstimation(countryForEstimation.getRegionName());
        inputPostCodeForEstimation(countryForEstimation.getPostCode());
        getQuotesClick();
        return new ShoppingCartPage(driver);
    }

    // In this case, there is a tax
    public ShoppingCartPage estimationShoppingCartPageTrue(CountryForEstimation countryForEstimation) {
        selectCountryForEstimation(countryForEstimation.getCountryName());
        selectRegionForEstimation(countryForEstimation.getRegionName());
        inputPostCodeForEstimation(countryForEstimation.getPostCode());
        getQuotesClick();
        taxConfirmInAlertClick();
        applyTaxRateInAlert();
        return new ShoppingCartPage(driver);
    }
}
