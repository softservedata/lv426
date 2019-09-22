package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.GeoZone;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AddGeoZomeManagePage;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AdminListContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeoZonePage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement addButton;
    private WebElement deleteButton;
    private AdminListContainerComponent listContainerComponent;

    public GeoZonePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        listContainerComponent = new AdminListContainerComponent(driver); // ??
        addButton = driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary"));
        deleteButton = driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger"));
    }

    private void asseptAlert() {
        driver.switchTo().alert().accept();
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



    public GeoZonePage deleteGeoZone(GeoZone geoZone) {
        listContainerComponent.selectByName(geoZone.getName());
        clickDeleteButton();
        asseptAlert();
        return new GeoZonePage(driver);
    }


    //TODO
    //chose some geozone for deleting;




}
