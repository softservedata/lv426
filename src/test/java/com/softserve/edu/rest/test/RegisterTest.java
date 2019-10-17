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
    private GuestService guestService;
    private AdminService adminService;
    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin(), UserRepository.notExistingUser2()},
        };
    }
@BeforeTest
public void setup(){

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
        Assert.assertEquals(adminService.isUserCreated(newUser), true);
        adminService
                .logoutUser()
                .successfulUserLogin(newUser)
                .logoutUser()
                .successfulAdminLogin(adminUser)
                .removeUser(newUser);
        Assert.assertEquals(adminService.isUserRemoved(newUser), true);
        adminService
                .logoutUser()
                .unsuccessfulUserLogin(newUser);

        //Check
        //Assert.assertTrue(userService.isUserLogged(user));
        //Step

    }
}
