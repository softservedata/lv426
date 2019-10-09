package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CustomersPage extends LeftSidebarMenuComponent {
    private WebElement customerNameField;
    private WebElement filterButton;

    public CustomersPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        customerNameField = driver.findElement(By.id("input-name"));
        filterButton = driver.findElement(By.id("button-filter"));
    }

    // Page Object
    //customerNameField
    public WebElement getCustomerNameField() {
        return customerNameField;
    }

    public void clearCustomerNameField() {
        getCustomerNameField().clear();
    }

    public void clickCustomerNameField() {
        getCustomerNameField().click();
    }

    public void setCustomerNameField(String text) {
        getCustomerNameField().sendKeys(text);
    }

    // filterButton
    public WebElement getFilterButton() {
        return filterButton;
    }

    public void clickFilterButton() {
        getFilterButton().click();
    }

    //unlockButton
    public WebElement getUnlockButton() {
        return driver.findElement(By.cssSelector("a.btn.btn-warning"));
    }

    public void clickUnlockButton() {
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(getUnlockButton()));
        getUnlockButton().click();
    }

    //Functional
    public void filterCustomer(IUser user) {
        clickCustomerNameField();
        clearCustomerNameField();
        setCustomerNameField(user.getFirstName() + " " + user.getLastName());
        clickFilterButton();
    }

    public void unlockUser(IUser user) {
        filterCustomer(user);

        clickUnlockButton();
    }

}
