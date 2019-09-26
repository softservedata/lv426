package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.checkout.PersonalDetailsForCheckoutRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingDetailsAsGuest extends CheckOutOptions{

    private WebDriver driver;
    private WebElement element;
    private BillingDetailsFilling methods;

    public BillingDetailsAsGuest(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        methods = new BillingDetailsFilling(driver);
    }

    public void billingDetailsPartFilling(IUser user){
        methods.personalInfoAndAddressFilling(user);
        methods.clickContinueCheckoutButton();
    }

    class BillingDetailsFilling extends PersonalDetailsForCheckoutRegistration{
        public BillingDetailsFilling(WebDriver driver) {
            super(driver);
        }

    }

}

