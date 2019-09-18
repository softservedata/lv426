package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.Currency;
import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyPage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement addButton;
    private WebElement deleteButton;

    private CurrencyListContainerComponent currencyListContainerComponent;

    public CurrencyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private void initElements() {
        //geoZoneListContainerComponent = new GeoZoneListContainerComponent(driver); // ??
        currencyListContainerComponent = new CurrencyListContainerComponent(driver);
        addButton = driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary"));
        deleteButton = driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger"));
    }


    private void clickAddButton() {
        addButton.click();
    }

    private void clickDeleteButton() {
        deleteButton.click();
    }

    public AddNewCurrencyPage goToAddNewCurrencyPage() {
        clickAddButton();
        return new AddNewCurrencyPage(driver);
    }


    public void deleteCurrency(Currency currency) {
        currencyListContainerComponent.selectCurrencyByName(currency.getTitle());
        clickDeleteButton();
        //work with alert TODO
        driver.switchTo().alert().accept();

    }


}
