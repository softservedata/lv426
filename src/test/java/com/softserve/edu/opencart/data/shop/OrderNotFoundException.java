package com.softserve.edu.opencart.data.shop;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
