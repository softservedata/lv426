package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
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
                UserRepository.getAdminWithEmptyData()
        };
    }


    @BeforeMethod
    public void login() {
        adminService = new AdminService(UserRepository.getAdmin())
                .successfulAdminLogin(UserRepository.getAdmin());
    }

    @AfterMethod()
    public void logout() {
        adminService.logoutUser();
    }

    @Test(dataProvider = "user")
    public void createTest(User newUser) {
        adminService.createUser(newUser);
        Assert.assertEquals(adminService.isUserCreated(newUser),
                true);
    }

    @Test(dataProvider = "user")
    public void removeTest(User newUser) {
        adminService
                .removeUser(newUser);
        Assert.assertEquals(adminService.isUserRemoved(newUser),
                true);
        adminService
                .logoutUser()
                .unsuccessfulUserLogin(newUser);
    }

}
