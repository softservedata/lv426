import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxTest {
    private WebDriver driver;
    private final String baseUrl = "http://192.168.68.131/opencart/upload";
    private final String adminUrl = "http://192.168.68.131/opencart/upload/admin";
    private final String username = "admin";
    private final String password = "Lv426_Taqc";
    private final double tax = 20;
    //  private final String priceOfIphone = "100";

    private double subTotal;
    //   private double total;
    private double flatRate;

    private Map map;


    @BeforeClass
    public void setWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //  softAssert = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(4000);

        goToAdminPage(driver);

        // Thread.sleep(3000);
        //get flatRate
        driver.findElement(By.id("menu-extension")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Extensions')]")).click();
        driver.findElement(By.cssSelector("select.form-control")).click();
        driver.findElement(By.xpath("//option[contains(text(),'Shipping')]")).click();
        driver.findElement(By.xpath("//td[contains(text(),'Flat Rate')]/following-sibling::td/a[@class='btn btn-primary']")).click();
        flatRate = Double.parseDouble(driver.findElement(By.cssSelector("input#input-cost")).getAttribute("value"));


        //add new geo zone
        driver.findElement(By.id("menu-system")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Localisation')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Geo Zones')]")).click();

        driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary")).click();
        //Thread.sleep(3000);

        driver.findElement(By.cssSelector(".col-sm-10 #input-name")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-name")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-name")).sendKeys("Australia ShippingZone");
        //  Thread.sleep(3000);

        driver.findElement(By.cssSelector(".col-sm-10 #input-description")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-description")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-description")).sendKeys("Australia ShippingZone");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".text-left .btn.btn-primary")).click();
        driver.findElement(By.cssSelector("select[name='zone_to_geo_zone[0][country_id]']")).click();
        driver.findElement(By.xpath("//select[@name='zone_to_geo_zone[0][country_id]']//option[contains(text(),'Australia')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".pull-right .btn.btn-primary")).click();

        // Thread.sleep(3000);

        //add new tax rate

        //add Fixed Amount Tax rate
        driver.findElement(By.id("menu-system")).click();
        //   driver.findElement(By.xpath("//a[contains(text(),'Localisation')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Taxes')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Tax Rates')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".col-sm-10 #input-name")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-name")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-name")).sendKeys("Test Tax");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".col-sm-10 #input-rate")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-rate")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-rate")).sendKeys(String.valueOf(tax));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("select[id ='input-type']")).click();
        driver.findElement(By.xpath("//div[@class='col-sm-10']//option[contains(text(),'Fixed Amount')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("select#input-geo-zone")).click();
        driver.findElement(By.xpath("//div[@class='col-sm-10']//option[contains(text(),'Australia ShippingZone')]")).click();
        driver.findElement(By.cssSelector(".pull-right .btn.btn-primary")).click();
        Thread.sleep(1000);

        //add tax classes
        driver.findElement(By.id("menu-system")).click();
        //driver.findElement(By.xpath("//a[contains(text(),'Localisation')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Taxes')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Tax Classes')]")).click();

        driver.findElement(By.cssSelector(".pull-right a.btn.btn-primary")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".col-sm-10 #input-title")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-title")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-title")).sendKeys("Test Class");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".col-sm-10 #input-description")).click();
        driver.findElement(By.cssSelector(".col-sm-10 #input-description")).clear();
        driver.findElement(By.cssSelector(".col-sm-10 #input-description")).sendKeys("Test Class");

        driver.findElement(By.cssSelector(".text-left .btn.btn-primary")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//select[@name='tax_rule[0][tax_rate_id]']")).click();
        driver.findElement(By.xpath("//td[@class='text-left']//option[contains(text(),'Test Tax')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//select[@name='tax_rule[0][based]']")).click();
        driver.findElement(By.xpath("//td[@class='text-left']//option[contains(text(),'Shipping Address')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='tax_rule[0][priority]']")).click();
        driver.findElement(By.xpath("//input[@name='tax_rule[0][priority]']")).clear();
        driver.findElement(By.xpath("//input[@name='tax_rule[0][priority]']")).sendKeys("1");

        driver.findElement(By.cssSelector(".pull-right .btn.btn-primary")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        //add test class to the product
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Thread.sleep(1000);

        //add class to Iphone
        driver.findElement(By.xpath("//tr/td[contains(text(),'iPhone')]/../td/a[@class='btn btn-primary']")).click();

        driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();
        Thread.sleep(1000);

        subTotal = Double.parseDouble(driver.findElement(By.cssSelector("input#input-price")).getAttribute("value"));

        Thread.sleep(1000);


        driver.findElement(By.cssSelector("select#input-tax-class")).click();
        driver.findElement(By.xpath("//option[contains(text(), 'Test Class')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".pull-right .btn.btn-primary")).click();
        Thread.sleep(1000);
        driver.quit();

    }

    @AfterClass
    public void goSleep() throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        goToAdminPage(driver);
        //delete tax class from iphon
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tr/td[contains(text(),'iPhone')]/../td/a[@class='btn btn-primary']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Data')]")).click();
        driver.findElement(By.cssSelector("select#input-tax-class")).click();
        driver.findElement(By.xpath("//option[contains(text(), ' --- None --- ')]")).click();
        driver.findElement(By.cssSelector(".pull-right .btn.btn-primary")).click();
        Thread.sleep(1000);


        //delete tax class
        driver.findElement(By.id("menu-system")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Localisation')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Taxes')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Tax Classes')]")).click();


        driver.findElement(By.xpath("//td[contains(text(),'Test Class')]/../td/input")).click();
        driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger")).click();

        driver.switchTo().alert().accept();

        //delete tax rates
        driver.findElement(By.id("menu-system")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//a[contains(text(),'Taxes')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Tax Rates')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//td[contains(text(),'Test Tax')]/../td/input")).click();
        driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger")).click();
        driver.switchTo().alert().accept();

        //delete geo zone
        driver.findElement(By.id("menu-system")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Geo Zones')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[contains(text(),'Australia ShippingZone')]/../td/input")).click();
        driver.findElement(By.cssSelector(".pull-right button.btn.btn-danger")).click();
        driver.switchTo().alert().accept();
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
    public void taxTestWithFixedAmountTax() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("iphone");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h4/a[contains(text(),'iPhone')]"));
        Thread.sleep(1000);
        driver.findElement(By
                .xpath("//h4/a[contains(text(),'iPhone')]/../../..//span[contains(@class,'hidden-xs hidden-sm hidden-md')]/.."))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[@class='text-right']/a/strong[contains(text(),' View Cart')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Estimate Shipping & Taxes ')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='input-country']//option[contains(text(),'Australia')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='input-zone']//option[contains(text(),'Australian Capital Territory')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).sendKeys("123");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button#button-quote")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label/input[@name='shipping_method']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#button-shipping")).click();
        Thread.sleep(1000);
        List<WebElement> table = driver.findElements(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table[@class='table table-bordered']/tbody/tr"));
        map = getMap(table);
        //assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(map.get("Sub-Total:"), subTotal);
        softAssert.assertEquals(map.get("Flat Shipping Rate:"), flatRate);
        softAssert.assertEquals(map.get("Test Tax:"), tax);
        softAssert.assertEquals(map.get("Total:"), subTotal + flatRate + tax);
        softAssert.assertAll();
    }

    @Test
    public void testWithPercentageTax() {


    }

    @Test
    public void notWorkingTaxInSomeGeoZone() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("iphone");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h4/a[contains(text(),'iPhone')]"));
        Thread.sleep(1000);
        driver.findElement(By
                .xpath("//h4/a[contains(text(),'iPhone')]/../../..//span[contains(@class,'hidden-xs hidden-sm hidden-md')]/.."))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[@class='text-right']/a/strong[contains(text(),' View Cart')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Estimate Shipping & Taxes ')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='input-country']//option[contains(text(),'Tuvalu')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='input-zone']//option[contains(text(),'Niulakita')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).sendKeys("123");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button#button-quote")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label/input[@name='shipping_method']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#button-shipping")).click();
        Thread.sleep(1000);
        List<WebElement> table = driver.findElements(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table[@class='table table-bordered']/tbody/tr"));
        map = getMap(table);
        //assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(map.get("Sub-Total:"), subTotal);
        softAssert.assertEquals(map.get("Flat Shipping Rate:"), flatRate);
        softAssert.assertEquals(map.get("Total:"), subTotal + flatRate);
        softAssert.assertAll();
    }

    @Test
    public void testTaxWithMoreThanOneProduct() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        int countOfProduct = 4;

        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#search > input")).click();
        driver.findElement(By.cssSelector("#search > input")).clear();
        driver.findElement(By.cssSelector("#search > input")).sendKeys("iphone");
        driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h4/a[contains(text(),'iPhone')]"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//h4/a[contains(text(),'iPhone')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("input-quantity")).click();
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys(String.valueOf(countOfProduct));
        Thread.sleep(1000);
        driver.findElement(By.id("button-cart")).click();

        driver.findElement(By.cssSelector("button.btn.btn-inverse.btn-block.btn-lg.dropdown-toggle")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[@class='text-right']/a/strong[contains(text(),' View Cart')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Estimate Shipping & Taxes ')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='input-country']//option[contains(text(),'Australia')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='input-zone']//option[contains(text(),'Australian Capital Territory')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).click();
        driver.findElement(By.id("input-postcode")).sendKeys("123");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button#button-quote")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label/input[@name='shipping_method']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input#button-shipping")).click();
        Thread.sleep(1000);
        List<WebElement> table = driver.findElements(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']/table[@class='table table-bordered']/tbody/tr"));
        map = getMap(table);
        //assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(map.get("Sub-Total:"), subTotal * countOfProduct);
        softAssert.assertEquals(map.get("Flat Shipping Rate:"), flatRate);
        softAssert.assertEquals(map.get("Test Tax:"), getMultiply(tax, countOfProduct));
        softAssert.assertEquals(map.get("Total:"), subTotal * countOfProduct + flatRate + getMultiply(tax, countOfProduct));
        softAssert.assertAll();

    }

    private void goToAdminPage(WebDriver driver) {
        driver.get(adminUrl);
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys(username);

        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);

        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    }


    private Map getMap(List<WebElement> table) {
        Map<String, Double> rezult = new HashMap<String, Double>();
        for (WebElement currentRow : table) {
            List<WebElement> cells = currentRow.findElements(By.tagName("td"));
            rezult.put(cells.get(0).getText(), getValue(cells.get(1).getText()));
        }
        return rezult;
    }

    //    private double getPersente(double number, double tax) {
//        DecimalFormat df = new DecimalFormat("#.##");
//        double rezult = number * (tax / 100);
//        return Double.parseDouble(df.format(rezult));
//    }
    private double getMultiply(double num1, double num2) {
        DecimalFormat df = new DecimalFormat("#.##");
        double result = num1 * num2;
        return Double.parseDouble(df.format(result));

    }

    private double getValue(String str) {
        String str1 = str.replaceAll("[,]", "");
        Pattern pattern = Pattern.compile("[0-9]*[.][0-9]*");
        Matcher matcher = pattern.matcher(str1);
        matcher.find();
        return Double.parseDouble(matcher.group());

    }
}
