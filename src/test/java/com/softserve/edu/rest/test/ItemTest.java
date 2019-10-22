package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.rest.data.ItemRepository.EXPECTED_EMPTY_ITEM_NAME;

public class ItemTest {

    public static final Logger logger = LoggerFactory.getLogger(ItemTest.class);

    @DataProvider
    public Object[][] createItem() {
        return new Object[][]{
                {UserRepository.forItemUser(), ItemRepository.getValidItem()}
        };
    }

    @DataProvider
    public Object[][] createInvalidItem() {
        return new Object[][]{
                {UserRepository.forItemUser(), ItemRepository.getInvalidItem()}
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

    @Test(dataProvider = "createInvalidItem")
    public void emptyItemCreateTest(User user, Item item) {
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(item);

        Assert.assertEquals(userService.getItem(item), EXPECTED_EMPTY_ITEM_NAME);

        userService.deleteItem(item);
        userService.logoutUser();
    }

    @Test(dataProvider = "updateItem")
    public void itemUpdateTest(User user, Item item, Item newItem) {
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(item);
        logger.trace("log in user " + user.getName() + " and add item " + item.getItem());
        Assert.assertEquals(userService.getItem(item), item.getItem());

        userService.updateItem(newItem);

        Assert.assertEquals(userService.getItem(newItem), newItem.getItem());

        userService.deleteItem(newItem);
        Assert.assertEquals(userService.getItem(item), null);
        userService.logoutUser();
        logger.trace("log in user " + user.getName() + " and add item " + item.getItem());
    }
}
