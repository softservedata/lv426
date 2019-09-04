import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class TestOC {
    private static final String DRIVER_PATH = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
    private String email;

    private MainPage mainPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private EditAccountPage editPage;
    private EditPasswordPage passwordPage;

    private WebDriver driver;

    private String BuildRandomEmail() {
        String SaltCHARS = "abcdefghigklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SaltCHARS.length());
            salt.append(SaltCHARS.charAt(index));
        }
        return salt.toString();
    }

    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();

        mainPage = PageFactory.initElements(driver, MainPage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        editPage = PageFactory.initElements(driver, EditAccountPage.class);
        passwordPage = PageFactory.initElements(driver, EditPasswordPage.class);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void setEmail() {
        email = BuildRandomEmail() + "@gmail.com";
        mainPage.openRegistration();
    }

    //@AfterTest
    public void close() {
        driver.quit();
    }

    @Test()
    public void invalidRegisterWithoutConfirmPrivacyPolicyTest() throws InterruptedException {

        assertTrue(mainPage.CheckValidRegisterPageOpening());

        registerPage.registerAs("Doo", "Foo", email,
                "0987654321", "12345", "Softserve",
                "Kotl 10", "Karm 34", "Lviv",
                "Ukraine", "L'vivs'ka Oblast'", "89987",
                "DooLoo123", "DooLoo123");

        registerPage.clickOnRegisterButton();
        Thread.sleep(4000);

        assertTrue(registerPage.checkWithoutConfirmPrivacyPolicy());

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooLoo123");

        assertTrue(loginPage.CheckInvalidLogin());
        Thread.sleep(2000);

    }

    @Test
    public void invalidFirstNameAtRegistrationTest() throws InterruptedException {

        assertTrue(mainPage.CheckValidRegisterPageOpening());

        registerPage.registerAs("Doooooooooooooooooooooooooooooooo",
                "Loo", email, "0987654321", "12345",
                "Softserve", "Kotl 10", "Karm 34",
                "Lviv", "Ukraine", "L'vivs'ka Oblast'",
                "89987", "DooLoo123", "DooLoo123");

        registerPage.clickOnPrivacyPolicyAgree();
        registerPage.clickOnRegisterButton();
        Thread.sleep(4000);

        assertTrue(registerPage.checkWithInvalidFirstNameInput());

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooLoo123");

        assertTrue(loginPage.CheckInvalidLogin());
        Thread.sleep(2000);
    }

    @Test
    public void invalidLastNameAtRegistrationTest() throws InterruptedException{

        assertTrue(mainPage.CheckValidRegisterPageOpening());

        registerPage.registerAs("Doo",
                "", email, "0987654321", "12345",
                "Softserve", "Kotl 10", "Karm 34",
                "Lviv", "Ukraine", "L'vivs'ka Oblast'",
                "89987", "DooLoo123", "DooLoo123");

        registerPage.clickOnPrivacyPolicyAgree();
        registerPage.clickOnRegisterButton();
        Thread.sleep(4000);

        assertTrue(registerPage.checkWithInvalidLastNameInput());

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooLoo123");

        assertTrue(loginPage.CheckInvalidLogin());
        Thread.sleep(2000);
    }

    @Test
    public void validRegisterTestAndEditAccount() throws InterruptedException{

        assertTrue(mainPage.CheckValidRegisterPageOpening());

        registerPage.registerAs("Doo", "Foo", email,
                "0987654321", "12345", "Softserve",
                "Kotl 10", "Karm 34", "Lviv",
                "Ukraine", "L'vivs'ka Oblast'", "89987",
                "DooLoo123", "DooLoo123");

        registerPage.clickOnPrivacyPolicyAgree();
        registerPage.clickOnRegisterButton();
        Thread.sleep(2000);

        assertTrue(registerPage.checkValidRegistration());

        mainPage.LogOut();
        Thread.sleep(1000);

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooLoo123");

        assertTrue(loginPage.CheckValidLogin());
        Thread.sleep(2000);

        editPage.editAccountAs("Doo", "Coo", email,
                "0987654322", "123123");
        editPage.clickOnContinueButton();

        assertTrue(editPage.checkValidAccountEdit());
        Thread.sleep(3000);

        mainPage.LogOut();
    }

    @Test
    public void validRegisterTestAndEditPassword() throws InterruptedException{

        assertTrue(mainPage.CheckValidRegisterPageOpening());

        registerPage.registerAs("Doo", "Foo", email,
                "0987654321", "12345", "Softserve",
                "Kotl 10", "Karm 34", "Lviv",
                "Ukraine", "L'vivs'ka Oblast'", "89987",
                "DooLoo123", "DooLoo123");

        registerPage.clickOnPrivacyPolicyAgree();
        registerPage.clickOnRegisterButton();
        Thread.sleep(2000);

        assertTrue(registerPage.checkValidRegistration());

        mainPage.LogOut();
        Thread.sleep(1000);

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooLoo123");

        assertTrue(loginPage.CheckValidLogin());
        Thread.sleep(1000);

        passwordPage.editPasswordAs("DooCoo123", "DooCoo123");

        passwordPage.clickOnContinueButton();

        assertTrue(passwordPage.checkValidPasswordEdit());
        Thread.sleep(3000);

        mainPage.LogOut();
        Thread.sleep(1000);

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooCoo123");
        Thread.sleep(1000);

        assertTrue(loginPage.CheckValidLogin());
        Thread.sleep(2000);

        mainPage.LogOut();
    }

    @Test
    public void validRegisterTestAndEditPasswordWithoutSaving() throws InterruptedException{

        assertTrue(mainPage.CheckValidRegisterPageOpening());

        registerPage.registerAs("Doo", "Foo", email,
                "0987654321", "12345", "Softserve",
                "Kotl 10", "Karm 34", "Lviv",
                "Ukraine", "L'vivs'ka Oblast'", "89987",
                "DooLoo123", "DooLoo123");

        registerPage.clickOnPrivacyPolicyAgree();
        registerPage.clickOnRegisterButton();
        Thread.sleep(2000);

        assertTrue(registerPage.checkValidRegistration());

        mainPage.LogOut();
        Thread.sleep(1000);

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooLoo123");

        assertTrue(loginPage.CheckValidLogin());

        passwordPage.editPasswordAs("DooCoo123", "DooCoo123");

        passwordPage.clickOnBackButton();
        Thread.sleep(2000);

        mainPage.LogOut();
        Thread.sleep(1000);

        mainPage.openLogin();

        assertTrue(mainPage.CheckValidLoginPageOpening());

        loginPage.LoginAs(email, "DooLoo123");
        Thread.sleep(1000);

        assertTrue(loginPage.CheckValidLogin());
        Thread.sleep(2000);

        mainPage.LogOut();
    }
}