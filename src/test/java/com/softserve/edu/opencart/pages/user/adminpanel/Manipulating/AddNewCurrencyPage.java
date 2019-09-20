package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Currency;
import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCurrencyPage extends LeftSidebarMenuComponent {
    private WebDriver driver;

    private WebElement saveButton;
    private WebElement title;
    private WebElement code;
    private WebElement symbolLeft;
    private WebElement decimalPlaces;
    private WebElement value;
    private WebElement status;

    public AddNewCurrencyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        title = driver.findElement(By.cssSelector(".col-sm-10 #input-title"));
        code = driver.findElement(By.cssSelector(".col-sm-10 #input-code"));
        symbolLeft = driver.findElement(By.cssSelector(".col-sm-10 #input-symbol-left"));
        decimalPlaces = driver.findElement(By.cssSelector(".col-sm-10 #input-decimal-place"));
        value = driver.findElement(By.cssSelector(".col-sm-10 #input-value"));
        status = driver.findElement(By.cssSelector(".col-sm-10 #input-status"));
        saveButton = driver.findElement(By.cssSelector(".pull-right > .btn.btn-primary"));
    }

    private void clickSaveButton() {
        saveButton.click();
    }

    private void clickTitle() {
        title.click();
    }

    private void clearTitle() {
        title.clear();
    }

    private void setTitle(String titleField) {
        title.sendKeys(titleField);
    }

    private void clickCode() {
        code.click();
    }

    private void clearCode() {
        code.clear();
    }

    private void setCode(String codeField) {
        code.sendKeys(codeField);
    }

    private void clickSymbolLeft() {
        symbolLeft.click();
    }

    private void clearSymbolLeft() {
        symbolLeft.clear();
    }

    private void setSymbolLeft(String symbolLeftField) {
        symbolLeft.sendKeys(symbolLeftField);
    }

    private void clickDecimalPlace() {
        decimalPlaces.click();
    }

    private void clearDecimalPlace() {
        decimalPlaces.clear();
    }

    private void setDecimalPlace(int decimalPlaceField) {
        decimalPlaces.sendKeys(String.valueOf(decimalPlaceField));
    }

    private void clickValue() {
        value.click();
    }

    private void clearValue() {
        value.clear();
    }

    private void setValue(double valueField) {
        value.sendKeys(String.valueOf(valueField));
    }

    private void clickStatus() {
        status.click();
    }

    private void clearStatus() {
        status.clear();
    }

    private void setStatus(String statusField) {
        status.sendKeys(statusField);
    }

    private void enterTitle(Currency currency) {
        clickTitle();
        clearTitle();
        setTitle(currency.getTitle());
    }

    private void enterCode(Currency currency) {
        clickCode();
        clearCode();
        setCode(currency.getCode());
    }

    private void enterSymbolLeft(Currency currency) {
        clickSymbolLeft();
        clearSymbolLeft();
        setSymbolLeft(currency.getSymbolLeft());
    }

    private void enterDecimalPlace(Currency currency) {
        clickDecimalPlace();
        clearDecimalPlace();
        setDecimalPlace(currency.getDecimalPlaces());
    }

    private void enterValue(Currency currency) {
        clickValue();
        clearValue();
        setValue(currency.getValue());
    }

    private void enterStatus(Currency currency) {
        clickStatus();
        clearStatus();
        setStatus(currency.getStatus());
    }

    private void fillInAllFields(Currency currency) {
        enterTitle(currency);
        enterCode(currency);
        enterSymbolLeft(currency);
        enterDecimalPlace(currency);
        enterValue(currency);
        enterStatus(currency);

    }

    public CurrencyPage addNewCurrency(Currency currency) {
        fillInAllFields(currency);
        clickSaveButton();
        return new CurrencyPage(driver);
    }


}
