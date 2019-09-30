package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAddressMessages extends EditAddressPage {

    private WebElement firstnameErorr;
    private WebElement lastnameError;
    private WebElement addressError;
    private WebElement cityError;
    private WebElement postcodeError;
    private WebElement countryError;
    private WebElement regionError;

    public EditAddressMessages(WebDriver driver) {
        super(driver);
    }


    public boolean editInitElements() {
        setFirstnameErorr();
        setLastnameError();
        setAddressError();
        setCityError();
        setCountryError();
        return true;
    }

    public boolean addInitElements() {
        setFirstnameErorr();
        setLastnameError();
        setAddressError();
        setCityError();
        setPostcodeError();
        setCountryError();
        return true;
    }


    private void setFirstnameErorr() {
        firstnameErorr = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'First')]"));
    }

    private void setLastnameError() {
        lastnameError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'Last')]"));
    }

    private void setAddressError() {
        addressError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'Address')]"));
    }

    private void setCityError() {
        cityError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'City')]"));
    }

    private void setPostcodeError() {
        cityError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'Postcode')]"));
    }

    private void setCountryError() {
        countryError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'country')]"));
    }

    public void setRegionError() {
        regionError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'region')]"));
    }


}
