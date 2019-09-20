package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CurrencyListContainerComponent{
    private WebDriver driver;

    public CurrencyListContainerComponent(WebDriver driver) {
        this.driver = driver;
    }

    private List<CurrencyListComponent> getListOfCurrency() {
        List<CurrencyListComponent> listOfCurrency = new ArrayList<>();///can be exception TODO (maybe)
        for (WebElement current : driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"))) {
            listOfCurrency.add(new CurrencyListComponent(driver, current));
        }

        return listOfCurrency;
    }

    private CurrencyListComponent searchByNameOfCurrency(String name) {
        CurrencyListComponent rezult = null;
        for (CurrencyListComponent current : getListOfCurrency()) {
            if (current.hasCurrencyName(name)) {
                rezult = current;
                break;
            }


        }
        if (rezult == null) {
            throw new RuntimeException("Can't search Component by [" + name + "] name");
        }
        return rezult;
    }

    public void selectCurrencyByName(String geoZoneName) {
        searchByNameOfCurrency(geoZoneName).selectCurrency();
    }
}
