package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.CoolDownTimeResource;
import com.softserve.edu.rest.resources.LoginAdminResource;
import com.softserve.edu.rest.resources.LoginUserResource;
import com.softserve.edu.rest.resources.TokenLifeTimeResource;
import com.softserve.edu.rest.tools.CoolDownTimeException;
import com.softserve.edu.rest.tools.LockPersonException;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuestService extends BaseService {
    protected String userNotFoundMessage = "ERROR, user not found";
    protected LoginAdminResource loginAdminResource;
    protected LoginUserResource loginUserResource;
    protected TokenLifeTimeResource tokenResources;
    protected CoolDownTimeResource cooldownResource;
    protected User user;
    private final Logger loggerGuest = LoggerFactory.getLogger(GuestService.class);

    public GuestService() {
        loginAdminResource = new LoginAdminResource();
        loginUserResource = new LoginUserResource();
        tokenResources = new TokenLifeTimeResource();
        cooldownResource = new CoolDownTimeResource();
    }

    protected void checkEntity(SimpleEntity simpleEntity, String message) {
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            loggerGuest.error("Throw RuntimeException");
            throw new RuntimeException(message);
        }
    }
    @Step("Check if cooldowntime request is success")
    protected void checkCoolDownTimeEntity(SimpleEntity simpleEntity, String message) {
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            loggerGuest.error("Throw CoolDownTimeException");
            throw new CoolDownTimeException(message);
        }
    }
    @Step("Check if lock request is success")
    protected void checkLockEntity(SimpleEntity simpleEntity, String message) {
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            loggerGuest.error("Throw LockPersonException");
            throw new LockPersonException(message);
        }
    }

    @Step("Get cooldwontime")
    public Lifetime getCoolDownTime() {
        SimpleEntity simpleEntity = cooldownResource
                .httpGetAsEntity(null, null);
        checkCoolDownTimeEntity(simpleEntity, "Something gets wrong");
        loggerGuest.info("Get cool down time");
        return new Lifetime(simpleEntity.getContent());
    }


    public UserService successfulUserLogin(User user) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", user.getName())
                .addParameter("password", user.getPassword());
        SimpleEntity simpleEntity = loginUserResource.httpPostAsEntity(null, null, bodyParameters);
        checkEntity(simpleEntity, "Error Login");
        user.setToken(simpleEntity.getContent());
        checkEntity(simpleEntity, "The user has not been logged");
        return new UserService(user);
    }

    public Lifetime getTokenLifetime() {
        RestParameters bodyParameters = new RestParameters();
        SimpleEntity simpleEntity = tokenResources.httpGetAsEntity(null, null);
        checkEntity(simpleEntity, "Something was wrong");
        return new Lifetime(simpleEntity.getContent());
    }

    public AdminService successfulAdminLogin(User adminUser) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", adminUser.getName())
                .addParameter("password", adminUser.getPassword());
        SimpleEntity simpleEntity = loginAdminResource.httpPostAsEntity(null, null, bodyParameters);
        checkEntity(simpleEntity, "Error Login");
        adminUser.setToken(simpleEntity.getContent());
        loggerGuest.trace("Successful admin sign in");
        return new AdminService(adminUser);
    }

    public GuestService unsuccessfulUserLogin(User user) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", user.getName())
                .addParameter("password", user.getPassword());
        SimpleEntity simpleEntity = loginUserResource.httpPostAsEntity(null, null, bodyParameters);
        if (simpleEntity.getContent() != userNotFoundMessage)
            return new UserService(user);
        loggerGuest.trace("Successful user sign in");
        return new GuestService();
    }

    public GuestService unsuccessfulAdminLogin(User adminUser) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", adminUser.getName())
                .addParameter("password", adminUser.getPassword());
        SimpleEntity simpleEntity = loginAdminResource.httpPostAsEntity(null, null, bodyParameters);
        if (!simpleEntity.getContent().contains(userNotFoundMessage))
            return new UserService(adminUser);
        return new GuestService();
    }



}
