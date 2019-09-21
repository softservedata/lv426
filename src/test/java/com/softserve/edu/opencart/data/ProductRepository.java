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

}