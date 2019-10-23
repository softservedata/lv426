package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import com.softserve.edu.rest.tools.Listener;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;


@Listeners(Listener.class)
@Epic("Admin trying to change a cool down time with invalid data")
@Story("Change cool down time with negative and hyge number, with text and different symbols")

public class InvalidCoolDownTimeTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @BeforeClass
    public void adminRegistration() {
        logger.info("Before class run");
        GuestService guestService = new GuestService();
        logger.trace("Successful admin sign in");
        guestService.successfulAdminLogin(UserRepository.getAdmin())
                .createUser(UserRepository.getMaxAdmin())
                .createUser(UserRepository.getAdmin2())
                .createUser(UserRepository.notExistingUser());
        logger.trace("Creation of three users");
    }

    @BeforeMethod
    public void checkIfCoolDownTimeWorks() {
        logger.info("Before method run");
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
        logger.trace("Unsuccessful change of cool down time into symbols");
        Assert.assertEquals(defaultTime.getTime(), userService.getCoolDownTime().getTime(),
                "The cool down time have changed into symbols");
        userService.logoutUser();
        logger.trace("Successful admin sign out");
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
        logger.trace("Unsuccessful change of cool down time into text");
        Assert.assertEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into text");
        userService.logoutUser();
        logger.trace("Successful admin sign out");
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
        logger.trace("Successful change of cool down time into zero");
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
        logger.trace("Successful admin sign in");
        logger.trace("Successful change of cool down time into negative number");
        Assert.assertNotEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into negative number");
        userService.logoutUser();
        logger.trace("Successful admin sign out");
    }

    @AfterClass(alwaysRun = true)
    public void setCoolDownTimeForDefault() {
        logger.info("After class method setCoolDownTimeForDefault() run");
        GuestService guestService = new GuestService();
        guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getDefaultCoolTime())
                .removeUser(UserRepository.getMaxAdmin())
                .removeUser(UserRepository.getAdmin2())
                .removeUser(UserRepository.notExistingUser())
                .logoutUser();
        logger.trace("Successful admin sign in");
        logger.trace("Successful set up the cool down time into default");
        logger.trace("Successful remove of 3 admins");
        Assert.assertEquals(LifetimeRepository.getDefaultCoolTime().getTime(), guestService.getCoolDownTime().getTime(),
                "The cool down time does not equal to default after test");
        logger.trace("Successful admin sign out");
    }

}
