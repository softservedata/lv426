package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.shop.CountryForEstimation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ShippingTaxesComponent extends ShoppingCartPage {

    protected WebDriver driver;
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
        taxConfirmAlert = driver.findElement(By.cssSelector("div.modal-content label input"));
        cancelButtonTaxAlert = driver.findElement(By.cssSelector("div.modal-footer  button"));
        applyButtonTaxAlert = driver.findElement(By.cssSelector("div.modal-footer  input"));
        flatRateInAlert = driver.findElement(By.cssSelector("div.modal-content label"));
    }

    // Page Object

    // Functional

    public void selectCountryForEstimation(String countryName) {
        countryForShippingAndTaxes = new Select(driver.findElement(By.cssSelector("#input-country")));
        driver.findElement(By.cssSelector("#input-country")).click();
        countryForShippingAndTaxes.selectByVisibleText(countryName);
    }

    public void selectRegionForEstimation(String regionName) {
        regionForShippingAndTaxes = new Select(driver.findElement(By.cssSelector("#input-country")));
        driver.findElement(By.cssSelector("#input-country")).click();
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
        return flatRateInAlert.getText();
    }

    public void applyTaxRateInAlert() {
        applyButtonTaxAlert.click();
    }

    public void taxConfirmInAlertClick() {
        taxConfirmAlert.click();
    }

    public void cancelEstimationAlertClick() {
        cancelButtonTaxAlert.click();
    }

    // Business Logic
    public void inputPostCodeForEstimation(String postcode) {
        postCodeClick();
        postCodeClear();
        setPostCode(postcode);
    }

    // In this case, there is not any taxes
    public void estimationShoppingCartPageFals(CountryForEstimation countryForEstimation) {
        selectCountryForEstimation(countryForEstimation.getCountryName());
        selectRegionForEstimation(countryForEstimation.getRegionName());
        inputPostCodeForEstimation(countryForEstimation.getPostCode());
        getQuotesClick();
    }

    // In this case, there is a tax
    public void estimationShoppingCartPageTrue(CountryForEstimation countryForEstimation) {
        selectCountryForEstimation(countryForEstimation.getCountryName());
        selectRegionForEstimation(countryForEstimation.getRegionName());
        inputPostCodeForEstimation(countryForEstimation.getPostCode());
        getQuotesClick();
        taxConfirmInAlertClick();
        applyTaxRateInAlert();

    }
}
