package feedbacktesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class which includes all elements and methods needed for users logging in login page.
 * <p>
 * version 1.
 */
public class LoginPageOC {
    private WebDriver driver;

    @FindBy(css = "input[class=\"btn btn-primary\"]")
    private WebElement loginButton;

    @FindBy(id = "input-email")
    private WebElement emailLink;

    @FindBy(xpath = "//*[@id=\"content\"]")
    public WebElement successLogin;

    @FindBy(id = "input-password")
    private WebElement passwordLink;

    public LoginPageOC(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on 'Login' button.
     */
    public void ClickOnLogin() {
        loginButton.click();
    }

    /**
     * Check is right page open after logging.
     *
     * @return true or false due to page opened after logining.
     */
    public boolean CheckValidLogin() {
        return successLogin.getText().contains("My Account");
    }

    /**
     * Enter user e-mail in detected e-mail box.
     *
     * @param email user e-mail.
     */
    public void enterEmail(String email) {
        emailLink.click();
        emailLink.clear();
        emailLink.sendKeys(email);
    }

    /**
     * Enter user password in detected password box.
     *
     * @param password user password.
     */
    public void enterPassword(String password) {
        passwordLink.click();
        passwordLink.clear();
        passwordLink.sendKeys(password);
    }

    /**
     * Includes privious methods for user logging.
     *
     * @param email    user e-mail.
     * @param password user password.
     */
    public void LoginAs(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        ClickOnLogin();
    }
}

