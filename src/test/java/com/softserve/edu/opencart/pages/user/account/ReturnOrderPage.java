package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReturnOrderPage extends AccountSidebarLoggedPart {

    private WebElement firstname;

    private WebElement lastname;

    private WebElement email;

    private WebElement phone;

    private WebElement orderId;

    private WebElement orderDate;

    private WebElement productName;

    private WebElement productCode;

    private WebElement quantity;

    /**
     * This variable for select Reason for returning on Return Order page
     */
    private WebElement returnReason;

    private WebElement productIsOpened;
    /**
     * This variable for button Submit on Return Order page
     */

    private WebElement detail;

    private WebElement submitButton;

    public ReturnOrderPage(WebDriver driver, WebElement firstname) {
        super(driver);
        initElements();
    }

    private void initElements() {
        this.firstname = driver.findElement(By.id("input-firstname"));
        this.lastname = driver.findElement(By.id("input-lastname"));
        this.email = driver.findElement(By.id("/input-email"));
        this.phone = driver.findElement(By.id("input-telephone"));
        this.orderId = driver.findElement(By.id("input-order-id"));
        this.orderDate =
                driver.findElement(By.id("input-date-ordered"));
        this.productName = driver.findElement(By.id("input-product"));
        this.productCode = driver.findElement(By.id("input-model"));
        this.quantity = driver.findElement(By.id("input-quantity"));
        this.productIsOpened = driver.findElement(
                By.xpath("//input[@name='opened' and @value='1']"));
        this.returnReason = driver.findElement(By.xpath(
                "//input[@name = 'return_reason_id' and @value = '1']"));
        this.detail = driver.findElement(By.name("comment"));
        this.submitButton = driver.findElement(
                By.xpath("//input[@class = 'btn btn-primary']"));
    }

    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getOrderId() {
        return orderId;
    }

    public WebElement getOrderDate() {
        return orderDate;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductCode() {
        return productCode;
    }

    public WebElement getQuantity() {
        return quantity;
    }

    public WebElement getReturnReason() {
        return returnReason;
    }

    public WebElement getProductIsOpened() {
        return productIsOpened;
    }

    public WebElement getDetail() {
        return detail;
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

    public void setProductName(String productName) {
        clickProductName();
        this.productName.clear();
        this.productName.sendKeys(productName);
    }

    public void setProductCode(String productCode) {
        clickProductCode();
        this.productCode.clear();
        this.productCode.sendKeys(productCode);
    }

    public void setQuantity(String quantity) {
        clickQuantity();
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public void setDetail(String detail) {
        clickDetail();
        this.detail.clear();
        this.detail.sendKeys(detail);
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

    public void clickProductName() {
        productName.click();
    }

    public void clickProductCode() {
        productCode.click();
    }

    public void clickQuantity() {
        quantity.click();
    }

    public void clickDetail() {
        detail.click();
    }

    public void clickProductIsOpened() {
        productIsOpened.click();
    }

    /**
     * This method select first Reason for Return Order
     */
    public void clickReturnReason() {
        returnReason.click();
    }

    /**
     * This method for click on button Submit
     */
    public void clickSubmitButton() {
        submitButton.click();
    }
}
