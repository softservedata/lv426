package com.softserve.edu.opencart.data;

import lombok.Getter;

@Getter
public enum  FinalPriceTable {
    SUB_TOTAL("Sub-Total"),
    TOTAL("Total");

    private String name;

    FinalPriceTable(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
