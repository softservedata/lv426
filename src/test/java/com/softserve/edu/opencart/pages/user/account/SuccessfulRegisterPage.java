package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.pages.user.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessfulRegisterPage extends AccountSidebarLoggedPart{

    private WebElement continueButton;

    public SuccessfulRegisterPage(WebDriver driver) {
        super(driver);
        initElements();
        ApplicationStatus.get().setLogged(true);
    }

    private void initElements() {
        continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='account']"));
    }

    // Page Object

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional

    // Business Logic

    public MyAccountPage gotoContinue(){
        clickContinueButton();
        return new MyAccountPage(driver);
    }
}

