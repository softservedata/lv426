package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.pages.user.search.SearchCriteriaPart;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends AccountSidebarLoggedPart {

    public static final String EXPECTED_MY_ACCOUNT_PAGE = "My Account";
    //
    private WebElement successMyAccountPage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private WebElement good;

    private void initElements() {
        successMyAccountPage = driver.findElement(By.cssSelector("div.col-sm-9 h2"));
    }

    // Page Object

    //successMyAccount
    public WebElement getsuccessMyAccountPage() {
        return successMyAccountPage;
    }

    public String getsuccessMyAccountPageText() {
        return getsuccessMyAccountPage().getText();
    }


    // Functional

    // Business Logic
    public SearchSuccessPage searchGood(WebElement goodName) {
        SearchCriteriaPart searchCriteriaPart = new SearchCriteriaPart(driver);
        searchCriteriaPart.clickgetCriteriaSearchField();
        searchCriteriaPart.setCriteriaSearchField("MackBook");
        searchCriteriaPart.ClickCriteriaSearchButton();
        return new SearchSuccessPage(driver);
    }

}
