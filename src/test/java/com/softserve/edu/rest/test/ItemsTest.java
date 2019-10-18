package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Items;
import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemsRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ItemsTest {

  /*  @DataProvider
    public Object[][] itemget() {
        return new Object[][]{
                {UserRepository.getAdmin(), ItemsRepository.getValidItem()}
        };
    }

    @Test(dataProvider = "itemget")
    public void getAllItemsTest(User user, Items item) {
        String userService = new GuestService()
                .successfulUserLogin(user)
                .getAllItems(item);

        Assert.assertEquals(userService.getAllItems(item), item.getAllItems());
        userService.logoutUser();
    }


    @Test (dataProvider = "itemget")
    public void  getAllItemsIndexesTest(User user, Items item){
        String userService = new GuestService()
                .successfulUserLogin(user)
                .getAllItemsIndexes(item);

        Assert.assertEquals(userService.getAllItemsIndexes(item), item.getAllItemsIndexes());
        userService.logoutUser();
    }

    @Test (dataProvider = "itemget")
    public void getUserItemsTest (User user, Items item){
        String userService = new GuestService()
                .successfulUserLogin(user)
                .getUserItems(item);

        Assert.assertEquals(userService.getUserItems(item), item.getUserItems());
        userService.logoutUser();

    }

    @Test (dataProvider = "itemget")
    public void getUserItemTest(User user, Items item){
        String userService = new GuestService()
                .successfulUserLogin(user)
                .getUserItem(item);

        Assert.assertEquals(userService.getUserItem(item), item.getUserItem());
        userService.logoutUser();
    }


   */
}
