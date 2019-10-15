package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.*;

public class RealTokenLifetime {
    private GuestService guestService;
    private AdminService adminService;


    @DataProvider
    public Object[][] adminUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getShortLifeTime()},
        };
    }
    @DataProvider
    public Object[][] user() {
        return new Object[][]{
                {UserRepository.getMaxUser(), LifetimeRepository.getShortLifeTime()},
        };
    }



    @BeforeClass
    public void setUp() {
        guestService = new GuestService();

    }
    @BeforeMethod
    public void loginAsAdmin() {
        adminService = guestService.successfulAdminLogin(UserRepository.getAdmin());
        adminService.createUser(UserRepository.getMaxUser());
    }

    @AfterMethod
    public void tearDown() {
        if ((adminService != null) && (guestService != null)){
            adminService.updateTokenLifetime(LifetimeRepository.getDefault());
            adminService.getTokenLifetime();
            adminService.removeUser(UserRepository.getMaxUser());
            adminService.isUserRemoved(UserRepository.getMaxUser());
            adminService.logoutUser();
            adminService = null;
            guestService = null;
        }
    }

    @AfterClass
    public void endWork() {
        guestService = null;
    }


    @Test(dataProvider = "adminUser")
    public void checkRealLifetimeForAdmin(User user, Lifetime testTime) {
        adminService.updateTokenLifetime(testTime);
        wait(testTime);
        Assert.assertFalse(adminService.isAdminLogged(user));
    }

    @Test(dataProvider = "user")
    public void checkRealLifetimeForUser(User user, Lifetime testTime) {
        UserService userService = guestService.successfulUserLogin(user);
        adminService.updateTokenLifetime(testTime);
        wait(testTime);
        adminService = guestService.successfulAdminLogin(UserRepository.getAdmin());
        Assert.assertFalse(adminService.isUserLogged(user));

    }

    private void wait(Lifetime time) {
        try {
            Thread.sleep(Integer.parseInt(time.getTime()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
