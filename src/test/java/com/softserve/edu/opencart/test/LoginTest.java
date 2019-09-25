package com.softserve.edu.opencart.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.EditAccountPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.tools.ListUtils;

public class LoginTest extends UserTestRunner {

	@DataProvider
	public Object[][] validUser() {
		return new Object[][] {
			{ UserRepository.get().getHahahaUser() },
		};
	}

	@DataProvider
	public Object[][] validUsers() {
		//return ListUtils.toMultiArray(UserRepository.get().fromCsv());
		return ListUtils.toMultiArray(UserRepository.get().fromExcel());
	}

	//@Test(dataProvider = "validUser")
	@Test(dataProvider = "validUsers")
	public void checkSuccessful(IUser validUser) throws Exception {
		// Steps
		MyAccountPage myAccountPage = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser);
		Thread.sleep(1000); // For Presentation ONLY
		//
		// Check
		Assert.assertTrue(ApplicationStatus.get().isLogged());
		Thread.sleep(1000); // For Presentation ONLY
		//
		// Steps
		// GOTO EditAccountPage + Message
		EditAccountPage editAccountPage = myAccountPage
				.gotoEditAccountRight();
		Thread.sleep(1000); // For Presentation ONLY
		//
		// Check
		Assert.assertEquals(editAccountPage.getFirstNameFieldText(),
				validUser.getFirstName());
		//
		// Return to Previous State
		
		HomePage homePage = editAccountPage
				.gotoContinue()  		// optional
				.gotoLogoutRight()
				.gotoContinue();
		//
		// Check (optional)
		Assert.assertFalse(ApplicationStatus.get().isLogged());
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.EXPECTED_IPHONE6));
		Thread.sleep(1000); // For Presentation ONLY
	}

	@DataProvider
	public Object[][] invalidUser() {
		return new Object[][] {
			{ UserRepository.get().getInvalidUser() },
		};
	}

	//@Test(dataProvider = "invalidUser")
	public void checkUnsuccessful(IUser invalidUser) throws Exception {
		// Steps
		UnsuccessfulLoginPage unsuccessfulLoginPage = loadApplication()
				.gotoLoginPage()
				.unsuccessfulLoginPage(invalidUser);
		Thread.sleep(1000); // For Presentation ONLY
		//
		// Check
		Assert.assertFalse(ApplicationStatus.get().isLogged());
		Thread.sleep(1000); // For Presentation ONLY
		//
		// Check
		Assert.assertTrue(unsuccessfulLoginPage
				.getAlertWarningText()
				.toLowerCase()
				.trim()
				.contains(UnsuccessfulLoginPage
						.EXPECTED_LOGIN_MESSAGE
						.toLowerCase()
						.trim()));
		//
		// Return to Previous State
		HomePage homePage = unsuccessfulLoginPage
				.gotoHomePage();
		Thread.sleep(1000); // For Presentation ONLY
		//
		// Check (optional)
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.EXPECTED_IPHONE6));
		Thread.sleep(1000); // For Presentation ONLY
	}

}
