package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Special;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.data.SpecialRepository.getNewSpecialPrice;

public class SpecialEditProductPage extends EditProductPage {
    private WebDriver driver;
    private WebElement addNewSpecialButton;
    //private List<SpecialTableComponent> allrowsOfTable = new ArrayList<>();;
    private SpecialTableComponent specialTableComponent;

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


    public void addNewSpecialPrice(Special special) {
        specialTableComponent = addSpecialTableComponent();
        specialTableComponent.fillInAllFields(special);//??
        clickSaveButton();
    }

    public void deleteAllDiscountTableComponent() {

        getLastInTableComponent().deleteSpecialTableComponent();

    }
}
