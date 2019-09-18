package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GeoZoneListContainerComponent {

    private WebDriver driver;

    public GeoZoneListContainerComponent(WebDriver driver) {
        this.driver = driver;
    }

    private List<GeoZoneListComponent> getListOfGeoZone() {
        List<GeoZoneListComponent> listOfGeoZone = new ArrayList<>();///can be exception TODO (maybe)
        for (WebElement current : driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr"))) {
            listOfGeoZone.add(new GeoZoneListComponent(driver, current));
        }

        return listOfGeoZone;
    }

    private GeoZoneListComponent searchByNameOfZone(String name) {
        GeoZoneListComponent rezult = null;
        for (GeoZoneListComponent current : getListOfGeoZone()) {
            if (current.hasGeoZoneName(name)) {
                rezult = current;
                break;
            }


        }
        if (rezult == null) {
            throw new RuntimeException("Can't search Component by [" + name + "] name");
        }
        return rezult;
    }

    public void selectGeoZoneByName(String geoZoneName) {
        searchByNameOfZone(geoZoneName).selectGeoZone();
    }
}
