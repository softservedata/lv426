package com.softserve.edu.opencart.test;


import com.softserve.edu.opencart.data.*;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulLoginPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulResetPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulForgottenPage;
import com.softserve.edu.opencart.pages.user.mail.MailUser;
import com.softserve.edu.opencart.pages.user.mail.MailUserRepository;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static com.softserve.edu.opencart.pages.user.account.MyAccountPage.EXPECTED_MY_ACCOUNT_PAGE;
import static com.softserve.edu.opencart.pages.user.account.SuccessfulLoginPage.EXPECTED_FORGOTTEN_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.SuccessfulResetPage.EXPECTED_RESET_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulForgottenPage.EXPECTED_INVALID_EMAIL_MESSAGE;

public class ForgottenPasswordTest extends UserTestRunner {

    @DataProvider
    public Object[][] changePasswordUser() {
        return new Object[][]{
                {UserRepository.get().getPasswordUser(), UserRepository.get().getChangedPasswordUser(), MailUserRepository.getDefault()}
        };
    }

    @DataProvider
    public Object[][] invalidEmailUser() {
        return new Object[][]{
                {UserRepository.get().getInvalidEmailUser()},
        };
    }

    @Test(dataProvider = "changePasswordUser")
    public void forgottenPasswordTest(IUser testUser, IUser changedUser, MailUser mailUser) {
        SuccessfulLoginPage successfulLoginPage = loadVikaApplication()
                .gotoLoginPage()
                .gotoForgottenPasswordRight()
                .sendEmailField(testUser);
        Assert.assertTrue(successfulLoginPage.getAlertSuccessText().contains(EXPECTED_FORGOTTEN_MESSAGE));
        SuccessfulResetPage mailLoginPage = loadMail()
                .login(mailUser)
                .gotoUnreadMail()
                .openMail()
                .gotoResetPasswordPage()
                .resetPassword(changedUser);
        Assert.assertTrue(mailLoginPage.getAlertSuccessText().contains(EXPECTED_RESET_MESSAGE));
        MyAccountPage loginChanged = mailLoginPage
                .gotoLoginPage()
                .successfulLogin(changedUser);
        Assert.assertTrue(loginChanged.getSuccessMyAccountPageText()
                .contains(EXPECTED_MY_ACCOUNT_PAGE));
    }

    @Test(dataProvider = "invalidEmailUser")
    public void forgottenPasswordInvalidTest(IUser invalidEmailUser) {
        UnsuccessfulForgottenPage unsuccessfulEmail = loadVikaApplication()
                .gotoLoginPage()
                .gotoForgottenPasswordRight()
                .sendIvalidEmail(invalidEmailUser);
        Assert.assertTrue(unsuccessfulEmail.getAlertWarningText().contains(EXPECTED_INVALID_EMAIL_MESSAGE));
    }

}
