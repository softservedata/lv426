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
    private WebElement backButton;

    EditAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        firstName = driver.findElement(By.name("firstname"));
        lastName = driver.findElement(By.name("lastname"));
        email = driver.findElement(By.name("email"));
        telephone = driver.findElement(By.name("telephone"));
        fax = driver.findElement(By.name("fax"));
        continueButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
        backButton = driver.findElement(By.cssSelector("a.btn.btn-default"));
    }

    // Page Object

    //firstname
    private WebElement getFirstName() {
        return firstName;
    }

    private void clickFirstNameField() {
        getFirstName().click();
    }

    private void clearFirstNameField() {
        getFirstName().clear();
    }

    private void setFirstName(String firstName) {
        getFirstName().sendKeys(firstName);
    }

    public String getFirstNameText() { return getFirstName().getAttribute("value"); }

    //lastname
    private WebElement getLastName() { return lastName; }

    private void clickLastNameField() { getLastName().click(); }

    private void clearLastNameField() { getLastName().clear(); }

    private void setLastName(String lastName) { getLastName().sendKeys(lastName); }

    public String getLastNameText() { return getLastName().getAttribute("value"); }

    //email
    public WebElement getEmail() { return email; }

    private void clickEmailField() { getEmail().click(); }

    private void clearEmailField() { getEmail().clear(); }

    public void setEmail(String email) { getEmail().sendKeys(email); }

    public String getEmailText() { return getEmail().getAttribute("value"); }

    //telephone
    private WebElement getTelephone() { return telephone; }

    private void clickTelephoneField() { getTelephone().click(); }

    private void clearTelephoneField() { getTelephone().clear(); }

    private void setTelephone(String telephone) { getTelephone().sendKeys(telephone); }

    public String getTelephoneText() { return getTelephone().getAttribute("value"); }

    //fax
    private WebElement getFax() { return fax; }

    private void clickFaxField() { getFax().click(); }

    private void clearFaxField() { getFax().clear(); }

    private void setFax(String fax) { getFax().sendKeys(fax); }

    public String getFaxText() { return getFax().getAttribute("value"); }

    //continueButtom
    private WebElement getContinueButton() { return continueButton; }

    private void clickContinueButtonn() { getContinueButton().click(); }

    //backButton
    private WebElement getBackButton() { return backButton; }

    private void clickBackButton() { getBackButton().click(); }

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

    private void fillEditAccount(IUser user) {
        enterFirstName(user.getFirstName());
        enterLastName(user.getLastName());
        enterEmail(user.geteMail());
        enterTelephone(user.getTelephone());
        enterFax(user.getFax());
    }

    private void wrongFirstNameEditAccount(IUser user) {
        fillEditAccount(user);
        enterFirstName("");
    }

    // Business Logic
    public SuccessfulAccountEditPage successEditAccount(IUser user) {
        fillEditAccount(user);
        clickContinueButtonn();
        return new SuccessfulAccountEditPage(driver);
    }

    public MyAccountPage withoutSavingEditAccount(IUser user) {
        fillEditAccount(user);
        clickBackButton();
        return new MyAccountPage(driver);
    }

    public UnsuccessfulEditAccountPage unsuccessFirstNameEditAccount(IUser user) {
        wrongFirstNameEditAccount(user);
        clickContinueButtonn();
        return new UnsuccessfulEditAccountPage(driver);
    }
}
