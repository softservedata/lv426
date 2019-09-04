package feedbacktesting;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Includes all elements needed in main page and methods for working with them.
 * <p>
 * version 1.
 */
public class MainPageOC {

    private static final String BASE_URL = "http://192.168.68.132/opencart/upload/";
    private WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement accountLink;


    //@FindBy(linkText = "Login")
    @FindBy(xpath = "//ul[contains(@class, 'dropdown-menu dropdown-menu-right')]//a[contains(text(),'Login')]")
    private WebElement loginLink;


    @FindBy(xpath = "//*[@id=\"logo\"]/a/img")
    private WebElement successOpening;

    public MainPageOC(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Open Opencart main page.
     */
    public void open() {
        driver.get(BASE_URL);
    }

    /**
     * Checking is needed page open.
     *
     * @return true or false due to opened page.
     */
    public boolean CheckValidMainPageOpening() {
        return successOpening.getText().contains("Your Store");
    }

    /**
     * Open login page with user login form.
     */
    public void openLogin() {
        driver.get(BASE_URL);
        accountLink.click();
        loginLink.click();
    }


}


