package OpencartTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

    public class WishListTest {
        private WebDriver driver;
        @BeforeSuite
        public void setup(){
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\1\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://demo.opencart.com/index.php?route=account/login");
            LogIn objLogin = new LogIn(driver);
            objLogin.loginToOpencart("beatka994@mail.ru", "qwerty12");
            objLogin.clickLogin();
        }
        @Test
        public void searchWishList(){
            WishListFind find = new WishListFind(driver);
            Assert.assertTrue(find.ifGetWishList());

        }
        @Test
        public void lookIntoWishList() {
            WishListAccess access = new WishListAccess(driver);
            Assert.assertEquals(access.getIntoWishList(),"https://demo.opencart.com/index.php?route=account/wishlist");

        }

        @Test
        public void addToWishList() {
            AddGoodToTheWishList add = new AddGoodToTheWishList(driver);
            String actual = add.addToWishList();
            Assert.assertEquals(actual,"Product 16");
        }

        @Test(dependsOnMethods = {"addToWishList"})
        public void deleteFromWishList(){
            DeleteFromWishList deleteFromWishList = new DeleteFromWishList(driver);
            int actualAmountInTheWishList = deleteFromWishList.deleteFromWishList();
            int expected = 0;
            Assert.assertEquals(actualAmountInTheWishList,expected);
        }
        @Test(dependsOnMethods = {"addToWishList"})
        public void aDDToCart(){
            AddToCart addToCart = new AddToCart(driver);
            int actualAmountInTheCart=addToCart.addToCart();
            int expected = 1;
            Assert.assertEquals(actualAmountInTheCart,expected);
        }

        @AfterSuite
        public void dropDown(){
            driver.quit();
        }









    }