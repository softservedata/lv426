package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.BaseService;
import com.softserve.edu.rest.tools.Listener;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(Listener.class)
@Epic("Some cases of blocking of Admins")
@Story("Yourself locking, locking admins each other, check lock" +
        " new admin with same name as locked admin")
public class LockAdminsTest {

    private static final Logger logger =
            Logger.getLogger(LockAdminsTest.class);
    AdminService adminService;

    @DataProvider
    public Object[][] user() {
        return new Object[][]{
                {UserRepository.notExistingUser(),
                        UserRepository.notExistingUser2()}
        };
    }


    @BeforeMethod
    public void login() {
        logger.info("Before method: login Admin");
        adminService = new AdminService(UserRepository.getAdmin())
                .successfulAdminLogin(UserRepository.getAdmin());
    }

    @AfterMethod()
    public void reset() {
        logger.info("After method: reset system");
        BaseService service = new BaseService()
                .reset();
    }

    @Test
    public void lockYourself() {
        logger.info(
                "Test: Admin block himself and had alive login session");
        adminService.lockUser(UserRepository.getAdmin());
        Assert.assertTrue(adminService
                .isAdminLocked(UserRepository.getAdmin()));
        logger.info(
                "Test end: Admin in system until login, after" +
                        " logout he can't do this because blocked");
    }

    @Test
    public void deadlock() {
        logger.info(
                "Test: Two admins block each other then they login");
        adminService.createUser(UserRepository.getAdmin2());
        AdminService adminServiceSecond =
                new AdminService(UserRepository.getAdmin2())
                        .successfulAdminLogin(
                                UserRepository.getAdmin2())
                        .lockUser(UserRepository.getAdmin());
        adminService.lockUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminServiceSecond
                .isAdminLocked(UserRepository.getAdmin()));
        Assert.assertTrue(adminService
                .isAdminLocked(UserRepository.getAdmin2()));
        logger.info(
                "Test end: They had alive login session until they logout");

    }

    @Test
    public void phantomBlock() {
        logger.info(
                "Test: check if the system is blocking a new admin who" +
                        " has the same name as the admin" +
                        " who has been blocked and deleted");
        adminService.createUser(UserRepository.getAdmin2())
                .lockUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminService
                .isAdminLocked(UserRepository.getAdmin2()));
        adminService.removeUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminService
                .isUserRemoved(UserRepository.getAdmin2()));
        Assert.assertFalse(adminService
                .isAdminLocked(UserRepository.getAdmin2()));
        logger.info(
                "Test end: after removing Admins name disappeared " +
                        "from list of blocked Admins and cant " +
                        "influence on new admin");

    }


}
