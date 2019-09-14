package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarPart extends BreadCrumbPart {

    protected WebElement myAccount;
    protected WebElement login;
    protected WebElement register;
    protected WebElement forgottenPassword;
    protected WebElement editAccount;
    protected WebElement changePassword;
    protected WebElement addressBook;
    protected WebElement wishList;
    protected WebElement orderHistory;
    protected WebElement downloads;
    protected WebElement recurringPayments;
    protected WebElement rewardPoints;
    protected WebElement returns;
    protected WebElement transactions;
    protected WebElement newsletter;
    protected WebElement logOut;


    public AccountSidebarPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        login = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Login')]"));
        register = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Register')]"));
        forgottenPassword = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Forgotten Password')]"));
        myAccount = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'My Account')]"));
        editAccount = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Edit Account')]"));
        changePassword = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Password')]"));
        addressBook = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Address Book')]"));
        wishList = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Wish List')]"));
        orderHistory = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Order History')]"));
        downloads = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Downloads')]"));
        recurringPayments = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Recurring payments')]"));
        rewardPoints = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Reward Points')]"));
        returns = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Returns')]"));
        transactions = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Transactions')]"));
        newsletter = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Newsletter')]"));
        logOut = driver.findElement(By.xpath("//div[contains(@class,'list-group')]/a[contains(text(), 'Logout')]"));
    }

    // Page Object

    // Functional

    // Business Logic
}
