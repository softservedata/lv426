package com.softserve.edu.opencart.data.checkout;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class NewAddressForCheckOut {
    private String cssPath;
    private WebElement element;
    private WebDriver driver;


    private WebElement firstNameBilling;
    private WebElement lastNameBilling;
    private WebElement companyBilling;
    private WebElement address1Billing;
    private WebElement address2Billing;
    private WebElement cityBilling;
    private WebElement postcodeBilling;
    private WebElement countryBilling;
    private Select countrySelect;
    private WebElement stateBilling;
    private Select stateSelect;

    public NewAddressForCheckOut(WebDriver driver, String cssPath){
        this.driver = driver;
        this.cssPath = cssPath;
        initElements(cssPath);
    }

    private void initElements(String cssPath){
        firstNameBilling = driver.findElement(By.cssSelector(cssPath + "firstname"));
        lastNameBilling = driver.findElement(By.cssSelector(cssPath + "lastname"));
        companyBilling = driver.findElement(By.cssSelector(cssPath + "company"));
        countryBilling = driver.findElement(By.cssSelector(cssPath + "country"));
        address1Billing = driver.findElement(By.cssSelector(cssPath + "address-1"));
        address2Billing = driver.findElement(By.cssSelector(cssPath + "address-2"));
        cityBilling = driver.findElement(By.cssSelector(cssPath + "city"));
        postcodeBilling = driver.findElement(By.cssSelector(cssPath + "postcode"));
        stateBilling = driver.findElement(By.cssSelector(cssPath + "zone"));
    }

    //Page object

    public void setFirstName(String firstName){
        firstNameBilling.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastNameBilling.sendKeys(lastName);
    }

    public void setCompany(String сompany){
        companyBilling.sendKeys(сompany);
    }

    public void setAddress1(String address1){
        address1Billing.sendKeys(address1);
    }

    public void setAddress2(String address2){
        address2Billing.sendKeys(address2);
    }

    public void setCity(String city){
        cityBilling.sendKeys(city);
    }

    public void setPostcode(String postcode){
        postcodeBilling.sendKeys(postcode);
    }


    //functional

    public void stateClick(){
        stateBilling.click();
    }
    public void postcodeClick(){
        postcodeBilling.click();
    }
    public void postcodeClear(){
        postcodeBilling.clear();
    }
    public void cityClick(){
        cityBilling.click();
    }
    public void cityClear(){
        cityBilling.clear();
    }
    public void address2Click(){
        address2Billing.click();
    }
    public void address2Clear(){
        address2Billing.clear();
    }

    public void address1Click(){
        address1Billing.click();
    }
    public void address1Clear(){
        address1Billing.clear();
    }
    public void companyClick(){
        companyBilling.click();
    }
    public void companyClear(){
        companyBilling.clear();
    }
    public void countryClick(){
        countryBilling.click();
    }
    public void lastNameClick(){
        lastNameBilling.click();
    }
    public void lastNameClear(){
        lastNameBilling.clear();
    }
    public void firstNameClick(){
        firstNameBilling.click();
    }
    public void firstNameClear(){
        firstNameBilling.clear();
    }
    //Business logic
    public void firstNameBillingInput(NewShippingAdress address){
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
        address2Clear();
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
        countrySelect = new Select(countryBilling);
        countryClick();
        countrySelect.selectByVisibleText(address.getCountryShipping());
    }

    public void stateBillingInput(NewShippingAdress address){
        stateSelect = new Select(stateBilling);
        stateClick();
        stateSelect.selectByVisibleText(address.getStateShipping());
    }

    public void fullIputs(NewShippingAdress address){
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

