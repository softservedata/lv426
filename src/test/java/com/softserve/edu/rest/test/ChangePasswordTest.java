package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.annotations.*;

public class ChangePasswordTest {
    GuestService guestService;
    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.existingUser()},
        };
    }
//    @BeforeClass
//    public void setUp() {
//        guestService = new GuestService();
//    }
//    @AfterMethod
//    public void changeBackPassword() {
//        if (guestService != null){
//            guestService.successfulUserLogin(UserRepository.existingUser());
//            UserService userService = new UserService(UserRepository.existingUser());
//            userService.changePassword("qwerty");
//            userService.logoutUser();
//            guestService = null;
//        }
//    }

    @Test(dataProvider = "correctUser")
    public void changePositiveTest(User user) {
       guestService
                .successfulUserLogin(user)
                .changePassword("qwerty1")//;
      // user.setPassword("qwerty1");

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

