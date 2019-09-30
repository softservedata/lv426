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
import static com.softserve.edu.opencart.pages.user.account.SuccessfulAccountEditPage.EXPECTED_SUCCESS_EDIT_MESSAGE;
import static com.softserve.edu.opencart.pages.user.account.UnsuccessfulEditAccountPage.EXPECTED_WRONG_FIRSTNAME;

public class EditAccountTest extends UserTestRunner {

    @DataProvider
    public Object[][] validEditAccount() {
        return new Object[][]{
                {UserRepository.get().getExistingUser(), UserRepository.get().getEditExistingUser()},
        };
    }

    @DataProvider
    public Object[][] invalidFirstNameEditAccount() {
        return new Object[][]{
                {UserRepository.get().getExistingUser(), UserRepository.get().getWrongFirstNameUser()},
        };
    }

    @Test(dataProvider = "validEditAccount")
    public void withoutSavingEditAccount(IUser validUser, IUser editUser) {
        MyAccountPage withoutSavingEditAccountPage = loadOlesiaApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoEditAccountRight()
                .withoutSavingEditAccount(editUser);

        Assert.assertTrue(withoutSavingEditAccountPage.getSuccessMyAccountPageText().contains(EXPECTED_MY_ACCOUNT_PAGE));

        EditAccountPage editAccountPage = withoutSavingEditAccountPage.gotoEditAccountRight();

        Assert.assertEquals(editAccountPage.getLastNameText(), validUser.getLastName());

        HomePage homePage = editAccountPage
                .gotoLogoutRight().gotoContinue();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }

    @Test(dataProvider = "validEditAccount")
    public void successEditAccount(IUser validUser, IUser editUser) {
        SuccessfulAccountEditPage successfulAccountEditPage = loadOlesiaApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoEditAccountRight()
                .successEditAccount(editUser);

        Assert.assertTrue(successfulAccountEditPage.getAlertWarningText().contains(EXPECTED_SUCCESS_EDIT_MESSAGE));

        EditAccountPage editAccountPage = successfulAccountEditPage
                .gotoEditAccountRight();

        Assert.assertEquals(editAccountPage.getLastNameText(), editUser.getLastName());
        Assert.assertEquals(editAccountPage.getTelephoneText(), editUser.getTelephone());

        SuccessfulAccountEditPage turnBackChanges = editAccountPage
                .successEditAccount(validUser);

        EditAccountPage editBackAccountPage = turnBackChanges
                .gotoEditAccountRight();

        Assert.assertEquals(editBackAccountPage.getLastNameText(), validUser.getLastName());
        Assert.assertEquals(editBackAccountPage.getTelephoneText(), validUser.getTelephone());

        HomePage homePage = editBackAccountPage
                .gotoLogoutRight().gotoContinue();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }


    @Test(dataProvider = "invalidFirstNameEditAccount")
    public void WrongFirstNameEditAccount(IUser validUser, IUser wrongFirstNameUser) {
        UnsuccessfulEditAccountPage unsuccessfulEditAccountPage = loadOlesiaApplication()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoEditAccountRight()
                .unsuccessFirstNameEditAccount(wrongFirstNameUser);

        Assert.assertTrue(unsuccessfulEditAccountPage.getWarningFirstNameText().contains(EXPECTED_WRONG_FIRSTNAME));

        EditAccountPage editAccountPage = unsuccessfulEditAccountPage
                .gotoEditAccountRight();

        Assert.assertEquals(editAccountPage.getFirstNameText(), validUser.getFirstName());

        HomePage homePage = editAccountPage
                .gotoLogoutRight().gotoContinue();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }
}
