package com.softserve.edu.opencart.data;

public class Currency {
    private String title;
    private String code;
    private String symbolLeft;
    private int  decimalPlaces;
    private double value;
    private String status;

    Currency(String title, String code, String symbolLeft, int decimalPlaces, double value, String status) {
        this.title = title;
        this.code = code;
        this.symbolLeft = symbolLeft;
        this.decimalPlaces = decimalPlaces;
        this.value = value;
        this.status = status;
    }
    //setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSymbolLeft(String symbolLeft) {
        this.symbolLeft = symbolLeft;
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //getters

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getSymbolLeft() {
        return symbolLeft;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }

    public double getValue() {
        return value;
    }

    public String getStatus() {
        return status;
    }
}
