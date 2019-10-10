package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IAddress;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.addressbook.AddressRepository;
import com.softserve.edu.opencart.pages.user.account.EditAddressMessages;
import com.softserve.edu.opencart.pages.user.addressbook.AddressBookPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class AddressBookTest extends UserTestRunner {
    private AddressBookPage addressBookPage;

    @DataProvider
    public Object[] validAddresses() {
        return new Object[]{
                AddressRepository.get().getValidAddress(),
                AddressRepository.get().getNumberAddress(),
                AddressRepository.get().getSpecSymbolsAddress(),
                AddressRepository.get().getMaxSymbolsAddress(),
                AddressRepository.get().getMinSymbolsAddress()
        };
    }

    @DataProvider
    Object[] invalidAddress() {
        return new Object[]{
                AddressRepository.get().getUnderMaxSymbolsAddress(),
                AddressRepository.get().getEmptyAddress()
        };
    }

    @BeforeClass
    public void setUp() {
        IUser user = UserRepository.get().getRomanUser();
        addressBookPage = loadYuraApplication()
                .gotoLoginPage()
                .successfulLogin(user)
                .gotoAddressBookRight();
    }



    @Override
    @AfterMethod
    public void afterMethod(ITestResult testResult) {
          addressBookPage = loadAddreeBook();
    }

    @Test(dataProvider = "validAddresses")
    public void addAddressTest(IAddress address) {
        addressBookPage = addressBookPage
                .newAddressClick()
                .fillEditAddress(address);
        waitDriver.until(ExpectedConditions.visibilityOf(addressBookPage.getTable()));
        Assert.assertTrue(addressBookPage.getAddressTable()
                .getAddressByText(address.getFirstname())
                .getAddressInfo().contains(address.getFirstname()));
    }

    @Test(dataProvider = "validAddresses")
    public void editAddressTest(IAddress address) {
        addressBookPage = addressBookPage
                .editClick()
                .fillEditAddress(address);

        Assert.assertTrue(addressBookPage.getAddressTable()
                .getAddressByText(address.getFirstname())
                .getAddressInfo().contains(address.getFirstname()));
    }

    @Test(dataProvider = "invalidAddress")
    public void failAddAddressTest(IAddress address) {
        EditAddressMessages messages = addressBookPage
                .newAddressClick()
                .fillFailEditAddress(address);
        System.out.println(address.getFirstname());
        Assert.assertTrue(messages.editInitElements());
    }

    @Test(dataProvider = "invalidAddress")
    public void failEditAddressTest(IAddress address) {
        EditAddressMessages messages = addressBookPage
                .editClick()
                .fillFailEditAddress(address);

        Assert.assertTrue(messages.editInitElements());
    }

}
