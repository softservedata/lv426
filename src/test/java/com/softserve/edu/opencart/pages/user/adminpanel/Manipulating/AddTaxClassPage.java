package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.TaxClass;
import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import com.softserve.edu.opencart.pages.user.adminpanel.TaxClassPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage.ADD_NEW_ROW_INTO_TABLE;

public class AddTaxClassPage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement saveButton;
    private WebElement taxClassName;
    private WebElement description;
    private WebElement addTaxClassButton;

    AddTaxClassPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        saveButton = driver.findElement(By.cssSelector(".pull-right > .btn.btn-primary"));
        addTaxClassButton = driver.findElement(By.cssSelector(ADD_NEW_ROW_INTO_TABLE));
        taxClassName = driver.findElement(By.cssSelector(".col-sm-10 #input-title"));
        description = driver.findElement(By.cssSelector(".col-sm-10 #input-description"));

    }

    private void clickSaveButton() {
        saveButton.click();
    }

    private void clickaddTaxClassButton() {
        addTaxClassButton.click();
    }

    private void clicktaxClassNameField() {
        taxClassName.click();
    }

    private void cleartaxClassNameField() {
        taxClassName.clear();
    }

    private void settaxClassNameField(String name) {
        taxClassName.sendKeys(name);
    }

    private void clickDescriptionField() {
        description.click();
    }

    private void clearDescriptionField() {
        description.clear();
    }

    private void setDescriptionField(String name) {
        description.sendKeys(name);
    }

    private TaxClassTableComponenet addTaxRateToClass() {
        clickaddTaxClassButton();
        return new TaxClassTableComponenet(driver);
    }

    private void enterTaxClassName(TaxClass tax) {
        clicktaxClassNameField();
        cleartaxClassNameField();
        settaxClassNameField(tax.getName());
    }

    private void enterTaxClassDescription(TaxClass tax) {
        clickDescriptionField();
        clearDescriptionField();
        setDescriptionField(tax.getDescription());
    }

    private void fillInAllFields(TaxClass tax) {
        enterTaxClassName(tax);
        enterTaxClassDescription(tax);
        addTaxRateToClass().choseTaxClass(tax);
    }

    public TaxClassPage addTaxClass(TaxClass tax) {
        fillInAllFields(tax);
        clickSaveButton();
        return new TaxClassPage(driver);
    }


}
