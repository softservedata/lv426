package com.softserve.edu.opencart.data;

import java.time.LocalDate;

public class SpecialRepository {

    private SpecialRepository() {

    }

    public static Special getDefault() {
        return getNewSpecialPrice();

    }
    public static Special getNewSpecialPrice() {
        return new Special(1, 50.5, LocalDate.now().toString(), LocalDate.now().plusDays(1).toString());
    }
}
