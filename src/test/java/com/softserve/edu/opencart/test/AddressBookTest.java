package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IAddress;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.data.addressbook.AddressRepository;
import com.softserve.edu.opencart.pages.user.addressbook.AddressBookPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.shop.UtilsForShoppingCart.Phones.IPHONE;

public class AddressBookTest extends UserTestRunner {

    @DataProvider
    public Object[][] addresses() {
        return new Object[][]{
                {AddressRepository.get().getValidAddress()},
                {AddressRepository.get().getNumberAddress()},
                {AddressRepository.get().getSpecSymbolsAddress()},
                {AddressRepository.get().getMaxSymbolsAddress()},
                {AddressRepository.get().getMinSymbolsAddress()},
                {AddressRepository.get().getUnderMaxSymbolsAddress()}

        };
    }

    @Test(dataProvider = "addresses")
    public void addAddressTest(IAddress address) {

    }


}
