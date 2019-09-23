package com.softserve.edu.opencart.data.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrderTableComponents {

    private WebDriver driver;
    private WebElement element;

    private WebElement productName;
    private WebElement model;
    private WebElement quantity;
    private WebElement unitPrice;
    private WebElement total;
    private WebElement subTotal;
    private WebElement flatRate;
    private WebElement totalOfAllOerders;

    public ConfirmOrderTableComponents(WebElement element){
        this.element = element;
        initElements();
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getQuantity() {
        return quantity;
    }

    public WebElement getUnitPrice() {
        return unitPrice;
    }

    public WebElement getTotal() {
        return total;
    }

    public WebElement getSubTotal() {
        return subTotal;
    }

    public WebElement getFlatRate() {
        return flatRate;
    }

    public WebElement getTotalOfAllOerders() {
        return totalOfAllOerders;
    }

    private void initElements(){
        productName = driver.findElement(By.cssSelector("div.panel-body tbody tr td.text-left a"));
        model = driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']//tbody//td/a/../" +
                "following-sibling::td[@class=\"text-left\"]"));
        quantity = driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']" +
                "//tbody//tr/td[@class='text-right'][1]"));
        unitPrice = driver.findElement(By.xpath("//div[@class='panel-collapse collapse in']" +
                "//tbody//tr/td[@class='text-right'][2]"));
        total = driver.findElement(By.cssSelector("//div[@class='panel-collapse collapse in']" +
                "//tbody//tr/td[@class='text-right'][3]"));
        subTotal = driver.findElement(By.xpath("//tfoot/tr/td/strong[contains(text(),'Sub-Total')]" +
                "/../following-sibling::td"));
        flatRate = driver.findElement(By.xpath("//tfoot/tr/td/strong[contains(text(),'Flat')]" +
                "/../following-sibling::td"));
        totalOfAllOerders = driver.findElement(By.xpath("//tfoot/tr/td/strong[contains(text(),'Flat')]" +
                "/../../following-sibling::tr/td/strong[contains(text(),'Total')]/../following-sibling::td"));
    }
}
