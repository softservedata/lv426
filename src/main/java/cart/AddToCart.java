package cart;

import base.BaseTest;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.WebDriverRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class AddToCart extends BaseTest {
    private String EMAIL = "chapchaimax@gmail.com";
    private String PASSWORD = "ocozliaes";

    public void logInSearchingAddDelete() throws InterruptedException {
        Selenide.open("http://192.168.163.131/opencart/upload/");

        SelenideDriver webDriver = WebDriverRunner.getSelenideDriver();
        //SelenideDriver driver = new ChromeDriver();

        webDriver.$(By.className("dropdown")).click();
        webDriver.$(By.xpath("//li/a[contains(text(),'Login')]")).click();

        //fillForm
        webDriver.$(By.cssSelector("div.form-group input[" +
                "name=\"email\"]")).sendKeys(EMAIL);
        webDriver.$(By.cssSelector("div.form-group input[name=\"password\"]")).sendKeys(PASSWORD);
        webDriver.$(By.cssSelector("input[class = \"btn btn-primary\"]")).click();
        Selenide.sleep(5000);

        System.out.println("wait to add");
        webDriver.$(By.cssSelector("input[name=\"search\"]")).click();
        webDriver.$(By.cssSelector("input[name=\"search\"]")).clear();
        webDriver.$(By.cssSelector("input[name=\"search\"]")).sendKeys("mac");
        webDriver.$(By.cssSelector("button[class=\"btn btn-default btn-lg\"]")).click();
        Selenide.sleep(5000);
        //add to cart
        webDriver.$(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'MacBook Pro')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        //go to my cart page
        webDriver.$(By.cssSelector("#cart")).click();
        Selenide.sleep(2000);
        webDriver.$(By.cssSelector(".text-right i[class=\"fa fa-shopping-cart\"]")).click();
        Selenide.sleep(5000);
        System.out.println("wait to add");
        WebElement element = webDriver.$(By.cssSelector("table[class=\"table table-bordered\"] td[class=\"text-left\"] a"));
        assertEquals("MacBook Pro", element.getText(), "The MacBook Pro has not been added");

        //delete from cart
        webDriver.$(By.cssSelector("#cart")).click();
        webDriver.$(By.cssSelector("#cart button[class=\"btn btn-danger btn-xs\"]")).click();
        System.out.println("wait until delete");
        Selenide.sleep(5000);
        WebElement emptyCart = webDriver.$(By.cssSelector("#content p"));
        assertEquals("Your shopping cart is empty!", emptyCart.getText());
        Selenide.sleep(5000);
    }

    public void checkIfSiteShowsRightDataInCart(String phone1, String phone2, String phone3) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://192.168.163.131/opencart/upload/");
        webDriver.findElement(By.className("dropdown")).click();
        webDriver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right')]" +
                "/li/a[contains(text(),'Login')]")).click();
        //fillForm
        webDriver.findElement(By.cssSelector("div.form-group input[" +
                "name=\"email\"]")).sendKeys(EMAIL);
        webDriver.findElement(By.cssSelector("div.form-group input[name=\"password\"]")).sendKeys(PASSWORD);
        webDriver.findElement(By.cssSelector("input[class = \"btn btn-primary\"]")).click();
        Thread.sleep(3000);
        System.out.println("fillForm");
        //choose a filter
        webDriver.findElement(By.xpath("//ul/li/a[contains(text(),'Phones')]")).click();
        webDriver.navigate().refresh();
        System.out.println("choose a filter");
        //add by one filter
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'HTC Touch HD')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        System.out.println("add by one filter");
        //choose a variant to show the things
        webDriver.findElement(By.cssSelector("button#list-view")).click();
        System.out.println("choose a variant to show the things");
        Thread.sleep(3000);
        //add by second filter
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'HTC Touch HD')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'iPhone')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'Palm Treo Pro')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(5000);
        System.out.println("add by second filter");
        //go to cart page
        webDriver.findElement(By.cssSelector("div#cart")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("div#cart strong i[class=\"fa fa-shopping-cart\"]")).click();
        Thread.sleep(5000);
        System.out.println("go to cart page");
        //multiple all elements
        webDriver.findElement(By.xpath("//td/a[contains(text(),'HTC Touch HD')]/../following-sibling::td/div/input"))
                .click();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'HTC Touch HD')]/../following-sibling::td/div/input"))
                .clear();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'HTC Touch HD')]/../following-sibling::td/div/input"))
                .sendKeys(phone1);
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//td/a[contains(text(),'iPhone')]/../following-sibling::td/div/input")).click();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'iPhone')]/../following-sibling::td/div/input")).clear();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'iPhone')]/../following-sibling::td/div/input"))
                .sendKeys(phone2);
        Thread.sleep(5000);
        webDriver.findElement(By.xpath("//td/a[contains(text(),'Palm Treo Pro')]" +
                "/../following-sibling::td/div/input")).click();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'Palm Treo Pro')]" +
                "/../following-sibling::td/div/input")).clear();
        webDriver.findElement(By.xpath("//td/a[contains(text(),'Palm Treo Pro')]" +
                "/../following-sibling::td/div/input")).sendKeys(phone3);
        webDriver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        System.out.println("multiple all elements");
        Thread.sleep(5000);
        //check if all my phones is really added
        String countOfPhonesAndSum = webDriver.findElement(By.xpath("//span[contains(text(), 'item(s)')]")).getText();
        String[] mass = countOfPhonesAndSum.split(" ");
        assertEquals("300", mass[0]);
        assertEquals("$48,099.00", mass[mass.length - 1]);
        System.out.println("check if all my phones is really added");
        //delete each one
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-danger\"]")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-danger\"]")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-danger\"]")).click();
        Thread.sleep(5000);
        System.out.println("delete each one");
        //check if they dead
        String countOfPhonesAndSumAfterDelete = webDriver.findElement(By.xpath("//span[contains(text(), 'item(s)')]"))
                .getText();
        assertEquals("0 item(s) - $0.00", countOfPhonesAndSumAfterDelete, "the items did not delete");
        webDriver.quit();
    }

    public Response postImgForTest() {
        File file = new File("C:\\Users\\Максим\\Pictures\\test.jpg");
        return RestAssured.given()
                .contentType("multipart/form-data")
                .multiPart(file)
                .post("http://192.168.163.131/opencart/upload/index.php?route=tool/upload");
    }

    public void bookThingWithRequirements() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://192.168.163.131/opencart/upload/");
        webDriver.findElement(By.className("dropdown")).click();
        webDriver.findElement(By.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right')]" +
                "/li/a[contains(text(),'Login')]")).click();
        //fillForm
        webDriver.findElement(By.cssSelector("div.form-group input[" +
                "name=\"email\"]")).sendKeys(EMAIL);
        webDriver.findElement(By.cssSelector("div.form-group input[name=\"password\"]")).sendKeys(PASSWORD);
        webDriver.findElement(By.cssSelector("input[class = \"btn btn-primary\"]")).click();
        Thread.sleep(3000);
        System.out.println("fillForm");
        webDriver.findElement(By.cssSelector("#logo")).click();
        Thread.sleep(5000);
        //add to cart by another way
        webDriver.findElement(By.xpath("//div[contains(@class,'row')]//h4/a[contains(text(),'Apple Cinema 30')]"))
                .click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-primary btn-lg btn-block\"]")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.name("option[218]")).click();
        //"//div[contains(@class,'form-group required')]/div/div/label/input[contains(text(),'')]"
        webDriver.findElement(By.name("option[223][]")).click();
        webDriver.findElement(By.cssSelector("#input-option208")).click();
        webDriver.findElement(By.cssSelector("#input-option208")).clear();
        webDriver.findElement(By.cssSelector("#input-option208")).sendKeys("just for test");
        webDriver.findElement(By.cssSelector("#input-option217")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("#input-option217 option[value =\"4\"]")).click();
        webDriver.findElement(By.cssSelector("#input-option209")).click();
        webDriver.findElement(By.cssSelector("#input-option209")).clear();
        webDriver.findElement(By.cssSelector("#input-option209")).sendKeys("text area for test");
        //postImgForTest();
        WebElement uploadImage = webDriver.findElement(By.cssSelector("#button-upload222"));
//        uploadImage.sendKeys("C:\\Users\\Максим\\Desktop\\test.txt");
        uploadImage.click();
        StringSelection ss = new StringSelection("C:\\Users\\Максим\\Pictures\\test.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        webDriver.switchTo().alert().accept();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector(".form-group #button-cart")).click();
        Thread.sleep(5000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();
        webDriver.findElement(By.cssSelector(".text-right i[class=\"fa fa-shopping-cart\"]")).click();
        Thread.sleep(5000);
        String countOfPhonesAndSum = webDriver.findElement(By.xpath("//span[contains(text(), 'item(s)')]")).getText();
        String[] mass = countOfPhonesAndSum.split(" ");
        assertEquals("2", mass[0]);
        Thread.sleep(3000);
        //conformation
        webDriver.findElement(By.cssSelector("div[class=\"pull-right\"] ")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("input[value=\"new\"]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("input[name=\"firstname\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"firstname\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"firstname\"]")).sendKeys("TestName");
        webDriver.findElement(By.cssSelector("input[name=\"lastname\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"lastname\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"lastname\"]")).sendKeys("TestLastName");
        webDriver.findElement(By.cssSelector("div[class=\"form-group required\"] input[placeholder=\"Address 1\"]"))
                .click();
        webDriver.findElement(By.cssSelector("div[class=\"form-group required\"] input[placeholder=\"Address 1\"]"))
                .clear();
        webDriver.findElement(By.cssSelector("div[class=\"form-group required\"] input[placeholder=\"Address 1\"]"))
                .sendKeys("TestAdress");

        webDriver.findElement(By.cssSelector("input[placeholder=\"City\"]")).click();
        webDriver.findElement(By.cssSelector("input[placeholder=\"City\"]")).clear();
        webDriver.findElement(By.cssSelector("input[placeholder=\"City\"]")).sendKeys("Kakhovka");

        webDriver.findElement(By.cssSelector("input[name=\"postcode\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"postcode\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"postcode\"]")).sendKeys("228");

        Select country = new Select(webDriver.findElement(By.cssSelector("#input-payment-country")));
        webDriver.findElement(By.cssSelector("#input-payment-country")).click();
        country.selectByVisibleText("Ukraine");

        Select zone = new Select(webDriver.findElement(By.cssSelector("#input-payment-zone")));
        webDriver.findElement(By.cssSelector("#input-payment-zone")).click();
        zone.selectByVisibleText("Khersons'ka Oblast'");
        webDriver.findElement(By.cssSelector("input[value = \"Continue\"]")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.cssSelector("#collapse-shipping-address .panel-body .form-horizontal input[value=\"existing\"]"))
                .click();
        webDriver.findElement(By.cssSelector(".pull-right #button-shipping-address")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.cssSelector(".panel-body textarea")).click();
        webDriver.findElement(By.cssSelector(".panel-body textarea")).clear();
        webDriver.findElement(By.cssSelector(".panel-body textarea")).sendKeys("bla bla bla test");
        webDriver.findElement(By.cssSelector(".pull-right #button-shipping-method")).click();
        Thread.sleep(2000);


        webDriver.findElement(By.cssSelector(".pull-right .agree")).click();
        Thread.sleep(2000);
        String termsAndConditions = webDriver.findElement(By.cssSelector(".modal-body p")).getText();
        assertEquals("Terms & Conditions", termsAndConditions, "Something gets wrong");
        webDriver.findElement(By.cssSelector(".close")).click();
        webDriver.findElement(By.cssSelector("input[name=\"agree\"]")).click();
        webDriver.findElement(By.cssSelector(".pull-right #button-payment-method")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("button[class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();
        String infoAboutOrderFromFirst = webDriver.findElement(By.cssSelector("table[class=\"table table-striped\"]" +
                " td[class=\"text-left\"]")).getText();
        String infoAboutOrderFromSecond = webDriver.findElement(By.cssSelector("table[class=\"table table-bordered" +
                " table-hover\"] tbody .text-left ")).getText();
        infoAboutOrderFromSecond = infoAboutOrderFromSecond.replaceAll(":\\s", " ");
        infoAboutOrderFromSecond = infoAboutOrderFromSecond.replaceAll("\\s-", "-");
        assertNotEquals(infoAboutOrderFromFirst, infoAboutOrderFromSecond, "The orders do not equal");

        webDriver.findElement(By.cssSelector("input[value=\"Confirm Order\"]")).click();
        Thread.sleep(2000);
        String success = webDriver.findElement(By.cssSelector("#content h1")).getText();
        assertEquals("Your order has been placed!", success, "The order does not placed");
        webDriver.findElement(By.cssSelector("a[class=\"btn btn-primary\"]")).click();
        Thread.sleep(2000);
        webDriver.quit();
    }

    public void withoutLogInBookingOrder() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://192.168.163.131/opencart/upload/");
        webDriver.findElement(By.xpath("//ul[contains(@class,'nav navbar-nav')]/li/a[contains(text(),'MP3 Players')]"))
                .click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[contains(@class,'collapse navbar-collapse navbar-ex1-collapse')]" +
                "/ul/li/div/a[contains(text(),'Show All MP3 Players')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'iPod Shuffle')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("#cart")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector(".text-right i[class=\"fa fa-shopping-cart\"]")).click();
        String productName = webDriver.findElement(By.cssSelector("table[class=\"table table-bordered\"] .text-left a"))
                .getText();
        assertEquals("iPod Shuffle", productName, "The product did not booked right");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("h4[class=\"panel-title\"] a[class=\"accordion-toggle\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("#input-coupon")).click();
        webDriver.findElement(By.cssSelector("#input-coupon")).clear();
        webDriver.findElement(By.cssSelector("#input-coupon")).sendKeys("ASDF-1221-ASDA-9999");
        webDriver.findElement(By.cssSelector("input[id=\"button-coupon\"]")).click();
        Thread.sleep(3000);
        String coupon = webDriver.findElement(By.cssSelector("div[class=\"alert alert-danger\"]")).getText();
        assertEquals("Warning: Coupon is either invalid, expired or reached its usage limit!\n×", coupon,
                "It is magic - coupon works");
        webDriver.findElement(By.xpath("//div[contains(@class,'panel panel-default')]" +
                "//a[contains(text(),'Estimate Shipping & Taxes')]")).click();
        Thread.sleep(2000);
        Select country = new Select(webDriver.findElement(By.cssSelector("#input-country")));
        webDriver.findElement(By.cssSelector("#input-country")).click();
        country.selectByVisibleText("Tunisia");
        Select region = new Select(webDriver.findElement(By.cssSelector("#input-zone")));
        webDriver.findElement(By.cssSelector("#input-zone")).click();
        region.selectByVisibleText("Gabes");
        webDriver.findElement(By.cssSelector("#input-postcode")).click();
        webDriver.findElement(By.cssSelector("#input-postcode")).clear();
        webDriver.findElement(By.cssSelector("#input-postcode")).sendKeys("123");
        webDriver.findElement(By.cssSelector("button[id=\"button-quote\"]")).click();
        Thread.sleep(2000);
        assertEquals("Flat Shipping Rate - $8.00", webDriver.findElement(By.cssSelector(".radio label")).getText(),
                "The quotes has been changed");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input[name=\"shipping_method\"]")).click();
        webDriver.findElement(By.cssSelector(".modal-footer input")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//a[contains(text(),'Use Gift Certificate ')]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input[name=\"voucher\"]")).click();
        webDriver.findElement(By.cssSelector("input[name=\"voucher\"]")).clear();
        webDriver.findElement(By.cssSelector("input[name=\"voucher\"]")).sendKeys("PODAROK14");
        webDriver.findElement(By.cssSelector("input[value=\"Apply Gift Certificate\"]")).click();
        Thread.sleep(2000);
        assertEquals("Warning: Gift Certificate is either invalid or the balance has been used up!\n×",
                webDriver.findElement(By.cssSelector("div[class=\"alert alert-danger\"] ")).getText(),
                "It is a magic - a Gift Certificate works ");
        webDriver.findElement(By.cssSelector("a[class=\"btn btn-primary\"]")).click();
        Thread.sleep(1000);
        assertEquals("Checkout Options:", webDriver.findElement(By.cssSelector("#content p")).getText()
                , "Unbelievable, a product should not add");
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("#input-email")).click();
        webDriver.findElement(By.cssSelector("#input-email")).clear();
        webDriver.findElement(By.cssSelector("#input-email")).sendKeys(EMAIL);
        webDriver.findElement(By.cssSelector("#input-password")).click();
        webDriver.findElement(By.cssSelector("#input-password")).clear();
        webDriver.findElement(By.cssSelector("#input-password")).sendKeys(PASSWORD);
        webDriver.findElement(By.cssSelector("input#button-login")).click();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("input#button-payment-address")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("#collapse-shipping-address input[value=\"new\"]")).click();
        //new adress
        webDriver.findElement(By.cssSelector("#input-shipping-firstname")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-firstname")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-firstname")).sendKeys("Tech");
        webDriver.findElement(By.cssSelector("#input-shipping-lastname")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-lastname")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-lastname")).sendKeys("Lead");
        webDriver.findElement(By.cssSelector("#input-shipping-address-1")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-address-1")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-address-1")).sendKeys("SoftServe");

        webDriver.findElement(By.cssSelector("#input-shipping-city")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).sendKeys("Lviv");

        webDriver.findElement(By.cssSelector("#input-shipping-city")).click();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).clear();
        webDriver.findElement(By.cssSelector("#input-shipping-city")).sendKeys("Lviv");

        Select countryForAdress = new Select(webDriver.findElement(By.cssSelector("#input-shipping-country")));
        webDriver.findElement(By.cssSelector("#input-shipping-country")).click();
        countryForAdress.selectByVisibleText("Ukraine");

        Select regionForAdress = new Select(webDriver.findElement(By.cssSelector("#input-shipping-zone")));
        webDriver.findElement(By.cssSelector("#input-shipping-zone")).click();
        regionForAdress.selectByVisibleText("L'vivs'ka Oblast'");

        webDriver.findElement(By.cssSelector("input#button-shipping-address")).click();
        Thread.sleep(2000);

        webDriver.findElement(By.cssSelector("textarea.form-control")).click();
        webDriver.findElement(By.cssSelector("textarea.form-control")).clear();
        webDriver.findElement(By.cssSelector("textarea.form-control")).sendKeys("I WANT TO BE FREE");
        webDriver.findElement(By.cssSelector("input#button-shipping-method")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("a.agree")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("button.close")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input[name=\"agree\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.cssSelector("input#button-payment-method")).click();
        Thread.sleep(2000);
        assertEquals("iPod Shuffle", webDriver.findElement(By.cssSelector("div.table-responsive tbody" +
                " td.text-left a")).getText(), "Product name does not appear to request");
        assertEquals("$105.00", webDriver.findElement(By.xpath("//tfoot/tr/td[contains(text(),'$105')]")).getText(),
                "The price does not appear to requirements");
        webDriver.findElement(By.cssSelector("input[value=\"Confirm Order\"]")).click();
        Thread.sleep(2000);

        assertEquals("Your order has been placed!", webDriver.findElement(By.cssSelector("#content h1")).getText(),
                "The order must be added");
        webDriver.findElement(By.cssSelector("div.pull-right a[class=\"btn btn-primary\"]")).click();
        webDriver.quit();
    }

    public void bookOrderUsingWrongData() {
        Selenide.open("http://192.168.163.131/opencart/upload/");
        Selenide.sleep(5000);
        SelenideDriver webDriver = WebDriverRunner.getSelenideDriver();
        webDriver.$(By.xpath("//ul[contains(@class,'nav navbar-nav')]/li/a[contains(text(),'Cameras')]")).click();
        Selenide.sleep(5000);
        webDriver.$(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'Nikon D300')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Selenide.sleep(5000);
        webDriver.$(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'Canon EOS 5D')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        Selenide.sleep(5000);
        Select color = new Select(webDriver.$("select.form-control"));
        webDriver.$("select.form-control").click();
        Selenide.sleep(2000);
        color.selectByVisibleText("Red");
        webDriver.$(By.name("quantity")).click();
        webDriver.$(By.name("quantity")).clear();
        webDriver.$(By.name("quantity")).setValue("300000000000000000000000000000000000000000000000000000000000000000");
        //bag!
        webDriver.$("button#button-cart").click();
        Selenide.sleep(5000);
        String alert = webDriver.$("div[class=\"alert alert-success\"]").getText();
        assertEquals("Success: You have added Canon EOS 5D to your shopping cart!\n×", alert,
                "Something gets wrong with camera ordering");
        webDriver.$("button#button-cart").click();
        Selenide.sleep(1000);
        webDriver.$("div#cart").click();
        Selenide.sleep(2000);
        webDriver.$(".text-right i[class=\"fa fa-shopping-cart\"]").click();
        Selenide.sleep(5000);
        alert = webDriver.$("div[class=\"alert alert-danger\"]").getText();
        assertEquals("Products marked with *** are not available in the desired quantity or not in stock!\n×",
                alert, "The count of orderings have not to satisfy a site ");
        webDriver.$("div.pull-left a").click();
        Selenide.sleep(3000);
        webDriver.$(By.xpath("//ul[contains(@class,'nav navbar-nav')]/li/a[contains(text(),'Tablets')]")).click();
        Selenide.sleep(3000);
        webDriver.$(By.xpath("//div[contains(@class,'caption')]/h4/a[contains(text(),'Samsung Galaxy Tab 10.1')]" +
                "/../../following-sibling::div/button[contains(@onclick,'cart.add')]")).click();
        webDriver.$("a[title=\"Checkout\"] i[class=\"fa fa-share\"]").click();
        Selenide.sleep(5000);
        webDriver.$(By.xpath("//div/table/tbody/tr/td[contains(@class,'text-left')]/a[contains(text(),'Canon EOS 5D')]"))
                .click();
        Selenide.sleep(5000);
        color = new Select(webDriver.$("select.form-control"));
        webDriver.$("select.form-control").click();
        color.selectByVisibleText("Blue");
        webDriver.$(By.name("quantity")).click();
        webDriver.$(By.name("quantity")).clear();
        webDriver.$(By.name("quantity")).setValue("sdas8");//bag!
        webDriver.$("button#button-cart").click();
        webDriver.$("div#cart").click();
        Selenide.sleep(2000);
        webDriver.$("div#cart strong i[class=\"fa fa-shopping-cart\"]").click();
        Selenide.sleep(5000);
        webDriver.$(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "/tbody/tr/td/a[contains(text(),'Samsung Galaxy Tab 10.1')]/../following-sibling::td/div/input"))
                .click();
        webDriver.$(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "/tbody/tr/td/a[contains(text(),'Samsung Galaxy Tab 10.1')]/../following-sibling::td/div/input"))
                .clear();
        webDriver.$(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "/tbody/tr/td/a[contains(text(),'Samsung Galaxy Tab 10.1')]/../following-sibling::td/div/input"))
                .setValue("-7852255");
        webDriver.$("span.input-group-btn button[type=\"submit\"]").click();
        Selenide.sleep(5000);
        String countOfOrdersAfterDelets = webDriver.$("div#cart span").getText();
        String[] mass = countOfOrdersAfterDelets.split(" ");
        assertEquals("2147483649", mass[0], "Order which must deleted - still in your order desk");
        String byFirstColorOfCanon = webDriver.$(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "/tbody/tr/td/a[contains(text(),'Canon EOS 5D')]" +
                "/../small[contains(text(),'Red')]/../../td/div/input")).getValue();
        String bySecondColorOfCanon = webDriver.$(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "/tbody/tr/td/a[contains(text(),'Canon EOS 5D')]" +
                "/../small[contains(text(),'Blue')]/../../td/div/input")).getValue();
        assertAll("One or both prices of cameras are fail",
                () -> assertEquals("2147483647", byFirstColorOfCanon, "Wrong count of cameras with red color"),
                () -> assertEquals("1", bySecondColorOfCanon, "Wrong count of cameras with blue color")
        );
        webDriver.$("div[class=\"buttons clearfix\"] div.pull-right a").click();
        Selenide.sleep(2000);
        webDriver.$(By.xpath("//table[contains(@class,'table table-bordered')]" +
                "/tbody/tr/td/a[contains(text(),'Canon EOS 5D')]" +
                "/../small[contains(text(),'Red')]/../../td/div/input")).setValue("1");
        webDriver.$("span.input-group-btn button[type=\"submit\"]").click();
        Selenide.sleep(2000);
        //webDriver.$("span.input-group-btn button[type=\"submit\"]").click();
        String alertAboutSuccessMod = webDriver.$("div[class=\"alert alert-success\"]").getText();
        assertEquals("Success: You have modified your shopping cart!\n×", alertAboutSuccessMod,
                "The modification does not work");
        webDriver.$("div[class=\"buttons clearfix\"] div[class=\"pull-right\"] a").click();
        Selenide.sleep(2000);
        webDriver.$("#input-email").click();
        webDriver.$("#input-email").clear();
        webDriver.$("#input-email").setValue(EMAIL);
        webDriver.$("#input-password").click();
        webDriver.$("#input-password").clear();
        webDriver.$("#input-password").setValue(PASSWORD);
        webDriver.$("input#button-login").click();
        Selenide.sleep(2000);
        webDriver.$("input#button-payment-address").click();
        Selenide.sleep(2000);
        webDriver.$("input#button-shipping-address").click();
        Selenide.sleep(2000);
        webDriver.$("textarea[name=\"comment\"]").setValue("bla bla");
        webDriver.$("input#button-shipping-method").click();
        webDriver.$("a.agree").click();
        Selenide.sleep(2000);
        webDriver.$("button.close").click();
        Selenide.sleep(2000);
        webDriver.$("input[name=\"agree\"]").click();
        Selenide.sleep(2000);
        webDriver.$("input#button-payment-method").click();
        Selenide.sleep(5000);
        webDriver.$("input[value=\"Confirm Order\"]").click();
        Selenide.sleep(5000);
        assertEquals("Your order has been placed!", webDriver.$(("#content h1")).getText(),
                "The order must be added");
        assertEquals("Your order has been placed!", webDriver.$("#content h1").getText(),
                "The order must be added");
        webDriver.$("div.pull-right a[class=\"btn btn-primary\"]").click();
    }


}
