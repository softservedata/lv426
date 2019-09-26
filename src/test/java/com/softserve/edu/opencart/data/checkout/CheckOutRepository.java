package com.softserve.edu.opencart.data.checkout;

import org.apache.commons.lang3.RandomStringUtils;

public final class CheckOutRepository {

    private static volatile CheckOutRepository instance = null;

    CheckOutRepository(){}

    public static CheckOutRepository get() {
        if (instance == null) {
            synchronized (CheckOutRepository.class) {
                if (instance == null) {
                    instance = new CheckOutRepository();
                }
            }
        }
        return instance;
    }
//??????????????
    public NewShippingAdress validAdress(){
        return NewShippingAdress.get()
                .setFirstName(RandomStringUtils.randomAlphabetic(5))
                .setLastName(RandomStringUtils.randomAlphabetic(5))
                .seteMail(RandomStringUtils.randomAlphabetic(5)+"@gamil.com")
                .setAddress1(RandomStringUtils.randomAlphabetic(5))
                .setCity(RandomStringUtils.randomAlphabetic(5))
                .setPostCode(RandomStringUtils.randomNumeric(3))
                .setCountry("Ukraine")
                .setRegionState("L'vivs'ka Oblast'")
                .build();
    }
}
