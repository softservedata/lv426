package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Special;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        addNewSpecialButton = driver.findElement(By.xpath("//table[@id='special']//tfoot//button[@class='btn btn-primary']"));
    }

    private void clickaddNewSpecialButton() {
        addNewSpecialButton.click();
    }

    private SpecialTableComponent addSpecialTableComponent() {
        clickaddNewSpecialButton();
        return new SpecialTableComponent(driver);
    }

    private SpecialTableComponent getLastSpecialTableComponent() {
        return new SpecialTableComponent(driver);
    }


    public void addNewSpecialPrice(Special special) {
        specialTableComponent = addSpecialTableComponent();
        specialTableComponent.fillInAllFields(special);//??
        clickSaveButton();
    }

    public void deleteLastSpecialTableComponent() {

        getLastSpecialTableComponent().deleteSpecialTableComponent();
        clickSaveButton();

    }
}
