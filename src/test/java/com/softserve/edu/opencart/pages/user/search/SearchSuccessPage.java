package com.softserve.edu.opencart.pages.user.search;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSuccessPage extends SearchCriteriaPart {

	private ProductsCriteriaComponent productsCriteria;
	
	public SearchSuccessPage(WebDriver driver) {
		super(driver);
		initElements();
	}
    private WebElement foundedGood;
	private void initElements() {
		// init elements
		productsCriteria = new ProductsCriteriaComponent(driver);

	}



    // Page Object

	// Functional

	// Business Logic
//    public SearchSuccessPage chooseCurrency(Currency currency)
//    {
//        clickCurrencyByPartialName(currency);
//        return new SearchSuccessPage(driver);
//    }

	 // TODO Use Enum
    public SearchSuccessPage sortProductsByCriteria(String text)
    {
        productsCriteria.setInputSort(text);
        return new SearchSuccessPage(driver);
    }
    
    // TODO Use Enum
    public SearchSuccessPage showProductsByCount(String text)
    {
        productsCriteria.setInputLimit(text);
        return new SearchSuccessPage(driver);
    }

}
