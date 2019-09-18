package com.softserve.edu.opencart.data;

public class CurrencyRepository {

    private CurrencyRepository() {

    }

    public static Currency getDefault() {
        return getNewUACurrency();

    }
    public static Currency getNewUACurrency() {
        return new Currency("Ukrainian UAN", "UAN", "₴", 2, 25.1730, "Enable");
    }
}
