package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.account.MyAccountPage.EXPECTED_MY_ACCOUNT_PAGE;

public class LockUnlockUserTest extends UserTestRunner {
    public static final String EXPECTED_LOCKED_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";

    @DataProvider
    public Object[][] changePasswordUser() {
        return new Object[][]{
                {UserRepository.get().getChangedPasswordUser(), UserRepository.get().getPasswordUser()}
        };
    }

    @Test(dataProvider = "changePasswordUser")
    public void changePasswordTest(IUser changedUser, IUser testUser) {
        UnsuccessfulLoginPage userLocking = loadVikaApplication()
                .gotoLoginPage()
                .lockUser(changedUser);
        Assert.assertTrue(userLocking.getAlertWarningText().contains(EXPECTED_LOCKED_MESSAGE));
    }

    @Test(dataProvider = "changePasswordUser")
    public void changePasswordTest1(IUser changedUser, IUser testUser) {
        UnsuccessfulLoginPage userLocking = loadVikaApplication()
                .gotoLoginPage()
                .unsuccessfulLoginPage(changedUser)
                .unsuccessfulLoginPage(changedUser)
                .unsuccessfulLoginPage(changedUser)
                .unsuccessfulLoginPage(changedUser)
                .unsuccessfulLoginPage(changedUser)
                .unsuccessfulLoginPage(changedUser);
        Assert.assertTrue(userLocking.getAlertWarningText().contains(EXPECTED_LOCKED_MESSAGE));
        loadVikaAdminLoginPage()
                .goToAdminHomePage()
                .goToCustomersPage()
                .clickUnlockButton();
        MyAccountPage userLogging = loadVikaApplication()
                .gotoLoginPage()
                .successfulLogin(testUser);
        Assert.assertTrue(userLogging.getSuccessMyAccountPageText().contains(EXPECTED_MY_ACCOUNT_PAGE));

    }
}
