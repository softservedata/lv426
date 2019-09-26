package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.EditReviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewComponent {

    protected WebElement reviewChoose;
    private WebDriver driver;
    private WebElement actionButton;


    ReviewComponent(WebDriver driver, WebElement productChoose) {
        this.driver = driver;
        this.reviewChoose = reviewChoose;
        initElements();
    }

    private void initElements(){

        actionButton = reviewChoose.findElement(By.cssSelector("tr a.btn.btn-primary"));
    }

    private void clickActionButton() {
        actionButton.click();
    }


    public EditReviewPage goToEditReviewPage() {
        clickActionButton();
        return new EditReviewPage(driver);

    }
}
