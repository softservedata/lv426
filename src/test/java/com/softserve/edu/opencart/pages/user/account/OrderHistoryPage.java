package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderHistoryPage extends AccountSidebarLoggedPart{

    /** This variable is button Look Order */
    private WebElement lookButton;



    public OrderHistoryPage(WebDriver driver, WebElement firstname) {
        super(driver);
        initElements();
    }

    private void initElements() {
        this.lookButton = driver.findElement(By.xpath("//td[contains(text(),'#3')]/following-sibling::td/a[contains(@class,'btn btn-info')]"));
    }

    public void lookClick() {
        lookButton.click();
    }
}
