package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage extends LeftSidebarMenuComponent {
    private WebElement customerNameField;
    private WebElement filterButton;
    private WebElement unlockButton;

    public CustomersPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        customerNameField = driver.findElement(By.id("input-name"));
        filterButton = driver.findElement(By.id("button-filter"));
        unlockButton = driver.findElement(By.cssSelector("a.btn.btn-warning"));
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
        return unlockButton;
    }

    public void clickUnlockButton() {
        getUnlockButton().click();
    }

    //Functional
    private void filterCustomer(String text) {
        clickCustomerNameField();
        clearCustomerNameField();
        setCustomerNameField(text);
        clickFilterButton();
    }
    private void unlockUser() {
        clickUnlockButton();
    }


}
