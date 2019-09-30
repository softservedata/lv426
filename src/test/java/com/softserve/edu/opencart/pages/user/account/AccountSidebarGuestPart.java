package com.softserve.edu.opencart.pages.user.account;


import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.pages.user.addressbook.AddressBookPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarGuestPart extends AccountSidebarPart {

    private WebElement loginRight;
    private WebElement registerRight;
    private WebElement forgottenPasswordRight;

    AccountSidebarGuestPart(WebDriver driver) {
        super(driver);
        initElements();
    }
    private void initElements() {
        // init elements
        loginRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]"));
        registerRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/register')]"));
        forgottenPasswordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/forgotten')]"));
    }

    // Page Object

    // loginRight
    private WebElement getLoginRight() {
        return loginRight;
    }

    public String LoginRightText() {
        return getLoginRight().getText();
    }

    private void clickLoginRight() {
        getLoginRight().click();
    }

    // registerRight
    private WebElement getRegisterRight() {
        return registerRight;
    }

    public String getRegisterRightText() {
        return getRegisterRight().getText();
    }

    private void clickRegisterRight() {
        getRegisterRight().click();
    }


    // forgottenPasswordRight
    private WebElement getForgottenPasswordRight() {
        return forgottenPasswordRight;
    }

    public String getForgottenPasswordRightText() {
        return getForgottenPasswordRight().getText();
    }

    private void clickForgottenPasswordRight() {
        getForgottenPasswordRight().click();
    }


    // Functional

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

    }

//    public OrderHistoryPage gotoOrderHistoryRight(IUser user) {}
//    public DownloadsPage gotoDownloadsRight(IUser user) {}
//    public RecurringpaymentsPage gotoRecurringpaymentsRight(IUser user) {}
//    public RewardPointsPage gotoRewardPointsRight(IUser user) {}
//    public ReturnsPage gotoReturnsRight(IUser user) {}
//    public TransactionsPage gotoTransactionsRight(IUser user) {}
//    public NewsletterPage gotoNewsletterRight(IUser user) {}

}
