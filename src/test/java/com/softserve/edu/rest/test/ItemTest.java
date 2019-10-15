package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ItemTest {

    @DataProvider
    public Object[][] createItem() {
        return new Object[][]{
                {UserRepository.forItemUser(), ItemRepository.getValidItem()}
        };
    }

    @DataProvider
    public Object[][] updateItem() {
        return new Object[][]{
                {UserRepository.forItemUser(), ItemRepository.getValidItem(), ItemRepository.getUpdateValidItem()}
        };
    }

    @Test(dataProvider = "createItem")
    public void itemCreateTest(User user, Item item) {
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(item);

        Assert.assertEquals(userService.getItem(item), item.getItem());
        userService.deleteItem(item);
        userService.logoutUser();
    }

    @Test(dataProvider = "updateItem")
    public void itemUpdateTest(User user, Item item, Item newItem) {
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(item);

        Assert.assertEquals(userService.getItem(item), item.getItem());

        userService.updateItem(newItem);

        Assert.assertEquals(userService.getItem(newItem), newItem.getItem());

        userService.deleteItem(newItem);
        Assert.assertEquals(userService.getItem(item), null);
        userService.logoutUser();
    }
}