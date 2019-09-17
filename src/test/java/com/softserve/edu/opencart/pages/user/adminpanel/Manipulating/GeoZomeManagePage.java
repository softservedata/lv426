package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.GeoZone;
import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage.ADD_NEW_ROW_INTO_TABLE;

public class GeoZomeManagePage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement name;
    private WebElement description;
    private WebElement addGeoZoneButton;
    private GeoZomeTableComponent tableComponent;

    public GeoZomeManagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        addGeoZoneButton = driver.findElement(By.cssSelector(ADD_NEW_ROW_INTO_TABLE));
    }

    private void clickGeoZoneButton() {
        addGeoZoneButton.click();
    }
    private void clickNameField() {
        name.click();
    }
    private void clearNameField() {
        name.clear();
    }
    private void setNameField(GeoZone geoZone) {
        name.sendKeys(geoZone.getName());
    }

    private void clickDescriptionField() {
        description.click();
    }
    private void clearDescriptionField() {
        description.clear();
    }
    private void setDescriptionField(GeoZone geoZone) {
        description.sendKeys(geoZone.getDescription());       //TODO
    }

    private void enterName(GeoZone geoZone) {
        clickNameField();
        clearNameField();
        setNameField(geoZone);
    }

    private void enterDescription(GeoZone geoZone) {
        clickDescriptionField();
        clearDescriptionField();
        setDescriptionField(geoZone);
    }




    private GeoZomeTableComponent addTableComponent() {
        clickGeoZoneButton();
        return new GeoZomeTableComponent(driver);
    }


    public void addNewGeoZone(GeoZone geoZone) {
        enterName(geoZone);
        enterDescription(geoZone);
        addTableComponent().choseGeoZone(geoZone);
    }


    //TODO
    public void deleteGeoZone(GeoZone geoZone) {

    }


}
