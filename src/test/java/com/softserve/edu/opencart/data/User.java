package com.softserve.edu.opencart.data;

interface IFirstName {
    ILastName setFirstName(String firstName);
}

interface ILastName {
    IEMail setLastName(String lastName);
}

interface IEMail {
    ITelephone seteMail(String eMail);
}

interface ITelephone {
    IAddress1 setTelephone(String telephone);
}

interface IAddress1 {
    ICity setAddress1(String address1);
}

interface ICity {
    IPostCode setCity(String city);
}

interface IPostCode {
    ICountry setPostCode(String postCode);
}

interface ICountry {
    IRegionState setCountry(String country);
}

interface IRegionState {
    IPassword setRegionState(String regionState);
}

interface IPassword {
    ISubscribe setPassword(String password);
}

interface ISubscribe {
    IUserBuild setSubscribe(boolean subscribe);
}

interface IUserBuild {
    IUserBuild setFax(String fax);
    IUserBuild setCompany(String company);
    IUserBuild setAddress2(String address2);
    // 5. Add Builder
    //User build();
    // 6. Add Dependency Inversion
    IUser build();
}

public class User implements IFirstName, ILastName,
        IEMail, ITelephone, IAddress1, ICity,
        IPostCode, ICountry, IRegionState,
        IPassword, ISubscribe, IUserBuild, IUser {

    private String firstName;
    private String lastName;
    private String eMail;
    private String telephone;
    private String fax; // optional
    private String company; // optional
    private String address1;
    private String address2; // optional
    private String city;
    private String postCode;
    private String country;
    private String regionState;
    private String password;
    private boolean subscribe;


    // 5. Add Builder
    private User() {
        fax = "";
        company = "";
        address2 = "";
    }

    // 4. Add Static Factory
    //public static User get() {
    // 5. Add Builder
    public static IFirstName get() {
        return new User();
    }

    // setters

    // 1. Classic Constructor
    // 2. Use Setters
    //public void setFirstName(String firstName) {
    // 3. Add Fluent Interface
    // public User setFirstName(String firstName) {
    // 5. Add Builder
    public ILastName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public IEMail setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ITelephone seteMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public IAddress1 setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public IUserBuild setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public IUserBuild setCompany(String company) {
        this.company = company;
        return this;
    }

    public ICity setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public IUserBuild setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public IPostCode setCity(String city) {
        this.city = city;
        return this;
    }

    public ICountry setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public IRegionState setCountry(String country) {
        this.country = country;
        return this;
    }

    public IPassword setRegionState(String regionState) {
        this.regionState = regionState;
        return this;
    }

    public ISubscribe setPassword(String password) {
        this.password = password;
        return this;
    }

    public IUserBuild setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
        return this;
    }

    // 5. Add Builder
    //public User build() {
    // 6. Add Dependency Inversion
    public IUser build() {
        return this;
    }

    // getters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFax() {
        return fax;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getRegionState() {
        return regionState;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

}
