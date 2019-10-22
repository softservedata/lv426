package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemRepository;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.softserve.edu.rest.data.ItemRepository.EXPECTED_EMPTY_ITEM_NAME;

public class ItemTest {

    public static final Logger logger = LoggerFactory.getLogger(ItemTest.class);

    private UserService userService;

    @BeforeMethod
    public void userLogIn() {
        logger.info("Before method userLogIn() START");
        userService = new GuestService()
                .successfulUserLogin(UserRepository.forItemUser());
    }

    @AfterMethod
    public void userLogOut() {
        logger.info("After method userLogOut() START");
        userService.logoutUser();
    }

    @DataProvider
    public Object[][] createValidItem() {
        logger.info("DataProvider createValidItem() START");
        return new Object[][]{
                {ItemRepository.getValidItem()}
        };
    }

    @DataProvider
    public Object[][] createInvalidItem() {
        logger.info("DataProvider createInvalidItem() START");
        return new Object[][]{
                {ItemRepository.getInvalidItem()}
        };
    }

    @DataProvider
    public Object[][] updateItem() {
        logger.info("DataProvider updateItem() START");
        return new Object[][]{
                {ItemRepository.getValidItem(), ItemRepository.getUpdateValidItem()}
        };
    }

    @Test(dataProvider = "createValidItem", description = "Valid Test Scenario, create valid Item")
    public void itemCreateTest(Item item) {
        logger.info("Test itemCreateTest() START");
        userService.addItem(item);
        Assert.assertEquals(userService.getItem(item), item.getItem());
        userService.deleteItem(item);
    }

    @Test(dataProvider = "createInvalidItem", description = "Invalid Test Scenario, create Item with empty index")
    public void emptyItemCreateTest(Item item) {
        logger.info("Test emptyItemCreateTest() START");
        userService.addItem(item);

        Assert.assertEquals(userService.getItem(item), EXPECTED_EMPTY_ITEM_NAME);
        userService.deleteItem(item);
    }

    @Test(dataProvider = "updateItem", description = "Valid Test Scenario, create valid Item and then modify it")
    public void itemUpdateTest(Item oldItem, Item newItem) {
        logger.info("Test itemUpdateTest() START");
        userService.addItem(oldItem);

        Assert.assertEquals(userService.getItem(oldItem), oldItem.getItem());

        userService.updateItem(newItem);

        Assert.assertEquals(userService.getItem(newItem), newItem.getItem());

        userService.deleteItem(newItem);
    }
}
