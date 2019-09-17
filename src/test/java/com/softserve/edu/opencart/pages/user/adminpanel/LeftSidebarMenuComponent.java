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

    //
    private MenuButtonComponent getMenuComponent(By path) {
        return new MenuButtonComponent(driver, path);
    }

    private void clickSystemMenu() {
        buttonSearching(AdminMenuButtons.SYSTEM).button.click();
    }

    private void clickProductMenu() {
        buttonSearching(AdminMenuButtons.CATALOG).button.click();
    }

    private void clickCustomerMenu() {
        buttonSearching(AdminMenuButtons.CUSTOMERS).button.click();
    }

    //func
    private void clickLocalizationMenu() {
        clickSystemMenu();
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
        getMenuComponent(By.xpath("//a[contains(text(),'Reviews')]")).button.click();
    }
    private void clickCustomerButton() {
        getMenuComponent(By.xpath("//a[contains(text(),'Customers')]")).button.click();
    }


    private MenuButtonComponent buttonSearching(AdminMenuButtons name) {
        menuButton = null;
        for (WebElement current : dropDowmMenuList) {
            if (current.getText().equals(name.toString())) {
                menuComponent = new MenuButtonComponent(driver, By.id(name.toString()));
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
        clickCurrencyButton();
        return new CurrencyPage(driver);
    }

    public TaxRatesPage goToTaxRatesPage() {
        clickTaxesMenu();
        clickTaxRatesButton();
        return new TaxRatesPage(driver);
    }

    public TaxRatesPage goToTaxClassPage() {
        clickTaxesMenu();
        clickTaxClassButton();
        return new TaxRatesPage(driver);
    }

    public ProductPage goToProductPage() {
        clickProductMenu();
        clickProductButton();
        return new ProductPage(driver);
    }

    public ReviewPage goToReviewPage() {
        clickProductMenu();
        clickReviewButton();
        return new ReviewPage(driver);
    }

    public CustomersPage goToCustomersPage() {
        clickCustomerMenu();
        clickCustomerButton();
        return new CustomersPage(driver);
    }


}
