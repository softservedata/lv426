import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *  Class which contains all main elements and methods
 *  to open another pages
 */
public class MainPage {
    private static final String BASE_URL = "http://192.168.45.130/opencart/upload/";

    private WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'My Account')]")
    private WebElement accountLink;

    @FindBy(xpath = "//a[contains(text(), 'Register')]")
    private WebElement registerLink;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutLink;

    @FindBy(id = "content")
    private WebElement successOpeningRegister;

    @FindBy(xpath = "//div[contains(@class, 'row')]//h2[contains(text(), 'Returning Customer')]")
    private WebElement successOpeningLogin;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private void open() {
        //open Open Cart application
        driver.get(BASE_URL);
    }

    boolean CheckValidRegisterPageOpening() {
        //verify success Register page opening
        return successOpeningRegister.getText().contains("Register Account");
    }

    boolean CheckValidLoginPageOpening() {
        //verify success Login page opening
        return successOpeningLogin.getText().contains("Returning Customer");
    }

    void openRegistration() {
        //open Registration page
        open();
        accountLink.click();
        registerLink.click();
    }

    void openLogin() {
        //open Login page
        open();
        accountLink.click();
        loginLink.click();
    }

    void LogOut() {
        //log out from login page
        accountLink.click();
        logoutLink.click();
    }
}
