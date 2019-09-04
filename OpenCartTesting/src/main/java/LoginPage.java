import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class which contains fields and methods
 * to log into application
 */
public class LoginPage {

    @FindBy(css = "input.btn.btn-primary")
    private WebElement loginButton;

    @FindBy(name = "email")
    private WebElement emailLink;

    @FindBy(id = "content")
    private WebElement successLogin;

    @FindBy(css = "div.alert.alert-danger")
    private WebElement unsuccessLogin;

    @FindBy(name = "password")
    private WebElement passwordLink;

    public LoginPage(WebDriver driver) {
    }

    public void ClickOnLogin() {
        //click to login button
        loginButton.click();
    }

    public boolean CheckValidLogin() {
        //verify success Login page opening
        return successLogin.getText().contains("My Account");
    }

    public boolean CheckInvalidLogin() {
        //verify unsuccessful user login
        return unsuccessLogin.getText().contains("No match for E-Mail Address and/or Password.");
    }

    private void enterEmail(String email) {
        //enter email field
        emailLink.click();
        emailLink.clear();
        emailLink.sendKeys(email);
    }

    private void enterPassword(String password) {
        //enter password field
        passwordLink.click();
        passwordLink.clear();
        passwordLink.sendKeys(password);
    }

    public void LoginAs(String email, String password) {
        //log in method
        enterEmail(email);
        enterPassword(password);
        ClickOnLogin();
    }
}