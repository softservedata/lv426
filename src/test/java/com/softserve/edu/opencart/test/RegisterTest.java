package com.softserve.edu.opencart.test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulRegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends UserTestRunner {

    @DataProvider
    public Object[][] validUserRegister() {
        return new Object[][]{
                {UserRepository.get().getHahahaUser()},
        };
    }

    @Test(dataProvider = "validUserRegister")
    public void checkExistingUserRegister(IUser invalidUser) throws Exception {
        UnsuccessfulRegisterPage register = loadOlesiaApplication()
                .gotoRegisterPage()
                .unsuccessfulRegisterUser(invalidUser);

        Thread.sleep(2000);
        Assert.assertTrue(register.getWarningBoxText().contains("Warning: E-Mail Address is already registered!"));

        HomePage homePage = register.gotoHomePage();

        Assert.assertTrue(homePage
                .getSlideshow0FirstImageAttributeSrcText()
                .contains(HomePage.EXPECTED_IPHONE6));
    }
}
