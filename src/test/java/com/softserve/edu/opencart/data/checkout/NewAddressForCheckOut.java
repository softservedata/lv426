package com.softserve.edu.opencart.data.checkout;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class NewAddressForCheckOut {
    private String cssPath;
    private WebElement element;
    private WebDriver driver;

    private Select countrySelect;
    private Select stateSelect;

    public NewAddressForCheckOut(WebDriver driver, String cssPath){
        this.driver = driver;
        this.cssPath = cssPath;
    }


    //Page object

    public void setFirstName(String firstName){
        getWebFirstNameBilling().sendKeys(firstName);
    }

    public void setLastName(String lastName){
        getWebLastNameBilling().sendKeys(lastName);
    }

    public void setCompany(String сompany){
        getWebCompanyBilling().sendKeys(сompany);
    }

    public void setAddress1(String address1){
        getWebAddress1Billing().sendKeys(address1);
    }

    public void setAddress2(String address2){
        getWebAddress2Billing().sendKeys(address2);
    }

    public void setCity(String city){
        getWebCityBilling().sendKeys(city);
    }

    public void setPostcode(String postcode){
        getWebPostcodeBilling().sendKeys(postcode);
    }


    //functional

    private WebElement getWebFirstNameBilling(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver,10)).until(ExpectedConditions
        .elementToBeClickable(By.cssSelector(cssPath + "firstname")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.findElement(By.cssSelector(cssPath + "firstname"));
    }

    private WebElement getWebLastNameBilling(){
        return driver.findElement(By.cssSelector(cssPath + "lastname"));
    }

    private WebElement getWebCompanyBilling(){
        return driver.findElement(By.cssSelector(cssPath + "company"));
    }

    private WebElement getWebCountryBilling(){
        return driver.findElement(By.cssSelector(cssPath + "country"));
    }

    private WebElement getWebAddress1Billing(){
        return driver.findElement(By.cssSelector(cssPath + "address-1"));
    }

    private WebElement getWebAddress2Billing(){
        return driver.findElement(By.cssSelector(cssPath + "address-2"));
    }

    private WebElement getWebCityBilling(){
        return driver.findElement(By.cssSelector(cssPath + "city"));
    }

    private WebElement getWebPostcodeBilling(){
        return driver.findElement(By.cssSelector(cssPath + "postcode"));
    }

    private WebElement getWebStateBilling(){
        return driver.findElement(By.cssSelector(cssPath + "zone"));
    }

    public void stateClick(){
        getWebStateBilling().click();
    }
    public void postcodeClick(){
        getWebPostcodeBilling().click();
    }
    public void postcodeClear(){
        getWebPostcodeBilling().clear();
    }
    public void cityClick(){
        getWebCityBilling().click();
    }
    public void cityClear(){
        getWebCityBilling().clear();
    }
    public void address2Click(){
        getWebAddress2Billing().click();
    }
    public void address2Clear(){
        getWebAddress2Billing().clear();
    }

    public void address1Click(){
        getWebAddress1Billing().click();
    }
    public void address1Clear(){
        getWebAddress1Billing().clear();
    }
    public void companyClick(){
        getWebCompanyBilling().click();
    }
    public void companyClear(){
        getWebCompanyBilling().clear();
    }
    public void countryClick(){
        getWebCountryBilling().click();
    }
    public void lastNameClick(){
        getWebLastNameBilling().click();
    }
    public void lastNameClear(){
        getWebLastNameBilling().clear();
    }
    public void firstNameClick(){
        (new WebDriverWait(driver,10)).until(ExpectedConditions
        .elementToBeClickable(getWebFirstNameBilling()));
        try {
            getWebFirstNameBilling().click();

        }catch (org.openqa.selenium.ElementClickInterceptedException ex){}
        getWebFirstNameBilling().click();
    }
    public void firstNameClear(){
        getWebFirstNameBilling().clear();
    }
    //Business logic
    public void firstNameBillingInput(NewShippingAdress address){
        (new WebDriverWait(driver, 2)).until(ExpectedConditions
                .elementToBeClickable(getWebFirstNameBilling()));
        firstNameClick();
        firstNameClear();
        setFirstName(address.getFirstNameShipping());
    }
    public void lastNameBillingInput(NewShippingAdress address){
        lastNameClick();
        lastNameClear();
        setLastName(address.getLastNameShipping());
    }

    public void companyBillingInput(NewShippingAdress address){
        companyClick();
        companyClear();
        setCompany(address.getCompanyShipping());
    }

    public void address1BillingInput(NewShippingAdress address){
        address1Click();
        address1Clear();
        setAddress1(address.getAddress1Shipping());
    }

    public void address2BillingInput(NewShippingAdress address){
        address2Click();
        address2Clear();
        setAddress2(address.getAddress1Shipping());
    }

    public void cityBillingInput(NewShippingAdress address){
        cityClick();
        cityClear();
        setCity(address.getCityShipping());
    }
    public void postcodeBillingInput(NewShippingAdress address){
        postcodeClick();
        postcodeClear();
        setPostcode(address.getPostcodeShipping());
    }

    public void countryBillingInput(NewShippingAdress address){
        countrySelect = new Select(getWebCountryBilling());
        countryClick();
        countrySelect.selectByVisibleText(address.getCountryShipping());
    }

    public void stateBillingInput(NewShippingAdress address){
        stateSelect = new Select(getWebStateBilling());
        stateClick();
        stateSelect.selectByVisibleText(address.getStateShipping());
    }

    public void fullInputs(NewShippingAdress address){
        firstNameBillingInput(address);
        lastNameBillingInput(address);
        companyBillingInput(address);
        address1BillingInput(address);
        address2BillingInput(address);
        cityBillingInput(address);
        postcodeBillingInput(address);
        countryBillingInput(address);
        stateBillingInput(address);
    }
}

