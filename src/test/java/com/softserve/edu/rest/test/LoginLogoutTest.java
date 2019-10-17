package com.softserve.edu.rest.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;

public class LoginLogoutTest {

	@Test
	public void checkVariables() {
		System.out.println("JENKINS_LV426_PASSWORD = "
				+ System.getenv().get("JENKINS_LV426_PASSWORD"));
		System.out.println("password.variable = " + System.getProperty("password.variable"));
	}

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
