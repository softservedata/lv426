import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UkrNetPage {
    private static final String BASE_URL = "https://mail.ukr.net/desktop#msglist/f0/p0";
    private WebDriver driver;
    @FindBy(id = "id-l")
    private WebElement loginName;
    @FindBy(id = "id-p")
    private WebElement password;
    @FindBy(css = "button.button_style-main.button_size-regular.form__submit")
    private WebElement loginButton;
    @FindBy(xpath = "//*[text() = 'Your Store - Password reset request']")
    private WebElement passwordResetMail;
    @FindBy(css = "a[href*='http://192.168.238.129/opencart/upload/']")
    private WebElement passwordResetLink;
    @FindBy(id = "unread")
    private WebElement unreadLink;

    public UkrNetPage(WebDriver driver) {

        this.driver = driver;
    }

    public void login(String loginNameData, String passwordData) {
        loginName.clear();
        loginName.sendKeys(loginNameData);
        password.clear();
        password.sendKeys(passwordData);
        loginButton.click();
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void goToUnreadMessages() {
        unreadLink.click();
    }

    public void readMail() {
        passwordResetMail.click();
    }

    public void goToChangePasswordLink() {
        passwordResetLink.click();
    }
}
