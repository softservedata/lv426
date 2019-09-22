package com.softserve.edu.opencart.data;

public interface ICurrency {
    String getTitle();

    String getCode();

    String getSymbolLeft();

    int getDecimalPlaces();

    double getValue();

    String getStatus();
}

