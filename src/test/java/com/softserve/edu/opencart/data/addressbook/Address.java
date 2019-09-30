package com.softserve.edu.opencart.data.addressbook;

import com.softserve.edu.opencart.data.IAddress;

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    IAddress1 setLastname(String lastname);
}

interface IAddress1 {
    ICity setAddress1(String address);
}

interface ICity {
    ICountry setCity(String city);
}

interface ICountry {
    IZone setCountry(String country);
}

interface IZone {
    IDefaultAddress setZone(String zone);
}

interface IDefaultAddress {
    IAddressBuild setDefaultAddress(boolean defaultAddress);
}

interface IAddressBuild {
    IAddressBuild setPostcode(String fax);

    IAddressBuild setCompany(String company);

    IAddressBuild setAddress2(String address2);


    // 5. Add Builder
    //User build();
    // 6. Add Dependency Inversion
    IAddress build();
}

public class Address
        implements IFirstname, ILastname, IAddress1, ICity, ICountry,
        IZone, IDefaultAddress, IAddressBuild, IAddress {

    private String firsname;
    private String lastname;
    private String address1;
    private String address2;
    private String company;
    private String city;
    private String postcode;
    private String country;
    private String zone;
    private boolean defaultAddress;

    private Address() {
        company = "";
        address2 = "";
        postcode = "";
    }

    public static IFirstname get() {
        return new Address();
    }

    public ILastname setFirstname(String firsname) {
        this.firsname = firsname;
        return this;
    }

    public IAddress1 setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public IAddressBuild setCompany(String country) {
        this.company = company;
        return this;
    }

    public ICity setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public IAddressBuild setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public ICountry setCity(String city) {
        this.city = city;
        return this;
    }

    public IAddressBuild setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public IZone setCountry(String country) {
        this.country = country;
        return this;
    }

    public IDefaultAddress setZone(String zone) {
        this.zone = zone;
        return this;
    }

    public IAddressBuild setDefaultAddress(boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
        return this;
    }

    public IAddress build() {
        return this;
    }

    public String getFirstname() {
        return firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getZone() {
        return zone;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }
}
