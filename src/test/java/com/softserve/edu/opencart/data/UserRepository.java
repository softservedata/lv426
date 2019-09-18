package com.softserve.edu.opencart.data;

public final class UserRepository {

	private UserRepository() {
	}
	
	public static User getDefault() {
		return getValidUser();
	}

	public static User getValidUser() {
		return new User("hahaha@gmail.com", "qwerty");
	} 
	
}
