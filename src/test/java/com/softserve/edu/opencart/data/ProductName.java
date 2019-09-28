package com.softserve.edu.opencart.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ProductName {


    IPHONE("iPhone"),
    NIKON("Nikon D300");

    public String getValue() {
        return value;
    }

    private String value;

    ProductName(String value) {
        this.value = value;
    }
}

