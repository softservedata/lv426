package com.softserve.edu.opencart.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ProductName {


    IPHONE("Iphone");

    private String value;

    ProductName(String value) {
        this.value = value;
    }
}
