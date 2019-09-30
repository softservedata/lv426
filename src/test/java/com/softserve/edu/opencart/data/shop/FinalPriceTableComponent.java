package com.softserve.edu.opencart.data.shop;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Setter
@NoArgsConstructor
public class FinalPriceTableComponent {
    private WebElement element;
    private WebDriver driver;

    public FinalPriceTableComponent(WebElement element, WebDriver driver) {
        this.element = element;
        this.driver = driver;
        initElements();
    }

    private void initElements() {
    }

    private WebElement getWebTitle() {
        return element.findElement(By.xpath("./td/strong"));
    }

    private WebElement getWebPrice() {
        return element.findElement(By.xpath("./td[last()]"));
    }

    public String getTitle() {
        return getWebTitle().getText();
    }

    public String getPrice() {
        return getWebPrice().getText();
    }
}


