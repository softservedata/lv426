package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturnsOrderInfo {

    private WebDriver driver;

    private WebElement firstname;

    private WebElement lastname;

    private WebElement email;

    private WebElement phone;

    private WebElement orderId;

    private WebElement orderDate;

    public ReturnsOrderInfo(WebDriver driver) {
        this.driver =  driver;
        initElements();
    }

    private void initElements() {
        this.firstname = driver.findElement(By.id("input-firstname"));
        this.lastname = driver.findElement(By.id("input-lastname"));
        this.email = driver.findElement(By.id("input-email"));
        this.phone = driver.findElement(By.id("input-telephone"));
        this.orderId = driver.findElement(By.id("input-order-id"));
        this.orderDate =
                driver.findElement(By.id("input-date-ordered"));
    }


    public void clickFirstname() {
        firstname.click();
    }

    public void clickLastname() {
        lastname.click();
    }

    public void clickEmail() {
        email.click();
    }

    public void clickPhone() {
        phone.click();
    }

    public void clickOrderId() {
        orderId.click();
    }

    public void clickOrderDate() {
        orderDate.click();
    }


    public void setFirstname(String firstname) {
        clickFirstname();
        this.firstname.clear();
        this.firstname.sendKeys(firstname);
    }

    public void setLastname(String lastname) {
        clickLastname();
        this.lastname.clear();
        this.lastname.sendKeys(lastname);
    }

    public void setEmail(String email) {
        clickEmail();
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void setPhone(String phone) {
        clickPhone();
        this.phone.clear();
        this.phone.sendKeys(phone);
    }

    public void setOrderId(String orderId) {
        clickOrderId();
        this.orderId.clear();
        this.orderId.sendKeys(orderId);
    }

    public void setOrderDate(String orderDate) {
        clickOrderDate();
        this.orderDate.clear();
        this.orderDate.sendKeys(orderDate);
    }
}
