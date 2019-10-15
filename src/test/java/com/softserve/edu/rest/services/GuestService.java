package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.CoolDownTimeResource;
import com.softserve.edu.rest.resources.LoginAdminResource;
import com.softserve.edu.rest.resources.TokenLifeTimeResource;

public class GuestService extends BaseService {

    protected LoginAdminResource loginAdminResource;
    protected TokenLifeTimeResource tokenResources;
    //	protected TokenlifetimeResource tokenlifetimeResource;
    protected CoolDownTimeResource cooldownResource;
    //	private ResetApiResource resetApiResource;
    protected User user;


    public GuestService() {
        loginAdminResource = new LoginAdminResource();
        tokenResources = new TokenLifeTimeResource();
        cooldownResource = new CoolDownTimeResource();
    }

//	public GuestService(LoginResource loginResource, TokenlifetimeResource tokenlifetimeResource) {
//		this.loginResource = loginResource;
//		this.tokenlifetimeResource = tokenlifetimeResource;
//	}

//	public void resetServiceToInitialState() {
//		resetApiResource.httpGetAsEntity(null, null);
//	}

    protected void checkEntity(SimpleEntity simpleEntity, String message) {
        // if (!simpleEntity.getContent().toLowerCase().equals("true"))
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            // TODO Develop Custom Exception
            throw new RuntimeException(message);
        }
    }

//	public boolean isUserLockedAfterTryToLogin(User user) {
//		RestParameters bodyParameters = new RestParameters().addParameter("name", user.getName())
//				.addParameter("password", user.getPassword());
//		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
//		checkEntity(simpleEntity, "Error Login");
//		return simpleEntity.getContent().equals("ERROR, user locked");
//	}

//	public Lifetime getCurrentLifetime() {
//		SimpleEntity simpleEntity = tokenlifetimeResource.httpGetAsEntity(null, null);
//		return new Lifetime(simpleEntity.getContent());
//	}

    public Lifetime getCoolDownTime() {
        SimpleEntity simpleEntity = cooldownResource
                .httpGetAsEntity(null, null);
        checkEntity(simpleEntity, "Something gets wrong");
        return new Lifetime(simpleEntity.getContent());
    }

//    public String getCoolDownTime() {
//        SimpleEntity simpleEntity = cooldownResource
//                .httpGetAsEntity(null, null);
//        return simpleEntity.getContent();
//    }

    // TODO
//    public void UnsuccessfulUserLogin(IUser user)
//    {
//    }
//

    public UserService successfulUserLogin(User user) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", user.getName())
                .addParameter("password", user.getPassword());
        SimpleEntity simpleEntity = loginAdminResource.httpPostAsEntity(null, null, bodyParameters);
        checkEntity(simpleEntity, "Error Login");
        user.setToken(simpleEntity.getContent());
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
        return new AdminService(adminUser);
    }

//	public AdminService ChangeCurrentPassword(User adminUser) {
//		String pass = "1111";
//		RestParameters bodyParameters = new RestParameters().addParameter("token", adminUser.getToken())
//				.addParameter("oldpassword", adminUser.getPassword()).addParameter("newpassword", pass);
//		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
//		checkEntity(simpleEntity, "Error Login");
//		adminUser.setToken(simpleEntity.getContent());
//		return new AdminService(adminUser);
//	}

}
