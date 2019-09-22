package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.PersonalDetailsForCheckoutRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountAndBillingDetails extends CheckOutPage {

    private WebDriver driver;
    private WebElement element;

    public AccountAndBillingDetails(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

    }

    class AccountRegister extends  PersonalDetailsForCheckoutRegistration{
        private WebDriver driver;
        private WebElement element;

        AccountRegister(WebDriver driver){
            super(driver);
            initElements();
        }

        private void initElements(){

        }

    }
}
