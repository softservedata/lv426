package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulEditAccountPage extends AccountSidebarLoggedPart {

    public static final String EXPECTED_WRONG_FIRSTNAME = "First Name must be between 1 and 32 characters!";
    public static final String EXPECTED_WRONG_LASTNAME = "Last Name must be between 1 and 32 characters!";
    public static final String EXPECTED_WRONG_EMAIL = "E-Mail Address does not appear to be valid!";
    public static final String EXPECTED_WRONG_TELEPHONE = "Telephone must be between 3 and 32 characters!";

    UnsuccessfulEditAccountPage(WebDriver driver) {
        super(driver);
    }

    // Page Object

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
        return driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"));
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
}
