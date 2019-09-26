package com.softserve.edu.opencart.data;

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
                .addPrice(Currencies.US_DOLLAR, "602.00");
    }

    public static Product getInvalid() {
        return new Product("Bok", "Intel", "100");
    }

    public static Product getIPhone(){
        return new Product("iPhone",
                "iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..",
                "123.20")
                .addPrice(Currencies.US_DOLLAR, "100");
    }

    public static Product getIMac()
    {
        return new Product("iMac",
                "Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..",
                "122.00");
    }

}

