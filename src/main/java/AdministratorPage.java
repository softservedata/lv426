import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdministratorPage {
    private static final String BASE_URL = "http://192.168.238.129/opencart/upload/admin";
    private WebDriver driver;
    @FindBy(id = "input-username")
    private WebElement username;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(css = "button.btn.btn-primary")
    private WebElement loginButton;
    @FindBy(css = "i.fa.fa-user.fw")
    private WebElement customersIcon;
    @FindBy(css ="#menu-customer > ul > li:nth-child(1) > a")
    private WebElement customersLink;
    @FindBy(id="input-name")
    private WebElement customerName;
    @FindBy(id="button-filter")
    private WebElement buttonFilter;
    @FindBy(css="a.btn.btn-warning")
    private WebElement warningButton;

    public AdministratorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void clickOnCustomersIcon(){
        customersIcon.click();
    }
    public void goToCustomersLink(){
        customersLink.click();
    }
    public void filterByName(String name){
        customerName.sendKeys(name);
        buttonFilter.click();
    }

    public void login(String usernameData, String passwordData) {
        username.clear();
        username.sendKeys(usernameData);
        password.clear();
        password.sendKeys(passwordData);
        loginButton.click();
    }
    public void unblockUser(){
        warningButton.click();
    }
}
