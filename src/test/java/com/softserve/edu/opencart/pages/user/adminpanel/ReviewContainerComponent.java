package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewContainerComponent {

    private WebDriver driver;

    private final String REVIEW_CONTAINER_CSSSELECTOR = "table-responsive";
    private WebElement productComponents;




    public ReviewContainerComponent(WebDriver driver) {
        this.driver=driver;
        initElements();
    }

    private void initElements(){
        productComponents = driver.findElement(By.cssSelector(REVIEW_CONTAINER_CSSSELECTOR));

    }


}
