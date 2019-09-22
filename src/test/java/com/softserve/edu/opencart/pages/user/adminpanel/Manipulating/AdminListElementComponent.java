package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminListElementComponent {
    private WebDriver driver;
    private WebElement component;
    private WebElement selectButton;

    public AdminListElementComponent(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        selectButton = component.findElement(By.cssSelector(".text-center input"));
    }

    private void clickSelectButton() {
        selectButton.click();
    }

    public boolean hasName(String name) {
        return component.findElement(By.cssSelector("td.text-left")).getText().equals(name);//TODO
    }

    public void select() {
        clickSelectButton();
    }
}
