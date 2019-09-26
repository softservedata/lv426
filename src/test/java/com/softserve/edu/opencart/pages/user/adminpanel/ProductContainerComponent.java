package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.ProductName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductContainerComponent {

    private WebDriver driver;
    private final String PRODUCT_COMPONENT_CSSSELECTOR = "table.table-bordered.table-hover > tbody";
    private WebElement productComponents;

    ProductContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        productComponents = driver.findElement(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR));
    }

    public ProductComponent searchByName(ProductName name){
        return new ProductComponent(driver, productComponents.findElement(By.xpath("//tr/td[contains(text(),'" + name.getValue() + "')]/..")));
    }


}
