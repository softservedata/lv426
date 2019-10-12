package com.softserve.edu.rest.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;

import java.lang.reflect.InvocationTargetException;

public class LoginLogoutTest {

	@DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                { UserRepository.getAdmin() },
        };
    }

	@Test(dataProvider = "correctUser")
	public void loginPositiveTest(User user) {
        //log.debug("loginPositiveTest started!");
        //Steps
        GuestService guestService = new GuestService();
        UserService userService = guestService
        		.successfulUserLogin(user);
        //Check
        //Assert.assertTrue(userService.isUserLogged(user));
        //Step
        guestService = userService.logoutUser();
        //Assert.assertFalse(guestService.isUserLogged(user));
        //log.debug("loginPositiveTest finished!");
    }
}
