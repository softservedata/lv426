package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import com.softserve.edu.rest.tools.AllureOkHttp;
import com.softserve.edu.rest.tools.Listener;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.interceptor.Interceptors;
@Listeners(Listener.class)
@Epic("Run all main functionality of Cool down part")
@Story("Admin change cool down time ")
public class ChangeCoolDownTimeTest {
    private GuestService guestService;
    private AdminService adminService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeMethod
    public void checkIfCoolDownTimeWorks() {
        logger.info("Before method checkIfCoolDownTimeWorks() run");
        guestService = new GuestService();
        adminService = guestService.successfulAdminLogin(UserRepository.getAdmin());
        Assert.assertEquals(guestService.getCoolDownTime().getTime(), "180000",
                "The cool down time does not equal to default before test");
        logger.warn("Check if the cool down time equals to expected");
        Assert.assertTrue(adminService.isAdminLogged(UserRepository.getAdmin()),
                "The admin does not logged");
        logger.warn("Check if the sign in as admin is successful");
    }

    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), LifetimeRepository.getNewLifeTime(),
                        LifetimeRepository.getDefaultCoolTime()},
        };
    }

    @Test(dataProvider = "correctUser")
  //  @Interceptors(AllureOkHttp.class)
    public void coolDownTimeChangeTest(User user, Lifetime lifetime, Lifetime defaultTime) {
        UserService userService = guestService
                .successfulAdminLogin(user)
                .changeCoolDown(lifetime);
        Assert.assertNotEquals(userService.getCoolDownTime().getTime(), defaultTime.getTime(),
                "The cool down time have not changed into new");
        logger.warn("Check if the cool down time change is unsuccessful ");
    }

    @AfterMethod
    public void setCoolDownTimeForDefault() {
       guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getDefaultCoolTime());
        Assert.assertEquals(guestService.getCoolDownTime().getTime(), LifetimeRepository.getDefaultCoolTime().getTime(),
                "The cool down time does not equal to default after test");
        logger.warn("Check if the cool down time change is returns to default ");
    }

//


}
