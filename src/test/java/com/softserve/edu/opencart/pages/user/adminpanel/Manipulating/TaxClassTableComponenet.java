package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.data.GeoZone;
import com.softserve.edu.opencart.data.TaxClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditProductPage.LAST_ROW_IN_TABLE;

public class TaxClassTableComponenet {
    private WebDriver driver;
    private WebElement tableElement;
    private Select component;
    private WebElement deleteButton;

    public TaxClassTableComponenet(WebDriver driver) {
        this.driver = driver;
        initElements();

    }
    private void initElements() {
        tableElement = driver.findElement(By.xpath(LAST_ROW_IN_TABLE));
        deleteButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        component = new Select(tableElement.findElement(By
                .xpath("//table[@id='tax-rule']/tbody/tr[last()]//select[contains(@name, 'tax_rate_id')]")));

    }
    private void clickDeleteButton() {
        deleteButton.click();
    }
    public void choseTaxClass(TaxClass tax) {
        component.selectByVisibleText(tax.getName());
    }

}
