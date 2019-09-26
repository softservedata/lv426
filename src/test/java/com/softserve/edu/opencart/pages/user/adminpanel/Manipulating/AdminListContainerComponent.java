package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AdminListContainerComponent {
    private WebDriver driver;

    public AdminListContainerComponent(WebDriver driver) {
        this.driver = driver;
    }

    private List<AdminListElementComponent> getListOfCurrency() {
        List<AdminListElementComponent> listOfCurrency = new ArrayList<AdminListElementComponent>();///can be exception TODO (maybe)
        for (WebElement current : driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"))) {
            listOfCurrency.add(new AdminListElementComponent(driver, current));
        }

        return listOfCurrency;
    }

    private AdminListElementComponent searchByName(String name) {
        AdminListElementComponent rezult = null;
        for (AdminListElementComponent current : getListOfCurrency()) {
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
}
