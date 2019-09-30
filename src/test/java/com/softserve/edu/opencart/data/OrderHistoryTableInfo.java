package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.pages.user.account.OrderDetailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryTableInfo {
    private WebElement element;
    private WebDriver driver;
    private WebElement orderId;
    private WebElement customer;
    private WebElement countOfProducts;
    private WebElement status;
    private WebElement totalPrice;
    private WebElement dateAdd;
    private WebElement lookDetailButton;

    public OrderHistoryTableInfo( WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        orderId = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//td[@class ='text-right' and contains(text(),'#')]"));
        lookDetailButton = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//td[@class ='text-right']/a"));
    }

    public OrderDetailPage clickLookDetailButton() {
        lookDetailButton.click();
        return new OrderDetailPage(driver);
    }

    public String getIdInform() {
        return orderId.getText();
    }

}
