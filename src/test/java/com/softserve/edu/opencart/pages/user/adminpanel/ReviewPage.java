package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.WebDriver;

public class ReviewPage extends LeftSidebarMenuComponent {

    private WebDriver driver;
    private ReviewContainerComponent reviewContainerComponent;
    private ReviewComponent reviewComponent;


    ReviewPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        reviewContainerComponent = new ReviewContainerComponent(driver);
    }
}
