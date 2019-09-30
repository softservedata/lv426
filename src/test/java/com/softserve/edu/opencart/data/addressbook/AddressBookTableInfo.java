package com.softserve.edu.opencart.data.addressbook;

import com.softserve.edu.opencart.pages.user.addressbook.AddressBookPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBookTableInfo  {
    private WebDriver driver;
    private WebElement element;
    private WebElement addressInfo;
    private WebElement editButton;
    private WebElement deleteButton;

    public AddressBookTableInfo( WebDriver driver) {
        this.driver = driver;
        initElemnts();
    }

    public void initElemnts() {
        addressInfo = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//td[contains(@class,'text-left')]"));
        editButton = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//td[contains(@class,'text-right')]"+"//a[@class = 'btn btn-info']"));
        deleteButton = driver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "//td[contains(@class,'text-right')]"+"//a[@class = 'btn btn-danger']"));
    }

    public String getAddressInfo() {
        return addressInfo.getText();
    }

    public void clickEditButton() {
        editButton.click();
    }
    public void clickDeleteButton() {
        deleteButton.click();
    }

}
