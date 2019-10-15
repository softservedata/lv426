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
    
    @DataProvider
    public Object[][] inCorrectLifetime() {
        return new Object[][]{
                {LifetimeRepository.getSpecialSymbolLifetime()},
                {LifetimeRepository.getTextLifetime()},
                {LifetimeRepository.getZeroLifetime()},
                {LifetimeRepository.getNegativeDefault()}
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
        if ((adminService != null) && (guestService != null)) {
            adminService.reset();
            adminService = null;
        }
    }

    @AfterClass
    public void tearDown() {
        guestService = null;
    }

    @Test
    public void tryToUpdateTokenLifetimeWithInvalidAdminToken() {
        AdminService adminService = new AdminService(UserRepository.FakeAdmin());
        adminService.updateTokenLifetime(LifetimeRepository.getDefault());
        Assert.assertEquals(adminService.getTokenLifetime().getTime(), LifetimeRepository.getDefault().getTime());
    }

    @Test
    public void tryToUpdateTokenLifetimeWithCorrectAdminToken() {
        adminService.updateTokenLifetime(LifetimeRepository.getNewLifeTime());
        Assert.assertEquals(adminService.getTokenLifetime().getTime(), LifetimeRepository.getNewLifeTime().getTime());
    }

    @Test(dataProvider = "inCorrectLifetime")
    public void tryToUpdateInvalidTokenLifeTime(Lifetime lifetime) {
        adminService.updateTokenLifetime(lifetime);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(adminService.getTokenLifetime().getTime(), LifetimeRepository.getDefault().getTime());
        softAssert.assertNotEquals(adminService.getTokenLifetime().getTime(), lifetime.getTime());
        softAssert.assertAll();
    }


}
