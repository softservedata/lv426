package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LockUserChangeCoolTimeCheckIfUnlocked {

@DataProvider
    public Object[][] dataDistributor(){
    return new Object[][]{
            {UserRepository.getMaxUser(), LifetimeRepository.getDefaultCoolTime(), UserRepository.getAdmin(),
            }
    };
}

@BeforeMethod
public void lockUserByLogin(){
    GuestService guestService = new GuestService();
    for (int i =0; i<3; i++)
    guestService.successfulUserLogin(UserRepository.getMaxUserWithMistake());
    }

@Test(dataProvider = "dataDistributor", expectedExceptions = RuntimeException.class)
    public void testName(User simpleUser){
    GuestService guestService = new GuestService();
    guestService.successfulUserLogin(simpleUser);
}
}
