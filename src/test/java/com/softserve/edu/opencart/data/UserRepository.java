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
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
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

    public IUser getWrongFirstNameUser() {
        return User.get()
                .setFirstName("")
                .setLastName("Klyn")
                .seteMail("ivan@gmail.com")
                .setTelephone("123456789")
                .setAddress1("Kolt 10")
                .setCity("Lviv")
                .setPostCode("11111")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword("qwerty")
                .setSubscribe(true)
                .build();
    }

    public IUser getExistingUser() {
        return User.get()
                .setFirstName("Olena")
                .setLastName("Kook")
                .seteMail("hahaha@gmail.com")
                .setTelephone("0987654321")
                .setAddress1("Zalizniaka 12")
                .setCity("Lviv")
                .setPostCode("88888")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword(System.getenv().get("MY_PASSWORD"))
                .setSubscribe(true)
                .setFax("12341")
                .setCompany("SoftServe")
                .build();
    }

    public IUser getWrongPasswordUser() {
        return User.get()
                .setFirstName("Danylo")
                .setLastName("Protz")
                .seteMail("danylo@gmail.com")
                .setTelephone("0987654321")
                .setAddress1("Zalizniaka 12")
                .setCity("Lviv")
                .setPostCode("98675")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword("")
                .setSubscribe(false)
                .setFax("12341")
                .build();
    }

//    public IUser getShopValidUser(){
//        return User.get()
//                .setFirstName()
//    }
    public IUser getBeataUser() {
        return User.get()
                .setFirstName("Beata")
                .setLastName("Kovtan")
                .seteMail("beatka994@mail.ru")
                .setTelephone("7telephone")
                .setAddress1("7address1")
                .setCity("7city")
                .setPostCode("7Code")
                .setCountry("7country")
                .setRegionState("")
                .setPassword("qwerty12")
                .setSubscribe(true)
                .setFax("7fax")
                .setCompany("7company")
                .setAddress2("7address2")
                .build();
    }

}
