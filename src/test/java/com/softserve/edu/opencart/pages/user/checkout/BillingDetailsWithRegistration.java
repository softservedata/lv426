package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.checkout.PersonalDetailsForCheckoutRegistration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.data.checkout.CheckOutRepository.PATH_FOR_BILLING_REGISTRATION_PATH;

public class BillingDetailsWithRegistration extends CheckOutOptions{

    private WebDriver driver;
    private WebElement element;

    private AccountRegister methods;

    public BillingDetailsWithRegistration(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        methods = new AccountRegister(driver);
    }

    public DeliveryDetails accountAndBillingDetailsFilling(IUser user){
//        driver.navigate().refresh();
        methods.personalInfoAndAddressFilling(user);
        methods.clickContinueCheckoutButton();
        return new DeliveryDetails(driver);
    }

    class AccountRegister extends PersonalDetailsForCheckoutRegistration {
        private WebDriver driver;
        private WebElement element;

        AccountRegister(WebDriver driver) {
            super(driver);
            this.driver = driver;
        }

        //Functional

        private WebElement getWebConfirmPassword(){
            return driver.findElement(By.cssSelector("input#input-payment-confirm"));
        }

        private WebElement getWebPassword(){
            return driver.findElement(By.cssSelector("div[class=\"form-group required\"] input[name=\"password\"]"));
        }
        private WebElement getWebNewsLetterCheckBox(){
            return driver.findElement(By.cssSelector("input#newsletter"));
        }
        private WebElement getWebShippingAdressCheckBox(){
            return driver.findElement(By.cssSelector("input[name=\"shipping_address\"]"));
        }
        private WebElement getWebPrivacyPolicyCheckBox(){
            return driver.findElement(By.cssSelector("input[name=\"agree\"]"));
        }

        private WebElement getWebPolicyLink(){
            return driver.findElement(By.cssSelector("a.agree"));
        }

        public void confirmPrivacyPolicyCheckBox(){
            getWebPrivacyPolicyCheckBox().click();
        }

        public void confirmNewsLetterCheckBox(){
            getWebNewsLetterCheckBox().click();
        }

        public void confirmShippingAddressCheckBox(){
            getWebShippingAdressCheckBox().click();
        }

        public void clickPasswordField(){
            getWebPassword().click();
        }

        public void clearPasswordField(){
            getWebPassword().clear();
        }

        public void setPasswordField(String passwordField){
            getWebPassword().sendKeys(passwordField);
        }

        public void clickPasswordConfirmField(){
            getWebConfirmPassword().click();
        }

        public void clearPasswordConfirmField(){
            getWebConfirmPassword().clear();
        }

        public void setPasswordConfirmField(String passwordField){
            getWebConfirmPassword().sendKeys(passwordField);
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
