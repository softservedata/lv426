package com.softserve.edu.opencart.data;

import java.time.LocalDate;

public class SpecialRepository {

    private SpecialRepository() {

    }

    public static Special getDefault() {
        return getNewSpecialPrice();

    }
    private static Special getNewSpecialPrice() {
        return Special.builder()
        .priority(1)
                .price(50.5)
                .startDate(LocalDate.now().toString())
                .endData(LocalDate.now().plusDays(1).toString())
                .build();
    }
}
