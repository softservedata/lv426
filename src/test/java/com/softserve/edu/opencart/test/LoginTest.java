package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.account.MyAccountPage.EXPECTED_MY_ACCOUNT_PAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE;

public class LoginTest extends UserTestRunner {
	@DataProvider
	public Object[][] validUser() {
		return new Object[][]{
				{UserRepository.get().getPasswordUser()},
		};
	}

	@DataProvider
	public Object[][] invalidEmailUser() {
		return new Object[][]{
				{UserRepository.get().getInvalidEmailUser()},
		};
	}

	@DataProvider
	public Object[][] invalidPasswordUser() {
		return new Object[][]{
				{UserRepository.get().getChangedPasswordUser()},
		};
	}

	@Test(dataProvider = "validUser")
	public void loginSuccessful(IUser validUser) {
		MyAccountPage successfulLogin = loadVikaApplication()
				.gotoLoginPage()
				.successfulLogin(validUser);
		Assert.assertTrue(successfulLogin.getSuccessMyAccountPageText().contains(EXPECTED_MY_ACCOUNT_PAGE));
	}

	@Test(dataProvider = "invalidEmailUser")
	public void loginUnsuccessfulEmail(IUser invalidUser) {
		UnsuccessfulLoginPage unsuccessfulLogin = loadVikaApplication()
				.gotoLoginPage()
				.unsuccessfulLoginPage(invalidUser);
		Assert.assertTrue(unsuccessfulLogin.getAlertWarningText().contains(EXPECTED_LOGIN_MESSAGE));
	}

	@Test(dataProvider = "invalidPasswordUser")
	public void loginUnsuccessfulPassword(IUser invalidUser) {
		UnsuccessfulLoginPage unsuccessfulLogin = loadVikaApplication()
				.gotoLoginPage()
				.unsuccessfulLoginPage(invalidUser);
		Assert.assertTrue(unsuccessfulLogin.getAlertWarningText().contains(EXPECTED_LOGIN_MESSAGE));
	}


}