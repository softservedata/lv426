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
@Epic("Create and remove new Admin")
@Story("Standard operation create and remove new admin and remove login Admin")
public class AdminCreateRemoveTest {

    private static final Logger logger =
            Logger.getLogger(AdminCreateRemoveTest.class);
    AdminService adminService;

    @DataProvider
    public Object[] user() {
        return new Object[]{
                UserRepository.notExistingUser(),
        };
    }


    @BeforeMethod
    public void login() {
        logger.info("Before method: login Admin");
        adminService = new AdminService(UserRepository.getAdmin())
                .successfulAdminLogin(UserRepository.getAdmin());
    }

    @AfterMethod()
    public void resetSystem() {
        logger.info("After method: reset system");
        BaseService service = new BaseService().reset();
    }

    @Test(dataProvider = "user")
    public void createAdminTest(User newUser) {
        logger.info("Test: creating Admin");
        adminService.createUser(newUser);
        Assert.assertEquals(adminService.isUserCreated(newUser),
                true);
        logger.info("Test end: Admin was created");
    }

    @Test(dataProvider = "user")
    public void removeAdminTest(User newUser) {
        logger.info("Test: removing Admin");
        adminService.createUser(newUser)
                .removeUser(newUser);
        Assert.assertEquals(adminService.isUserRemoved(newUser),
                true);
        logger.info("Test end: Admin was created and removed");
    }

    @Test
    public void removeLoginAdminTest() {
        logger.info("Test removing login Admin");
        adminService.createUser(UserRepository.getAdmin2());
        AdminService adminServiceSecond =
                new AdminService(UserRepository.getAdmin2())
                        .successfulAdminLogin(
                                UserRepository.getAdmin2());
        Assert.assertTrue(adminService
                .isAdminLogged(UserRepository.getAdmin2()));
        logger.info("Second admin create and login");
        adminService.removeUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminService
                .isUserRemoved(UserRepository.getAdmin2()));
        logger.info("Removing second admin");
        Assert.assertTrue(adminServiceSecond.getAllAdmins()
                .contains(UserRepository.getAdmin2().getName()));
        logger.info("Second admin alive in login session");
        adminServiceSecond.logoutUser()
                .successfulAdminLogin(UserRepository.getAdmin2());
        Assert.assertFalse(adminServiceSecond
                .isAdminLogged(UserRepository.getAdmin2()));
        logger.info("Test end: After logout second admin is not found");
    }

}
