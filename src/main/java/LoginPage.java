import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private static final String BASE_URL = "http://192.168.238.129/opencart/upload";
    // private static final String BASE_URL = "https://demo.opencart.com";
    private static final String ACCOUNT_LINK = "My Account";
    private static final String LOGIN_LINK = "Login";

    private WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement accountLink;
    @FindBy(linkText = "Login")
    private WebElement loginLink;
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(linkText = "Forgotten Password")
    private WebElement forgottenPassword;
    @FindBy(css = "input.btn.btn-primary")
    private WebElement loginButton;
    @FindBy(linkText = "Change your password")
    private WebElement changePasswordLink;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void accountLocalization() {
        accountLink.click();
    }

    public void loginLocalization() {
        loginLink.click();
    }

    public void login(String emailData, String passwordData) {
        email.clear();
        email.sendKeys(emailData);
        password.clear();
        password.sendKeys(passwordData);
        loginButton.click();
    }

    public void goToForgottenPassword() {
        forgottenPassword.click();
    }

    public void goToChangePassword() {
        changePasswordLink.click();
    }
}
