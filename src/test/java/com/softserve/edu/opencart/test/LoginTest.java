package com.softserve.edu.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.ProductComponent;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;

public class LoginTest extends UserTestRunner {

	@DataProvider
	public Object[][] validUser() {
		return new Object[][] {
			{ UserRepository.get().getHahahaUser() },
		};
	}

	@Test(dataProvider = "validUser")
	public void checkSuccessful(IUser validUser) throws Exception {
		// Steps
		/*
		SearchSuccessPage searchSuccessPage = loadMaxApplication()
				.successfulSearch(searchFilter)
				.chooseCurrency(currency);
		ProductComponent actualProductComponent = searchSuccessPage
				.getProductsCriteria()
				.getProductComponentByName(searchFilter.getProduct());
		//
		// Check
		Assert.assertTrue(actualProductComponent
				.getPriceText()
				.contains(searchFilter
						.getProduct()
						//.getPriceDollarExTax()));
						.getPrice(currency)));
		Thread.sleep(1000); // For Presentation ONLY
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
		Thread.sleep(1000); // For Presentation ONLY
		*/
	}

}
