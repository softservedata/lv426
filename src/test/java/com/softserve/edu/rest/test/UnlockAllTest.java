package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UnlockAllTest {

    AdminService adminService;

    @DataProvider
    public Object[][] user() {
        return new Object[][]{
                { UserRepository.notExistingUser(),
                //UserRepository.getAdminWithEmptyData()
                        UserRepository.notExistingUser2()}
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

    @Test(dataProvider =  "user")
    public void locking(User[] users) {
        adminService
                .createUser(users[0]);
        adminService
                .createUser(users[1]);
        adminService.isUserCreated(users[0]);
        adminService.isUserCreated(users[1]);

        adminService
                .lockUser(users[0]);
        adminService
                .lockUser(users[1]);
        adminService.getAllLockedUsers();
        //Assert.();
    }
}
