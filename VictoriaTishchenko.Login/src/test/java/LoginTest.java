
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver;

    @BeforeMethod
    public static void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vik\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public static void tearDownAfterClass() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testLoginOpenCart1() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.accountLocalization();
        loginPage.loginLocalization();
        loginPage.login(System.getenv().get("EMAIL_ADDRESS"), System.getenv().get("OPENCART_PASSWORD"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(driver.findElement(By.linkText("Edit your account information")));
    }

    @Test
    public void testLoginOpenCart2() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.accountLocalization();
        loginPage.loginLocalization();
        loginPage.login((System.getenv().get("EMAIL_ADDRESS")), System.getenv().get("ANOTHER_OPENCART_PASSWORD"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(driver.findElement(By.cssSelector("div.alert.alert-danger")));
    }

    @Test
    public void testLoginOpenCart3() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.accountLocalization();
        loginPage.loginLocalization();
        loginPage.login("vika@gmail.com", System.getenv().get("OPENCART_PASSWORD"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(driver.findElement(By.cssSelector("div.alert.alert-danger")));
    }

    @Test
    public void testLoginOpenCartForgottenPassword() throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ForgottenPasswordPage forgottenPasswordPage = PageFactory.initElements(driver, ForgottenPasswordPage.class);
        UkrNetPage ukrNetPage = PageFactory.initElements(driver, UkrNetPage.class);
        loginPage.open();
        loginPage.accountLocalization();
        loginPage.loginLocalization();
        loginPage.goToForgottenPassword();
        forgottenPasswordPage.sendEmail(System.getenv().get("EMAIL_ADDRESS"));
        Assert.assertNotNull(driver.findElement(By.cssSelector("div.alert.alert-success")));
        ukrNetPage.open();
        ukrNetPage.login(System.getenv().get("EMAIL_LOGIN"), System.getenv().get("EMAIL_PASSWORD"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        ukrNetPage.goToUnreadMessages();
        ukrNetPage.readMail();
        ukrNetPage.goToChangePasswordLink();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        ResetPasswordPage resetPasswordPage = PageFactory.initElements(driver, ResetPasswordPage.class);
        resetPasswordPage.resetPassword(System.getenv().get("OPENCART_PASSWORD"), System.getenv().get("OPENCART_PASSWORD"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertNotNull(driver.findElement(By.cssSelector("div.alert.alert-success")));
        loginPage.login(System.getenv().get("EMAIL_ADDRESS"), System.getenv().get("OPENCART_PASSWORD"));
        Assert.assertNotNull(driver.findElement(By.linkText("Edit your account information")));
    }

    @Test
    public void testLoginOpenCartChangePassword() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ChangePasswordPage changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        loginPage.open();
        loginPage.accountLocalization();
        loginPage.loginLocalization();
        loginPage.login(System.getenv().get("EMAIL_ADDRESS"), System.getenv().get("OPENCART_PASSWORD"));
        loginPage.goToChangePassword();
        changePasswordPage.changePassword(System.getenv().get("OPENCART_PASSWORD"), System.getenv().get("OPENCART_PASSWORD"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(driver.findElement(By.cssSelector("div.alert.alert-success")));
    }

    @Test
    public void testLoginOpenCartChangePasswordInvalid() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ChangePasswordPage changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        loginPage.open();
        loginPage.accountLocalization();
        loginPage.loginLocalization();
        loginPage.login(System.getenv().get("EMAIL_ADDRESS"), System.getenv().get("OPENCART_PASSWORD"));
        loginPage.goToChangePassword();
        changePasswordPage.changePassword(System.getenv().get("OPENCART_PASSWORD"), System.getenv().get("ANOTHER_OPENCART_PASSWORD"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertNotNull(driver.findElement(By.cssSelector("div.text-danger")));
    }

    @Test
    public void testBlockandUnblockUser() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();
        loginPage.accountLocalization();
        loginPage.loginLocalization();
        for (int i = 0; i < 6; i++) {
            loginPage.login(System.getenv().get("EMAIL_ADDRESS"), System.getenv().get("ANOTHER_OPENCART_PASSWORD"));
        }
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        AdministratorPage administratorPage = PageFactory.initElements(driver, AdministratorPage.class);
        administratorPage.open();
        administratorPage.login("admin", System.getenv().get("OPENCART_PASSWORD"));
        administratorPage.clickOnCustomersIcon();
        administratorPage.goToCustomersLink();
        administratorPage.filterByName("Test1 Test1");
        administratorPage.unblockUser();
        driver.switchTo().window(tabs2.get(0));
        loginPage.login(System.getenv().get("EMAIL_ADDRESS"), System.getenv().get("OPENCART_PASSWORD"));
    }
}
