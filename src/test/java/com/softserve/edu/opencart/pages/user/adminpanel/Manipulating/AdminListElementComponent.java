package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminListElementComponent {
    private WebDriver driver;
    protected WebElement component;
    private WebElement selectButton;
    private WebElement name;

    public AdminListElementComponent(WebDriver driver, WebElement component) {
        this.driver = driver;
        this.component = component;
        selectButton = component.findElement(By.cssSelector(".text-center input"));
        name = component.findElement(By.cssSelector("td.text-left"));
    }

    public WebElement getName() {
        return name;
    }

    private void clickSelectButton() {
        selectButton.click();
    }

    public boolean hasName(String name) {
        return getName().getText().equals(name);//TODO
    }

    public void select() {
        clickSelectButton();
    }
}
