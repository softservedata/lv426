package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.WishListPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.SearchUnsuccessPage;
import com.softserve.edu.opencart.pages.user.shop.ShoppingCartPage;

public abstract class TopPart {
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass().getName());
    protected final String OPTION_NULL_MESSAGE = "DropdownOption is null";
    protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    protected final String PAGE_DO_NOT_EXIST="Page do not exist!!!";
    //
    protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";
    //
    protected final String LIST_CURRENCIES_CSSSELECTOR = "div.btn-group.open ul.dropdown-menu li";
    protected final String DROPDOWN_MYACCOUNT_CSSSELECTOR = ".dropdown-menu-right li";
    //
    protected WebDriver driver;
    //
    private WebElement currency;
    private WebElement myAccount;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement checkout;
    private WebElement logo;
    private WebElement searchTopField;
    private WebElement searchTopButton;
    private WebElement cartButton;
    //
    // private MainMenuComponent MainMenuComponent; 
    private DropdownComponent dropdownOptions;

    protected TopPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        currency = driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        myAccount = driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle"));
        wishList = driver.findElement(By.id("wishlist-total"));
        shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
        checkout = driver.findElement(By.cssSelector("a[title='Checkout']"));
        logo = driver.findElement(By.cssSelector("#logo a"));
        searchTopField = driver.findElement(By.name("search"));
        searchTopButton = driver.findElement(By.cssSelector("button.btn.btn-default"));
        cartButton = driver.findElement(By.cssSelector("#cart > button"));
    }

    // Page Object

    // currency
    public WebElement getCurrency() {
    	//return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return currency;
    }

    public String getCurrencyText() {
        return getCurrency().getText();
    }

    public void clickCurrency() {
        getCurrency().click();
    }

    // myAccount
    public WebElement getMyAccount() {
        return myAccount;
    }

    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    public void clickMyAccount() {
        getMyAccount().click();
    }

    // wishList
    public WebElement getWishList() {
        return wishList;
    }

    public String getWishListText() {
        return getWishList().getText();
    }

    public void clickWishList() {
        getWishList().click();
    }

//    public int getWishListNumber() {
//        Use getWishListText()
//    }

    // shoppingCart
    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public String getShoppingCartText() {
        return getShoppingCart().getText();
    }

    public void clickShoppingCart() {
        getShoppingCart().click();
    }

    // checkout
    public WebElement getCheckout() {
        return checkout;
    }

    public String getCheckoutText() {
        return getCheckout().getText();
    }

    public void clickCheckout() {
        getCheckout().click();
    }

    // logo
    public WebElement getLogo() {
        return logo;
    }

    public void clickLogo() {
        getLogo().click();
    }

    // searchTopField
    public WebElement getSearchTopField() {
        return searchTopField;
    }

    public String getSearchTopFieldText() {
        return getSearchTopField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSearchTopField() {
        getSearchTopField().clear();
    }

    public void clickSearchTopField() {
        getSearchTopField().click();
    }

    public void setSearchTopField(String text) {
        getSearchTopField().sendKeys(text);
    }

    // searchTopButton
    public WebElement getSearchTopButton() {
        return searchTopButton;
    }

    public void clickSearchTopButton() {
        getSearchTopButton().click();
    }

    // cartButton
    public WebElement getCartButton() {
        return cartButton;
    }

    public String getCartButtonText() {
        return getCartButton().getText();
    }

    public void clickCartButton() {
        getCartButton().click();
    }

    // TODO getCartButtonNumber()
    
    // dropdownOptions
//    protected DropdownComponent getDropdownOptions() {
//        LeaveUtils.castExceptionByCondition(dropdownOptions == null, OPTION_NULL_MESSAGE);
//        return dropdownOptions;
//    }

//    private DropdownComponent createDropdownOptions(By searchLocator) {
//        dropdownOptions = new DropdownComponent(driver, searchLocator);
//        return getDropdownOptions();
//    }

//    private void clickDropdownOptionByPartialName(String optionName) {
//        LeaveUtils.castExceptionByCondition(!getDropdownOptions().isExistDropdownOptionByPartialName(optionName),
//                String.format(OPTION_NOT_FOUND_MESSAGE, optionName, dropdownOptions.getListOptionsText().toString()));
//        getDropdownOptions().clickDropdownOptionByPartialName(optionName);
//        dropdownOptions = null;
//    }

//    private void closeDropdownOption() {
//        clickSearchTopField();
//        dropdownOptions = null;
//    }

    // Functional

    // currency
    private void openCurrencyDropdownOption() {
        clickSearchTopField();
        clickCurrency();
 //       createDropdownOptions(By.cssSelector(LIST_CURRENCIES_CSSSELECTOR));
    }

//    protected void clickCurrencyByPartialName(Currencies optionName) {
//        openCurrencyDropdownOption();
//        clickDropdownOptionByPartialName(optionName.toString());
//    }

//    public List<String> getListCurrencyNames() {
//        openCurrencyDropdownOption();
//        List<String> result = getDropdownOptions().getListOptionsText();
//        closeDropdownOption();
//        return result;
//    }

    // myAccount
//    private void clickDropdownMyAccountByPartialName(String componentName) {
//        clickSearchTopField();
//        clickMyAccount();
//        createDropdownOptions(By.cssSelector(DROPDOWN_MYACCOUNT_CSSSELECTOR));
//        clickDropdownOptionByPartialName(componentName);
//    }

//    protected void clickUnloggedMyAccountByPartialName(UnloggedMyAccount optionName) {
//        // TODO Check if Unlogged
//        clickDropdownMyAccountByPartialName(optionName.toString());
//    }

//    protected void clickLoggedMyAccountByPartialName(LoggedMyAccount optionName) {
//        // TODO Check if loggined
//        clickDropdownMyAccountByPartialName(optionName.toString());
//    }

    // searchTopField
    private void fillSearchTopField(String text) {
        clickSearchTopField();
        clearSearchTopField();
        setSearchTopField(text);
    }

    // Business Logic

    public HomePage gotoHomePage() {
        clickLogo();
        return new HomePage(driver);
    }

    public SearchSuccessPage successfulSearch(String searchItem) {
        fillSearchTopField(searchItem);
        clickSearchTopButton();
        return new SearchSuccessPage(driver);
    }

    public SearchUnsuccessPage unsuccessfulSearch(String searchItem){
        fillSearchTopField(searchItem);
        clickSearchTopButton();
        return new SearchUnsuccessPage(driver);
    }

//    public SuccessfulSearchPage searchProducts(SearchFilter searchItems) {
//  fillSearchTopField(searchItems.getProductSearchName());
//  clickSearchTopButton();
//}

    public WishListPage gotoWishListPage() {
    	// TODO if loggined
    	clickWishList();
        return new WishListPage(driver);
    }

    public ShoppingCartPage gotoShoppingCartPage() {
        clickShoppingCart();
        return new ShoppingCartPage(driver);
    }

//    public LoginPage gotoLoginPage() {
//        clickUnloggedMyAccountByPartialName(UnloggedMyAccount.LOGIN);
//        return new LoginPage(driver);
//    }

//    public RegisterPage gotoRegisterPage() {
//        clickUnloggedMyAccountByPartialName(UnloggedMyAccount.REGISTER);
//        return new RegisterPage(driver);
//    }

//    public AccountLogoutPage logout() {
 //       clickLoggedMyAccountByPartialName(LoggedMyAccount.LOGOUT);
//        return new AccountLogoutPage(driver);
//    }

    public ButtonCartProductComponent openButtonCartProductComponent() {
        clickCartButton();
        // TODO is Aggregation
        return new ButtonCartProductComponent(driver);
    }

    public ButtonCartEmptyComponent openEmptyButtonCartProductComponent() {
        clickCartButton();
        return new ButtonCartEmptyComponent(driver);
    }

}
