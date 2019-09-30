package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.data.shop.DiscountUsageCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiscountComponent extends ShoppingCartPage {

    private WebElement couponCodeInputField;
    private WebElement couponCodeApplyButton;
    private WebElement giftCertificationInputField;
    private WebElement giftCertificationApplyButton;

    public DiscountComponent(WebDriver driver) {
        super(driver);
    }



    // Page Object

    // Functional

    //coupon manipulation
    public void couponCodeInputsClick() {
        couponCodeInputField = driver.findElement(By.cssSelector("div#collapse-coupon input.form-control"));
        couponCodeInputField.click();
    }

    public void couponCodeInputsClear() {
        couponCodeInputField = driver.findElement(By.cssSelector("div#collapse-coupon input.form-control"));
        couponCodeInputField.clear();
    }

    public void setCouponCodeInputs(String couponCode) {
        couponCodeInputField = driver.findElement(By.cssSelector("div#collapse-coupon input.form-control"));
        couponCodeInputField.sendKeys(couponCode);
    }

    public void applyCouponButtonClick() {
        couponCodeApplyButton = driver.findElement(By.cssSelector("div#collapse-coupon input#button-coupon"));
        couponCodeApplyButton.click();
    }

    //gift certification manipulation
    public void giftCertificationInputFieldClick() {
        giftCertificationInputField = driver.findElement(By.cssSelector("div.panel-body input[name=\"voucher\"]"));
        giftCertificationInputField.click();
    }

    public void giftCertificationInputFieldClear() {
        giftCertificationInputField = driver.findElement(By.cssSelector("div.panel-body input[name=\"voucher\"]"));
        giftCertificationInputField.clear();
    }

    public void setGiftCertificationInputField(String giftCertification) {
        giftCertificationInputField = driver.findElement(By.cssSelector("div.panel-body input[name=\"voucher\"]"));
        giftCertificationInputField.sendKeys(giftCertification);
    }

    public void giftCertificationApplyButtonClick() {
        giftCertificationApplyButton = driver.findElement(By.cssSelector("div.panel-body input[type=\"submit\"]"));
        giftCertificationApplyButton.click();
    }

    // Business Logic
    public ShoppingCartPage couponCodeInputsAndApplying(DiscountUsageCode code){
        couponCodeInputsClick();
        couponCodeInputsClear();
        setCouponCodeInputs(code.getCouponCode());
        applyCouponButtonClick();
        return new ShoppingCartPage(driver);
    }

    public ShoppingCartPage giftCertificationInputsAndApplying(DiscountUsageCode gift){
        giftCertificationInputFieldClick();
        giftCertificationInputFieldClear();
        setGiftCertificationInputField(gift.getGiftCertificationCode());
        giftCertificationApplyButtonClick();
        return new ShoppingCartPage(driver);
    }
}
