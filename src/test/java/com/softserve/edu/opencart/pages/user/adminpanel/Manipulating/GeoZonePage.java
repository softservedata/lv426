package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.GeoZone;
import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeoZonePage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement addButton;
    private WebElement deleteButton;
    private GeoZoneListContainerComponent geoZoneListContainerComponent;

    public GeoZonePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        geoZoneListContainerComponent = new GeoZoneListContainerComponent(driver); // ??
        addButton = driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary"));
        deleteButton = driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger"));
    }


    private void clickAddButton() {
        addButton.click();
    }
    private void clickDeleteButton() {
        deleteButton.click();
    }


    public AddGeoZomeManagePage goToAddGeoZomeManagePage() {
        clickAddButton();
        return new AddGeoZomeManagePage(driver);
    }



    public void deleteGeoZone(GeoZone geoZone) {
        geoZoneListContainerComponent.selectGeoZoneByName(geoZone.getName());
        clickDeleteButton();
        //work with alert TODO
        driver.switchTo().alert().accept();

    }


    //TODO
    //chose some geozone for deleting;




}
