package com.softserve.edu.opencart.data;

import java.time.LocalDate;

public class DiscountRepository {
    private DiscountRepository() {

    }

    public static Discount getDefault() {
        return getNewDiscount();

    }
    public static Discount getNewDiscount() {
        return new Discount(10, 1, 15, LocalDate.now().toString(), LocalDate.now().plusDays(1).toString());
    }
}
