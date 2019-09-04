import feedbacktesting.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Includes tests for testing feedback leaving and enabling.
 * <p>
 * version 1
 */
public class TestFeedback {

    String driverPath = "C:\\Users\\Admin\\Desktop\\TAQC ITA SoftServe\\chromedriver_win32\\chromedriver.exe";
    private WebDriver driver;


    @BeforeTest
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Testing login user leaving valid feedback with valid length of name and review and rating 1. After that admin have to find it from admin panel, enable,
     * and check will it appear in product review page.
     */
    @Test
    public void loginTest() throws InterruptedException {
        MainPageOC mainPage = PageFactory.initElements(driver, MainPageOC.class);
        mainPage.openLogin();


        LoginPageOC loginPage = PageFactory.initElements(driver, LoginPageOC.class);
        loginPage.LoginAs("ivaqwerty@gmail.com", "root");


        ProfileSearchPage cartPage = PageFactory.initElements(driver, ProfileSearchPage.class);
        cartPage.searchItem("iMac");


        IMacPageOC imacpage = PageFactory.initElements(driver, IMacPageOC.class);
        imacpage.sendReviewR1("iva qwerty", "Good product! I'm so happy that I Bought this amazing iMac computer!");
        Thread.sleep(3000);
        imacpage.sendReviewR5("marta fina", "best thing I`ve ever bought! Very nice device!!!");
        Thread.sleep(3000);
        LoginAdminOC adminlogin = PageFactory.initElements(driver, LoginAdminOC.class);
        adminlogin.open();
        adminlogin.AdminLoginAs("admin", "Lv426_Taqc");


        AdminPageOC adminpage = PageFactory.initElements(driver, AdminPageOC.class);
        adminpage.openReviews();

        ReviewListPageOC reviewpage = PageFactory.initElements(driver, ReviewListPageOC.class);
        reviewpage.filterByProduct("iMac");
        Thread.sleep(3000);
        reviewpage.filterByAuthor("iva qwerty");
        Thread.sleep(3000);
        reviewpage.clickEdit();


        EditReviewPageOC editReview = PageFactory.initElements(driver, EditReviewPageOC.class);
        editReview.enableReview();
        imacpage.open();
        imacpage.checkReview();
        Thread.sleep(3000);


    }

    /**
     * Trying to leave a comment without logining, enter review and rating '2'.
     * Checkin will warning message appear when we won`t enter user name with right length.
     */
    @Test
    public void withoutNameTest() throws InterruptedException {
        MainPageOC mainPage = PageFactory.initElements(driver, MainPageOC.class);
        mainPage.openLogin();


        LoginPageOC loginPage = PageFactory.initElements(driver, LoginPageOC.class);
        loginPage.LoginAs("ivaqwerty@gmail.com", "root");
        Assert.assertTrue(loginPage.CheckValidLogin());


        ProfileSearchPage cartPage = PageFactory.initElements(driver, ProfileSearchPage.class);
        cartPage.searchItem("iMac");


        IMacPageOC imacpage = PageFactory.initElements(driver, IMacPageOC.class);
        Assert.assertTrue(imacpage.CheckValidiMacPageOpening());
        imacpage.sendReviewR2(" ", "Good product! I'm so happy that I Bought this amazing iMac computer!");
        Thread.sleep(3000);
        imacpage.nameWarningExist();

    }

    /**
     * Trying to leave a comment without logining, enter user name and rating '2'.
     * Checkin will warning message appear when we won't enter review with needed length.
     */
    @Test
    public void noLoginShortReviewTest() throws InterruptedException {
        MainPageOC mainPage = PageFactory.initElements(driver, MainPageOC.class);

        mainPage.open();

        ProfileSearchPage cartPage = PageFactory.initElements(driver, ProfileSearchPage.class);

        cartPage.searchItem("iMac");

        IMacPageOC imacpage = PageFactory.initElements(driver, IMacPageOC.class);
        Assert.assertTrue(imacpage.CheckValidiMacPageOpening());
        imacpage.sendReviewR3("iva qwerty", "Good product!");
        Thread.sleep(3000);
        imacpage.reviewWarningExist();


    }

    /**
     * Trying to leave a comment without logining, enter user name and review.
     * Checkin will warning message appear when we won't choose rating.
     */
    @Test
    public void withoutRatingTest() throws InterruptedException {
        MainPageOC mainPage = PageFactory.initElements(driver, MainPageOC.class);

        mainPage.open();

        ProfileSearchPage cartPage = PageFactory.initElements(driver, ProfileSearchPage.class);

        cartPage.searchItem("iMac");

        IMacPageOC imacpage = PageFactory.initElements(driver, IMacPageOC.class);
        Assert.assertTrue(imacpage.CheckValidiMacPageOpening());
        imacpage.sendReviewR0("iva qwerty", "Good product! I'm so happy that I Bought this amazing iMac computer!");
        Thread.sleep(3000);
        imacpage.ratingWarningExist();


    }


}

