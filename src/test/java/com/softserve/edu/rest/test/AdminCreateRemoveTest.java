package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.BaseService;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminCreateRemoveTest {

    AdminService adminService;

    @DataProvider
    public Object[] user() {
        return new Object[]{
                UserRepository.notExistingUser(),
                //   UserRepository.getAdminWithEmptyData()
        };
    }


    @BeforeMethod
    public void login() {
        adminService = new AdminService(UserRepository.getAdmin())
                .successfulAdminLogin(UserRepository.getAdmin());
    }

    @AfterMethod()
    public void logout() {
        BaseService service = new BaseService().reset();
    }

    @Test(dataProvider = "user")
    public void createTest(User newUser) {
        adminService.createUser(newUser);
        Assert.assertEquals(adminService.isUserCreated(newUser),
                true);
    }

    @Test(dataProvider = "user")
    public void removeTest(User newUser) {
        adminService.createUser(newUser);

        adminService
                .removeUser(newUser);
        Assert.assertEquals(adminService.isUserRemoved(newUser),
                true);
        adminService
                .logoutUser()
                .unsuccessfulUserLogin(newUser);
    }

    @Test
    public void removeLoginAdminTest() {
        adminService.createUser(UserRepository.getAdmin2());
        AdminService adminServiceSecond =
                new AdminService(UserRepository.getAdmin2())
                        .successfulAdminLogin(
                                UserRepository.getAdmin2());
        Assert.assertTrue(adminService
                .isAdminLogged(UserRepository.getAdmin2()));
        adminService.removeUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminService
                .isUserRemoved(UserRepository.getAdmin2()));
        Assert.assertTrue(adminServiceSecond.getAllAdmins()
                .contains(UserRepository.getAdmin2().getName()));
        adminServiceSecond.logoutUser()
                .successfulAdminLogin(UserRepository.getAdmin2());
        Assert.assertFalse(adminServiceSecond
                .isAdminLogged(UserRepository.getAdmin2()));
    }

}
