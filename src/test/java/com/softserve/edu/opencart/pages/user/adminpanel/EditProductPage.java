package com.softserve.edu.opencart.pages.user.adminpanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProductPage extends LeftSidebarMenuComponent {

    private WebElement saveButton;
    EditProductPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        saveButton = driver.findElement(By.cssSelector(".pull-right .btn.btn-primary"));
    }


    private void clickSaveButton() {
        saveButton.click();
    }


}
