package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.TaxRate;
import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import com.softserve.edu.opencart.pages.user.adminpanel.TaxRatesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddTaxRatePage extends LeftSidebarMenuComponent {

    private WebDriver driver;
    private WebElement saveButton;
    private WebElement taxName;
    private WebElement taxRate;
    private Select type;
    private Select geoZone;

    public AddTaxRatePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        saveButton = driver.findElement(By.cssSelector(".pull-right > .btn.btn-primary"));
        taxName = driver.findElement(By.cssSelector(".col-sm-10 #input-name"));
        taxRate = driver.findElement(By.cssSelector(".col-sm-10 #input-rate"));
        type = new Select(driver.findElement(By.cssSelector("select#input-type")));
        geoZone = new Select(driver.findElement(By.cssSelector("select#input-geo-zone")));
    }

    private void clickSaveButton() {
        saveButton.click();
    }

    private void clickTaxNameField() {
        taxName.click();
    }

    private void clearTaxNameField() {
        taxName.clear();
    }

    private void setTaxNameField(String name) {
        taxName.sendKeys(name);
    }

    private void clickTaxRateField() {
        taxRate.click();
    }

    private void clearTaxRateField() {
        taxRate.clear();
    }
    private void setTaxRateField(String rate) {
        taxRate.sendKeys(rate);
    }

    private void selectType(String typeName) {
        type.selectByVisibleText(typeName);
    }

    private void selectGeoZone(String zoneName) {
        geoZone.selectByVisibleText(zoneName);
    }


    private void enterTaxName(TaxRate tax) {
        clickTaxNameField();
        clearTaxNameField();
        setTaxNameField(tax.getName());
    }

    private void enterTaxRate(TaxRate tax) {
        clickTaxRateField();
        clearTaxRateField();
        setTaxRateField(String.valueOf(tax.getRate()));
    }

    private void fillInAllField(TaxRate tax) {
        enterTaxName(tax);
        enterTaxRate(tax);
        selectType(tax.getType());
        selectGeoZone(tax.getGeoZone());
    }

    public TaxRatesPage addNewTaxRate(TaxRate tax) {
        fillInAllField(tax);
        clickSaveButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TaxRatesPage(driver);
    }

}
