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

import static com.softserve.edu.opencart.data.checkout.CheckOutRepository.NEW_SHIPPING_ADDRESS_CSSSELECTOR;

public class DeliveryDetails extends CheckOutPage{
    private WebElement element;

    private Select chooseDeliveryAccount;
    private DeliveryDetailsNewAddress fillForm;

    public DeliveryDetails(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        fillForm = new DeliveryDetailsNewAddress(driver, NEW_SHIPPING_ADDRESS_CSSSELECTOR);
    }

    //Functional

    private WebElement getWebContinueDeliveryButton(){
        return driver.findElement(By.cssSelector("input#button-shipping-address"));
    }

    private WebElement getWebContinueDeliveryButtonAsGuest(){
        return driver.findElement(By.cssSelector("input#button-guest-shipping"));
    }

    public WebElement getWebExistingAddressCheckBox(){
        return driver.findElement(By.cssSelector("input[name=\"shipping_address\"][value=\"existing\"]"));
    }

    public WebElement getWebNewAddressCheckBox(){
        return driver.findElement(By.cssSelector("input[name=\"shipping_address\"][value=\"new\"]"));
    }

    public WebElement getWebDeliveryAccount(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("#shipping-existing select.form-control")));
        return driver.findElement(By.cssSelector("#shipping-existing select.form-control"));
    }

    /**
     * The method which choose already created account to delivery
     * the delivery account that has been already created
     * @return the next class
     */
    public DeliveryMethod setChooseDeliveryAccount(){
        chooseDeliveryAccount = new Select(getWebDeliveryAccount());
        try {
            getWebDeliveryAccount().click();
        }
        catch (org.openqa.selenium.ElementClickInterceptedException ex){
        }
        chooseDeliveryAccount.getFirstSelectedOption();
        getWebDeliveryAccount().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        clickContinueDeliveryButton();
        return new DeliveryMethod(driver);
    }

    public void clickContinueDeliveryButton(){
        getWebContinueDeliveryButton().click();
    }

    public void clickContinueDeliveryButtonAsGuest(){
        getWebContinueDeliveryButtonAsGuest().click();
    }

    public void chooseNewAddressInDelivery(){
        getWebNewAddressCheckBox().click();
    }

    public void chooseExsistingAddressInDelivery(){
        getWebExistingAddressCheckBox().click();
    }

    /**
     * This method fully complete a delivery part
     * of checkout
     */
    public DeliveryMethod chooseAndDoneNewAddressInDeliveryDetails(){
        chooseNewAddressInDelivery();
        fillForm.methods.fullInputs(CheckOutRepository.get().validAddress());
        clickContinueDeliveryButton();
        return new DeliveryMethod(driver);
    }

    public DeliveryMethod addNewAddressInDeliveryDetailsAsGuest(){
        fillForm.methods.fullInputs(CheckOutRepository.get().validAddress());
        clickContinueDeliveryButtonAsGuest();
        return new DeliveryMethod(driver);
    }





    class DeliveryDetailsNewAddress extends NewAddressForCheckOut{

        private WebDriver driver;
        private WebElement element;
        private String path = NEW_SHIPPING_ADDRESS_CSSSELECTOR;
        private NewAddressForCheckOut methods;

        DeliveryDetailsNewAddress(WebDriver driver, String path){
            super(driver, path);
            this.driver = driver;
            initElements();
        }

        private void initElements(){
            methods = new NewAddressForCheckOut(driver, path);
        }
    }
}
