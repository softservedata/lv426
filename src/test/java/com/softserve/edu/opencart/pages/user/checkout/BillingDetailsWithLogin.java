package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.CheckOutRepository;
import com.softserve.edu.opencart.data.checkout.NewAddressForCheckOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.softserve.edu.opencart.data.checkout.CheckOutRepository.NEW_BILLING_ADDRESS_CSSSELECTOR;


public class BillingDetailsWithLogin extends CheckOutOptions {

    private WebDriver driver;
    private WebElement element;

    private WebElement continueBillingButton;
    private WebElement existingAddressCheckBox;
    private WebElement newAddressCheckBox;
    private FillingNewAddressBillingDeatails formInputs;
    private Select chooseBillingAccount;
    private WebElement billingAccount;

    public BillingDetailsWithLogin(WebDriver driver) {
        super(driver);
        initElements();

    }

    private void initElements(){
        continueBillingButton = driver.findElement(By.cssSelector("input#button-payment-address"));
        formInputs = new FillingNewAddressBillingDeatails(driver,NEW_BILLING_ADDRESS_CSSSELECTOR);
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
        formInputs.method.fullInputs(CheckOutRepository.get().validAdress());
        continueBillingButtonClick();
        return new DeliveryDetails(driver);
    }

    public void chooseNewAddressCreationBillingDetails(){
        newAddressCheckBox.click();
    }

    public void chooseExsistingAddressBillingDetails(){
        existingAddressCheckBox.click();
    }

    public void setChooseBillingAccount(String fullAcc){
        chooseBillingAccount = new Select(billingAccount);
        billingAccount.click();
        chooseBillingAccount.selectByVisibleText(fullAcc);
    }

    public void continueBillingButtonClick(){
        continueBillingButton.click();
    }

    class FillingNewAddressBillingDeatails extends NewAddressForCheckOut {
        private WebDriver driver;
        private String path = NEW_BILLING_ADDRESS_CSSSELECTOR;
        private NewAddressForCheckOut method;

        FillingNewAddressBillingDeatails(WebDriver driver, String path ){
            super(driver,path);
            initElements();
        }

        private void initElements(){
            method = new NewAddressForCheckOut(driver,path);
        }


    }
}
