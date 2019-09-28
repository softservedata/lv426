package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.checkout.PersonalDetailsForCheckoutRegistration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingDetailsWithRegistration extends CheckOutOptions{

    private WebDriver driver;
    private WebElement element;

    private WebElement newsLetterCheckBox;
    private WebElement shippingAdressCheckBox;
    private WebElement privacyPolicyCheckBox;
    private WebElement privacyPolicyLink;
    private WebElement password;
    private WebElement passwordConfirm;
    private AccountRegister methods;

    public BillingDetailsWithRegistration(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        methods = new AccountRegister(driver);
    }

    public DeliveryDetails accountAndBillingDetailsFilling(IUser user){
        methods.personalInfoAndAddressFilling(user);
        methods.clickContinueCheckoutButton();
        return new DeliveryDetails(driver);
    }

    class AccountRegister extends PersonalDetailsForCheckoutRegistration {
        private WebDriver driver;
        private WebElement element;

        AccountRegister(WebDriver driver) {
            super(driver);
            initElements();
        }

        protected void initElements() {
            passwordConfirm = driver.findElement(By.cssSelector("input#input-payment-confirm"));
            password = driver.findElement(By.cssSelector("div[class=\"form-group required\"] input[name=\"password\"]"));
            newsLetterCheckBox = driver.findElement(By.cssSelector("input#newsletter"));
            shippingAdressCheckBox = driver.findElement(By.cssSelector("input[name=\"shipping_address\"]"));
            privacyPolicyCheckBox = driver.findElement(By.cssSelector("input[name=\"agree\"]"));
            privacyPolicyLink = driver.findElement(By.cssSelector("a.agree"));
        }
        //Functional

        public void confirmPrivacyPolicyCheckBox(){
            privacyPolicyCheckBox.click();
        }

        public void confirmNewsLetterCheckBox(){
            newsLetterCheckBox.click();
        }

        public void confirmShippingAddressCheckBox(){
            shippingAdressCheckBox.click();
        }

        public void clickPasswordField(){
            password.click();
        }

        public void clearPasswordField(){
            password.clear();
        }

        public void setPasswordField(String passwordField){
            password.sendKeys();
        }

        public void clickPasswordConfirmField(){
            passwordConfirm.click();
        }

        public void clearPasswordConfirmField(){
            passwordConfirm.clear();
        }

        public void setPasswordConfirmField(String passwordField){
            passwordConfirm.sendKeys();
        }

        //BA

        public void setPasswordAndPasswordConfirm(String password){
            clickPasswordField();
            clearPasswordField();
            setPasswordField(password);
            clickPasswordConfirmField();
            clearPasswordConfirmField();
            setPasswordConfirmField(password);
        }
        @Override
        public void personalInfoAndAddressFilling(IUser user) {
            firstNameFill(user.getFirstName());
            lastNameFill(user.getLastName());
            eMailFill(user.geteMail());
            telephoneFill(user.getTelephone());
            faxFill(user.getFax());
            companyFill(user.getCompany());
            adress1Fill(user.getAddress1());
            adress2Fill(user.getAddress2());
            cityFill(user.getCity());
            postcodeFill(user.getPostCode());
            setCountry(user.getCountry());
            setState(user.getRegionState());
            setPasswordAndPasswordConfirm(user.getPassword());
            confirmNewsLetterCheckBox();
            confirmShippingAddressCheckBox();
            confirmPrivacyPolicyCheckBox();
        }

    }
}
