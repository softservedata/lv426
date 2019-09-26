package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulRegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.account.MyAccountPage.EXPECTED_MY_ACCOUNT_PAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulRegisterPage.*;

public class RegisterTest extends UserTestRunner {

    @DataProvider
    public Object[][] invalidFirstNameUserRegister() {
        return new Object[][]{
                {UserRepository.get().getWrongFirstNameUser()},
        };
    }

    @DataProvider
    public Object[][] existingUserRegister() {
        return new Object[][]{
                {UserRepository.get().getExistingUser()},
        };
    }

    @DataProvider
    public Object[][] withoutConfirmPrivacyPolicyUserRegister() {
        return new Object[][]{
                {UserRepository.get().getWrongFirstNameUser()},
        };
    }

    @DataProvider
    public Object[][] invalidPasswordUserRegister() {
        return new Object[][]{
                {UserRepository.get().getWrongPasswordUser()},
        };
    }
    @Test(dataProvider = "existingUserRegister")
    public void checkExistingUserRegister(IUser existingUser){
        UnsuccessfulRegisterPage unsuccessfulRegisterPage = loadOlesiaApplication()
                .gotoRegisterPage()
                .unsuccessfulRegisterUser(existingUser);

        Assert.assertTrue(unsuccessfulRegisterPage.getWarningBoxText().contains(EXPECTED_EXISTING_EMAIL));

        MyAccountPage successfulLogin = unsuccessfulRegisterPage
                .gotoLoginPage()
                .successfulLogin(existingUser);

        Assert.assertTrue(successfulLogin.getsuccessMyAccountPageText()
                .contains(EXPECTED_MY_ACCOUNT_PAGE));

        HomePage homePage = successfulLogin.gotoHomePage();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }

    @Test(dataProvider = "invalidFirstNameUserRegister")
    public void checkWrongFirstNameUserRegister(IUser wrongFirstNameUser){
        UnsuccessfulRegisterPage unsuccessfulRegisterPage = loadOlesiaApplication()
                .gotoRegisterPage()
                .unsuccessfulRegisterUser(wrongFirstNameUser);

        Assert.assertTrue(unsuccessfulRegisterPage.getWarningFirstNameText().contains(EXPECTED_WRONG_FIRSTNAME));

        UnsuccessfulLoginPage unsuccessfulLogin = unsuccessfulRegisterPage
                .gotoLoginPage()
                .unsuccessfulLoginPage(wrongFirstNameUser);

        Assert.assertTrue(unsuccessfulLogin.getAlertWarningText()
                .contains(EXPECTED_LOGIN_MESSAGE));

        HomePage homePage = unsuccessfulLogin.gotoHomePage();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }

    @Test(dataProvider = "invalidFirstNameUserRegister")
    public void withoutConfirmPrivacyPolicyUserRegister(IUser invalidUser){
        UnsuccessfulRegisterPage unsuccessfulRegisterPage = loadOlesiaApplication()
                .gotoRegisterPage()
                .unsuccessfulRegisterNotAgreePrivacyPolicy(invalidUser);

        Assert.assertTrue(unsuccessfulRegisterPage.getWarningBoxText().contains(EXPECTED_NOT_AGREE_PRIVACY_POLICY));

        UnsuccessfulLoginPage unsuccessfulLogin = unsuccessfulRegisterPage
                .gotoLoginPage()
                .unsuccessfulLoginPage(invalidUser);

        Assert.assertTrue(unsuccessfulLogin.getAlertWarningText()
                .contains(EXPECTED_LOGIN_MESSAGE));

        HomePage homePage = unsuccessfulLogin.gotoHomePage();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }

    @Test(dataProvider = "invalidPasswordUserRegister")
    public void checkWrongConfirmPasswordUserRegister(IUser invalidUser){
        UnsuccessfulRegisterPage unsuccessfulRegisterPage = loadOlesiaApplication()
                .gotoRegisterPage()
                .unsuccessfulRegisterUser(invalidUser);

        Assert.assertTrue(unsuccessfulRegisterPage.getWarningPasswordText().contains(EXPECTED_WRONG_PASSWORD));

        UnsuccessfulLoginPage unsuccessfulLogin = unsuccessfulRegisterPage
                .gotoLoginPage()
                .unsuccessfulLoginPage(invalidUser);

        Assert.assertTrue(unsuccessfulLogin.getAlertWarningText()
                .contains(EXPECTED_LOGIN_MESSAGE));

        HomePage homePage = unsuccessfulLogin.gotoHomePage();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }
}
