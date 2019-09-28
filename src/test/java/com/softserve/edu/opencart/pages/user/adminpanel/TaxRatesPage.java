package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.TaxRate;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AddTaxRatePage;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AdminListContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaxRatesPage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement addButton;
    private WebElement deleteButton;
    private AdminListContainerComponent listContainerComponent;

    public TaxRatesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }


    private void initElements() {
        listContainerComponent = new AdminListContainerComponent(driver); // ??
        addButton = driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary"));
        deleteButton = driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger"));
    }

    private void asseptAlert() {
        driver.switchTo().alert().accept();
    }

    private void clickAddButton() {
        addButton.click();
    }

    private void clickDeleteButton() {
        deleteButton.click();
    }


    public AddTaxRatePage goToAddTaxRatePage() {
        clickAddButton();
        return new AddTaxRatePage(driver);
    }


    //return new TaxRatePage or this ?
    public TaxRatesPage deleteTaxRate(TaxRate taxRate) {
        listContainerComponent.selectByName(taxRate.getName());
        clickDeleteButton();
        asseptAlert();
        return new TaxRatesPage(driver);

    }

}
