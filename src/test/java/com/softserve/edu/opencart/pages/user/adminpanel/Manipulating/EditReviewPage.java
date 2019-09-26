package com.softserve.edu.opencart.pages.user.adminpanel.Manipulating;

import com.softserve.edu.opencart.pages.user.adminpanel.LeftSidebarMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditReviewPage extends LeftSidebarMenuComponent {


    private WebDriver driver;
    private WebElement authorField;
    private WebElement productField;
    private WebElement textField;
    private WebElement ratingButton;
    private WebElement dateComponent;
    private WebElement statusButton;
    private WebElement enableButton;
    private WebElement saveButton;




    public EditReviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        statusButton=driver.findElement(By.id("input-status"));
        enableButton=driver.findElement(By.xpath("//*[@id=\"input-status\"]/option[1]"));
        saveButton=driver.findElement(By.cssSelector("div.pull-right button"));

    }

    public WebElement getAuthorField() {
        return authorField;
    }

    public WebElement getProductField() {
        return productField;
    }

    public WebElement getTextField() {
        return textField;
    }

    public WebElement getRatingButton() {
        return ratingButton;
    }

    public WebElement getDateComponent() {
        return dateComponent;
    }

    public WebElement getStatusButton() {
        return statusButton;
    }

    public WebElement getEnableButton() {
        return enableButton;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public void clickStatusButton(){
        getStatusButton().click();
    }

    public void clickEnableButton(){
        getEnableButton().click();
    }

    public void clickSaveButon(){
        getSaveButton().click();
    }

    public void enableReview(){
        clickStatusButton();
        clickEnableButton();
        clickSaveButon();
    }
}
