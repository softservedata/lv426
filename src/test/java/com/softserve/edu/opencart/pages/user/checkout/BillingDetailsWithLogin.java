package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.CheckOutRepository;
import com.softserve.edu.opencart.data.checkout.NewAddressForCheckOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.softserve.edu.opencart.data.checkout.CheckOutRepository.NEW_BILLING_ADDRESS_CSSSELECTOR;


public class BillingDetailsWithLogin extends CheckOutOptions {

    private WebElement element;

    private WebElement continueBillingButton;
    private WebElement existingAddressCheckBox;
    private WebElement newAddressCheckBox;
    private FillingNewAddressBillingDetails formInputs;
    private Select chooseBillingAccount;
    private WebElement billingAccount;

    public BillingDetailsWithLogin(WebDriver driver) {
        super(driver);
        initElements();

    }

    private void initElements(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 5)).until(ExpectedConditions
        .elementToBeClickable(By.cssSelector("input#button-payment-address")));
        continueBillingButton = driver.findElement(By.cssSelector("input#button-payment-address"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        formInputs = new FillingNewAddressBillingDetails(driver,NEW_BILLING_ADDRESS_CSSSELECTOR);
        existingAddressCheckBox = driver
                .findElement(By.cssSelector("input[name=\"payment_address\"][value=\"existing\"]"));
        newAddressCheckBox = driver
                .findElement(By.cssSelector("input[name=\"payment_address\"][value=\"new\"]"));
        billingAccount = driver.findElement(By.cssSelector("div#payment-existing select.form-control"));
    }

    /**
     * Method fully input a billing part
     * with log in user
     */
    public DeliveryDetails billingDetailsFullyDone(){
        chooseNewAddressCreationBillingDetails();
        formInputs.method.fullInputs(CheckOutRepository.get().validAddress());
        continueBillingButtonClick();
        return new DeliveryDetails(driver);
    }

    public DeliveryDetails billingDetailsUsingExistingAddress(String value){
        chooseExistingAddressBillingDetails();
        setChooseBillingAccount(value);
        continueBillingButtonClick();
        return new DeliveryDetails(driver);
    }

    public void chooseNewAddressCreationBillingDetails(){
        newAddressCheckBox.click();
    }

    public void chooseExistingAddressBillingDetails(){
        existingAddressCheckBox.click();
    }

    public void setChooseBillingAccount(String value){
        chooseBillingAccount = new Select(billingAccount);
        billingAccount.click();
        chooseBillingAccount.selectByValue(value);
    }

    public void continueBillingButtonClick(){
        continueBillingButton.click();
    }

    class FillingNewAddressBillingDetails extends NewAddressForCheckOut {
        private WebDriver driver;
        private String path = NEW_BILLING_ADDRESS_CSSSELECTOR;
        private NewAddressForCheckOut method;

        FillingNewAddressBillingDetails(WebDriver driver, String path ){
            super(driver,path);
            initElements();
        }

        private void initElements(){
            method = new NewAddressForCheckOut(driver,path);
        }


    }
}
