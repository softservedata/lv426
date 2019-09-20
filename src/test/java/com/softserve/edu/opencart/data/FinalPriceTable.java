package com.softserve.edu.opencart.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;

public class FinalPriceTable {
    private WebElement element;
    private WebDriver driver;
//table elements
    private WebElement subTotal;
    private WebElement ecoTax;
    private WebElement vat;
    private WebElement total;

    public FinalPriceTable(WebElement element){
        this.element = element;
        initElements();
    }

    private void initElements(){
        subTotal = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                "//td/strong[contains(text(),'Sub-Total:')]/../following-sibling::td"));
        ecoTax = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                "//td/strong[contains(text(),'Eco Tax')]/../following-sibling::td"));
        vat = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                "//td/strong[contains(text(),'VAT')]/../following-sibling::td"));
        total = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                "//td/strong[contains(text(),'VAT')]/../../following-sibling::tr/td/strong[contains(text(),'Total:')]" +
                "/../following-sibling::td[last()]"));
    }

    public WebElement getSubTotal() {
        return subTotal;
    }

    public WebElement getEcoTax() {
        return ecoTax;
    }

    public WebElement getVat() {
        return vat;
    }

    public WebElement getTotal() {
        return total;
    }
}
