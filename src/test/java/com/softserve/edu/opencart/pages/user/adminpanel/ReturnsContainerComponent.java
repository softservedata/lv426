package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReturnsContainerComponent extends ReturnsPage {

    private final String RETURNS_COMPONENTS_SELECTOR =
            "//div[contains(@class,'table-responsive')]" +
                    "/table[contains(@class,'table table-bordered')]/tbody/tr";

    private List<ReturnsTableInfo> returnsElements ;

    public ReturnsContainerComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        returnsElements = new ArrayList<>();
        for(WebElement productTable : driver.findElements(By.xpath(RETURNS_COMPONENTS_SELECTOR))){
            returnsElements.add(new ReturnsTableInfo(productTable, driver,RETURNS_COMPONENTS_SELECTOR));
        }
    }

    public ReturnsTableInfo getOrderById(String id) {
        int ind = 0;
        for(int i = 0; i<returnsElements.size()-1; i++) {
            if(returnsElements.get(i).getReturnId().contains(id)) {
                ind=i;
                break;
            }
        }
        return returnsElements.get(ind);
    }

    public List<ReturnsTableInfo> getReturnsElements() {
        return returnsElements;
    }
}
