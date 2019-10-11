package com.softserve.edu.rest.dto;

public final class RestUrlRepository {
	private static String server = "http://localhost:8080";

	private RestUrlRepository() {
	}

	public static RestUrl getAdminAuthorized() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/login/admins")
				.addPostUrl("/login")
				.addPutUrl("")
				.addDeleteUrl("");
		// .addDeleteUrl("/logout");
	}

	public static RestUrl getUserAuthorized() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/login/users")
				.addPostUrl("/login")
				.addPutUrl("")
				.addDeleteUrl("");
		// .addDeleteUrl("/logout");
	}
	public static RestUrl getCoolDownTime() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/cooldowntime")
				.addPostUrl("")
				.addPutUrl("/cooldowntime")
				.addDeleteUrl("");
		// .addDeleteUrl("/logout");
	}

	public static RestUrl getLogout() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("")
				.addPostUrl("/logout")
				.addPutUrl("")
				.addDeleteUrl("");
	}

	public static RestUrl getTokenLifetime() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/tokenlifetime")
				.addPostUrl("")
				.addPutUrl("/tokenlifetime")
				.addDeleteUrl("");
	}

	public static RestUrl getUserItem() {
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/item/{index}/user/{name}")
				.addPostUrl("")
				.addPutUrl("")
				.addDeleteUrl("");
	}

	public static RestUrl getItem() {
		return new RestUrl().addBaseUrl(server)
				.addGetUrl("/item/{index}")
				.addPostUrl("/item/{index}")
				.addPutUrl("/item/{index}")
				.addDeleteUrl("/item/{index}");
	}

	public static RestUrl getAllAdmins()
	{
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/admins")
				.addPostUrl("")
				.addPutUrl("")
				.addDeleteUrl("");

	}
	public static RestUrl getAllUsers()
	{
		return new RestUrl()
				.addBaseUrl(server)
				.addGetUrl("/users")
				.addPostUrl("")
				.addPutUrl("")
				.addDeleteUrl("");

	}
}
