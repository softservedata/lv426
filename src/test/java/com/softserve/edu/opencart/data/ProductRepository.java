package com.softserve.edu.opencart.data;

import org.apache.commons.lang3.RandomStringUtils;

import static com.softserve.edu.opencart.data.Currencies.TEST;

public final class ProductRepository {

    private ProductRepository() {
    }

    public static Product getDefault() {
        return getMacBook();
    }

    public static Product getMacBook() {
        return new Product("MacBook", "Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..", "500")
                .addPrice(Currencies.EURO, "472.33")
                .addPrice(Currencies.POUND_STERLING, "368.73")
                .addPrice(Currencies.US_DOLLAR, "602.00")
                .addPrice(TEST, RandomStringUtils.randomAlphabetic(3)+"$#@!%^&*()?><:;.,/[]/*-+");
    }

    public static Product getIphone() {
        return new Product("iPhone", "iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..", "100.00");
    }

    public static Product getNikon() {
        return new Product("Nikon D300", "Engineered with pro-level features and performance, the 12.3-effective-megapixel D300 combine..", "122.00")
                .addPrice(TEST, "-15656484646");
    }

    public static Product getInvalid() {
        return new Product("Bok", "Intel", "100");
    }

    public static Product getIPhone(){
        return new Product("iPhone",
                "iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..",
                "123.20")
                .addPrice(Currencies.US_DOLLAR, "101.00")
                .addPrice(TEST, "33333333333333333333333333333333333333333333333333333333333333333333" +
                        "3333333333333333333333333333333333333333333333333333333333333333");
    }

    public static Product getIMac()
    {
        return new Product("iMac",
                "Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..",
                "122.00");
    }

}

