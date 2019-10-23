package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest {
    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), UserRepository.notExistingUser2()},
        };
    }
    @DataProvider
    public Object[][] emptyUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), UserRepository.emptyUser()},
        };
    }
    @BeforeTest
    public void setup() {

    }

    @AfterTest
    public void afterRegister() {

    }

    @Test(dataProvider = "correctUser")
    public void registerPositiveTest(User adminUser, User newUser) {
        //log.debug("loginPositiveTest started!");
        //Steps
        AdminService adminService = new AdminService(adminUser)
                .successfulAdminLogin(adminUser)
                .createUser(newUser);
        Assert.assertTrue(adminService.isUserCreated(newUser));
        adminService
                .logoutUser()
                .successfulUserLogin(newUser)
                .logoutUser()
                .successfulAdminLogin(adminUser)
                .removeUser(newUser);
        Assert.assertTrue(adminService.isUserRemoved(newUser));
        adminService
                .logoutUser()
                .unsuccessfulUserLogin(newUser);
    }

    @Test(dataProvider = "emptyUser")
    public void registerEmptyTest(User adminUser, User emptyUser) {
        AdminService adminService = new AdminService(adminUser)
                .successfulAdminLogin(adminUser)
                .createUser(emptyUser);
        Assert.assertTrue(adminService.isUserCreated(emptyUser));
        adminService
                .logoutUser()
                .unsuccessfulUserLogin(emptyUser)
                .successfulAdminLogin(adminUser)
                .removeUser(emptyUser);
        Assert.assertFalse(adminService.isUserRemoved(emptyUser));
        adminService
                .logoutUser();
    }
}
