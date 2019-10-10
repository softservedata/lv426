package com.softserve.edu.opencart.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.softserve.edu.opencart.pages.user.account.OrderHistoryPage;
import com.softserve.edu.opencart.pages.user.account.WishListPage;
import com.softserve.edu.opencart.pages.user.addressbook.AddressBookPage;
import com.softserve.edu.opencart.pages.user.adminpanel.AdminLoginPage;
import com.softserve.edu.opencart.pages.user.mail.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.user.HomePage;

public abstract class UserTestRunner {

	private final String DRIVER_ERROR = "ERROR: Chromedriver not Found";
	//private final String SERVER_URL = "http://taqc-opencart.epizy.com";

	private final String ADMIN_ARSEN_URL = "http://192.168.68.138/opencart/upload/admin";
	private final String SERVER_ARSEN_URL = "http://192.168.68.138/opencart/upload";

	private final String ADMIN_URL = "http://192.168.68.137/opencart/upload/admin";
	//private final String SERVER_URL = "http://192.168.68.137/opencart/upload";
	private final String SERVER_URL_BY_NELOMAYTECOD = "https://demo.opencart.com/index.php?route=common/home";

	//private final String SERVER_URL = "http://192.168.68.137/opencart/upload";
	private final String SERVER_URL_BY_BEATA = "https://demo.opencart.com/index.php?route=common/home";

	private final String SERVER_URL = "http://192.168.68.137/opencart/upload";
	private final String SERVER_URL_BY_MAX = "http://192.168.163.137/opencart/upload";
	private final String ADMIN_URL_BY_MAX = "http://192.168.163.137/opencart/upload/admin";

	private final String SERVER_URL_BY_OLESIA = "http://192.168.45.132/opencart/upload";

	private final String ADMIN_YURA_URL = "http://192.168.112.135/opencart/upload/admin";
	private final String SERVER_YURA_URL = "http://192.168.112.135/opencart/upload";
	private final String ADDRESS_BOOK = "http://192.168.112.135/opencart/upload/index.php?route=account/address";
	private final String ORDER_HISTORY = "http://192.168.112.135/opencart/upload/index.php?route=account/order";
	
 	private final String ADMIN_URL_BY_VIKA = "http://192.168.238.130/opencart/upload/admin";
	private final String SERVER_URL_BY_VIKA = "http://192.168.238.130/opencart/upload";
	
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
	private final String  SERVER_URL_BY_MARTA="http://192.168.68.133/opencart/upload";
	private final String ADMIN_MARTA_URL="http://192.168.68.133/opencart/upload/admin";
	private final String MAIL_URL = "https://mail.ukr.net";
	//
	private final Logger log = LoggerFactory.getLogger(this.getClass().getName());
	WebDriver driver;
	WebDriverWait waitDriver;

	@BeforeClass
	public void beforeClass() {
		log.info("Test suite start");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("ChromeDriver loaded");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		if (driver != null) {
			driver.quit();
		}
		log.info("ChromeDriver quite");
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (!testResult.isSuccess()) {
			log.error("Test failed");
			try {
				String name = takeScreenShot();
				takePageSource(name);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.manage().deleteAllCookies();
	}

	HomePage loadMaxApplication() {
		driver.get(SERVER_URL_BY_MAX);
		log.debug("loadMaxApplication start");
		return new HomePage(driver);
	}

	HomePage loadArsenApplication() {
		//driver.get(SERVER_URL);
		driver.get(SERVER_ARSEN_URL);
		log.debug("loadApplication start");
		return new HomePage(driver);
	}

	HomePage loadMartaApplication(){
		driver.get(SERVER_URL_BY_MARTA);
		log.debug("loadMartaApplication start");
		return new HomePage(driver);
	}

    HomePage loadOlesiaApplication() {
        driver.get(SERVER_URL_BY_OLESIA);
        log.debug("loadOlesiaApplication start");
        return new HomePage(driver);
    }

	HomePage loadBeataApplication(){
		driver.get(SERVER_URL_BY_BEATA);
		log.debug("loadMaxApplication start");
		return new HomePage(driver);
	}

	HomePage loadYuraApplication() {
		driver.get(SERVER_YURA_URL);
		waitDriver = new WebDriverWait(driver,20);
		log.debug("loadYuraApplication start");
		return new HomePage(driver);
	}

	public  OrderHistoryPage loadOrderHistory() {
		driver.get(ORDER_HISTORY);
		log.debug("OrderHistory load");
		return new OrderHistoryPage(driver);
	}

	public AddressBookPage loadAddreeBook() {
		driver.get(ADDRESS_BOOK);
		log.debug("AddressBook load");
		return new AddressBookPage(driver);
	}


	AdminLoginPage loadArsenAdminLoginPage() {
		driver.get(ADMIN_ARSEN_URL);
		log.debug("loadAdminPanel start");
		return new AdminLoginPage(driver);
	}

	AdminLoginPage loadMartaAdminLoginPage(){
		driver.get(ADMIN_MARTA_URL);
		log.debug("loadAdminPanel start");
		return new AdminLoginPage(driver);

	}

	public AdminLoginPage loadYuraAdminLoginPage(){
		driver.get(ADMIN_YURA_URL);
		log.debug("loadAdminPanel start");
		return new AdminLoginPage(driver);

	}
	public AdminLoginPage loadVikaAdminLoginPage() {
        	driver.get(ADMIN_URL_BY_VIKA);
        	log.debug("loadAdminPanel start");
        	return new AdminLoginPage(driver);
   	}

	public HomePage loadVikaApplication() {
		driver.get(SERVER_URL_BY_VIKA);
		log.debug("loadApplication start");
		return new HomePage(driver);
	}

	public LoginPage loadMail() {
		driver.get(MAIL_URL);
		log.debug("loadApplication start");
		return new LoginPage(driver);
	}


	//@Step("Save attached screenshot")
	//@Attachment(value = "{0}", type = "image/png")
	public byte[] saveImageAttach() {
		byte[] result = null;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			result = Files.readAllBytes(scrFile.toPath());
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Attachment taken failure!");
		}
		return result;
	}

	//@Step("Take screenshot")
	private String takeScreenShot() throws IOException {
		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./img/" + currentTime + "_screenshot.png"));
		log.info("Screenshot was taken");
		return "./img/" + currentTime + "_screenshot";
	}
	
	private void takePageSource(String fileName) {
		String pageSource = driver.getPageSource();
		Path path = Paths.get(fileName + ".txt");
		byte[] strToBytes = pageSource.getBytes();
		try {
			Files.write(path, strToBytes,  StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
