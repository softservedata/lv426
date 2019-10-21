package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import org.testng.Assert;
import org.testng.annotations.*;

public class LockUserChangeCoolTimeCheckIfUnlocked {
    private GuestService guestService;
    private AdminService adminService;

    @BeforeClass
    public void registerOfUser() {
        guestService = new GuestService();
        adminService = guestService.successfulAdminLogin(UserRepository.getAdmin())
                .createUser(UserRepository.getMaxUser());
        Assert.assertTrue(adminService.isUserCreated(UserRepository.getMaxUser()));
    }

    @BeforeMethod
    public void lockUserByLogin() {
        adminService.changeCoolDown(LifetimeRepository.getShortLifeTime());
        for (int i = 0; i < 3; i++) {
            guestService.unsuccessfulUserLogin(UserRepository.getMaxUserWithMistake());
        }
        Assert.assertTrue((guestService.successfulAdminLogin(UserRepository.getAdmin())
                .getAllLockedUsers().contains("testUser")));
    }

    //TODO
    @AfterMethod(alwaysRun = true)
    public void returnSystemIntoInitialState() {
        adminService.successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getDefaultCoolTime());
    }

    //TODO
    @AfterClass(alwaysRun = true)
    public void deleteCreatedUser() {
        adminService.successfulAdminLogin(UserRepository.getAdmin())
                .removeUser(UserRepository.getMaxUser()).logoutUser();
    }

    @DataProvider
    public Object[][] dataDistributor() {
        return new Object[][]{
                {UserRepository.getMaxUser(), UserRepository.getAdmin()}
        };
    }

    @Test(dataProvider = "dataDistributor")
    public void testName(User simpleUser, User admin) {
        try {
            Thread.sleep(Long.parseLong(guestService.getCoolDownTime().getTime()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(adminService.logoutUser()
                .successfulUserLogin(simpleUser)
                .successfulAdminLogin(admin)
                .isUserLogged(simpleUser));
    }
}