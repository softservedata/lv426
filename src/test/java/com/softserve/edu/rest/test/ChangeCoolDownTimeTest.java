package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ChangeCoolDownTimeTest {
    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin()},
        };
    }

    @Test(dataProvider = "correctUser")
    public void coolDownTimeChangeTest(User user) {
        GuestService guestService = new GuestService();
        UserService userService = guestService
                .getCoolDownTime()
                .SuccessfulAdminLogin(user)
                .changeCoolDown("500000");
        assertEquals(userService.getCoolDownTime(), "500000");
    }
}
