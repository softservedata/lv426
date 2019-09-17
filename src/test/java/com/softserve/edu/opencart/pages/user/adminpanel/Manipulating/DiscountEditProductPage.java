package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.DiscountRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DiscountEditProductPage extends EditProductPage {
    private WebDriver driver;
    private WebElement addNewDiscauntButton;
    private List<DiscountTableComponent> allRowOfTable; // ??
    private DiscountTableComponent discountTableComponent;
    private DiscountRepository discountRepository;

    public DiscountEditProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        discountRepository = new DiscountRepository();
        allRowOfTable = new ArrayList<>();
        initElement();
    }

    private void initElement() {
        addNewDiscauntButton =  driver.findElement(By.cssSelector(ADD_NEW_ROW_INTO_TABLE));
    }

    private void clickAddNewDiscauntButton() {
        addNewDiscauntButton.click();
    }

    private DiscountTableComponent addDiscountTableComponent() {
        clickAddNewDiscauntButton();
        return new DiscountTableComponent(driver);
    }

    private DiscountTableComponent getDiscountTableComponent() {
        return new DiscountTableComponent(driver);
    }

    public void addNewDiscount() {
        discountTableComponent = addDiscountTableComponent();
        discountTableComponent.fillInAllFields(discountRepository.getNewDiscount());//??
       // allRowOfTable.add(discountTableComponent);
        clickSaveButton();
    }

    public void deleteDiscountTableComponent() {
        getDiscountTableComponent().deleteComponent();
    }
}
