package com.softserve.edu.rest.data;

import org.apache.commons.lang3.RandomStringUtils;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getNotExistingUserWithToken(){
        return User.builder()
                .name(RandomStringUtils.randomAlphabetic(5))
                .password(RandomStringUtils.randomAlphabetic(5))
                .token("XO9V2IPPMH8NC36XX0I37AKP2SHDCLSE")
                .adminRights(false)
                .build();
    }

    public static User getMaxUser(){
        return User.builder()
                .name("testUser")
                .password("qwerty")
                .adminRights(false)
                .build();
    }

    public static User getMaxUserWithMistake(){
        return User.builder()
                .name("testUser")
                .password("qwer2ty")
                .adminRights(false)
                .build();
    }

    public static User getAdmin() {
        return User.builder()
                .name("admin")
                .password("qwerty")
                .adminRights(true)
                .build();
    }

    public static User notExistingUser() {
        return User.builder()
                .name("Anna")
                .password("ksjddlfkjddqwerty")
                .adminRights(true)
                .build();
    }

    public static User notExistingUser2() {
        return User.builder()
                .name("Ivan1")
                .password("ksjddlfkjddqwerty")
                .adminRights(false)
                .build();
    }

    public static User existingUser(){
        return User.builder()
                .name("Vasya")
                .password("qwerty")
                .adminRights(false)
                .build();
    }

    public static User forItemUser(){
        return User.builder()
                .name("khalaktc")
                .password("qwerty")
                .adminRights(false)
                .build();
    }

    public static User FakeAdmin() {
        return User.builder()
                .name("FakeAdmin")
                .password("1234")
                .token("DT2ES1AHRY5Y09MMC6A5XSQ500W74E3E")
                .build();
    }

}