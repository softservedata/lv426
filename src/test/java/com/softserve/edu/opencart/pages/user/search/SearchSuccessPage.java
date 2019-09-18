package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.opencart.data.Currencies;

public class SearchSuccessPage extends SearchCriteriaPart {

	private ProductsCriteriaComponent productsCriteria;
	
	public SearchSuccessPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		productsCriteria = new ProductsCriteriaComponent(driver);
	}

	// Page Object
	
	// productsCriteria
	public ProductsCriteriaComponent getProductsCriteria() {
		return productsCriteria;
	}
	
	// Functional

	// Business Logic
    public SearchSuccessPage chooseCurrency(Currencies currency)
    {
        clickCurrencyByPartialName(currency);
        return new SearchSuccessPage(driver);
    }

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
