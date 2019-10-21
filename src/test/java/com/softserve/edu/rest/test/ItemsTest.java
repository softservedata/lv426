package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.*;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ItemsTest {

    @DataProvider
    public Object[][] itemget() {
        return new Object[][]{
                {UserRepository.forItemUser(),ItemRepository.getValidItem(), UserRepository.getAdmin(),
                        ItemRepository.getSecond()}
        };
    }

    @Test(dataProvider = "itemget")
    public void getAllItemsTest(User user, Item firstItem, User admin, Item secondItem) {
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(firstItem)
                .addItem(secondItem);



        Assert.assertTrue(userService.getAllItems().contains(secondItem.getItem()));
        Assert.assertTrue(userService.getAllItems().contains(firstItem.getItem()));
        userService.logoutUser();

    }


    @Test(dataProvider = "itemget")
    public void getAllItemsIndexesTest(User user, Item firstItem, User admin, Item secondItem) {

        UserService adminService = new GuestService()
                .successfulUserLogin(admin)
                //.addItem(firstItem)
                .addItem(secondItem);
        adminService.logoutUser();

        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(firstItem);

        Assert.assertTrue(userService.getAllItemsIndexes().contains(secondItem.getIndex()));
        Assert.assertTrue(userService.getAllItemsIndexes().contains(firstItem.getIndex()));

        userService.logoutUser();
    }



    @Test(dataProvider = "itemget")
    public void getUserItemsTest(User user, Item firstItem, User admin, Item secondItem) {
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(firstItem)
                .addItem(secondItem);
        userService.logoutUser();
        UserService adminService = new GuestService()
                .successfulUserLogin(admin);
        //.getUserItems(user);

        Assert.assertTrue(adminService.getUserItems(user).contains(firstItem.getItem()));
        Assert.assertTrue(adminService.getUserItems(user).contains(secondItem.getItem()));
        adminService.logoutUser();

    }

    @Test(dataProvider = "itemget")
    public void getUserItemTest(User user, Item firstItem, User admin, Item secondItem) {
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(firstItem)
                .addItem(secondItem);
        userService.logoutUser();
        UserService adminService = new GuestService()
                .successfulUserLogin(admin);
        //.getUserItems(user);

        Assert.assertTrue(adminService.getUserItem(firstItem, user).contains(firstItem.getItem()));
        adminService.logoutUser();
    }



}
