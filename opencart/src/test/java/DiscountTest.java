import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;

public class DiscountTest {
    private WebDriver driver;
    private final String baseUrl = "http://192.168.68.131/opencart/upload";
    private final String adminUrl = "http://192.168.68.131/opencart/upload/admin";
    private final String username = "admin";
    private final String password = "Lv426_Taqc";

    private Map map;

    private double priceOfProduct;
    private double countOfProduct = 10;
    private double priceWithDiscaunt = 15;


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
        //add discount to Iphone


        driver.findElement(By.xpath("//a[contains(text(),'Discount')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='discount']//button[@class='btn btn-primary']")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Quantity']")).click();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Quantity']")).clear();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Quantity']")).sendKeys(String.valueOf(countOfProduct));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Priority']")).click();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Priority']")).clear();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Priority']")).sendKeys("1");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Price']")).click();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Price']")).clear();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Price']")).sendKeys(String.valueOf(priceWithDiscaunt));

        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date Start']")).click();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date Start']")).clear();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date Start']")).sendKeys(LocalDate.now().toString());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date End']")).click();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date End']")).clear();
        driver.findElement(By.xpath("//tr[@id='discount-row0']//input[@placeholder='Date End']")).sendKeys(LocalDate.now().plusDays(1).toString());
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();


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
        driver.findElement(By.xpath("//a[contains(text(),'Discount')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='discount']//input[contains(@value,'"
                + priceWithDiscaunt
                + "')]/../following-sibling::td/button[@class='btn btn-danger']"))
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

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("iphone");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//h4/a[contains(text(),'iPhone')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("input-quantity")).click();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys(String.valueOf(countOfProduct));
        Thread.sleep(2000);
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='text-right']/a/strong[contains(text(),' View Cart')]")).click();
        Thread.sleep(2000);

        List<WebElement> table = driver.findElements(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table[@class='table table-bordered']/tbody/tr"));
        map = getMap(table);



        assertEquals(map.get("Total:"), priceWithDiscaunt * countOfProduct);


        Thread.sleep(2000);

    }

    private double getValue(String str) {
        String str1 = str.replaceAll("[,]", "");
        Pattern pattern = Pattern.compile("[0-9]*[.][0-9]*");
        Matcher matcher = pattern.matcher(str1);
        matcher.find();
        return Double.parseDouble(matcher.group());

    }

    private Map getMap(List<WebElement> table) {
        Map<String, Double> rezult = new HashMap<String, Double>();
        for (WebElement currentRow : table) {
            List<WebElement> cells = currentRow.findElements(By.tagName("td"));
            rezult.put(cells.get(0).getText(), getValue(cells.get(1).getText()));
        }
        return rezult;
    }

}


