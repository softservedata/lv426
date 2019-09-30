package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrencyListElementComponent extends AdminListElementComponent {


    private WebElement value;
  //  private WebElement component;

    CurrencyListElementComponent(WebDriver driver, WebElement comp) {
        super(driver, comp);
        this.value = component.findElement(By.xpath(".//td[contains(text(), '.')]"));
    }


    public double getValue() {
        return Double.parseDouble(value.getText());
    }


}
