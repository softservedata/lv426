package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulRegisterPage extends AccountSidebarGuestPart {


    public UnsuccessfulRegisterPage(WebDriver driver) {
        super(driver);
    }

    protected void defaultLogin(IUser user) {
    }

    // Page Object

    // wsrningBox
    private WebElement getWarningBox() {
        return driver.findElement(By.cssSelector("div.alert.alert-danger"));
    }

    public String getWarningBoxText() {
        return getWarningBox().getText();
    }

    //firstName
    private WebElement getWarningFirstName() {
        return driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"));
    }

    public String getWarningFirstNameText() {
        return getWarningFirstName().getText();
    }

    //lastName
    private WebElement getWarningLastName() {
        return driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"));
    }

    public String getWarningLastNameText() {
        return getWarningLastName().getText();
    }

    //email
    private WebElement getWarningEmail() {
        return driver.findElement(By.xpath("//div[contains(text(),E-Mail Address does not appear to be valid!')]"));
    }

    public String getWarningEmailText() {
        return getWarningEmail().getText();
    }

    //telephone
    private WebElement getWarningTelephone() {
        return driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"));
    }

    public String getWarningTelephoneText() {
        return getWarningTelephone().getText();
    }

    //address01
    private WebElement getWarningAddress01() {
        return driver.findElement(By.xpath("//div[contains(text(),'Address 1 must be between 3 and 128 characters!')]"));
    }

    public String getWarningAddress01Text() {
        return getWarningAddress01().getText();
    }

    //city
    private WebElement getWarningCity() {
        return driver.findElement(By.xpath("//div[contains(text(),'City must be between 2 and 128 characters!')]"));
    }

    public String getWarningCityText() {
        return getWarningCity().getText();
    }

    //postCode
    private WebElement getPostCodeCity() {
        return driver.findElement(By.xpath("//div[contains(text(),'Postcode must be between 2 and 10 characters!')]"));
    }

    public String getPostCodeCityText() {
        return getPostCodeCity().getText();
    }

    //regionState
    private WebElement getWarningRegionState() {
        return driver.findElement(By.xpath("//div[contains(text(),'Please select a region / state!')]"));
    }

    public String getWarningRegionStateText() {
        return getWarningRegionState().getText();
    }

    //password
    private WebElement getWarningPassword() {
        return driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"));
    }

    public String getWarningPasswordText() {
        return getWarningPassword().getText();
    }

    //passwordConfirm
    private WebElement getWarningConfirmPassword() {
        return driver.findElement(By.xpath("//div[contains(text(),'Password confirmation does not match password!')]"));
    }

    public String getWarningConfirmPasswordText() {
        return getWarningConfirmPassword().getText();
    }
}
