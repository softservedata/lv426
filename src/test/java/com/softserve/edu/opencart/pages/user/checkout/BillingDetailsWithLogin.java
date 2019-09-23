package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.CheckOutRepository;
import com.softserve.edu.opencart.data.checkout.NewAddressForCheckOut;
import com.softserve.edu.opencart.data.checkout.NewShippingAdress;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.data.checkout.NewAddressForCheckOut.NEW_BILLING_ADRESS;

public class BillingDetailsWithLogin extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;

    private WebElement continueBillingButton;
    private FillingNewAddressBillingDeatails formInputs;

    public BillingDetailsWithLogin(WebDriver driver) {
        super(driver);
        initElements();

    }

    private void initElements(){
        continueBillingButton = driver.findElement(By.cssSelector("input#button-payment-address"));
        formInputs = new FillingNewAddressBillingDeatails(driver,NEW_BILLING_ADRESS);
    }

    /**
     * Method fully input a billing part
     * with log in user
     */
    public void billingDetailsFullyDone(){
        formInputs.method.fullIputs(CheckOutRepository.get().validAdress());
        continueBillingButtonClick();
    }

    public void continueBillingButtonClick(){
        continueBillingButton.click();
    }

    class FillingNewAddressBillingDeatails extends NewAddressForCheckOut {
        private WebDriver driver;
        private String path = NEW_BILLING_ADRESS;
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
