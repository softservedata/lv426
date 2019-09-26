package com.softserve.edu.opencart.data.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;

@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class FinalPriceTable {
    private WebElement element;
    private WebDriver driver;
//table elements
    private WebElement subTotal;
    private WebElement ecoTax;
    private WebElement vat;
    private WebElement total;

    public FinalPriceTable(WebElement element, WebDriver driver){
        this.element = element;
        this.driver = driver;
        initElements();
    }
    private void initElements(){
    }

    public WebElement getSubTotalWeb() {
        subTotal = (new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                        "//td/strong[contains(text(),'Sub-Total:')]/../following-sibling::td"))));

        return subTotal;
    }

    public WebElement getEcoTaxWeb() {
        ecoTax = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                "//td/strong[contains(text(),'Eco Tax')]/../following-sibling::td"));
        return ecoTax;
    }

    public WebElement getVatWeb() {
        vat = driver.findElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                "//td/strong[contains(text(),'VAT')]/../following-sibling::td"));
        return vat;
    }

    public WebElement getTotalWeb() {
        total = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']" +
                        "//td/strong[contains(text(),'VAT')]/../../following-sibling::tr/td/strong[contains(text(),'Total:')]" +
                        "/../following-sibling::td[last()]")));
        return total;
    }

    //functional
     public String getTotal(){
        return getTotalWeb().getText();
     }

     public String getVat(){
        return getVatWeb().getText();
     }

     public String getEcoTax(){
        return getEcoTaxWeb().getText();
     }

     public String getSubTotal(){
        return getSubTotalWeb().getText();
     }
}
