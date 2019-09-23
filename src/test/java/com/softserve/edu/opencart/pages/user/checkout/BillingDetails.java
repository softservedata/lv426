package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.checkout.PersonalDetailsForCheckoutRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BillingDetails extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;
    private BillingDetailsFilling methods;

    public BillingDetails(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        methods = new BillingDetailsFilling(driver);
    }

    public void billingDetailsPartFilling(IUser user){
        methods.personalInfoAndAdressFilling(user);
        methods.clickContinueCheckoutButton();
    }

    class BillingDetailsFilling extends PersonalDetailsForCheckoutRegistration{

        public BillingDetailsFilling(WebDriver driver) {
            super(driver);
        }

        public void setFirstName(String firtsName) {
            firstName.sendKeys(firtsName);
        }

        public void setLastName(String LastName) {
            lastName.sendKeys(LastName);
        }

        public void setEmail(String Email){
            email.sendKeys(Email);
        }

        public void setTelephone(String phone){
            telephone.sendKeys(phone);
        }

        public void setFax(String faxon){
            fax.sendKeys(faxon);
        }

        public void setCompany(String coop){
            company.sendKeys(coop);
        }

        public void setAddress01(String adress){
            address01.sendKeys(adress);
        }

        public void setAddress02(String adress){
            address02.sendKeys(adress);
        }

        public void setCity(String bigCity){
            city.sendKeys(bigCity);
        }

        public void setPostcode(String code){
            postcode.sendKeys(code);
        }

        public void setCountry(String bigCountry){
            countrySelect = new Select(country);
            clickCountryField();
            countrySelect.selectByVisibleText(bigCountry);
        }

        public void setState(String bigState){
            stateSelect = new Select(country);
            clickStateField();
            stateSelect.selectByVisibleText(bigState);}


        // Functional

        public void clickContinueCheckoutButton(){
            continueCheckoutButton.click();
        }

        public void clickFirstNameField() {
            firstName.click();
        }

        public void clickLastNameField() {
            lastName.click();
        }

        public void clickEmailField() {
            email.click();
        }

        public void clickFaxField() {
            fax.click();
        }

        public void clickTelephoneField() {
            telephone.click();
        }

        public void clickCompanyField() {
            company.click();
        }

        public void clickAddress01Field() {
            address01.click();
        }

        public void clickAddress02Field() {
            address02.click();
        }

        public void clickCityField() {
            city.click();
        }

        public void clickPostcodeField() {
            postcode.click();
        }

        public void clickCountryField() {
            country.click();
        }

        public void clickStateField() {
            state.click();
        }

        public void clearFirstNameField(){firstName.clear();}

        public void clearLastNameField() {
            lastName.clear();
        }

        public void clearEmailField() {
            email.clear();
        }

        public void clearFaxField() {
            fax.clear();
        }

        public void clearTelephoneField() {
            telephone.clear();
        }

        public void clearCompanyField() {
            company.clear();
        }

        public void clearAddress01Field() { address01.clear(); }

        public void clearAddress02Field() {
            address02.clear();
        }

        public void clearCityField() {
            city.clear();
        }

        public void clearPostcodeField() {
            postcode.clear();
        }


        // Business Logic

        public void firstNameFill(String firstName){
            clickFirstNameField();
            clearFirstNameField();
            setFirstName(firstName);
        }

        public void lastNameFill(String lastName){
            clickLastNameField();
            clearLastNameField();
            setLastName(lastName);
        }

        public void eMailFill(String eMail){
            clickEmailField();
            clearEmailField();
            setEmail(eMail);
        }
        public void telephoneFill(String telephone){
            clickTelephoneField();
            clearTelephoneField();
            setTelephone(telephone);
        }
        public void faxFill(String fax){
            clickFaxField();
            clearFaxField();
            setFax(fax);
        }
        public void companyFill(String company){
            clickCompanyField();
            clearCompanyField();
            setCompany(company);
        }
        public void adress1Fill(String adress1){
            clickAddress01Field();
            clearAddress01Field();
            setAddress01(adress1);
        }
        public void adress2Fill(String adress2){
            clickAddress02Field();
            clearAddress02Field();
            setAddress02(adress2);
        }
        public void cityFill(String city){
            clickCityField();
            clearCityField();
            setCity(city);
        }
        public void postcodeFill(String postcode){
            clickPostcodeField();
            clearPostcodeField();
            setPostcode(postcode);
        }


        public void personalInfoAndAdressFilling(IUser user){
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
            clickContinueCheckoutButton();
        }

    }



}
