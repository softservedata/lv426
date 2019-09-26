package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.TaxClass;
import com.softserve.edu.opencart.data.TaxRate;
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

    public AddTaxClassPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        saveButton = driver.findElement(By.cssSelector(".pull-right > .btn.btn-primary"));
        addTaxClassButton = driver.findElement(By.xpath("//table[@id='tax-rule']//tfoot//button[@class='btn btn-primary']"));
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

    private void fillInAllFields(TaxClass tax, TaxRate taxRate) {
        enterTaxClassName(tax);
        enterTaxClassDescription(tax);
        addTaxRateToClass().choseTaxClass(taxRate);
    }

    public TaxClassPage addTaxClass(TaxClass tax, TaxRate taxRate) {
        fillInAllFields(tax, taxRate);
        clickSaveButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TaxClassPage(driver);
    }


}
