package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.GeoZone;
import com.softserve.edu.opencart.pages.user.adminpanel.GeoZonePage;
import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage.ADD_NEW_ROW_INTO_TABLE;

public class AddGeoZomeManagePage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement name;
    private WebElement description;
    private WebElement addGeoZoneButton;
    private WebElement saveButton;




    public AddGeoZomeManagePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();


    }

    private void initElements() {
        saveButton = driver.findElement(By.cssSelector(".pull-right > .btn.btn-primary"));
        addGeoZoneButton = driver.findElement(By.cssSelector(ADD_NEW_ROW_INTO_TABLE));
        name = driver.findElement(By.cssSelector(".col-sm-10 #input-name"));
        description = driver.findElement(By.cssSelector(".col-sm-10 #input-description"));


    }


    private void clickSaveButton() {
        saveButton.click();
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

    private void setNameField(String geoZoneName) {
        name.sendKeys(geoZoneName);
    }

    private void clickDescriptionField() {
        description.click();
    }

    private void clearDescriptionField() {
        description.clear();
    }

    private void setDescriptionField(String geoZoneDescription) {
        description.sendKeys(geoZoneDescription);
    }

    private void enterName(GeoZone geoZone) {
        clickNameField();
        clearNameField();
        setNameField(geoZone.getName());
    }

    private void enterDescription(GeoZone geoZone) {
        clickDescriptionField();
        clearDescriptionField();
        setDescriptionField(geoZone.getDescription());
    }


    private GeoZomeTableComponent addTableComponent() {
        clickGeoZoneButton();
        return new GeoZomeTableComponent(driver);
    }


    private void enterAllFields(GeoZone geoZone) {
        enterName(geoZone);
        enterDescription(geoZone);
        addTableComponent().choseGeoZone(geoZone);
    }

    public GeoZonePage addNewGeoZone(GeoZone geoZone) {
        enterAllFields(geoZone);
        clickSaveButton();
        return new GeoZonePage(driver);

    }

}
