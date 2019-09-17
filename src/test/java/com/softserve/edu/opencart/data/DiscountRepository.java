package com.softserve.edu.opencart.data;

import java.time.LocalDate;

public class DiscountRepository {
    public Discount getNewDiscount() {
        return new Discount(10, 1, 15, LocalDate.now().toString(), LocalDate.now().plusDays(1).toString());
    }
}
