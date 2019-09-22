package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.pages.user.common.DropdownComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class HeaderPart {
    private WebDriver driver;

    protected WebElement menuButton;
    private WebElement logOutButton;
    private WebElement logo;
    private DropdownComponent helpMenu;
    private DropdownComponent NotificationsMenu;
    private DropdownComponent storesMenu;


    public HeaderPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        menuButton = driver.findElement(By.id("button-menu"));
        logOutButton = driver.findElement(By.xpath("//a/i[@class='fa fa-sign-out fa-lg']//ancestor::a"));
        logo = driver.findElement(By.cssSelector("a.navbar-brand"));
    }


    private WebElement getMenuButton() {
        return menuButton;
    }

    private WebElement getLogOutButton() {
        return logOutButton;
    }

    private WebElement getLogo() {
        return logo;
    }
}
