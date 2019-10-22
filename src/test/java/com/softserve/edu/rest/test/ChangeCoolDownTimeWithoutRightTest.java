package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeCoolDownTimeWithoutRightTest extends TestRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DataProvider
    public Object[][] dataDistributor() {
        return new Object[][]{
                {UserRepository.notExistingUser2(), LifetimeRepository.getNewLifeTime()}
        };
    }

    @Test(dataProvider = "dataDistributor")
    public void changeCoolDownTimeAsUser(User existingUser, Lifetime newLifeTime) {
        GuestService guestService = new GuestService();
        UserService user = guestService
                .successfulAdminLogin(existingUser)
                .changeCoolDown(newLifeTime);
        Assert.assertNotEquals(user.getCoolDownTime().getTime(), newLifeTime.getTime(),
                "Cool down time has been changed without admin rights, as user");
        logger.warn("Cool down time fail change");
    }

    @DataProvider
    public Object[][] tokenDistributor() {
        return new Object[][]{
                {UserRepository.getNotExistingUserWithToken(), LifetimeRepository.getNewLifeTime(),
                        LifetimeRepository.getDefaultCoolTime()}
        };
    }

    @Test(dataProvider = "tokenDistributor")
    public void changeCoolDownTimeWithRandomToken(User randomUser, Lifetime newLifetime, Lifetime defaultLifetime) {
        GuestService guestService = new GuestService();
        UserService userService = guestService.successfulAdminLogin(randomUser)
                .changeCoolDown(newLifetime);
        Assert.assertEquals(defaultLifetime.getTime(), userService.getCoolDownTime().getTime(),
                "Cool down time has been changed with with not existing user");
        logger.warn("Cool down time fail change");
    }
}
