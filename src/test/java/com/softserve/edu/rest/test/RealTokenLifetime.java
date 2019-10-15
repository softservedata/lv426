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
                {UserRepository.getAdmin()},
        };
    }

    @BeforeClass
    public void setUp() {
        guestService = new GuestService();
    }

    @BeforeMethod
    public void login() {
        adminService = guestService.successfulAdminLogin(UserRepository.getAdmin());
    }


    @AfterMethod
    public void tearDown() {
        if ((adminService != null) && (guestService != null)){
            adminService.updateTokenLifetime(LifetimeRepository.getDefault())
                    .removeUser(UserRepository.getMaxUser());
            System.out.println(adminService.isUserRemoved(UserRepository.getMaxUser()));
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
    public void checkRealTime(User user) {
        Lifetime testTime = LifetimeRepository.getShortLifeTime();
        AdminService adminService = guestService.successfulAdminLogin(user);
        adminService.updateTokenLifetime(testTime);
        wait(testTime);
        Assert.assertFalse(adminService.isAdminLogged(user));
    }


    @Test(dataProvider = "user")
    public void checkRealLifetimeForUser(User user, Lifetime testTime) {
        UserService userService = guestService.successfulUserLogin(user);
        adminService.updateTokenLifetime(testTime);
        wait(testTime);
        guestService.successfulAdminLogin(UserRepository.getAdmin());
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
