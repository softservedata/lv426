package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.EditAccountPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.SuccessfulAccountEditPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulEditAccountPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.opencart.pages.user.account.MyAccountPage.EXPECTED_MY_ACCOUNT_PAGE;
import static com.softserve.edu.opencart.pages.user.account.SuccessfulAccountEditPage.EXPECTED_EDIT_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulEditAccountPage.EXPECTED_WRONG_FIRSTNAME;

public class EditAccountTest extends UserTestRunner {

    @DataProvider
    public Object[][] successEditAccount() {
        return new Object[][]{
                {UserRepository.get().getEditExistingUser()},
        };
    }

    @DataProvider
    public Object[][] withoutSavingEditAccount() {
        return new Object[][]{
                {UserRepository.get().getEditExistingUser()},
        };
    }

    @DataProvider
    public Object[][] invalidFirstNameEditAccount() {
        return new Object[][]{
                {UserRepository.get().getExistingUser()},
        };
    }

    @Test(dataProvider = "successEditAccount")
    public void successEditAccount(IUser validUser) {
        SuccessfulAccountEditPage successfulAccountEditPage = loadOlesiaApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoEditAccountRight()
                .successEditAccount(validUser);

        Assert.assertTrue(successfulAccountEditPage.getAlertWarningText().contains(EXPECTED_EDIT_MESSAGE));

        EditAccountPage editAccountPage = successfulAccountEditPage
                .gotoEditAccountRight();

        Assert.assertEquals(editAccountPage.getLastNameText(), validUser.getLastName());

        Assert.assertEquals(editAccountPage.getTelephoneText(), validUser.getTelephone());

        HomePage homePage = editAccountPage
                .gotoLogoutRight().gotoContinue();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }

    @Test(dataProvider = "withoutSavingEditAccount")
    public void withoutSavingEditAccount(IUser validUser) {
        MyAccountPage withoutSavingEditAccountPage = loadOlesiaApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoEditAccountRight()
                .withoutSavingEditAccount(validUser);

        Assert.assertTrue(withoutSavingEditAccountPage.getSuccessMyAccountPageText().contains(EXPECTED_MY_ACCOUNT_PAGE));

        Assert.assertEquals(withoutSavingEditAccountPage
                .gotoEditAccountRight().getLastNameText(), validUser.getLastName());

        HomePage homePage = withoutSavingEditAccountPage
                .gotoLogoutRight().gotoContinue();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }

    @Test(dataProvider = "invalidFirstNameEditAccount")
    public void WrongFirstNameEditAccount(IUser wrongFirstNameUser) {
        UnsuccessfulEditAccountPage unsuccessfulEditAccountPage = loadOlesiaApplication()
                .gotoLoginPage()
                .successfulLogin(wrongFirstNameUser)
                .gotoEditAccountRight()
                .unsuccessEditAccount(wrongFirstNameUser);

        Assert.assertTrue(unsuccessfulEditAccountPage.getWarningFirstNameText().contains(EXPECTED_WRONG_FIRSTNAME));

        HomePage homePage = unsuccessfulEditAccountPage
                .gotoLogoutRight().gotoContinue();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }
}
