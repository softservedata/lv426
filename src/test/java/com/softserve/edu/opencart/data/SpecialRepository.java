package com.softserve.edu.opencart.data;

import java.time.LocalDate;

public class SpecialRepository {
    public Special getNewSpecialPrice() {
        return new Special(1, 50.5, LocalDate.now().toString(), LocalDate.now().plusDays(1).toString());
    }
}
