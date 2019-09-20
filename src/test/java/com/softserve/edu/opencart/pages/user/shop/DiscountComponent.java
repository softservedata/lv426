package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.DiscountUsageCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountComponent extends ShoppingCartPage {

    protected WebDriver driver;

    private WebElement couponCodeInputField;
    private WebElement couponCodeApplyButton;
    private WebElement giftCertificationInputField;
    private WebElement giftCertificationApplyButton;

    public DiscountComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        couponCodeInputField = driver.findElement(By.cssSelector("div#collapse-coupon input.form-control"));
        couponCodeApplyButton = driver.findElement(By.cssSelector("div#collapse-coupon input#button-coupon"));
        giftCertificationInputField = driver.findElement(By.cssSelector("div.panel-body input[name=\"voucher\"]"));
        giftCertificationApplyButton = driver.findElement(By.cssSelector("div.panel-body input[type=\"submit\"]"));
    }

    // Page Object

    // Functional

    //coupon manipulation
    public void couponCodeInputsClick() {
        couponCodeInputField.click();
    }

    public void couponCodeInputsClear() {
        couponCodeInputField.clear();
    }

    public void setCouponCodeInputs(String couponCode) {
        couponCodeInputField.sendKeys(couponCode);
    }

    public void applyCouponButtonClick() {
        couponCodeApplyButton.click();
    }

    //gift certification manipulation
    public void giftCertificationInputFieldClick() {
        giftCertificationInputField.click();
    }

    public void giftCertificationInputFieldClear() {
        giftCertificationInputField.clear();
    }

    public void setGiftCertificationInputField(String giftCertification) {
        giftCertificationInputField.sendKeys(giftCertification);
    }

    public void giftCertificationApplyButtonClick() {
        giftCertificationApplyButton.click();
    }

    // Business Logic
    public void couponCodeInputsAndApplying(DiscountUsageCode code){
        couponCodeInputsClick();
        couponCodeInputsClear();
        setCouponCodeInputs(code.getCouponCode());
        applyCouponButtonClick();
    }

    public void giftCertificationInputsAndApplying(DiscountUsageCode gift){
        giftCertificationApplyButtonClick();
        giftCertificationInputFieldClear();
        setGiftCertificationInputField(gift.getGiftCertificationCode());
        giftCertificationApplyButtonClick();
    }
}
