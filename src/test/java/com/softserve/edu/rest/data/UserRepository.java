package com.softserve.edu.rest.data;
public final class  UserRepository {

    private UserRepository() {
    }

    public static User getAdmin() {
        return User.builder()
                .name("admin")
                .password("qwerty")
                .adminRights(true)
                .build();
    }

    public static User notExistingUser(){
        return User.builder()
                .name("Anna")
                .password("ksjddlfkjddqwerty")
                .adminRights(true)
                .build();
    }

    public static User FakeAdmin()
    {
        return User.builder()
                .name("FakeAdmin")
                .password("1234")
                .token("DT2ES1AHRY5Y09MMC6A5XSQ500W74E3E")
                .build();
    }


}