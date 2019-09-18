package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyListComponent {
    private WebDriver driver;
    private WebElement component;
    private WebElement selectButton;

    public CurrencyListComponent(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        selectButton = component.findElement(By.xpath("/td/input"));
    }

    private void clickSelectButton() {
        selectButton.click();
    }

    public boolean hasCurrencyName(String name) {
        return component.findElement(By.xpath("//td[contains(text(),'" + name + "')]")) != null;//TODO
    }

    public void selectCurrency() {
        clickSelectButton();
    }
}
