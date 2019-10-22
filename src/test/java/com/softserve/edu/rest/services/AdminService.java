package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminService extends UserService {

    //    private AdminsResource adminsResource;
    // private LoggedAdminsResource loggedAdminsResource;
//    // Locked
//    private LockedAdminsResource lockedAdminsResource;
    private LoginAdminResource adminLoginResource;
    private LoginUserResource userLoginResource;
    private UserResource userResource;
    private UsersResource usersResource;
    private AdminResource adminResource;
    private LockUserResource lockUserResource;
    private LockUsersResource lockUsersResource;
    private LockedAdminsResource lockAdminsResource;
//    private LockedUsersResource lockedUsersResource;
//    private UnlockAllUsersResource unlockAllUsersResource;
//    private LockUnlockUserResource lockUnlockUserResource;
//    //protected CooldownResource cooldownResource;
private final Logger logger = LoggerFactory.getLogger(AdminService.class);


    public AdminService(User user) {
        super(user);
        adminResource = new AdminResource();
        userResource = new UserResource();
        usersResource = new UsersResource();
        adminLoginResource = new LoginAdminResource();
        userLoginResource = new LoginUserResource();
        lockUserResource = new LockUserResource();
        lockUsersResource = new LockUsersResource();
        lockAdminsResource = new LockedAdminsResource();

    }

    //    public AdminService(LoginResource loginResource,
//                        TokenlifetimeResource tokenlifetimeResource,
//                        User user) {
//        super(loginResource, tokenlifetimeResource, user);
//    }
//
    public AdminService updateTokenLifetime(Lifetime lifetime) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("time", lifetime.getTime());
        SimpleEntity simpleEntity = tokenResources
                .httpPutAsEntity(null, null, bodyParameters);
        logger.info("Token has been updated");
        return this;
    }

    public AdminService createUser(User newUser) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("name", newUser.getName())
                .addParameter("password", newUser.getPassword())
                .addParameter("rights", newUser.isAdminRights() + "");

        SimpleEntity simpleEntity = userResource.
                httpPostAsEntity(null, null, bodyParameters);
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            throw new RuntimeException();
        }
        logger.info("User has been created");
        return this;
    }

    public AdminService changeCoolDown(Lifetime lifetime) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("time", lifetime.getTime());
        SimpleEntity simpleEntity = cooldownResource
                .httpPutAsEntity(null, null, bodyParameters);
        checkCoolDownTimeEntity(simpleEntity, "The cool down time has not been changed");
        logger.trace("Trying to change the cool down time ");
        return this;
    }

    public AdminService lockUser(User userForLock){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("name", userForLock.getName());
        SimpleEntity simpleEntity = lockUserResource
                .httpPostAsEntity(pathParameters,null, bodyParameters);
        checkLockEntity(simpleEntity, "User was not locked");
        return this;
    }

    public AdminService unlockUser(User user){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("", user.getName());
        SimpleEntity simpleEntity = lockUserResource
                .httpPutAsEntity(pathParameters,null,bodyParameters);
        checkLockEntity(simpleEntity, "User was not unlocked");
        return this;
    }

    public String getAllLockedUsers(){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = lockUsersResource
                .httpGetAsEntity(null, bodyParameters);
        return simpleEntity.getContent();
    }

    public AdminService unlockAllUsers(){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = lockUsersResource
                .httpPutAsEntity(null,null, bodyParameters);
        return this;
    }


    public String getAllUsers() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = usersResource.httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent();
    }

    public String getAllAdmins() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = adminResource.httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent();
    }
//@Step("Delete user")
    public AdminService removeUser(User removedUser) {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("name", removedUser.getName());
        SimpleEntity simpleEntity = userResource.httpDeleteAsEntity(null, urlParameters, null);
//        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
//                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
//            throw new RuntimeException();
//        }
        return this;
    }
    public String getAllLockedAdmins() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = lockAdminsResource.httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent();
    }

//
    public String getAllLoggedAdmins() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = loginAdminResource.httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent();
    }

    public String getAllLoggedUsers() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = loginUserResource.httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent();
    }

//    private String getLockedAdmins() {
//        RestParameters urlParameters = new RestParameters()
//                .addParameter("token", user.getToken());
//        SimpleEntity simpleEntity = lockedAdminsResource.httpGetAsEntity(null, urlParameters);
//        return simpleEntity.getContent();
//    }
//
    public boolean isAdminLogged(User user) {

        if (getAllLoggedAdmins().contains(user.getName())) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isUserLogged(User user) {

        if (getAllLoggedUsers().contains(user.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAdminLocked(User user) {

        if (getAllLockedAdmins().contains(user.getName())) {
            return true;
        } else {
            return false;
        }
    }



//
//    public void unlockAllUsers() {
//        RestParameters bodyParameters = new RestParameters()
//                .addParameter("token", user.getToken());
//        unlockAllUsersResource.httpPutAsEntity(null, null, bodyParameters);
//    }
//
//    public boolean isUserPresentInLockedUsers(User user){
//        return getLockedUsers().contains(user.getName());
//    }
//
//    public boolean isAdminPresentInLockedAdmins(User user){
//        return getLockedAdmins().contains(user.getName());
//    }
//
    public boolean isUserCreated(User user) {
        if (getAllUsers().contains(user.getName())) {
            return true;
        } else {
            return false;
        }

    }
    public boolean isUserRemoved(User user) {
        if (!getAllUsers().contains(user.getName())) {
            return true;
        } else {
            return false;
        }
    }

//
//
//    public boolean isUserAdmin(User user) {
//        if (getAllAdmins().contains(user.getName())) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
