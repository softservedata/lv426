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
    private WebElement deleteButton;

    public GeoZomeTableComponent(WebDriver driver) {
        this.driver = driver;
        initElements();

    }
    private void initElements() {
        tableElement = driver.findElement(By.xpath(LAST_ROW_IN_TABLE));
        deleteButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        component = new Select(tableElement.findElement(By
                .xpath("//table[@id='zone-to-geo-zone']/tbody/tr[last()]//select[contains(@name, 'country')]")));

    }
    private void clickDeleteButton() {
        deleteButton.click();
    }
    public void choseGeoZone(GeoZone geoZone) {
        component.selectByVisibleText(geoZone.getCountry());
    }

}
