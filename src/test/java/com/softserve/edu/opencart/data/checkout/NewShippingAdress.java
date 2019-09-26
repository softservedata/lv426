package com.softserve.edu.opencart.data.checkout;

interface IFirstName {
    ILastName setFirstName(String firstName);
}

interface ILastName {
    IEMail setLastName(String lastName);
}

interface IEMail {
    IAddress1 seteMail(String eMail);
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
    INewShippingAdressBuild setRegionState(String regionState);
}


interface INewShippingAdressBuild {
    INewShippingAdress setCompany(String company);

    INewShippingAdress setAddress2(String address2);

    NewShippingAdress build();
}

public class NewShippingAdress implements IFirstName, ILastName,
        IEMail, IAddress1, ICity,
        IPostCode, ICountry, IRegionState,
        INewShippingAdress, INewShippingAdressBuild {

    private String firstNameShipping;
    private String lastNameShipping;
    private String emailShipping;
    private String companyShipping;
    private String address1Shipping;
    private String address2Shipping;
    private String cityShipping;
    private String postcodeShipping;
    private String countryShipping;
    private String stateShipping;

    private NewShippingAdress() {
        companyShipping = "";
        address2Shipping = "";
    }

    public static IFirstName get() {
        return new NewShippingAdress();
    }


    public ILastName setFirstName(String firstNameShipping) {
        this.firstNameShipping = firstNameShipping;
        return this;
    }


    public IEMail setLastName(String lastName) {
        this.lastNameShipping = lastName;
        return this;
    }


    public IAddress1 seteMail(String eMail) {
        this.emailShipping = eMail;
        return this;
    }


    public ICity setAddress1(String address1) {
        this.cityShipping = address1;
        return this;
    }


    public IPostCode setCity(String city) {
        this.address1Shipping = city;
        return this;
    }


    public ICountry setPostCode(String postCode) {
        this.postcodeShipping = postCode;
        return this;
    }


    public IRegionState setCountry(String country) {
        this.countryShipping = country;
        return this;
    }


    public INewShippingAdressBuild setRegionState(String regionState) {
        this.stateShipping = regionState;
        return this;
    }
    public INewShippingAdress setCompany(String company) {
        this.companyShipping = company;
        return this;
    }


    public INewShippingAdress setAddress2(String address2) {
        this.address2Shipping = address2;
        return this;
    }


    public NewShippingAdress build() {
        return this;
    }


    public String getFirstNameShipping() {
        return firstNameShipping;
    }


    public String getLastNameShipping() {
        return lastNameShipping;
    }


    public String getEmailShipping() {
        return emailShipping;
    }


    public String getCompanyShipping() {
        return companyShipping;
    }


    public String getAddress1Shipping() {
        return address1Shipping;
    }


    public String getAddress2Shipping() {
        return address2Shipping;
    }


    public String getCityShipping() {
        return cityShipping;
    }


    public String getPostcodeShipping() {
        return postcodeShipping;
    }


    public String getCountryShipping() {
        return countryShipping;
    }


    public String getStateShipping() {
        return stateShipping;
    }


}
