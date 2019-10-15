package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ChangeCoolDownTimeTest {

    @BeforeMethod
    public void checkIfCoolDownTimeWorks() {
        GuestService guestService = new GuestService();
        AdminService adminService = new AdminService(UserRepository.getAdmin());
        assertEquals(guestService.getCoolDownTime().getTime(), "180000");
        Assert.assertFalse(adminService.isAdminLogged(UserRepository.getAdmin()),
                "The cool down time does not equal to default before test");
    }

    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getNewLifeTime(),
                        LifetimeRepository.getDefaultCoolTime()},
        };
    }

    @Test(dataProvider = "correctUser")
    public void coolDownTimeChangeTest(User user, Lifetime lifetime, Lifetime defaultTime) {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertNotEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into new");
    }

    @AfterMethod
    public void setCoolDownTimeForDefault() {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getDefaultCoolTime());
        assertEquals(guestService.getCoolDownTime().getTime(), LifetimeRepository.getDefaultCoolTime().getTime(),
                "The cool down time does not equal to default after test");
    }
}
