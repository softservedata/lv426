package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.GeoZone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage.LAST_ROW_IN_TABLE;

public class GeoZomeTableComponent {

    private WebDriver driver;
    private WebElement tableElement;
    private Select component;

    GeoZomeTableComponent(WebDriver driver) {
        this.driver = driver;
        tableElement = driver.findElement(By.xpath(LAST_ROW_IN_TABLE));
        component = new Select(tableElement.findElement(By.xpath("some xpath"))); ///TODO
    }

    public void choseGeoZone(GeoZone geoZone) {
        component.selectByVisibleText(geoZone.getCountry());
    }

}
