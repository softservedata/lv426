package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.LogoutResource;

import java.lang.reflect.InvocationTargetException;

public class UserService extends GuestService {

    protected LogoutResource logoutResource;

//    protected UserResource userResource;
    protected User user;

//    protected UsersResourse usersResourse;

    public UserService(User user) {

        // super(); // by default
        logoutResource = new LogoutResource();
//        userResource = new UserResource();
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

    public UserService tryToChangeTokenLifeTime(Lifetime time) {
        RestParameters body = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("time", time.getTime());
        SimpleEntity entity = tokenResources.httpPutAsEntity(null, null, body);
        return this;
    }



//    public String getUserName() {
//        RestParameters urlParameters = new RestParameters()
//                .addParameter("token", user.getToken());
//        SimpleEntity simpleEntity = userResource
//                .httpGetAsEntity(null, urlParameters);
//        checkEntity(simpleEntity, user.getName());
//        return simpleEntity.getContent();
//    }

//    public String changePassword(String newPassword) {
//        RestParameters bodyParameters = new RestParameters()
//                .addParameter("token", user.getToken())
//                .addParameter("oldpassword", user.getPassword())
//                .addParameter("newpassword", newPassword);
//        SimpleEntity simpleEntity = userResource
//                .httpPutAsEntity(null, null, bodyParameters);
//        //checkEntity(simpleEntity, user.getPassword());
//        return simpleEntity.getContent();
//    }
//
//    public String changeCooldown(String newTime){
//        RestParameters bodyParameters = new RestParameters()
//                .addParameter("token", user.getToken())
//                .addParameter("time", newTime);
//        SimpleEntity simpleEntity = cooldownResource
//                .httpPutAsEntity(null, null, bodyParameters);
//        //checkEntity(simpleEntity, user.getPassword());
//        return simpleEntity.getContent();
//    }
}
