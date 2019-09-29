package com.softserve.edu.opencart.data.checkout;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.softserve.edu.opencart.data.checkout.CheckOutRepository.PATH_FOR_BILLING_REGISTRATION_PATH;

public abstract class PersonalDetailsForCheckoutRegistration {
    private WebElement element;
    private WebDriver driver;


    protected Select countrySelect;
    protected Select stateSelect;

    public PersonalDetailsForCheckoutRegistration(WebDriver driver){
        this.driver = driver;
    }


    // Page Object

    public void setFirstName(String firtsName) {
        getWebFirstName().sendKeys(firtsName);
    }

    public void setLastName(String LastName) {
        getWebLastName().sendKeys(LastName);
    }

    public void setEmail(String Email){
        getWebEmail().sendKeys(Email);
    }

    public void setTelephone(String phone){
        getWebTelephone().sendKeys(phone);
    }

    public void setFax(String faxon){
        getWebFax().sendKeys(faxon);
    }

    public void setCompany(String coop){
        getWebCompany().sendKeys(coop);
    }

    public void setAddress01(String address){
        getWebAddress01().sendKeys(address);
    }

    public void setAddress02(String address){
        getWebAddress02().sendKeys(address);
    }

    public void setCity(String bigCity){
        getWebCity().sendKeys(bigCity);
    }

    public void setPostcode(String code){
        getWebPostcode().sendKeys(code);
    }

    public void setCountry(String bigCountry){
        countrySelect = new Select(getWebCountry());
        clickCountryField();
        countrySelect.selectByVisibleText(bigCountry);
    }

    public void setState(String bigState){
        stateSelect = new Select(getWebState());
        clickStateField();
        stateSelect.selectByVisibleText(bigState);}


    // Functional

    private WebElement getWebFirstName(){
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
        return driver.findElement(By.name("firstname"));
    }

    private WebElement getWebLastName(){
        return driver.findElement(By.name("lastname"));
    }

    private WebElement getWebEmail(){
//        (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        return driver.findElement(By.cssSelector("div[class=\"form-group required\"] input[name=\"email\"]"));
    }

    private WebElement getWebTelephone(){
        return driver.findElement(By.name("telephone"));
    }

    private WebElement getWebFax(){
        return driver.findElement(By.name("fax"));
    }

    private WebElement getWebCompany(){
        return driver.findElement(By.name("company"));
    }

    private WebElement getWebAddress01(){
        return driver.findElement(By.name("address_1"));
    }

    private WebElement getWebAddress02(){
        return driver.findElement(By.name("address_2"));
    }

    private WebElement getWebCity(){
        return driver.findElement(By.name("city"));
    }

    private WebElement getWebPostcode(){
        return driver.findElement(By.name("postcode"));
    }

    private WebElement getWebState(){
        return driver.findElement(By.cssSelector("select#input-payment-zone"));
    }

    private WebElement getWebCountry(){
        return driver.findElement(By.cssSelector("select#input-payment-country"));
    }

    private WebElement getWebContinueCheckoutButton(){
        return driver.findElement(By.cssSelector("input#button-register"));
    }


    public void clickContinueCheckoutButton(){
        getWebContinueCheckoutButton().click();
    }

    public void clickFirstNameField() {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions
                .elementToBeClickable(getWebFirstName()));
        getWebFirstName().click();
    }

    public void clickLastNameField() {
        getWebLastName().click();
    }

    public void clickEmailField() {
        getWebEmail().click();
    }

    public void clickFaxField() {
        getWebFax().click();
    }

    public void clickTelephoneField() {
        getWebTelephone().click();
    }

    public void clickCompanyField() {
        getWebCompany().click();
    }

    public void clickAddress01Field() {
        getWebAddress01().click();
    }

    public void clickAddress02Field() {
        getWebAddress02().click();
    }

    public void clickCityField() {
        getWebCity().click();
    }

    public void clickPostcodeField() {
        getWebPostcode().click();
    }

    public void clickCountryField() {
        getWebCountry().click();
    }

    public void clickStateField() {
        getWebState().click();
    }

    public void clearFirstNameField(){getWebFirstName().clear();}

    public void clearLastNameField() {
        getWebLastName().clear();
    }

    public void clearEmailField() {
        getWebEmail().clear();
    }

    public void clearFaxField() {
        getWebFax().clear();
    }

    public void clearTelephoneField() {
        getWebTelephone().clear();
    }

    public void clearCompanyField() {
        getWebCompany().clear();
    }

    public void clearAddress01Field() { getWebAddress01().clear(); }

    public void clearAddress02Field() {
        getWebAddress02().clear();
    }

    public void clearCityField() {
        getWebCity().clear();
    }

    public void clearPostcodeField() {
        getWebPostcode().clear();
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


    public void personalInfoAndAddressFilling(IUser user){
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
    }


}
