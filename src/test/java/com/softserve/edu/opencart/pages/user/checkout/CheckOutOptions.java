package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutOptions extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;

    private WebElement registerCheckBox;
    private WebElement guestCheckBox;
    private WebElement eMailInput;
    private WebElement passwordInput;
    private WebElement forgottenPasswordLink;
    private WebElement continueCheckOutOptionsButton;
    private WebElement loginCheckOutOptionsButton;


    public CheckOutOptions(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
    }

    // Page object

    private WebElement getWebRegisterCheckBox(){
        return driver.findElement(By.cssSelector("input[value=\"register\"]"));
    }
    private WebElement getWebGuestCheckBox(){
        return driver.findElement(By.cssSelector("input[value=\"guest\"]"));
    }
    private WebElement getWebeMailInput(){
        return driver.findElement(By.cssSelector("input#input-email"));
    }
    private WebElement getWebPasswordInput(){
        return driver.findElement(By.cssSelector("input#input-password"));
    }
    private WebElement getWebForgottenPasswordLink (){
        return driver.findElement(By.xpath("//a[contains(text(),'Forgotten')]"));
    }
    private WebElement getWebContinueCheckOutOptionsButton(){
        return driver.findElement(By.cssSelector("input#button-account"));
    }
    private WebElement getWebLoginCheckOutOptionsButton(){
        return driver.findElement(By.cssSelector("input#button-login"));
    }

    public void eMailInputClick() {
        getWebeMailInput().click();
    }

    public void eMailInputClear() {
        getWebeMailInput().clear();
    }

    public void setEMailInput(String email) {
        getWebeMailInput().sendKeys(email);
    }

    public void passwordInputClick() {
        getWebPasswordInput().click();
    }

    public void passwordInputClear() {
        getWebPasswordInput().clear();
    }

    public void setPasswordInput(String password) {
        getWebPasswordInput().sendKeys(password);
    }

    //functional
    public void continueCheckOutOptionsButtonClick() {
        (new WebDriverWait(driver, 3)).until(ExpectedConditions
                .elementToBeClickable( getWebContinueCheckOutOptionsButton()));
        getWebContinueCheckOutOptionsButton().click();
    }

    public void loginCheckOutOptionsButtonClick() {
        getWebLoginCheckOutOptionsButton().click();
    }

    public void chooseRegisterCheckBox() {
        getWebRegisterCheckBox().click();
    }

    public void chooseGuestCheckBox() {
        getWebGuestCheckBox().click();
    }

    public void forgottenPasswordLinkClick(){
        getWebForgottenPasswordLink().click();
    }

//business logic

    public BillingDetailsWithLogin loginAsUser(User user){
        eMailInputClick();
        eMailInputClear();
        setEMailInput(user.geteMail());
        passwordInputClick();
        passwordInputClear();
        setPasswordInput(user.getPassword());
        loginCheckOutOptionsButtonClick();
        return new BillingDetailsWithLogin(driver);
    }

    public BillingDetailsAsGuest continueCheckoutAsGuest(){
        chooseGuestCheckBox();
        continueCheckOutOptionsButtonClick();
        return new BillingDetailsAsGuest(driver);
    }

    public BillingDetailsWithRegistration continueCheckoutWithRegistration(){
        chooseRegisterCheckBox();
        continueCheckOutOptionsButtonClick();
        return new BillingDetailsWithRegistration(driver);
    }




}
