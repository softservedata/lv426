package com.softserve.edu.opencart.data.checkout;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class CheckOutRepository {
//for delivery details
    public static String NEW_BILLING_ADDRESS_CSSSELECTOR = "#input-payment-";
    public static String NEW_SHIPPING_ADDRESS_CSSSELECTOR = "#input-shipping-";
    public static String FULL_TEST_ACC = "TestName TestLastName, TestAdress, Kakhovka, Khersons'ka Oblast', Ukraine";
    public static String PATH_FOR_BILLING_REGISTRATION_PATH = "div[class=\"form-group required\"]";
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

    public NewShippingAdress validAddress(){
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

    public String getSpecialTextForCheckOut(){

        StringBuilder text = new StringBuilder();
        BufferedReader special = null;
        try {
            special = new BufferedReader(new FileReader("D:\\framework\\lv426\\specialtext.txt"));
            while (special.ready()) {
                text.append(special.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (special != null) {
                special.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
