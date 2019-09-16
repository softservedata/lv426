package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.pages.user.search.SearchCriteriaPart;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends AccountSidebarLoggedPart {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		initElements();
	}
	private WebElement good;
	private void initElements() {

	}

	// Page Object


	// Functional

	// Business Logic
	public SearchSuccessPage searchGood(WebElement goodName){
		SearchCriteriaPart searchCriteriaPart = new SearchCriteriaPart(driver);
		searchCriteriaPart.clickgetCriteriaSearchField();
		searchCriteriaPart.setCriteriaSearchField("MackBook");
		searchCriteriaPart.ClickCriteriaSearchButton();
		return new SearchSuccessPage(driver);
	}

}
