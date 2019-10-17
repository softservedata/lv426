package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.*;

public class LockUserAndUnlockAll {
    private GuestService guestService;
    private AdminService adminService;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        guestService = new GuestService();
        guestService
                .successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getShortLifeTime())
                .updateTokenLifetime(LifetimeRepository.getNewLifeTime())
                .logoutUser();
    }

    @BeforeMethod(alwaysRun = true)
    public void registration() {
        adminService = guestService.successfulAdminLogin(UserRepository.getAdmin())
                .createUser(UserRepository.getMaxAdmin())
                .createUser(UserRepository.getMaxUser())
                .lockUser(UserRepository.getMaxUser());
        Assert.assertTrue(adminService.getAllAdmins().contains("testAdmin"),
                "The admin has not been created");
        Assert.assertTrue(adminService.getAllUsers().contains("testUser"),
                "The user has not been created");
        for (int i = 0; i < 3; i++) {
            guestService
                    .unsuccessfulAdminLogin(UserRepository.getAdmin()
                            .setPassword(RandomStringUtils.randomAlphabetic(3)));
        }
        Assert.assertTrue(adminService.getAllLockedUsers().contains("testUser"));
        adminService.logoutUser();
    }

    @AfterMethod(alwaysRun = true)
    public void deleteUsers() {
        adminService.successfulAdminLogin(UserRepository.getAdmin())
                .removeUser(UserRepository.getMaxAdmin())
                .removeUser(UserRepository.getMaxAdmin());
    }

    @AfterClass(alwaysRun = true)
    public void resetUp(){
        adminService.successfulAdminLogin(UserRepository.getAdmin())
                .changeCoolDown(LifetimeRepository.getDefaultCoolTime())
                .updateTokenLifetime(LifetimeRepository.getDefault())
                .logoutUser();
    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {UserRepository.getMaxAdmin(), UserRepository.getAdmin(),
                UserRepository.getMaxUser()}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void unlockAllUsers(User admin, User unlockedAdmin, User unlockedUser) {
        adminService = guestService.successfulAdminLogin(admin);
        try {
            Thread.sleep(Long.parseLong(adminService.getCoolDownTime().getTime()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(guestService
                        .successfulAdminLogin(unlockedAdmin)
                        .unlockAllUsers()
                        .getAllLockedUsers()
                        .contains("\\."),
                "Some user still locked");
        Assert.assertTrue(guestService
                        .successfulUserLogin(unlockedUser)
                        .successfulAdminLogin(unlockedAdmin)
                        .isUserLogged(unlockedUser),
                "User");
    }
}
