package com.softserve.edu.opencart.pages.user.mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final String BASE_URL = "https://mail.ukr.net";
    protected WebDriver driver;
    private WebElement loginNameField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        loginNameField = driver.findElement(By.id("id-l"));
        passwordField = driver.findElement(By.id("id-p"));
        loginButton = driver.findElement(By.cssSelector("button.button_style-main.button_size-regular.form__submit"));
    }

    //LoginNameField
    public WebElement getLoginNameField() {
        return loginNameField;
    }

    public void clearLoginNameField() {
        getLoginNameField().clear();
    }

    public void clickLoginNameField() {
        getLoginNameField().click();
    }

    public void setLoginNameField(String text) {
        getLoginNameField().sendKeys(text);
    }

    //PasswordField
    public WebElement getPasswordField() {
        return passwordField;
    }

    public void clearPasswordField() {
        getPasswordField().clear();
    }

    public void clickPasswordField() {
        getPasswordField().click();
    }

    public void setPasswordField(String text) {
        getPasswordField().sendKeys(text);
    }

    //LoginButton
    public WebElement getLoginButton() {
        return loginButton;
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    //Functional
    //LoginNameField
    private void fillLoginNameField(String text) {
      /*  clickLoginNameField();
        clearLoginNameField();*/
        setLoginNameField(text);
    }

    //PasswordField
    private void fillPasswordField(String text) {
       /* clickPasswordField();
        clearPasswordField();*/
        setPasswordField(text);
    }

    //Business Logic
    public MailSidebarPart login(MailUser mailUser) {
        fillLoginNameField(mailUser.getLoginName());
        fillPasswordField(mailUser.getPassword());
        clickLoginButton();
        return new IncomingMailPage(driver);
    }

}

