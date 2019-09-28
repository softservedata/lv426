package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.data.ICurrency;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AddNewCurrencyPage;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AdminListContainerComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class CurrencyPage extends LeftSidebarMenuComponent {
    private WebDriver driver;
    private WebElement addButton;
    private WebElement deleteButton;

    private AdminListContainerComponent listContainerComponent;

    public CurrencyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        listContainerComponent = new AdminListContainerComponent(driver);
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

    public AddNewCurrencyPage goToAddNewCurrencyPage() {
        clickAddButton();
        return new AddNewCurrencyPage(driver);
    }

    public Map<String, Double> getConvertValue() {
        return  listContainerComponent.getMapOfConventValue();
    }


    public CurrencyPage deleteCurrency(ICurrency currency) {
        listContainerComponent.selectByName(currency.getTitle());
        clickDeleteButton();
        asseptAlert();
        return new CurrencyPage(driver);

    }


}
