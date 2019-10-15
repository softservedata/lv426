package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangeCoolDownTimeWithoutRightTest {
    @DataProvider
    public Object[][] dataDistributor() {
        return new Object[][]{
                {UserRepository.notExistingUser2(), LifetimeRepository.getNewLifeTime()}
        };
    }

    @Test(dataProvider = "dataDistributor")
    public void changeCoolDownTimeAsUser(User existingUser, Lifetime newLifeTime) {
        GuestService guestService = new GuestService();
        UserService user = guestService
                .successfulAdminLogin(existingUser)
                .changeCoolDown(newLifeTime);

    }
}
