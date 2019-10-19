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
        UserService adminService = new GuestService()
                .successfulUserLogin(admin)
                //.addItem(firstItem)
                .addItem(secondItem);
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem (firstItem);

        Assert.assertTrue(adminService.getAllItems().contains(secondItem.getItem()));
        Assert.assertTrue(adminService.getAllItems().contains(firstItem.getItem()));

        userService.logoutUser();
    }


     @Test (dataProvider = "itemget")
    public void  getAllItemsIndexesTest(User user, Item firstItem, User admin, Item secondItem){
         UserService adminService = new GuestService()
                 .successfulUserLogin(admin)
                 //.addItem(firstItem)
                 .addItem(secondItem);
         UserService userService = new GuestService()
                 .successfulUserLogin(user)
                 .addItem (firstItem);

         Assert.assertTrue(adminService.getAllItemsIndexes().contains(secondItem.getIndex()));
         Assert.assertTrue(adminService.getAllItemsIndexes().contains(firstItem.getIndex()));

         userService.logoutUser();
    }


    @Test (dataProvider = "itemget")
    public void getUserItemsTest (User user,Item firstItem, User admin,Item secondItem){
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(firstItem)
                .successfulUserLogin(admin)
                .addItem(secondItem);
                //.getUserItems(user);

        Assert.assertTrue(userService.getUserItems(user).contains(firstItem.getItem()));
        userService.logoutUser();

    }

    @Test (dataProvider = "itemget")
    public void getUserItemTest(User user,Item firstItem, User admin,Item secondItem, Items item){
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(firstItem)
                .successfulUserLogin(admin)
                .addItem(secondItem);
        //.getUserItems(user);

        Assert.assertTrue(userService.getUserItem(item).contains(firstItem.getItem()));
        userService.logoutUser();
    }



}
