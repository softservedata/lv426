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

    public void setFirstnameErorr() {
        firstnameErorr = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'First')]"));
    }

    public void setLastnameError() {
        lastnameError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'Last')]"));
    }

    public void setAddressError() {
        addressError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'Address')]"));
    }

    public void setCityError() {
        cityError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'City')]"));
    }

    public void setPostcodeError() {
        cityError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'Postcode')]"));
    }

    public void setCountryError() {
        countryError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'country')]"));
    }

    public void setRegionError() {
        regionError = driver.findElement(By.xpath(
                "//div[@class='text-danger' and contains(text(), 'region')]"));
    }
}
