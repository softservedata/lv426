package com.softserve.edu.opencart.pages.user.adminpanel;

import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AdminUser;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AdminUserRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLoginPage {

    private WebDriver driver;

    private WebElement inputLoginField;
    private WebElement inputPasswordField;
    private WebElement loginButton;


    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
        initElements();

    }

    private void initElements() {
        inputLoginField = driver.findElement(By.id("input-username"));
        inputPasswordField = driver.findElement(By.id("input-password"));
        loginButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
    }


    //page obj
    private void clickOnUserNameField() {
        inputLoginField.click();
    }

    private void clearUserNameField() {
        inputLoginField.clear();
    }

    private void clickOnPasswordField() {
        inputPasswordField.click();
    }

    private void clearPasswordField() {
        inputPasswordField.clear();
    }

    private void clickOnLoginButton() {
        loginButton.click();
    }

    //funk
    private void enterUserName(AdminUser adminUser) {
        clickOnUserNameField();
        clearUserNameField();
        inputLoginField.sendKeys(adminUser.getLoginName());
    }

    private void enterPassword(AdminUser adminUser) {
        clickOnPasswordField();
        clearPasswordField();
        inputPasswordField.sendKeys(adminUser.getPassword());
    }

    //BL
    public AdminHomePage goToAdminHomePage() {
        enterUserName(AdminUserRepository.getDefault());
        enterPassword(AdminUserRepository.getDefault());
        clickOnLoginButton();
        return new AdminHomePage(driver);
    }

}
