package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductComponent {

    protected WebElement productChoose;
    private WebDriver driver;
    private WebElement actionButton;


    ProductComponent(WebDriver driver, WebElement productChoose) {
        this.driver = driver;
        this.productChoose = productChoose;
        initElements();
    }

    private void initElements() {
        actionButton = productChoose.findElement(By.cssSelector("a.btn.btn-primary"));

    }

    private void clickActionButton() {
        actionButton.click();
    }


    public EditProductPage goToEditProductPage() {
        clickActionButton();
        return new EditProductPage(driver);

    }

}
