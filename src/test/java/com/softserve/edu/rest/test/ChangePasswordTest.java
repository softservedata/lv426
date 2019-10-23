package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.BaseService;
import com.softserve.edu.rest.services.GuestService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangePasswordTest {

    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.existingUser(), UserRepository.chngedExistingUser()},
        };
    }

    @DataProvider
    public Object[][] changeUser() {
        return new Object[][]{
                {UserRepository.existingUser2(), UserRepository.emptyUser()},
        };
    }

    @BeforeClass
    public void createUser() {
        AdminService adminService = new AdminService(UserRepository.getAdmin())
                .successfulAdminLogin(UserRepository.getAdmin())
                .createUser(UserRepository.existingUser())
                .createUser(UserRepository.existingUser2());
    }

    @AfterClass
    public void restore() {
        BaseService baseService = new BaseService()
                .reset();
    }

    @Test(dataProvider = "correctUser")
    public void changePositiveTest(User user, User changed) {
        GuestService guestService = new GuestService()
                .successfulUserLogin(user)
                .changePassword(changed.getPassword())
                .logoutUser()
                .successfulUserLogin(user)
                .logoutUser();
    }

    @Test(dataProvider = "changeUser")
    public void changeNegativeTest(User user, User empty) {
        GuestService guestService = new GuestService()
                .successfulUserLogin(user)
                .changePassword(empty.getPassword())
                .logoutUser()
                .successfulUserLogin(user)
                .logoutUser();
    }

}

