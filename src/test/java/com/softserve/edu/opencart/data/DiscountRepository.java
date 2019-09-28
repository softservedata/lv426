package com.softserve.edu.opencart.data;

import java.time.LocalDate;

public class DiscountRepository {
    private DiscountRepository() {

    }
    public static Discount getDefault() {
        return getNewDiscount();

    }
    private static Discount getNewDiscount() {
        return Discount.builder()
                .quantity(10)
                .priority(1)
                .price(15)
                .startDate(LocalDate.now().toString())
                .endData( LocalDate.now().plusDays(1).toString())
                .build();
    }


}
