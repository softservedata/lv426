import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialPriceTest {
    private WebDriver driver;
    private final String baseUrl = "http://192.168.68.131/opencart/upload";
    private final String adminUrl = "http://192.168.68.131/opencart/upload/admin";
    private final String username = "admin";
    private final String password = "Lv426_Taqc";
    private double specialPrice = 50.5;
    private double priceOfProduct;

    @BeforeClass
    public void setWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(adminUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys(username);

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);

        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        Thread.sleep(4000);
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tr/td[contains(text(),'iPhone')]/../td/a[@class='btn btn-primary']")).click();
        Thread.sleep(3000);
        //get price of product

        driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();
        Thread.sleep(3000);

        priceOfProduct = Double.parseDouble(driver.findElement(By.cssSelector("input#input-price")).getAttribute("value"));
        Thread.sleep(2000);
        //add special price to Iphone


        driver.findElement(By.xpath("//a[contains(text(),'Special')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='special-row0']//button[@class='btn btn-primary']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Priority']")).click();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Priority']")).clear();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Priority']")).sendKeys("1");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Price']")).click();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Price']")).clear();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Price']")).sendKeys(String.valueOf(specialPrice));


        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Date Start']")).click();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Date Start']")).clear();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Date Start']")).sendKeys(LocalDate.now().toString());

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Date End']")).click();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Date End']")).clear();
        driver.findElement(By.xpath("//*[@id='special-row0']//input[@placeholder='Date End']")).sendKeys(LocalDate.now().plusDays(1).toString());

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();


        driver.quit();

    }

    @AfterClass
    public void goToSleep() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(adminUrl);
        driver.manage().window().maximize();

        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys(username);

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);

        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();


        //delete special price class from iphone
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tr/td[contains(text(),'iPhone')]/../td/a[@class='btn btn-primary']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Special')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='special']//input[contains(@value,'"
                + specialPrice + "')]/../following-sibling::td/button[@class='btn btn-danger']"))
                .click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        driver.quit();


    }

    @AfterMethod
    public void quite() {
        driver.quit();
    }

    @BeforeMethod
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void testOfSpecialTest() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("iphone");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(3000);

        double oldPrice = getValue(driver.findElement(By.xpath("//h4/a[contains(text(),'iPhone')]/../../p[@class='price']/span[@class='price-old']")).getText());
        double newPrice = getValue(driver.findElement(By.xpath("//h4/a[contains(text(),'iPhone')]/../../p[@class='price']/span[@class='price-new']")).getText());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(oldPrice, priceOfProduct);
        softAssert.assertEquals(newPrice, specialPrice);
        softAssert.assertAll();

        Thread.sleep(2000);

    }

    private double getValue(String str) {
        String str1 = str.replaceAll("[,]", "");
        Pattern pattern = Pattern.compile("[0-9]*[.][0-9]*");
        Matcher matcher = pattern.matcher(str1);
        matcher.find();
        return Double.parseDouble(matcher.group());

    }

}
