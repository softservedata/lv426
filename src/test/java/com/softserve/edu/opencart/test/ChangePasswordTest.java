package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulMyAccountPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulPasswordPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.account.MyAccountPage.EXPECTED_MY_ACCOUNT_PAGE;
import static com.softserve.edu.opencart.pages.user.account.SuccessfulMyAccountPage.EXPECTED_CHANGE_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulPasswordPage.EXPECTED_INVALID_CONFIRMATION_MESSAGE;


public class ChangePasswordTest extends UserTestRunner {
    @DataProvider
    public Object[][] changePasswordUser() {
        return new Object[][]{
                {UserRepository.get().getPasswordUser(), UserRepository.get().getChangedPasswordUser()}
        };
    }

    @Test(dataProvider = "changePasswordUser", priority = 1)
    public void changePasswordTest(IUser testUser, IUser changedUser) {
        SuccessfulMyAccountPage successfulChange = loadVikaApplication()
                .gotoLoginPage()
                .successfulLogin(testUser)
                .gotoPasswordRight()
                .changePassword(changedUser);
        Assert.assertTrue(successfulChange.getAlertSuccessText().contains(EXPECTED_CHANGE_MESSAGE));
        MyAccountPage loginChanged = successfulChange
                .gotoLogoutRight()
                .gotoLoginPage()
                .successfulLogin(changedUser);
        Assert.assertTrue(loginChanged.getSuccessMyAccountPageText()
                .contains(EXPECTED_MY_ACCOUNT_PAGE));
    }

    @Test(dataProvider = "changePasswordUser", priority = 2)
    public void changeInvalidPasswordTest(IUser testUser, IUser changedUser) {
        UnsuccessfulPasswordPage unsuccessfulChange = loadVikaApplication()
                .gotoLoginPage()
                .successfulLogin(changedUser)
                .gotoPasswordRight()
                .changeInvalidPassword(testUser.getPassword(), changedUser.getPassword());
        Assert.assertTrue(unsuccessfulChange.getAlertWarningText().contains(EXPECTED_INVALID_CONFIRMATION_MESSAGE));
        UnsuccessfulLoginPage loginChanged = unsuccessfulChange
                .gotoLogoutRight()
                .gotoLoginPage()
                .unsuccessfulLoginPage(testUser);
        Assert.assertTrue(loginChanged.getAlertWarningText().contains(EXPECTED_LOGIN_MESSAGE));
    }

    @Test(dataProvider = "changePasswordUser", priority = 3)
    public void changeBackPasswordTest(IUser testUser, IUser changedUser) {
        SuccessfulMyAccountPage successfulChange = loadVikaApplication()
                .gotoLoginPage()
                .successfulLogin(changedUser)
                .gotoPasswordRight()
                .changePassword(testUser);
        Assert.assertTrue(successfulChange.getAlertSuccessText().contains(EXPECTED_CHANGE_MESSAGE));
        MyAccountPage loginChanged = successfulChange
                .gotoLogoutRight()
                .gotoLoginPage()
                .successfulLogin(testUser);
        Assert.assertTrue(loginChanged.getSuccessMyAccountPageText()
                .contains(EXPECTED_MY_ACCOUNT_PAGE));
    }
}
