package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends AccountSidebarGuestPart {

    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement telephone;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement fax;
    private WebElement company;
    private WebElement address01;
    private WebElement address02;
    private WebElement city;
    private WebElement postcode;
    private WebElement regionState;
    private WebElement country;
    private WebElement subscribe;
    private WebElement continueButton;
    private WebElement agreePrivacyPolicyLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        firstName = driver.findElement(By.name("firstname"));
        lastName = driver.findElement(By.name("lastname"));
        email = driver.findElement(By.name("email"));
        telephone = driver.findElement(By.name("telephone"));
        password = driver.findElement(By.name("password"));
        confirmPassword = driver.findElement(By.name("confirm"));
        fax = driver.findElement(By.name("fax"));
        company = driver.findElement(By.name("company"));
        address01 = driver.findElement(By.name("address_1"));
        address02 = driver.findElement(By.name("address_2"));
        city = driver.findElement(By.name("city"));
        postcode = driver.findElement(By.name("postcode"));
        continueButton = driver.findElement(By.cssSelector("div.buttons div.pull-right input.btn.btn-primary"));
        agreePrivacyPolicyLink = driver.findElement(By.name("agree"));
        regionState = driver.findElement(By.id("input-zone"));
        country = driver.findElement(By.id("input-country"));
        subscribe = driver.findElement(By.cssSelector("label.radio-inline input"));
    }

    // Page Object

    //firstName
    public WebElement getFirstName() {
        return firstName;
    }

    public void clickFirstNameField() {
        getFirstName().click();
    }

    public void clearFirstNameField() {
        getFirstName().clear();
    }

    public void setFirstName(String firstName) {
        getFirstName().sendKeys(firstName);
    }

    //lastName
    public WebElement getLastName() {
        return lastName;
    }

    public void clickLastNameField() {
        getLastName().click();
    }

    public void clearLastNameField() {
        getLastName().clear();
    }

    public void setLastName(String lastName) {
        getLastName().sendKeys(lastName);
    }

    //email
    public WebElement getEmail() {
        return email;
    }

    public void clickEmailField() {
        getEmail().click();
    }

    public void clearEmailField() {
        getEmail().clear();
    }

    public void setEmail(String email) {
        getEmail().sendKeys(email);
    }

    //telephone
    public WebElement getTelephone() {
        return telephone;
    }

    public void clickTelephoneField() {
        getTelephone().click();
    }

    public void clearTelephoneField() {
        getTelephone().clear();
    }

    public void setTelephone(String telephone) {
        getTelephone().sendKeys(telephone);
    }

    //fax
    public WebElement getFax() {
        return fax;
    }

    public void clickFaxField() {
        getFax().click();
    }

    public void clearFaxField() {
        getFax().clear();
    }

    public void setFax(String fax) {
        getFax().sendKeys(fax);
    }

    //company
    public WebElement getCompany() {
        return company;
    }

    public void clickCompanyField() {
        getCompany().click();
    }

    public void clearCompanyField() {
        getCompany().clear();
    }

    public void setCompany(String company) {
        getCompany().sendKeys(company);
    }

    //address01
    public WebElement getAddress01() {
        return address01;
    }

    public void clickAddress01Field() {
        getAddress01().click();
    }

    public void clearAddress01Field() {
        getAddress01().clear();
    }

    public void setAddress01(String address01) {
        getAddress01().sendKeys(address01);
    }

    //address02
    public WebElement getAddress02() {
        return address02;
    }

    public void clickAddress02Field() {
        getAddress02().click();
    }

    public void clearAddress02Field() {
        getAddress02().clear();
    }

    public void setAddress02(String address02) {
        getAddress01().sendKeys(address02);
    }

    //city
    public WebElement getCity() {
        return city;
    }

    public void clickCityField() {
        getCity().click();
    }

    public void clearCityField() {
        getCity().clear();
    }

    public void setCity(String city) {
        getCity().sendKeys(city);
    }

    //postcode
    public WebElement getPostcode() {
        return postcode;
    }

    public void clickPostcodeField() {
        getPostcode().click();
    }

    public void clearPostcodeField() {
        getPostcode().clear();
    }

    public void setPostcode(String postcode) {
        getPostcode().sendKeys(postcode);
    }

    //country
    public WebElement getCountry() {
        return country;
    }

    public void clickCountryField() {
        getCountry().click();
    }

    public void setCountry(String country) {
        getCountry().sendKeys(country);
    }

    //regionState
    public WebElement getRegionState() {
        return regionState;
    }

    public void clickRegionStateField() {
        getRegionState().click();
    }

    public void setRegionState(String zone) {
        getRegionState().sendKeys(zone);
    }

    //password
    public WebElement getPassword() {
        return password;
    }

    public void clickPasswordField() {
        getPassword().click();
    }

    public void clearPasswordField() {
        getPassword().clear();
    }

    public void setPassword(String password) {
        getPassword().sendKeys(password);
    }

    //confirmPassword
    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public void clickConfirmPasswordField() {
        getConfirmPassword().click();
    }

    public void clearConfirmPasswordField() {
        getConfirmPassword().clear();
    }

    public void setConfirmPassword(String confirmPassword) {
        getConfirmPassword().sendKeys(confirmPassword);
    }

    //continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    //agreePrivacyPolicyLink
    public WebElement getAgreePrivacyPolicyLink() {
        return agreePrivacyPolicyLink;
    }

    public void clickAgreePrivacyPolicyLink() {
        getAgreePrivacyPolicyLink().click();
    }

    //subscribe
    public WebElement getSubscribeLink() {
        return subscribe;
    }

    public void clickSubscribeLink(Boolean subscribe) {
        if (subscribe) {
            getSubscribeLink().click();
        }
    }

    public void defaultLogin(IUser user) {
    }

    // Functional

    private void enterFirstName(String firstname) {
        clickFirstNameField();
        clearFirstNameField();
        setFirstName(firstname);
    }

    private void enterLastName(String lastname) {
        clickLastNameField();
        clearLastNameField();
        setLastName(lastname);
    }

    private void enterEmail(String email) {
        clickEmailField();
        clearEmailField();
        setEmail(email);
    }

    private void enterTelephone(String phone) {
        clickTelephoneField();
        clearTelephoneField();
        setTelephone(phone);
    }

    private void enterFax(String fax) {
        clickFaxField();
        clearFaxField();
        setFax(fax);
    }

    private void enterCompany(String company) {
        clickCompanyField();
        clearCompanyField();
        setCompany(company);
    }

    private void enterAddress01(String address) {
        clickAddress01Field();
        clearAddress01Field();
        setAddress01(address);
    }

    private void enterAddress02(String address) {
        clickAddress02Field();
        clearAddress02Field();
        setAddress02(address);
    }

    private void enterCity(String city) {
        clickCityField();
        clearCityField();
        setCity(city);
    }

    private void enterPostcode(String postcode) {
        clickPostcodeField();
        clearPostcodeField();
        setPostcode(postcode);
    }

    private void enterCountry(String country) {
        clickCountryField();
        setCountry(country);
    }

    private void enterRegionState(String regionState) {
        clickRegionStateField();
        setRegionState(regionState);
    }

    private void enterPassword(String password) {
        clickPasswordField();
        clearPasswordField();
        setPassword(password);
    }

    private void enterConfirmPassword(String confirmPassword) {
        clickConfirmPasswordField();
        clearConfirmPasswordField();
        setConfirmPassword(confirmPassword);
    }

    public void fillRegister(IUser user) {

        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.geteMail());
        enterTelephone(user.getTelephone());
        enterFax(user.getFax());

        enterCompany(user.getCompany());
        enterAddress01(user.getAddress1());
        enterAddress02(user.getAddress2());
        enterCity(user.getCity());
        enterPostcode(user.getPostCode());
        enterCountry(user.getCountry());
        enterRegionState(user.getRegionState());

        enterPassword(user.getPassword());
        enterConfirmPassword(user.getPassword());
        clickSubscribeLink(user.isSubscribe());
    }

    public void fillRegisterInvalidConfirmPassword(IUser user) {
        fillRegister(user);
        enterConfirmPassword(user.getPassword() + "qwerty");
        clickAgreePrivacyPolicyLink();
        clickContinueButton();
    }

    public void fillRegisterAgreePrivacyPolicy(IUser user) {
        fillRegister(user);
        clickAgreePrivacyPolicyLink();
        clickContinueButton();
    }

    public void fillRegisterNotAgreePrivacyPolicy(IUser user) {
        fillRegister(user);
        clickContinueButton();
    }

    // Business Logic
    public SuccessfulRegisterPage successfulRegisterUser(IUser user) {

        fillRegisterAgreePrivacyPolicy(user);
        return new SuccessfulRegisterPage(driver);
    }

    public UnsuccessfulRegisterPage unsuccessfulConfirmPasswordRegisterUser(IUser user) {

        fillRegisterInvalidConfirmPassword(user);
        return new UnsuccessfulRegisterPage(driver);
    }

    public UnsuccessfulRegisterPage unsuccessfulRegisterNotAgreePrivacyPolicy(IUser user) {

        fillRegisterNotAgreePrivacyPolicy(user);
        return new UnsuccessfulRegisterPage(driver);
    }

    public UnsuccessfulRegisterPage unsuccessfulRegisterUser(IUser invalidUser) {

        fillRegisterAgreePrivacyPolicy(invalidUser);
        return new UnsuccessfulRegisterPage(driver);
    }

}
