package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class UpdateTokenLifetime {
    private GuestService guestService;
    private AdminService adminService;
    private UserService userService;
    private UserRepository user;


    @DataProvider
    public Object[][] inCorrectLifetime() {
        return new Object[][]{
                {LifetimeRepository.getNegativeDefault()},
                {LifetimeRepository.getSpecialSymbolLifetime()},
                {LifetimeRepository.getTextLifetime()},
                {LifetimeRepository.getZeroLifetime()},
        };
    }

    @BeforeClass
    public void setUp() {
        guestService = new GuestService();
    }

    @BeforeMethod
    public void loginAsAdmin() {
        adminService = guestService.successfulAdminLogin(UserRepository.getAdmin());
    }

    @AfterMethod
    public void logoutAdmin() {
        if (adminService != null) {
            adminService.updateTokenLifetime(LifetimeRepository.getDefault());
            adminService.logoutUser();
            adminService = null;
        }
    }

    @Test
    public void tryToUpdateTokenLifetimeWithInvalidAdminToken() {
        UserService userService = new UserService(UserRepository.FakeAdmin());
        userService.tryToChangeTokenLifeTime(LifetimeRepository.getDefault());
        Assert.assertEquals(LifetimeRepository.getDefault().getTime(), userService.getTokenLifetime().getTime());
    }

    @Test
    public void tryToUpdateTokenLifetimeWithCorrectAdminToken() {
        adminService.updateTokenLifetime(LifetimeRepository.getNewLifeTime());
        Assert.assertEquals(adminService.getTokenLifetime().getTime(), LifetimeRepository.getNewLifeTime().getTime());
    }

    @Test(dataProvider = "inCorrectLifetime")
    public void tryToUpdateInvalidTokenLifeTime(Lifetime lifetime) {
        Lifetime lifeTimeBefore = guestService.getTokenLifetime();
        adminService.updateTokenLifetime(lifetime);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(adminService.getTokenLifetime().getTime(), lifeTimeBefore.getTime());
        softAssert.assertNotEquals(adminService.getTokenLifetime().getTime(), lifetime);
        softAssert.assertAll();
    }


}
