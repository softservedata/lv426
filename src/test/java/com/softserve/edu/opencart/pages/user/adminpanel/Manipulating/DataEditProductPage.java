package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.TaxClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DataEditProductPage extends EditProductPage {
    private WebDriver driver;
    private WebElement priceField;
    private Select taxClass;

    public DataEditProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        priceField = driver.findElement(By.cssSelector("input#input-price"));
        taxClass = new Select(driver.findElement(By.cssSelector("select#input-tax-class")));
    }

    private void selectTaxClassByName(TaxClass tax) {
        taxClass.selectByVisibleText(tax.getName());
    }

    private void selectDefaultTaxClass() {
        taxClass.selectByIndex(0);
    }

    private WebElement getPriceField() {
        return priceField;
    }

    public String getSubPrice() {
        return getPriceField().getAttribute("value");
    }

    public void selectClassTax(TaxClass tax) {
        selectTaxClassByName(tax);
    }

    public void selectDefaultTax() {
        selectDefaultTaxClass();
    }
}
