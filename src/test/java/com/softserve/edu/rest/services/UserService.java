package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.Items;
import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;


import com.softserve.edu.rest.resources.*;

import com.softserve.edu.rest.resources.ItemResource;
import com.softserve.edu.rest.resources.LogoutResource;
import com.softserve.edu.rest.resources.UserResource;


public class UserService extends GuestService {

    protected LogoutResource logoutResource;
    protected ItemResource itemResource;

    protected AllItemsResource allItemsResource;
    protected AllItemsIndexesResource allItemsIndexesResource;
    protected UserItemsResource userItemsResource;
    protected UserItemResource userItemResource;
    //    protected UserResource userResource;

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


    public UserService addItem(Item item) {
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("item", item.getItem());
        SimpleEntity simpleEntity = itemResource.httpPostAsEntity(pathParameters, null, bodyParameters);
        checkEntity(simpleEntity, item.getItem());
        System.out.println("add "+ simpleEntity.getContent());
        return new UserService(user);
    }

    public String getItem(Item item) {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        SimpleEntity simpleEntity = itemResource.httpGetAsEntity(pathParameters, urlParameters);
        //checkEntity(simpleEntity, item.getItem());
        return simpleEntity.getContent();
    }

    public UserService deleteItem(Item item) {
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = itemResource.httpDeleteAsEntity(pathParameters, urlParameters, null);
        checkEntity(simpleEntity, item.getItem());
        return new UserService(user);
    }

    public UserService updateItem(Item item) {
        RestParameters pathParameters = new RestParameters()
                .addParameter("index", item.getIndex());
        RestParameters bodyParameters = new RestParameters()
                .addParameter("item", item.getItem())
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = itemResource.httpPutAsEntity(pathParameters, null, bodyParameters);
        checkEntity(simpleEntity, item.getItem());
        return new UserService(user);
    }

    public String getAllItems() {

        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = allItemsResource.httpGetAsEntity(null, urlParameters);
        checkEntity(simpleEntity, "Not found");
        System.out.println("getAll " + simpleEntity.getContent());
        return simpleEntity.getContent();
    }

    public String getAllItemsIndexes() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = allItemsIndexesResource.httpGetAsEntity(null, urlParameters);
        checkEntity(simpleEntity, "Not found");
        System.out.println("getAllIndexes " + simpleEntity.getContent());
        return simpleEntity.getContent();
    }


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


    public String getUserName() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = userResource
                .httpGetAsEntity(null, urlParameters);
        checkEntity(simpleEntity, user.getName());
        return simpleEntity.getContent();
    }


    public UserService changePassword(String newPassword) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("oldpassword", user.getPassword())
                .addParameter("newpassword", newPassword);
        SimpleEntity simpleEntity = userResource
                .httpPutAsEntity(null, null, bodyParameters);
        //checkEntity(simpleEntity, user.getPassword());
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            throw new RuntimeException();
        }
        return this;
    }

}
