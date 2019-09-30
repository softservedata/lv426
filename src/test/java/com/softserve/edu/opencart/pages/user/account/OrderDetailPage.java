package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetailPage extends AccountSidebarLoggedPart {

    /**
     * This variable is button Return Order
     */
    private WebElement returnButton;

    /**
     * This variable is button Reorder Order
     */
    private WebElement reorderButton;

    /**
     * This variable for catching message about success reordering
     */
    private WebElement actionMessage;

    public OrderDetailPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        this.returnButton = driver.findElement(By.xpath(
                "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-danger')]"));
        this.reorderButton = driver.findElement(By.xpath(
                "//td[contains(text(),'iPhone')]/following-sibling::td/a[contains(@class,'btn btn-primary')]"));
        //       this.actionMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-success']"));
    }

    /**
     * This method for click on button Return Order
     */
    public ReturnOrderPage returnButtonClick() {
        returnButton.click();
        return new ReturnOrderPage(driver);
    }

    /**
     * This method for click on button Reorder Order
     */
    public OrderDetailPage reorderButtonClick() {
        reorderButton.click();
        return new OrderDetailPage(driver);
    }

    /**
     * This method for catch text from message about success reordering
     */
    public String getActionMessage() {
        return actionMessage.getText();
    }
}
