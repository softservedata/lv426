package com.softserve.edu.opencart.data;

public class CurrencyRepository {
    public Currency getNewUACurrency() {
        return new Currency("Ukrainian UAN", "UAN", "₴", 2, 25.1730, "Enable");
    }
}
