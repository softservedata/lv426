package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeoZonePage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement addButton;
    private WebElement deleteButton;

    public GeoZonePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    private void initElements() {
        addButton = driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary"));
        deleteButton = driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger"));
    }


    private void clickAddButton() {
        addButton.click();
    }
    private void clickDeleteButton() {
        deleteButton.click();
    }


    public GeoZomeManagePage goToGeoZomeManagePage() {
        clickAddButton();
        return new GeoZomeManagePage(driver);
    }


    //TODO
    //chose some geozone for deleting;




}
