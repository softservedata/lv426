package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest {@DataProvider
public Object[][] correctUser() {
    return new Object[][]{
            { UserRepository.getAdmin(), UserRepository.notExistingUser2() },
    };
}

    @Test(dataProvider = "correctUser")
    public void registerPositiveTest(User user, User newUser) {
        //log.debug("loginPositiveTest started!");
        //Steps
        GuestService guestService = new GuestService()
                .successfulAdminLogin(user)
                .createUser(newUser)
                .logoutUser();


        //Check
        //Assert.assertTrue(userService.isUserLogged(user));
        //Step

    }
}
