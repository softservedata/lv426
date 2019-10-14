package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.WebDriver;

public class SuccessfulReturnPage extends AccountSidebarLoggedPart {

    private boolean thisPage = false;

    public SuccessfulReturnPage(WebDriver driver) {
        super(driver);
        thisPage = true;
    }

    public boolean isSuccessfulPage() {
        return thisPage;
    }

}
