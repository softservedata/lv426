package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.SpecialRepository;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SpecialEditProductPage extends EditProductPage {
    private WebDriver driver;
    private WebElement addNewSpecialButton;
    //private List<SpecialTableComponent> allrowsOfTable = new ArrayList<>();;
    private SpecialTableComponent specialTableComponent;
    private SpecialRepository specialRepository;

    SpecialEditProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        addNewSpecialButton = driver.findElement(By.cssSelector(ADD_NEW_ROW_INTO_TABLE));
    }

    private void clickaddNewSpecialButton() {
        addNewSpecialButton.click();
    }

    private SpecialTableComponent addSpecialTableComponent() {
        clickaddNewSpecialButton();
        return new SpecialTableComponent(driver);
    }

    private SpecialTableComponent getLastInTableComponent() {
        return new SpecialTableComponent(driver);
    }


    public void addNewSpecialPrice() {
        specialTableComponent = addSpecialTableComponent();
        specialTableComponent.fillInAllFields(specialRepository.getNewSpecialPrice());//??
        //  allrowsOfTable.add(specialTableComponent);
        clickSaveButton();
    }

    public void deleteAllDiscountTableComponent() {

        getLastInTableComponent().deleteSpecialTableComponent();

    }
}
