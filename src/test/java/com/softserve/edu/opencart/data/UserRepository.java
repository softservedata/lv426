package com.softserve.edu.opencart.data;

import org.apache.commons.lang3.RandomStringUtils;

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

    public IUser getMaksymUser(){
        return User.get()
                .setFirstName("Maksym")
                .setLastName("Chapchai")
                .seteMail("chapchaimax@gmail.com")
                .setTelephone("456446465")
                .setAddress1("Lviv")
                .setCity("Lvivshchina")
                .setPostCode("2")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword("ocozliaes")
                .setSubscribe(true)
                .build();
    }

    public IUser getValidUser() {
        return User.get()
                .setFirstName("mary")
                .setLastName("heras")
                .seteMail("mary@gamil.com")
                .setTelephone("765483945")
                .setAddress1("address1")
                .setCity("Lviv")
                .setPostCode("77777")
                .setCountry("Ukraine")
                .setRegionState("Ternopil's'ka Oblast'")
                .setPassword("mary")
                .setSubscribe(true)
                .setFax("12345")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser getValidUserForCheckoutWithRegistration() {
        return User.get()
                .setFirstName("mary")
                .setLastName("heras")
                .seteMail(RandomStringUtils.randomAlphabetic(5)+"@gamil.com")
                .setTelephone("765483945")
                .setAddress1("address1")
                .setCity("Lviv")
                .setPostCode("77777")
                .setCountry("Ukraine")
                .setRegionState("Ternopil's'ka Oblast'")
                .setPassword("mary")
                .setSubscribe(true)
                .setFax("12345")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser getValidUserForCheckoutAsGuest() {
        return User.get()
                .setFirstName(RandomStringUtils.randomAlphabetic(3)+RandomStringUtils.randomNumeric(3))
                .setLastName(RandomStringUtils.randomNumeric(3)+RandomStringUtils.randomAlphabetic(3))
                .seteMail(RandomStringUtils.randomAlphabetic(5)+"@bk.com")
                .setTelephone(RandomStringUtils.randomNumeric(9))
                .setAddress1(RandomStringUtils.randomAlphabetic(7))
                .setCity("Lviv")
                .setPostCode("77777")
                .setCountry("Ukraine")
                .setRegionState("Ternopil's'ka Oblast'")
                .setPassword("mary")
                .setSubscribe(true)
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
                .setLastName("Kookin")
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
                .setFirstName("Taras")
                .setLastName("Kook")
                .seteMail("taras@gmail.com")
                .setTelephone("5555555555")
                .setAddress1("Zalizniaka 12")
                .setCity("Lviv")
                .setPostCode("88888")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword("taras")
                .setSubscribe(true)
                .setFax("12341")
                .setCompany("SoftServe")
                .build();
    }

    public IUser getEditExistingUser() {
        return User.get()
                .setFirstName("Taras")
                .setLastName("Kookin")
                .seteMail("taras@gmail.com")
                .setTelephone("1111111111")
                .setAddress1("Zalizniaka 12")
                .setCity("Lviv")
                .setPostCode("88888")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword("taras")
                .setSubscribe(true)
                .setFax("12341")
                .setCompany("SoftServe")
                .build();
    }

    public IUser getMartaUser() {
        return User.get()
                .setFirstName("Olena")
                .setLastName("Kook")
                .seteMail("ivaqwerty@gmail.com")
                .setTelephone("0987654321")
                .setAddress1("Zalizniaka 12")
                .setCity("Lviv")
                .setPostCode("88888")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword("root")
                .setSubscribe(true)
                .setFax("12341")
                .setCompany("SoftServe")
                .build();
    }

    public IUser getNewUser() {
        return User.get()
                .setFirstName("Danylo")
                .setLastName("Protz")
                .seteMail("danylko@gmail.com")
                .setTelephone("0987654321")
                .setAddress1("Zalizniaka 12")
                .setCity("Lviv")
                .setPostCode("98675")
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .setPassword("danylko")
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
