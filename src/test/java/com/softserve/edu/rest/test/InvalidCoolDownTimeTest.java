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

public class InvalidCoolDownTimeTest {
    @BeforeMethod
    public void checkIfCoolDownTimeWorks() {
        GuestService guestService = new GuestService();
        AdminService adminService = new AdminService(UserRepository.getAdmin());
        assertEquals(guestService.getCoolDownTime().getTime(), "180000");
        Assert.assertFalse(adminService.isAdminLogged(UserRepository.getAdmin()),
                "The cool down time does not equal to default before test");
    }

    @DataProvider
    public Object[][] inCorrectLifetime() {
        return new Object[][]{
                {UserRepository.getAdmin(),LifetimeRepository.getSpecialSymbolLifetime()
                ,LifetimeRepository.getDefaultCoolTime()}
        };
    }
    @Test(dataProvider = "inCorrectLifetime")
    public void coolDownTimeWithSpecialSymbols(User user, Lifetime lifetime, Lifetime defaultTime){
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have changed into symbols");
        userService.logoutUser();
    }
    @DataProvider
    public Object[][] textLifetime() {
        return new Object[][]{
                {UserRepository.getAdmin(),LifetimeRepository.getTextLifetime()
                        ,LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "textLifetime")
    public void coolDownTimeWithText(User user, Lifetime lifetime, Lifetime defaultTime){
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
                {UserRepository.getAdmin(),LifetimeRepository.getZeroLifetime()
                        ,LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "zeroLifetime")
    public void coolDownTimeWithZero(User user, Lifetime lifetime, Lifetime defaultTime){
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertNotEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into new");
        userService.logoutUser();
    }
    @DataProvider
    public Object[][] negativeNumberLifetime() {
        return new Object[][]{
                {UserRepository.getAdmin(),LifetimeRepository.getNegativeDefault()
                        ,LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "negativeNumberLifetime")
    public void coolDownTimeWithNegativeDigits(User user, Lifetime lifetime, Lifetime defaultTime){
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertNotEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into new");
        userService.logoutUser();
    }

    @AfterMethod
    public void setCoolDownTimeForDefault() {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getDefaultCoolTime());
        Assert.assertEquals(LifetimeRepository.getDefaultCoolTime().getTime(),guestService.getCoolDownTime().getTime(),
                "The cool down time does not equal to default after test");
    }

}
