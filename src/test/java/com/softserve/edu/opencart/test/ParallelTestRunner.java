package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.pages.user.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class ParallelTestRunner {
    public List<WebDriver> drivers;
    private final String SERVER_URL_BY_MAX = "http://192.168.163.137/opencart/upload";


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//Maksym
        drivers = new ArrayList<>();


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        for (WebDriver driver : drivers) {
            if (driver == null) {
                driver.quit();
            }
        }
    }

    public HomePage loadMaxParallelApplication() {
        WebDriver driver = new ChromeDriver();
        driver.get(SERVER_URL_BY_MAX);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new HomePage(driver);
    }

}
