package com.softserve.edu.opencart.data.addressbook;

import com.softserve.edu.opencart.data.IAddress;

public class AddressRepository {

    private static volatile AddressRepository instance = null;

    private AddressRepository() {

    }

    public static AddressRepository get() {
        if (instance == null) {
            synchronized (AddressRepository.class) {
                if (instance == null) {
                    instance = new AddressRepository();
                }
            }
        }
        return instance;
    }

    public IAddress getValidAddress() {
        return Address.get()
                .setFirstname("andrii")
                .setLastname("Iatskiv")
                .setAddress1("Lychakivska street")
                .setCity("Kyiv")
                .setCountry("Togo")
                .setZone("Kara")
                .setDefaultAddress(false)
                .setPostcode("12345")
                .build();
    }

    public IAddress getNumberAddress() {
        return Address.get()
                .setFirstname("12345")
                .setLastname("12345")
                .setAddress1("12345")
                .setCity("12345")
                .setCountry("Togo")
                .setZone("Kara")
                .setDefaultAddress(false)
                .setPostcode("12345")
                .build();
    }

    public IAddress getSpecSymbolsAddress() {
        return Address.get()
                .setFirstname("!@#$%")
                .setLastname("!@#$%")
                .setAddress1("!@#$%")
                .setCity("!@#$%")
                .setCountry("Togo")
                .setZone("Kara")
                .setDefaultAddress(false)
                .setPostcode("!@#$%")
                .build();
    }

    public IAddress getEmptyAddress() {
        return Address.get()
                .setFirstname("")
                .setLastname("")
                .setAddress1("")
                .setCity("")
                .setCountry("")
                .setZone("")
                .setDefaultAddress(false)
                .setPostcode("")
                .build();
    }

    public IAddress getMinSymbolsAddress() {
        return Address.get()
                .setFirstname("a")
                .setLastname("a")
                .setAddress1("aaa")
                .setCity("aa")
                .setCountry("Togo")
                .setZone("Kara")
                .setDefaultAddress(false)
                .setPostcode("aa")
                .build();
    }

    public IAddress getMaxSymbolsAddress() {
        return Address.get()
                .setFirstname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setLastname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setAddress1(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setCity(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setCountry("Togo")
                .setZone("Kara")
                .setDefaultAddress(false)
                .setPostcode("1234567891")
                .build();
    }

    public IAddress getUnderMaxSymbolsAddress() {
        return Address.get()
                .setFirstname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setLastname("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setAddress1(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setCity(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .setCountry("Togo")
                .setZone("Kara")
                .setDefaultAddress(false)
                .setPostcode("12345678911")
                .build();
    }
}
