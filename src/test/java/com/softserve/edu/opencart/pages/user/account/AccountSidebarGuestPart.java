package com.softserve.edu.opencart.pages.user.account;

<<<<<<< HEAD
import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarGuestPart extends AccountSidebarPart {

    private WebElement loginRight;
    private WebElement registerRight;
    private WebElement forgottenPasswordRight;
=======
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;

public abstract class AccountSidebarGuestPart extends AccountSidebarPart {

	private WebElement loginRight;
	private WebElement registerRight;
	private WebElement forgottenPasswordRight;

	public AccountSidebarGuestPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		loginRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]"));
		registerRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/register')]"));
		forgottenPasswordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/forgotten')]"));
	}
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b

    public AccountSidebarGuestPart(WebDriver driver) {
        super(driver);
        initElements();
    }

<<<<<<< HEAD
    private void initElements() {
        // init elements
        loginRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]"));
        registerRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/register')]"));
        forgottenPasswordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/forgotten')]"));
    }

    // Page Object

    // loginRight
    public WebElement getLoginRight() {
        return loginRight;
    }

    public String LoginRight() {
        return getLoginRight().getText();
    }

    public void clickLoginRight() {
        getLoginRight().click();
    }

    // registerRight
    public WebElement getRegisterRight() {
        return registerRight;
    }

    public String getRegisterRightText() {
        return getRegisterRight().getText();
    }

    public void clickRegisterRight() {
        getRegisterRight().click();
    }

=======
	// loginRight
    public WebElement getLoginRight() {
        return loginRight;
    }

    public String LoginRight() {
        return getLoginRight().getText();
    }

    public void clickLoginRight() {
        getLoginRight().click();
    }

	// registerRight
    public WebElement getRegisterRight() {
        return registerRight;
    }

    public String getRegisterRightText() {
        return getRegisterRight().getText();
    }

    public void clickRegisterRight() {
        getRegisterRight().click();
    }

>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
    // forgottenPasswordRight
    public WebElement getForgottenPasswordRight() {
        return forgottenPasswordRight;
    }

    public String getForgottenPasswordRightText() {
        return getForgottenPasswordRight().getText();
    }

    public void clickForgottenPasswordRight() {
        getForgottenPasswordRight().click();
    }

<<<<<<< HEAD
    // Functional

=======
	// Functional
    
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
//    protected void defaultLogin(IUser user) {
//    	new LoginPage(driver)
//    		.fillLogin(user);
//    }
<<<<<<< HEAD

    // Business Logic

    public LoginPage gotoLoginRight() {
        clickLoginRight();
        return new LoginPage(driver);
    }

    public RegisterPage gotoRegisterRight() {
        clickRegisterRight();
        return new RegisterPage(driver);
    }

    public ForgotPasswordPage gotoForgottenPasswordRight() {
        clickForgottenPasswordRight();
        return new ForgotPasswordPage(driver);
    }

    // Business Logic from AccountSidebarPart

    public MyAccountPage gotoMyAccountRight(IUser user) {
        clickMyAccountRight();
        defaultLogin(user);
        return new MyAccountPage(driver);
    }

    public AddressBookPage gotoAddressBookRight(IUser user) {
        clickAddressBookRight();
        defaultLogin(user);
        return new AddressBookPage(driver);
    }

    public WishListPage gotoWishListRight(IUser user) {
        clickWishListRight();
        defaultLogin(user);
        return new WishListPage(driver);
=======
    
	// Business Logic
    
    public LoginPage gotoLoginRight() {
    	clickLoginRight();
    	return new LoginPage(driver);
    }

    public RegisterPage gotoRegisterRight() {
    	clickRegisterRight();
    	return new RegisterPage(driver);
    }
    
    public ForgotPasswordPage gotoForgottenPasswordRight() {
    	clickForgottenPasswordRight();
    	return new ForgotPasswordPage(driver);
    }

    // Business Logic from AccountSidebarPart    

    public MyAccountPage gotoMyAccountRight(IUser user) {
    	clickMyAccountRight();
    	defaultLogin(user);
    	return new MyAccountPage(driver);
    }
    
    public AddressBookPage gotoAddressBookRight(IUser user) {
    	clickAddressBookRight();
    	defaultLogin(user);
    	return new AddressBookPage(driver);
    }
    
    public WishListPage gotoWishListRight(IUser user) {
    	clickWishListRight();
    	defaultLogin(user);
    	return new WishListPage(driver);
>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
    }

//    public OrderHistoryPage gotoOrderHistoryRight(IUser user) {}
//    public DownloadsPage gotoDownloadsRight(IUser user) {}
//    public RecurringpaymentsPage gotoRecurringpaymentsRight(IUser user) {}
//    public RewardPointsPage gotoRewardPointsRight(IUser user) {}
//    public ReturnsPage gotoReturnsRight(IUser user) {}
//    public TransactionsPage gotoTransactionsRight(IUser user) {}
//    public NewsletterPage gotoNewsletterRight(IUser user) {}
<<<<<<< HEAD
=======

>>>>>>> 40c679a4d7b258b0d93712d093a711e40eed356b
}
