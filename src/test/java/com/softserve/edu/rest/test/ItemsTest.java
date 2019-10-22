package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.*;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class ItemsTest {

    public static final Logger logger = (Logger) LoggerFactory.getLogger(ItemsTest.class);

    @DataProvider
    public Object[][] itemget() {
        logger.info("@DataProvider itemget() DONE");
        return new Object[][]{
                {UserRepository.forItemUser(),ItemRepository.getValidItem(), UserRepository.getAdmin(),
                        ItemRepository.getSecond()}
        };
    }


    @Attachment(value="{0}", type="text/plain")
    @Description("checking all added items getting")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "itemget")
    public void getAllItemsTest(User user, Item firstItem, User admin, Item secondItem) {
        logger.info("getAllItemsTest() START");
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .addItem(firstItem)
                .addItem(secondItem);
        logger.trace("log in user " + user.getName() + " and add item " + firstItem.getItem());



        Assert.assertTrue(userService.getAllItems().contains(secondItem.getItem()));
        Assert.assertTrue(userService.getAllItems().contains(firstItem.getItem()));
        userService.logoutUser();
        logger.info("getAllItemsTest() FINISH");
    }

    @Attachment(value="{0}", type="text/plain")
    @Description("Checking all added item's indexes getting")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(dataProvider = "itemget")
    public void getAllItemsIndexesTest(User user, Item firstItem, User admin, Item secondItem) {
        logger.info("getAllItemsIndexesTest() START");
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
        logger.info("getAllItemsIndexesTest() FINISH");
    }


    @Attachment(value="{0}", type="text/plain")
    @Description("checking all added user items getting")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "itemget")
    public void getUserItemsTest(User user, Item firstItem, User admin, Item secondItem) {
        logger.info("getUserItemsTest() START");
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
        logger.info("getUserItemsTest() FINISH");

    }

    @Attachment(value="{0}", type="text/plain")
    @Description("Checking  added user item getting")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "itemget")
    public void getUserItemTest(User user, Item firstItem, User admin, Item secondItem) {
        logger.info("getUserItemTest() START");
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
        logger.info("getUserItemsTest() FINISH");
    }



}
