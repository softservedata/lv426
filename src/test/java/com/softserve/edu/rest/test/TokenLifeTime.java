package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TokenLifeTime {
    private GuestService guestService;
    private  Lifetime lifetime;

    @DataProvider
    public Object[][] correctUser() {
        return new Object[][]{
                {UserRepository.getAdmin()},
        };
    }


    @BeforeClass
    public void setUp() {
        guestService = new GuestService();
    }

    @Test
    public void getTokenLifeTime() {
        lifetime = guestService.getTokenLifetime();
        Assert.assertEquals(lifetime.getTime(), LifetimeRepository.getDefault().getTime());
    }

    @Test
    public void checkIfTokenLifeTimeIsPositiveNumber() {
        lifetime = guestService.getTokenLifetime();
        Assert.assertTrue(Integer.parseInt(lifetime.getTime()) > 0);
    }

    private int parseInt(String lifetime) {
        return Integer.parseInt(lifetime);
    }


}
