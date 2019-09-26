package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminListContainerComponent {
    private WebDriver driver;
    private List<AdminListElementComponent> listOfCurrency;

    public AdminListContainerComponent(WebDriver driver) {
        this.driver = driver;
    }

    private List<AdminListElementComponent> getList() {
        List<AdminListElementComponent> list = new ArrayList<AdminListElementComponent>();///can be exception TODO (maybe)
        for (WebElement current : driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"))) {
            list.add(new AdminListElementComponent(driver, current));
        }

        return list;
    }


    private List<CurrencyListElementComponent> getListOfCurrency() {
        List<CurrencyListElementComponent> listOfCurrency = new ArrayList<>();///can be exception TODO (maybe)
        for (WebElement current : driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"))) {
            listOfCurrency.add(new CurrencyListElementComponent(driver, current));
        }

        return listOfCurrency;
    }

    private AdminListElementComponent searchByName(String name) {
        AdminListElementComponent rezult = null;
        for (AdminListElementComponent current : getList()) {
            if (current.hasName(name)) {
                rezult = current;
                break;
            }


        }
        if (rezult == null) {
            throw new RuntimeException("Can't search Component by [" + name + "] name");
        }
        return rezult;
    }

    public void selectByName(String name) {
        searchByName(name).select();
    }



    public Map<String, Double> getMapOfConventValue() {
        Map<String, Double> rezult = new HashMap<>();
        for  (CurrencyListElementComponent current : getListOfCurrency()) {
            rezult.put(current.getName().getText(), current.getValue());

        }
        return rezult;
    }
}
