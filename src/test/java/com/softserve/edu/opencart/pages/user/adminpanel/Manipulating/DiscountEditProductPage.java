package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Discount;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountEditProductPage extends EditProductPage {
    private WebDriver driver;
    private WebElement addNewDiscauntButton;



    public DiscountEditProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElement();
    }

    private void initElement() {
        addNewDiscauntButton =  driver.findElement(By.xpath(ADD_NEW_ROW_INTO_TABLE));
    }

    private void clickAddNewDiscountButton() {
        addNewDiscauntButton.click();
    }

    private DiscountTableComponent addDiscountTableComponent() {
        clickAddNewDiscountButton();
        return new DiscountTableComponent(driver);
    }

    private DiscountTableComponent getLastDiscountTableComponent() {
        return new DiscountTableComponent(driver);
    }

    public void addNewDiscount(Discount discount) {
        addDiscountTableComponent().fillInAllFields(discount);
        clickSaveButton();
    }

    public void deleteLastDiscountTableComponent() {
        getLastDiscountTableComponent().deleteComponent();
        clickSaveButton();
    }
}
