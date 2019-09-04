package feedbacktesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class which includes all elements and methods in login page foradmin  logging in OpenCart system.
 * <p>
 * version 1
 */
public class LoginAdminOC {

    private static final String BASE_URL_admin = "http://192.168.68.132/opencart/upload/admin/";
    public WebDriver driver;

    @FindBy(id = "input-username")
    private WebElement adminUsernameBox;

    @FindBy(id = "input-password")
    private WebElement adminPasswordBox;

    //@FindBy (xpath = "//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
    @FindBy(css = "div.text-right button")
    private WebElement adminLogInButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/h1")
    private WebElement dashboard;

    /**
     * Open admin login page.
     */
    public void open() {
        driver.get(BASE_URL_admin);
    }


    public LoginAdminOC(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on 'Login' button.
     */
    public void ClickOnAdminLogin() {
        adminLogInButton.click();
    }

    /**
     * Founding namebox and entering the name.
     *
     * @param username of admin.
     */
    public void enterAdminUsername(String username) {
        adminUsernameBox.click();
        adminUsernameBox.clear();
        adminUsernameBox.sendKeys(username);
    }

    /**
     * Founding namebox and entering the password.
     *
     * @param password of admin.
     */
    public void enterAdminPassword(String password) {
        adminPasswordBox.click();
        adminPasswordBox.clear();
        adminPasswordBox.sendKeys(password);
    }

    /**
     * Includes previous methods for admin logging.
     *
     * @param username of admin.
     * @param password of admin.
     */
    public void AdminLoginAs(String username, String password) {
        enterAdminUsername(username);
        enterAdminPassword(password);
        ClickOnAdminLogin();
    }

}
