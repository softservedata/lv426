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

public class InvalidCoolDownTimeTest {
    @BeforeClass
    public void adminRegistration() {
        GuestService guestService = new GuestService();
        guestService.successfulAdminLogin(UserRepository.getAdmin())
                .createUser(UserRepository.getMaxAdmin())
                .createUser(UserRepository.getAdmin2())
                .createUser(UserRepository.notExistingUser());
    }

    @BeforeMethod
    public void checkIfCoolDownTimeWorks() {
        AdminService adminService = new AdminService(UserRepository.getAdmin());
        Assert.assertFalse(adminService.isAdminLogged(UserRepository.getAdmin()),
                "The cool down time does not equal to default before test");
    }

    @DataProvider
    public Object[][] inCorrectLifetime() {
        return new Object[][]{
                {UserRepository.getAdmin2(), LifetimeRepository.getSpecialSymbolLifetime()
                        , LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "inCorrectLifetime", expectedExceptions = RuntimeException.class)
    public void coolDownTimeWithSpecialSymbols(User user, Lifetime lifetime, Lifetime defaultTime) {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertEquals(defaultTime.getTime(), userService.getCoolDownTime().getTime(),
                "The cool down time have changed into symbols");
        userService.logoutUser();
    }

    @DataProvider
    public Object[][] textLifetime() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getTextLifetime()
                        , LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "textLifetime", expectedExceptions = RuntimeException.class)
    public void coolDownTimeWithText(User user, Lifetime lifetime, Lifetime defaultTime) {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into text");
        userService.logoutUser();
    }

    @DataProvider
    public Object[][] zeroLifetime() {
        return new Object[][]{
                {UserRepository.notExistingUser(), LifetimeRepository.getZeroLifetime()
                        , LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "zeroLifetime")
    public void coolDownTimeWithZero(User user, Lifetime lifetime, Lifetime defaultTime) {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertNotEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into zero");
        userService.logoutUser();
    }

    @DataProvider
    public Object[][] negativeNumberLifetime() {
        return new Object[][]{
                {UserRepository.getMaxAdmin(), LifetimeRepository.getNegativeDefault()
                        , LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "negativeNumberLifetime")
    public void coolDownTimeWithNegativeDigits(User user, Lifetime lifetime, Lifetime defaultTime) {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertNotEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into negative number");
        userService.logoutUser();
    }

    @AfterClass(alwaysRun = true)
    public void setCoolDownTimeForDefault() {
        GuestService guestService = new GuestService();
        guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getDefaultCoolTime())
                .removeUser(UserRepository.getMaxAdmin())
                .removeUser(UserRepository.getAdmin2())
                .removeUser(UserRepository.notExistingUser());
        Assert.assertEquals(LifetimeRepository.getDefaultCoolTime().getTime(), guestService.getCoolDownTime().getTime(),
                "The cool down time does not equal to default after test");
    }

}
