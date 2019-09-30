package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulForgottenPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AdminUser;
import com.softserve.edu.opencart.pages.user.adminpanel.Manipulating.AdminUserRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.account.LockedUserLoginPage.EXPECTED_LOCKED_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.MyAccountPage.EXPECTED_MY_ACCOUNT_PAGE;

public class LockUnlockUserTest extends UserTestRunner {

    @DataProvider
    public Object[][] changePasswordUser() {
        return new Object[][]{
                {UserRepository.get().getChangedPasswordUser(), UserRepository.get().getPasswordUser(), AdminUserRepository.getDefault()}
        };
    }

    @Test(dataProvider = "changePasswordUser")
    public void lockAndUnlockTest(IUser changedUser, IUser testUser, AdminUser adminUser) {
        UnsuccessfulForgottenPage userLocking = loadVikaApplication()
                .gotoLoginPage()
                .lockUser(changedUser);
        Assert.assertTrue(userLocking.getAlertWarningText().contains(EXPECTED_LOCKED_MESSAGE));
        loadVikaAdminLoginPage()
                .goToAdminHomePage()
                .goToCustomersPage()
                .unlockUser(testUser);
        MyAccountPage userLogging = loadVikaApplication()
                .gotoLoginPage()
                .successfulLogin(testUser);
        Assert.assertTrue(userLogging.getSuccessMyAccountPageText().contains(EXPECTED_MY_ACCOUNT_PAGE));
    }

}
