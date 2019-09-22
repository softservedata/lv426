package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        initElements();
    }

    private void initElements() {
        registerCheckBox = driver.findElement(By.cssSelector("input[value=\"register\"]"));
        guestCheckBox = driver.findElement(By.cssSelector("input[value=\"guest\"]"));
        eMailInput = driver.findElement(By.cssSelector("input#input-email"));
        passwordInput = driver.findElement(By.cssSelector("input#input-password"));
        forgottenPasswordLink = driver.findElement(By.xpath("//a[contains(text(),'Forgotten')]"));
        continueCheckOutOptionsButton = driver.findElement(By.cssSelector("input#button-account"));
        loginCheckOutOptionsButton = driver.findElement(By.cssSelector("input#button-login"));
    }

    // Page object

    public void eMailInputClick() {
        eMailInput.click();
    }

    public void eMailInputClear() {
        eMailInput.clear();
    }

    public void setEMailInput(String email) {
        eMailInput.sendKeys(email);
    }

    public void passwordInputClick() {
        passwordInput.click();
    }

    public void passwordInputClear() {
        passwordInput.clear();
    }

    public void setPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    //functional
    public void continueCheckOutOptionsButtonClick() {
        continueCheckOutOptionsButton.click();
    }

    public void loginCheckOutOptionsButtonClick() {
        loginCheckOutOptionsButton.click();
    }

    public void chooseRegisterCheckBox() {
        registerCheckBox.click();
    }

    public void chooseGuestCheckBox() {
        guestCheckBox.click();
    }

    public void forgottenPasswordLinkClick(){
        forgottenPasswordLink.click();
    }

//business logic

    public void loginAsUser(User user){
        eMailInputClick();
        eMailInputClear();
        setEMailInput(user.geteMail());
        passwordInputClick();
        passwordInputClear();
        setPasswordInput(user.getPassword());
        loginCheckOutOptionsButtonClick();
    }

    public void continueCheckoutAsGuest(){
        chooseGuestCheckBox();
        continueCheckOutOptionsButtonClick();
    }

    public void continueCheckoutWithRegistration(){
        chooseRegisterCheckBox();
        continueCheckOutOptionsButtonClick();
    }


}
