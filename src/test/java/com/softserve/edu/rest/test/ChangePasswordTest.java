package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangePasswordTest {
    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.existingUser()},
        };
    }

    @Test(dataProvider = "correctUser")
    public void changePositiveTest(User user) {
        GuestService guestService  = new GuestService()
                .successfulUserLogin(user)
                .changePassword("qwerty")
//        user.setPassword("qwerty1");
//        userService
                .logoutUser()
                .successfulUserLogin(user)
                .logoutUser();
    }

//    @AfterTest
//    public void changeBackPassword() {
//        User user = UserRepository.existingUser();
//        UserService userService  = new UserService(user)
//                .successfulUserLogin(user)
//                .changePassword("qwerty");
//        user.setPassword("qwerty");
//        userService
//                .logoutUser();
//    }
}

