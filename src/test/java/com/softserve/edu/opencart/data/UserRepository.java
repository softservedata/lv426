package com.softserve.edu.opencart.data;

public final class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getDefault() {
        return getValidUser();
    }

    public IUser getValidUser() {
        return User.get()
                .setFirstName("7firstName")
                .setLastName("7lastName")
                .seteMail("7eMail")
                .setTelephone("7telephone")
                .setAddress1("7address1")
                .setCity("7city")
                .setPostCode("7Code")
                .setCountry("7country")
                .setRegionState("7State")
                .setPassword("7password")
                .setSubscribe(true)
                .setFax("7fax")
                .setCompany("7company")
                .setAddress2("7address2")
                .build();
    }

    public IUser getHahahaUser() {
        return User.get()
                .setFirstName("7firstName")
                .setLastName("7lastName")
                .seteMail("hahaha@gmail.com")
                .setTelephone("7telephone")
                .setAddress1("7address1")
                .setCity("7city")
                .setPostCode("7Code")
                .setCountry("7country")
                .setRegionState("7State")
                .setPassword(System.getenv().get("MY_PASSWORD"))
                .setSubscribe(true)
                .setFax("7fax")
                .setCompany("7company")
                .setAddress2("7address2")
                .build();
    }
    public IUser getChangePasswordUser() {
        return User.get()
                .setFirstName("Test1")
                .setLastName("Test1")
                .seteMail(System.getenv().get("EMAIL_ADDRESS"))
                .setTelephone("123456")
                .setAddress1("111")
                .setCity("111")
                .setPostCode("111")
                .setCountry("Ukraine")
                .setRegionState("Kyiv")
                .setPassword(System.getenv().get("OPENCART_PASSWORD"))
                .setSubscribe(true)
                .build();
    }
}
