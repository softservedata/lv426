package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.OrderHistoryTableInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OrderHistoryContainerComponent {
    protected WebDriver driver;

    private final String ORDERHISTORY_COMPONENTS_SELECTOR =
            "//div[contains(@class,'table-responsive')]" +
                    "/table[contains(@class,'table table-bordered')]/tbody/tr";

    private List<OrderHistoryTableInfo> addressElements ;

    public OrderHistoryContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        addressElements = new ArrayList<>();
        for(WebElement productTable : driver.findElements(By.xpath(ORDERHISTORY_COMPONENTS_SELECTOR))){
            addressElements.add(new OrderHistoryTableInfo( driver));

        }
    }

    public OrderHistoryTableInfo getOrderById(String id) {
        int ind = 0;
        for(int i = 0; i<addressElements.size()-1; i++) {
            if(addressElements.get(i).getIdInform().contains("#"+id)) {
                ind=i;
                break;
            }
        }
        return addressElements.get(ind);
    }
}
