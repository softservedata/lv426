package com.softserve.edu.opencart.test;

import java.util.Currency;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.SearchFilter;
import com.softserve.edu.opencart.data.SearchFilterRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;

public class SearchTest extends UserTestRunner {

	@DataProvider
	public Object[][] searchData() {
		return new Object[][] {
			{ SearchFilterRepository.searchMacBook() },
		};
	}

	@Test(dataProvider = "searchData")
	//public void checkSearch(SearchFilter searchFilter, Currency currency) throws Exception {
	public void checkSearch(SearchFilter searchFilter) throws Exception {
		// Steps
		SearchSuccessPage searchSuccessPage = loadApplication()
				.successfulSearch(searchFilter);
				//.ChooseCurrency(currency);
		ProductComponent actualProductComponent = searchSuccessPage
				.getProductsCriteria()
				.getProductComponentByName(searchFilter.getProduct());
		//
		// Check
		Assert.assertTrue(actualProductComponent
				.getPriceText()
				.contains(searchFilter
						.getProduct()
						.getPriceDollarExTax()));
						//.getPrice(currency)));
		Thread.sleep(5000); // For Presentation ONLY
		//
		// TODO
		// Continue Searching. Use SearchCriteria from SearchCriteriaPart
		//
		// Return to Previous State
		HomePage homePage = searchSuccessPage.gotoHomePage();
		//
		// Check (optional)
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.EXPECTED_IPHONE6));
		Thread.sleep(5000); // For Presentation ONLY
	}

}
