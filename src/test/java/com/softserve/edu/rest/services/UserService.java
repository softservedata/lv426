package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.*;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserService extends GuestService {

    protected LogoutResource logoutResource;
    protected ItemResource itemResource;

    protected AllItemsResource allItemsResource;
    protected AllItemsIndexesResource allItemsIndexesResource;
    protected UserItemsResource userItemsResource;
    protected UserItemResource userItemResource;
<<<<<<< HEAD
    protected UserResource userResource;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
=======
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
>>>>>>> 5cf1b1de1f284e6917259b310de2eb22728841bc

    protected UserResource userResource;

    protected User user;

//    protected UsersResourse usersResourse;

    public UserService(User user) {
        // super(); // by default
        logoutResource = new LogoutResource();
        itemResource = new ItemResource();
        userResource = new UserResource();

        allItemsResource = new AllItemsResource();
        allItemsIndexesResource = new AllItemsIndexesResource();
        userItemsResource = new UserItemsResource();
        userItemResource = new UserItemResource();
//        usersResourse = new UsersResourse();
        // TODO Is Logged
        this.user = user;
    }

//    public UserService(LoginResource loginResource,
//                       TokenlifetimeResource tokenlifetimeResource,
//                       User user) {
//        super(loginResource, tokenlifetimeResource);
//        this.user = user;
//    }

    public GuestService logoutUser() {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", user.getName())
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = logoutResource
                .httpPostAsEntity(null, null, bodyParameters);
        user.setToken("");
        return new GuestService();
    }

//    public UserService tryToChangeTokenLifeTime(Lifetime time) {
//        RestParameters body = new RestParameters()
//                .addParameter("token", user.getToken())
//                .addParameter("time", time.getTime());
//        SimpleEntity entity = tokenResources.httpPutAsEntity(null, null, body);
//        return this;
//    }

    @Step("Create new Item")
    public UserService addItem(Item item) {
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("item", item.getItem());
        SimpleEntity simpleEntity = itemResource.httpPostAsEntity(pathParameters, null, bodyParameters);
        checkEntity(simpleEntity, item.getItem());
        logger.trace("Successful create Item");
        return new UserService(user);
    }

    @Step("Get current Item")
    public String getItem(Item item) {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        SimpleEntity simpleEntity = itemResource.httpGetAsEntity(pathParameters, urlParameters);
        checkEntity(simpleEntity, item.getItem());
        logger.trace("Successful get Item");
        return simpleEntity.getContent();
    }

    @Step("Delete current Item")
    public UserService deleteItem(Item item) {
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = itemResource.httpDeleteAsEntity(pathParameters, urlParameters, null);
        checkEntity(simpleEntity, item.getItem());
        logger.trace("Successful delete Item");
        return new UserService(user);
    }

    @Step("Update current Item")
    public UserService updateItem(Item item) {
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        RestParameters bodyParameters = new RestParameters()
                .addParameter("item", item.getItem())
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = itemResource.httpPutAsEntity(pathParameters, null, bodyParameters);
        checkEntity(simpleEntity, item.getItem());
        logger.trace("Successful update Item");
        return new UserService(user);
    }

    @Step("Getting all users`s items by his token")
    public String getAllItems() {

        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = allItemsResource.httpGetAsEntity(null, urlParameters);
        checkEntity(simpleEntity, "Not found");
        //System.out.println("getAll " + simpleEntity.getContent());
        return simpleEntity.getContent();
    }

    @Step("Getting all users`s items's indesex by his token")
    public String getAllItemsIndexes() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = allItemsIndexesResource.httpGetAsEntity(null, urlParameters);
        checkEntity(simpleEntity, "Not found");
        System.out.println("getAllIndexes " + simpleEntity.getContent());
        return simpleEntity.getContent();
    }


    @Step("Getting all user`s items by admin token and user name")
    public String getUserItems(User userItem) {
        RestParameters pathParameters = new RestParameters()
                .addParameter("name", userItem.getName());
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = userItemsResource.httpGetAsEntity(pathParameters, urlParameters);

        checkEntity(simpleEntity, "Not found");
        System.out.println("getUserItems " + simpleEntity.getContent());
        return simpleEntity.getContent();
    }

    @Step("Getting  user`s item by admin token, item index and user name")
    public String getUserItem(Item item, User userItem) {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("name", userItem.getName())
                .addParameter("index", item.getIndex());
        SimpleEntity simpleEntity = userItemResource.httpGetAsEntity(pathParameters, urlParameters);
        checkEntity(simpleEntity, "Not found");
        System.out.println("getUserItem " + simpleEntity.getContent());
        return simpleEntity.getContent();
    }

    @Step("Getting username by admin token")
    public String getUserName() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = userResource
                .httpGetAsEntity(null, urlParameters);
        checkEntity(simpleEntity, user.getName());
        return simpleEntity.getContent();
    }

    @Step("Change user's password")
    public UserService changePassword(String newPassword) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("oldpassword", user.getPassword())
                .addParameter("newpassword", newPassword);
        SimpleEntity simpleEntity = userResource
                .httpPutAsEntity(null, null, bodyParameters);
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            throw new RuntimeException();
        }
        return this;
    }

}
