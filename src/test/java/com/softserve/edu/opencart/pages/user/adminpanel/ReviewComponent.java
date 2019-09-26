package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditReviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewComponent {


    private WebDriver driver;
    private WebElement actionButton;


    ReviewComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements(){

        actionButton = driver.findElement(By.cssSelector("tr a.btn.btn-primary"));
    }

    private void clickActionButton() {
        actionButton.click();
    }


    public EditReviewPage goToEditReviewPage() {
        clickActionButton();
        return new EditReviewPage(driver);

    }
}
