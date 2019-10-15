package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.*;

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
//    private LockedUsersResource lockedUsersResource;
//    private UnlockAllUsersResource unlockAllUsersResource;
//    private LockUnlockUserResource lockUnlockUserResource;
//    //protected CooldownResource cooldownResource;
//

    public AdminService(User user) {
        super(user);
        adminResource = new AdminResource();
        userResource = new UserResource();
        usersResource = new UsersResource();
        adminLoginResource = new LoginAdminResource();
        userLoginResource = new LoginUserResource();
        lockUserResource = new LockUserResource();
        lockUsersResource = new LockUsersResource();
//        loggedUsersResource = new LoggedUsersResource();
//        lockedAdminsResource = new LockedAdminsResource();
//        lockedUsersResource = new LockedUsersResource();
//        unlockAllUsersResource = new UnlockAllUsersResource();
//        lockUnlockUserResource = new LockUnlockUserResource();
//        cooldownResource = new CooldownResource();
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
        return this;
    }

    //
//    //    public String getAdminName() {
////        RestParameters urlParameters = new RestParameters()
////                .addParameter("token",user.getToken());
////        SimpleEntity simpleEntity = userResource
////                .httpGetAsEntity(null, urlParameters);
////        checkEntity(simpleEntity, user.getName());
////        return simpleEntity.getContent();
////    }
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
        return this;
    }

    public AdminService changeCoolDown(Lifetime lifetime) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken())
                .addParameter("time", lifetime.getTime());
        SimpleEntity simpleEntity = cooldownResource
                .httpPutAsEntity(null, null, bodyParameters);
        checkEntity(simpleEntity, user.getPassword());
        return this;
    }

    public AdminService lockUser(User user){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("", user.getName());
        SimpleEntity simpleEntity = lockUserResource
                .httpPostAsEntity(pathParameters,null,bodyParameters);
        return this;
    }

    public AdminService unlockUser(User user){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("", user.getName());
        SimpleEntity simpleEntity = lockUserResource
                .httpPutAsEntity(pathParameters,null,bodyParameters);
        return this;
    }

    public AdminService getAllLockedUsers(){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = lockUsersResource
                .httpGetAsEntity(null, bodyParameters);
        return this;
    }

    public AdminService unlockAllUsers(){
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = lockUsersResource
                .httpPutAsEntity(null,null, bodyParameters);
        return this;
    }

    public GuestService gotoGuestFunctional(){
        return this;
    }
//
//        SimpleEntity simpleEntity = userResource.
//                httpPutAsEntity(null, bodyParameters, null);
//
//        checkEntity(simpleEntity, "true");
//        if (simpleEntity.getContent().equals("true")) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }
//
//
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
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            throw new RuntimeException();
        }
        return this;
    }
//

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
