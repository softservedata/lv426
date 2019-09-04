import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class CurrencyConvertTest {

    private WebDriver driver;
    private final String baseUrl = "http://192.168.68.131/opencart/upload";
    private final String adminUrl = "http://192.168.68.131/opencart/upload/admin";
    private final String username = "admin";
    private final String password = "Lv426_Taqc";

    private double euroConvert;
    private double poundSterlingConvert;
    private double ukrainianHryvniaConvert;

    private SoftAssert softAssert;


    @BeforeClass
    public void setWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(4000);

        driver.get(adminUrl);
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys(username);

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);

        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("menu-system")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Localisation')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Currencies')]")).click();

        //Add new Currency

        driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-title")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-title")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-title")).sendKeys("Ukrainian Hryvnia");

        driver.findElement(By.cssSelector(".col-sm-10 #input-code")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-code")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-code")).sendKeys("UAH");

        driver.findElement(By.cssSelector(".col-sm-10 #input-symbol-left")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-symbol-left")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-symbol-left")).sendKeys("₴");

        driver.findElement(By.cssSelector(".col-sm-10 #input-decimal-place")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-decimal-place")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-decimal-place")).sendKeys("2");

        driver.findElement(By.cssSelector(".col-sm-10 #input-value")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-value")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-value")).sendKeys("25.1730");

        driver.findElement(By.cssSelector(".col-sm-10 #input-status")).click();
        driver.findElement(By.xpath("//*[@id='input-status']/option[contains(text(), 'Enabled')]")).click();

        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        //Extract Currency convent
        WebElement euroElement = driver
                .findElement(By.xpath("//td[contains(text(),'Euro')]/..//following-sibling::td[contains(text(), '.')]"));

        WebElement poundElement = driver
                .findElement(By.xpath("//td[contains(text(),'Pound Sterling')]/..//following-sibling::td[contains(text(), '.')]"));

        WebElement hryvnElement = driver
                .findElement(By.xpath("//td[contains(text(),'Ukrainian Hryvnia')]/..//following-sibling::td[contains(text(), '.')]"));

        euroConvert = Double.parseDouble(euroElement.getText());
        poundSterlingConvert = Double.parseDouble(poundElement.getText());
        ukrainianHryvniaConvert = Double.parseDouble(hryvnElement.getText());

        Thread.sleep(5000);
        driver.quit();

    }

    @AfterClass
    public void goSleep() throws InterruptedException {

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
        Thread.sleep(3000);

        driver.findElement(By.id("menu-system")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Localisation')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Currencies')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//td[contains(text(),'Ukrainian Hryvnia')]/..//input")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button.btn.btn-danger")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @Test
    public void checkIfNewCurrencyIfVisible() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        assertTrue(driver.findElement(By.cssSelector("[name='UAH']")).isDisplayed());


    }

    @Test
    public void corectConvertofCurrency() throws InterruptedException {

        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("mac");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(3000);


        WebElement defaultPrice = driver.findElement(By.xpath("//h4/a[text()='MacBook']/../following-sibling::p[@class='price']"));
        double dolarValute = getValute(defaultPrice.getText());
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector("[name='EUR']")).click();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        WebElement newEuroPrice = driver.findElement(By.xpath("//h4/a[text()='MacBook']/../following-sibling::p[@class='price']"));
        double euroValute = getValute(newEuroPrice.getText());
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector("[name='GBP']")).click();
        driver.navigate().refresh();
        Thread.sleep(2000);

        WebElement newPoundPrice = driver.findElement(By.xpath("//h4/a[text()='MacBook']/../following-sibling::p[@class='price']"));
        double poundSterlingValute = getValute(newPoundPrice.getText());

        driver.findElement(By.cssSelector("button.btn.btn-link.dropdown-toggle")).click();
        driver.findElement(By.cssSelector("[name='UAH']")).click();
        driver.navigate().refresh();
        Thread.sleep(2000);
        WebElement newHryvniaPrice = driver.findElement(By.xpath("//h4/a[text()='MacBook']/../following-sibling::p[@class='price']"));
        double hryvniaValute = getValute(newHryvniaPrice.getText());

        softAssert.assertEquals(euroValute, getMultiply(dolarValute, euroConvert));
        softAssert.assertEquals(poundSterlingValute, getMultiply(dolarValute, poundSterlingConvert));
        softAssert.assertEquals(hryvniaValute, getMultiply(dolarValute, ukrainianHryvniaConvert));

        // driver.quit();

    }


    private double getValute(String str) {
        String str1 = str.replaceAll("[,]", "");
        List<String> rezult = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[0-9]*[.][0-9]*");
        Matcher matcher = pattern.matcher(str1);
        while (matcher.find()) {
            rezult.add(matcher.group());
        }

        return Double.parseDouble(rezult.get(0));
    }

    private double getMultiply(double num1, double num2) {
        DecimalFormat df = new DecimalFormat("#.##");
        double rezult = num1 * num2;
        return Double.parseDouble(df.format(rezult));

    }

}
