package com.softserve.edu.opencart.data.checkout;

import org.apache.commons.lang3.RandomStringUtils;

public final class CheckOutRepository {
//for delivery details
    public static String NEW_BILLING_ADDRESS_CSSSELECTOR = "#input-payment-";
    public static String NEW_SHIPPING_ADDRESS_CSSSELECTOR = "#input-shipping-";
    public static String FULL_TEST_ACC = "TestName TestLastName, TestAdress, Kakhovka, Khersons'ka Oblast', Ukraine";

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
