package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownLogged {

	private WebDriver driver;
	//
	private WebElement myAccount;
	private WebElement orderHistory;
	private WebElement transactions;
	private WebElement downloads;
	private WebElement logout;
	
    protected DropdownLogged(WebDriver driver) {
        this.driver = driver;
        initElements();
    }
    
    private void initElements() {
    	//TODO +++++++++++++++++++++++++++++++++++
    	myAccount = driver.findElement(By.cssSelector(""));
    	orderHistory = driver.findElement(By.cssSelector(""));
    	transactions = driver.findElement(By.cssSelector(""));
    	downloads = driver.findElement(By.cssSelector(""));
    	logout = driver.findElement(By.cssSelector(""));
    }

	// Page Object

	// myAccount
    public WebElement getMyAccount() {
    	//return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return myAccount;
    }

    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    public void clickMyAccount() {
        getMyAccount().click();
    }

	// orderHistory
    public WebElement getOrderHistory() {
    	//return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return orderHistory;
    }

    public String getOrderHistoryText() {
        return getOrderHistory().getText();
    }

    public void clickOrderHistory() {
        getOrderHistory().click();
    }

	// transactions
    public WebElement getTransactions() {
    	//return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return transactions;
    }

    public String getTransactionsText() {
        return getTransactions().getText();
    }

    public void clickTransactions() {
        getTransactions().click();
    }

	// downloads
    public WebElement getDownloads() {
        return downloads;
    }

    public String getDownloadsText() {
        return getDownloads().getText();
    }

    public void clickDownloads() {
        getDownloads().click();
    }

	// logout
    public WebElement getLogout() {
    	//return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return logout;
    }

    public String getLogoutText() {
        return getLogout().getText();
    }

    public void clickLogout() {
        getLogout().click();
    }

	// Functional

	// Business Logic

}
