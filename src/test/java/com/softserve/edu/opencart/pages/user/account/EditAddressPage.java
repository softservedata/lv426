package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAddressPage extends AccountSidebarLoggedPart {

    /**
     * This variable is input field FirstName
     */
    private WebElement firstname;

    /**
     * This variable is input field LastName
     */
    private WebElement lastname;

    /**
     * This variable is input field Company
     */
    private WebElement company;

    /**
     * This variable is input field First Address
     */
    private WebElement firstAddress;

    /**
     * This variable is input field Second Address
     */
    private WebElement secondAddress;

    /**
     * This variable is input field City
     */
    private WebElement city;

    /**
     * This variable is input field PostCode
     */
    private WebElement postcode;

    /**
     * This variable is dropdown menu Country
     */
    private WebElement country;

    /**
     * This variable is dropdown menu Region/Stait
     */
    private WebElement zone;

    /**
     * This variable is yes button for check Default Address
     */
    private WebElement yesButton;

    /**
     * This variable is no button for check Default Address
     */
    private WebElement noButton;

    /**
     * This variable is Continue button
     */
    private WebElement continueButton;

    /**
     * This variable is Back button
     */
    private WebElement backButton;

    /**
     * This variable for catching message about something error in firs input field
     */
    private WebElement errorText;

    public EditAddressPage(WebDriver driver, WebElement firstname) {
        super(driver);
        initElements();
    }

    private void initElements() {
        this.firstname = driver.findElement(By.id("input-firstname"));
        this.lastname = driver.findElement(By.id("input-lastname"));
        this.company = driver.findElement(By.id("input-company"));
        this.firstAddress = driver.findElement(By.name("address_1"));
        this.secondAddress = driver.findElement(By.name("address_2"));
        this.city = driver.findElement(By.id("input-city"));
        this.postcode = driver.findElement(By.id("input-postcode"));
        this.country = driver.findElement(By.id("input-country"));
        this.zone = driver.findElement(By.id("input-zone"));
        this.yesButton = driver.findElement(By.xpath(
                "//input[@name ='default' and @value ='1']"));
        this.noButton = driver.findElement(By.xpath(
                "//input[@name ='default' and @value ='0']"));
        this.continueButton = driver.findElement(
                By.xpath("//input[@class='btn btn-primary']"));
        this.backButton = driver.findElement(
                By.xpath("//a[@class='btn btn-default']"));
        this.errorText = driver.findElement(
                By.xpath("//div[contains(@class,'text-danger')]"));
    }


    /**
     * This method for input text in field FirstName
     */
    public void inputFirstname(String text) {
        firstname.click();
        firstname.clear();
        firstname.sendKeys(text);
    }

    /**
     * This method for input text in field LastName
     */
    public void inputLastname(String text) {
        lastname.click();
        lastname.clear();
        lastname.sendKeys(text);
    }

    /**
     * This method for input text in field Company
     */
    public void inputCompany(String text) {
        company.click();
        company.clear();
        company.sendKeys(text);
    }

    /**
     * This method for input text in field First Address
     */
    public void inputAddress1(String text) {
        firstAddress.click();
        firstAddress.clear();
        firstAddress.sendKeys(text);
    }

    /**
     * This method for input text in field Second Address
     */
    public void inputAddress2(String text) {
        secondAddress.click();
        secondAddress.clear();
        secondAddress.sendKeys(text);
    }

    /**
     * This method for input text in field City
     */
    public void inputCity(String text) {
        city.click();
        city.clear();
        city.sendKeys(text);
    }

    /**
     * This method for input text in field Postcode
     */
    public void inputPostcode(String text) {
        postcode.click();
        postcode.clear();
        postcode.sendKeys(text);
    }

    /**
     * This method for select from dropdown menu Country element equal @param text
     */
    public void selectCountry(String text) {
        String xpath = String.format("//option[text()='%s']", text);
        country = country.findElement(By.xpath(xpath));
        country.click();
    }

    /**
     * This method for click on button Continue
     */
    public void clickContinueButton() {
        continueButton.click();
    }

    /**
     * This method for select from dropdown menu Country element equal @param text
     */
    public void selectZone(String text) {
        String xpath = String.format("//option[text()='%s']", text);
        zone = zone.findElement(By.xpath(xpath));
        zone.click();
    }

    /**
     * This method for click on button Yes if check Default Address
     */
    public void clickYesDefault() {
        yesButton.click();
    }

    /**
     * This method for click on button No if check Default Address
     */
    public void clickNoDefault() {
        noButton.click();
    }

    /**
     * This method for click on button Back
     */
    public void clickBackButton() {
        backButton.click();
    }

    /**
     * This method for catch text from error message in firs input field
     */
    public String getErrorText() {
        return errorText.getText();
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getCompany() {
        return company;
    }

    public WebElement getFirstAddress() {
        return firstAddress;
    }

    public WebElement getSecondAddress() {
        return secondAddress;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getPostcode() {
        return postcode;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getZone() {
        return zone;
    }
}


