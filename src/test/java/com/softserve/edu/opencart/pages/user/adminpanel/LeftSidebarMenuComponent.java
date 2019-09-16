package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.AdminMenuButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LeftSidebarMenuComponent extends HeaderPart {


    private WebElement dashBoard;
    private List<WebElement> dropDowmMenuList;
    private MenuButtonComponent menuComponent;


    LeftSidebarMenuComponent(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        dropDowmMenuList = driver.findElements(By.id("menu"));
        dashBoard = driver.findElement(By.id("menu-dashboard"));
    }

    //pageobj
    private void clickOnSystemMenu() {
        buttonSearching(AdminMenuButtons.menuButtonsName.SYSTEM.getValue()).button.click();
    }

    private void clickOnProductMenu() {
        buttonSearching(AdminMenuButtons.menuButtonsName.CATALOG.getValue()).button.click();
    }
    private void clickOnCustomerMenu() {
        buttonSearching(AdminMenuButtons.menuButtonsName.CUSTOMERS.getValue()).button.click();
    }

    //func
    private void clickLocalizationMenu() {
        clickOnSystemMenu();
        MenuButtonComponent Localization = new MenuButtonComponent();
        Localization.button = driver.findElement(By.xpath("//a[contains(text(),'Localisation')]"));
        Localization.button.click();
    }

    private void clickOnTaxesMenu() {
        clickLocalizationMenu();
        MenuButtonComponent Taxes = new MenuButtonComponent();
        Taxes.button = driver.findElement(By.xpath("//a[contains(text(),'Taxes')]"));
        Taxes.button.click();

    }


    private MenuButtonComponent buttonSearching(String name) {
        menuButton = null;
        for (WebElement current : dropDowmMenuList) {
            if (current.getText().equals(name)) {
                menuComponent = new MenuButtonComponent();
                break;
            }

        }
        if (menuComponent == null) {
            throw new RuntimeException();
        }
        return menuComponent;
    }

    //bl
    public AdminHomePage goToAdminHomePage() {
        dashBoard.click();
        return new AdminHomePage(driver);
    }

    public CurrencyPage goToCurrencyPage() {
        clickLocalizationMenu();
        MenuButtonComponent currency = new MenuButtonComponent();
        currency.button = driver.findElement(By.xpath("//a[contains(text(),'Currencies')]"));
        currency.button.click();
        return new CurrencyPage(driver);
    }

    public TaxRatesPage goToTaxRatesPage() {
        clickOnTaxesMenu();
        MenuButtonComponent taxRate = new MenuButtonComponent();
        taxRate.button = driver.findElement(By.xpath("//a[contains(text(),'Tax Rates')]"));
        taxRate.button.click();
        return new TaxRatesPage(driver);
    }

    public TaxRatesPage goToTaxClassPage() {
        clickOnTaxesMenu();
        MenuButtonComponent taxClass = new MenuButtonComponent();
        taxClass.button = driver.findElement(By.xpath("//a[contains(text(),'Tax Classes')]"));
        taxClass.button.click();
        return new TaxRatesPage(driver);
    }

    public ProductPage goToProductPage() {
        clickOnProductMenu();
        MenuButtonComponent products = new MenuButtonComponent();
        products.button = driver.findElement(By.xpath("//a[contains(text(),'Products')]"));
        products.button.click();
        return new ProductPage(driver);
    }

    public ReviewPage goToReviewPage() {
        clickOnProductMenu();
        MenuButtonComponent review = new MenuButtonComponent();
        review.button = driver.findElement(By.xpath("//a[contains(text(),'Reviews')]"));
        return new ReviewPage(driver);
    }

    public CustomersPage goToCustomersPage() {
        clickOnCustomerMenu();
        MenuButtonComponent review = new MenuButtonComponent();
        review.button = driver.findElement(By.xpath("//a[contains(text(),'Customers')]"));
        return new CustomersPage(driver);
    }


}
