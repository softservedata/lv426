package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.BaseService;
import com.softserve.edu.rest.services.GuestService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LockAdminsTest {

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

        BaseService service = new BaseService()
                .reset();
    }

    @Test
    public void lockYourself()
    {
        adminService.lockUser(UserRepository.getAdmin());
        Assert.assertTrue(adminService.isAdminLocked(UserRepository.getAdmin()));
    }

    @Test
    public void deadlock() {
        adminService.createUser(UserRepository.getAdmin2());
        AdminService adminServiceSecond = new AdminService(UserRepository.getAdmin2())
                .successfulAdminLogin(UserRepository.getAdmin2())
                .lockUser(UserRepository.getAdmin());
        adminService.lockUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminServiceSecond.isAdminLocked(UserRepository.getAdmin()));
        Assert.assertTrue(adminService.isAdminLocked(UserRepository.getAdmin2()));
    }

    @Test
    public void phantomBlock() {
        adminService.createUser(UserRepository.getAdmin2())
                .lockUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminService.isAdminLocked(UserRepository.getAdmin2()));
        adminService.removeUser(UserRepository.getAdmin2());
        Assert.assertTrue(adminService.isUserRemoved(UserRepository.getAdmin2()));
        Assert.assertFalse(adminService.isAdminLocked(UserRepository.getAdmin2()));


    }


}
