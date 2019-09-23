package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditAccountPage extends AccountSidebarLoggedPart {

    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement telephone;
    private WebElement fax;
    private WebElement continueButton;

    public EditAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        firstName = driver.findElement(By.name("firstname"));
        lastName = driver.findElement(By.name("lastname"));
        email = driver.findElement(By.name("email"));
        telephone = driver.findElement(By.name("telephone"));
        fax = driver.findElement(By.name("fax"));
        continueButton = driver.findElement(By.cssSelector("div.buttons.clearfix div.pull-right input"));
    }

    // Page Object

    //firstname
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

    //lastname
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

    //continueButtom
    public WebElement getContinueButton() {
        return continueButton;
    }

    public void clickContinueButtonn() {
        getContinueButton().click();
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

    // Business Logic
    public MyAccountPage fillEditAccount(IUser user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.geteMail());
        enterTelephone(user.getTelephone());
        enterFax(user.getFax());

        clickContinueButtonn();
        return new MyAccountPage(driver);
    }
}
