package com.softserve.edu.opencart.data;

import lombok.Getter;

public class ProductName {
    @Getter
    public enum productName {
        IPHONE("Iphone");

        private String value;

        productName(String value) {
            this.value = value;
        }
    }
}
