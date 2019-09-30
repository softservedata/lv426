package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends AccountSidebarLoggedPart {

    /**
     * This variable is button Look Order
     */
    private OrderHistoryContainerComponent ordersTable;


    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        this.ordersTable = new OrderHistoryContainerComponent(driver);
    }

    public OrderHistoryContainerComponent getOrdersTable() {
        return ordersTable;
    }
}
