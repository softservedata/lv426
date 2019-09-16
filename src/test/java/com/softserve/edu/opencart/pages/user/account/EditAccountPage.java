package com.softserve.edu.opencart.pages.user.account;

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

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getTelephone() {
        return telephone;
    }

    public WebElement getFax() {
        return fax;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }
    // Functional
    public void clickFirstNameField() {
        getFirstName().click();
    }

    public void clickLastNameField() {
        getLastName().click();
    }

    public void clickEmailField() {
        getEmail().click();
    }

    public void clickFaxField() {
        getFax().click();
    }

    public void clickTelephoneField() {
        getTelephone().click();
    }

    public void clickContinueButtonn() {
        getContinueButton().click();
    }

    public void clearFirstNameField() {
        getFirstName().clear();
    }

    public void clearLastNameField() {
        getLastName().clear();
    }

    public void clearEmailField() {
        getEmail().clear();
    }

    public void clearFaxField() {
        getFax().clear();
    }

    public void clearTelephoneField() {
        getTelephone().clear();
    }

    public void setFirstName(String firstName) {
        getFirstName().sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        getLastName().sendKeys(lastName);
    }

    public void setEmail(String email) {
        getEmail().sendKeys(email);
    }

    public void setTelephone(String telephone) {
        getTelephone().sendKeys(telephone);
    }

    public void setFax(String fax) {
        getFax().sendKeys(fax);
    }

    // Business Logic
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

    public MyAccountPage editAccountAs(String firstname, String lastname, String email,
                              String telephone, String fax) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(email);
        enterTelephone(telephone);
        enterFax(fax);

        clickContinueButtonn();
        return new MyAccountPage(driver);
    }
}
