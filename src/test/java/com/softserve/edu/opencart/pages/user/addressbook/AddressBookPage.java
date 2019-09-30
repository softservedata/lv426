package com.softserve.edu.opencart.pages.user.addressbook;

import com.softserve.edu.opencart.data.IAddress;
import com.softserve.edu.opencart.pages.user.account.AccountSidebarLoggedPart;
import com.softserve.edu.opencart.pages.user.account.EditAddressPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBookPage extends AccountSidebarLoggedPart {

    /**
     * This variable for address information on page
     */
    private AddressBookContainerComponent addressTable;

    /**
     * This variable for button New Address on page
     */
    private WebElement newAddressButton;

    /*	*//** This variable for catching message about success update *//*
	private WebElement updateText;

	*/

    /**
     * This variable for catching message with warning
     *//*
	private WebElement warningText;*/
    public AddressBookPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        addressTable = new AddressBookContainerComponent(driver);
        newAddressButton =
                driver.findElement(By.linkText("New Address"));
    }

    // Page Object

    // Functional

    public AddressBookContainerComponent getAddressTable() {
        return addressTable;
    }

    /**
     * This method click on button Edit
     */
    public EditAddressPage editClick() {
        addressTable.getAddresselements().get(0).clickEditButton();
        return new EditAddressPage(driver);
    }

    /**
     * This method click on button Delete
     */
    public void deleteClick() {
        addressTable.getAddresselements().get(0).clickDeleteButton();
    }

    /**
     * This method click on button New Address
     */
    public EditAddressPage newAddressClick() {
        newAddressButton.click();
        return new EditAddressPage(driver);
    }

    // Business Logic

}
