package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.AdminMenuButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeftSidebarMenuComponent extends HeaderPart {

    public WebDriver driver; // made public
    private WebElement dashBoard;
    private List<WebElement> dropDowmMenuList;
    private MenuButtonComponent menuComponent;


    public LeftSidebarMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        dropDowmMenuList = driver.findElements(By.cssSelector("#menu > li"));
        dashBoard = driver.findElement(By.id("menu-dashboard"));
    }

    //
    private MenuButtonComponent getMenuComponent(By path) {
        return new MenuButtonComponent(driver, path);
    }

    private void clickMenuButton(AdminMenuButtons name) {
        getMenuComponent(By.cssSelector("#" + name.getValue() + " > a")).button.click();
    }

    //func

    private void clickGeoZoneButton() {
        getMenuComponent(By.xpath("//a[contains(text(),'Geo Zones')]")).button.click();
    }






    private void clickSalesMenu() {
        clickMenuButton(AdminMenuButtons.SALES);
    }

    //func

    private void clickLocalizationMenu() {
        clickMenuButton(AdminMenuButtons.SYSTEM);
        getMenuComponent(By.xpath("//a[contains(text(),'Localisation')]")).button.click();
    }

    private void clickTaxesMenu() {
        clickLocalizationMenu();
        getMenuComponent(By.xpath("//a[contains(text(),'Taxes')]")).button.click();

    }

    private void clickCurrencyButton() {
        getMenuComponent(By.xpath("//a[contains(text(),'Currencies')]")).button.click();
    }

    private void clickTaxClassButton() {
        getMenuComponent(By.xpath("//a[contains(text(),'Tax Classes')]")).button.click();
    }

    private void clickTaxRatesButton() {
        getMenuComponent(By.xpath("//a[contains(text(),'Tax Rates')]")).button.click();
    }

    private void clickProductButton() {
        getMenuComponent(By.xpath("//a[contains(text(),'Products')]")).button.click();
    }

    private void clickReviewButton() {
        //getMenuComponent(By.xpath("//a[contains(text(),'Reviews')]")).button.click();
        getMenuComponent(By.xpath("//ul[contains(@id,'menu')]//a[contains(text(),'Reviews')]")).button.click();
    }

    private void clickCustomerButton() {
        getMenuComponent(By.xpath("//a[contains(text(),'Customers')]")).button.click();
    }
    private void clickReturnsButton() {
        getMenuComponent(By.xpath("//li[@id = 'menu-sale']/ul/li/a[contains(text(),'Returns')]")).button.click();
    }



    //bl
    public LeftSidebarMenuComponent closeLocalizationMenu() {
        clickLocalizationMenu();
        return new LeftSidebarMenuComponent(driver);
    }

    public LeftSidebarMenuComponent closeTaxesMenu() {
        clickLocalizationMenu();
        clickTaxesMenu();
        return new LeftSidebarMenuComponent(driver);
    }

    public AdminHomePage goToAdminHomePage() {
        dashBoard.click();
        return new AdminHomePage(driver);
    }

    public CurrencyPage goToCurrencyPage() {
        clickLocalizationMenu();
        clickCurrencyButton();
        return new CurrencyPage(driver);
    }

    public TaxRatesPage goToTaxRatesPage() {
        clickTaxesMenu();
        clickTaxRatesButton();
        return new TaxRatesPage(driver);
    }

    public TaxClassPage goToTaxClassPage() {
        clickLocalizationMenu();
        clickTaxesMenu();
        clickTaxClassButton();
        return new TaxClassPage(driver);
    }

    public ProductPage goToProductPage() {
        clickMenuButton(AdminMenuButtons.CATALOG);
        clickProductButton();
        return new ProductPage(driver);
    }

    public ReviewPage goToReviewPage() {
        clickMenuButton(AdminMenuButtons.CATALOG);
        clickReviewButton();
        return new ReviewPage(driver);
    }

    public GeoZonePage goToGeoZonePage() {
        clickLocalizationMenu();
        clickGeoZoneButton();
        return new GeoZonePage(driver);
    }

    public CustomersPage goToCustomersPage() {
        clickMenuButton(AdminMenuButtons.CUSTOMERS);
        clickCustomerButton();
        return new CustomersPage(driver);
    }

//    public ReturnsPage goToReturnsPage() {
//        clickSalesMenu();
//        clickReturnsButton();
//        return  new  ReturnsPage(driver);
//    }



}
