package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LockUserChangeCoolTimeCheckIfUnlocked {


//@BeforeMethod
//public void lockUserByLogin(){
//    GuestService guestService = new GuestService();
//    for (int i =0; i<3; i++)
//    guestService.unsuccessfulUserLogin(UserRepository.getMaxUserWithMistake());
//    String lockedUsers = guestService.successfulAdminLogin(UserRepository.getAdmin()).getAllLockedUsers();
//    System.out.println(lockedUsers);
//    }

    @DataProvider
    public Object[][] dataDistributor(){
        return new Object[][]{
                {UserRepository.getMaxUser(), UserRepository.getAdmin(), LifetimeRepository.getDefaultCoolTime()
                }
        };
    }

@Test(dataProvider = "dataDistributor")
    public void testName(User simpleUser, User admin, Lifetime lifetime){
    GuestService guestService = new GuestService();
    for (int i =0; i<3; i++)
    guestService.unsuccessfulUserLogin(UserRepository.getMaxUserWithMistake());
    String lockedUsers = guestService.successfulAdminLogin(UserRepository.getAdmin()).getAllLockedUsers();
    Assert.assertEquals("testUser", lockedUsers.replaceAll("\\d\\s+", ""));
    guestService.successfulUserLogin(simpleUser);
    try {
        Thread.sleep(Long.parseLong(guestService.getCoolDownTime().getTime()));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    Assert.assertTrue(guestService.successfulAdminLogin(admin).isUs);
    guestService.successfulUserLogin(simpleUser).logoutUser();
    guestService.successfulAdminLogin(admin).changeCoolDown(lifetime);

}
}
