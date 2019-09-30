package com.softserve.edu.opencart.pages.user.addressbook;

import com.softserve.edu.opencart.data.addressbook.AddressBookTableInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddressBookContainerComponent  {

    private WebDriver driver;

    private final String ADDRESSBOOK_COMPONENTS_SELECTOR =
            "//div[contains(@class,'table-responsive')]" +
                    "/table[contains(@class,'table table-bordered')]/tbody/tr";

    private List<AddressBookTableInfo> addressElements ;

    public AddressBookContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        addressElements = new ArrayList<>();
        for(WebElement productTable : driver.findElements(By.xpath(ADDRESSBOOK_COMPONENTS_SELECTOR))){
            addressElements.add(new AddressBookTableInfo( driver));

        }
    }

    public List<AddressBookTableInfo> getAddresselements() {
        return addressElements;
    }

    public AddressBookTableInfo getAddressByText(String text) {
        int ind = 0;
        for(int i = 0; i<addressElements.size()-1; i++) {
            if(addressElements.get(i).getAddressInfo().contains(text)) {
                ind=i;
                break;
            }
        }
        return addressElements.get(ind);
    }
}
