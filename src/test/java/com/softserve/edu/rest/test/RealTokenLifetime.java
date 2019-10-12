package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RealTokenLifetime {
    private GuestService guestService;


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

    @Test(dataProvider = "adminUser")
    public void checkRealTime(User user) {
        Lifetime testTime = LifetimeRepository.getShortLifeTime();
        AdminService adminService = guestService.successfulAdminLogin(user);
        adminService.updateTokenLifetime(testTime);
        wait(testTime);
        Assert.assertFalse(adminService.isAdminLogged(user));
    }

    private void wait(Lifetime time) {
        try {
            Thread.sleep(Integer.parseInt(time.getTime()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
