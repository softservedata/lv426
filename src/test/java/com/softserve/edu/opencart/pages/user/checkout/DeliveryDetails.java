package com.softserve.edu.opencart.pages.user.checkout;

import com.softserve.edu.opencart.data.checkout.CheckOutRepository;
import com.softserve.edu.opencart.data.checkout.NewAddressForCheckOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.softserve.edu.opencart.data.checkout.NewAddressForCheckOut.NEW_SHIPPING_ADRESS;

public class DeliveryDetails extends CheckOutPage{
    private WebDriver driver;
    private WebElement element;

    private WebElement continueDeliveryButton;
    private WebElement existingAddressCheckBox;
    private WebElement newAddressCheckBox;
    private Select chooseDeliveryAccount;
    private WebElement deliveryAccount;
    private DeliveryDetailsNewAddress fillForm;

    public DeliveryDetails(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        continueDeliveryButton = driver.findElement(By.cssSelector("input#button-shipping-address"));
        existingAddressCheckBox = driver
                .findElement(By.cssSelector("input[name=\"shipping_address\"][value=\"existing\"]"));
        newAddressCheckBox = driver
                .findElement(By.cssSelector("input[name=\"shipping_address\"][value=\"new\"]"));
        deliveryAccount = driver.findElement(By.cssSelector("#shipping-existing select.form-control"));
        fillForm = new DeliveryDetailsNewAddress(driver, NEW_SHIPPING_ADRESS);
    }

    public void setChooseDeliveryAccount(String fullAcc){
        chooseDeliveryAccount = new Select(deliveryAccount);
        deliveryAccount.click();
        chooseDeliveryAccount.selectByVisibleText(fullAcc);
    }

    public void clickContinueDeliveryButton(){
        continueDeliveryButton.click();
    }

    public void chooseNewAddressInDelivery(){
        newAddressCheckBox.click();
    }

    public void chooseExsistingAddressInDelivery(){
        existingAddressCheckBox.click();
    }

    /**
     * This method fully complete a delivery part
     * of checkout
     */
    public void chooseAndDoneNewAddressInDeliveryDetails(){
        chooseNewAddressInDelivery();
        fillForm.methods.fullIputs(CheckOutRepository.get().validAdress());
        clickContinueDeliveryButton();
    }



    class DeliveryDetailsNewAddress extends NewAddressForCheckOut{

        private WebDriver driver;
        private WebElement element;
        private String path = NEW_SHIPPING_ADRESS;
        private NewAddressForCheckOut methods;

        DeliveryDetailsNewAddress(WebDriver driver, String path){
            super(driver, path);
        }

        private void initElements(){
            methods = new NewAddressForCheckOut(driver, path);
        }
    }
}
