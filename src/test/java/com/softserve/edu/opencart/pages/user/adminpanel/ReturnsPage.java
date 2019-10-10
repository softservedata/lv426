package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.WebDriver;

public class ReturnsPage extends LeftSidebarMenuComponent {

    private ReturnsFilter returnsFilter;
    private ReturnsContainerComponent returnsProducts;

    ReturnsPage(WebDriver driver) {
        super(driver);
        returnsFilter = new ReturnsFilter(driver);
        returnsProducts = new ReturnsContainerComponent(driver);
    }

    public ReturnsContainerComponent getReturnsProducts() {
        return returnsProducts;
    }
}
