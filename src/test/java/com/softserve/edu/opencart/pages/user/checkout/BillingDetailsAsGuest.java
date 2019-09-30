package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.checkout.PersonalDetailsForCheckoutRegistration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingDetailsAsGuest extends CheckOutOptions{

    private WebElement element;
    private BillingDetailsFilling methods;

    public BillingDetailsAsGuest(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        methods = new BillingDetailsFilling(driver);
    }

    public DeliveryDetails billingDetailsAndRegistrationPartFilling(IUser user){
        methods.clickContinueCheckoutAsRegistrationButton();
        methods.personalInfoAndAddressFilling(user);
        methods.clickContinueCheckoutAsRegistrationButton();
        return new DeliveryDetails(driver);
    }

    public PaymentMethod billingDetailsAsGuestPartFillingWithoutDelivery(IUser user){
        methods.personalInfoAndAddressFilling(user);
        methods.clickContinueCheckoutAsGuestButton();
        return new PaymentMethod(driver);
    }

    public DeliveryDetails billingDetailsAsGuestPartFilling(IUser user){
        methods.personalInfoAndAddressFilling(user);
        methods.clickContinueCheckoutAsGuestButton();
        return new DeliveryDetails(driver);
    }

    class BillingDetailsFilling extends PersonalDetailsForCheckoutRegistration{
        public BillingDetailsFilling(WebDriver driver) {
            super(driver);

        }

    }

}

