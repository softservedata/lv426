package com.softserve.edu.opencart.data;
interface ITitle {
    ICode setTitle(String title);
}
interface ICode {
    ISymbolLeft setCode(String code);
}
interface ISymbolLeft {
    IDecimalPlaces setSymbolLeft(String symbolLeft);
}
interface IDecimalPlaces {
    IValue setDecimalPlaces(int decimalPlaces);
}
interface IValue {
    IStatus setValue(double value);
}
interface IStatus {
    ICurrencyBuild setStatus(String status);
}
interface ICurrencyBuild {
    ICurrency build();
}

public class Currency implements ITitle, ICode, ISymbolLeft, IDecimalPlaces, IValue, IStatus, ICurrencyBuild, ICurrency{
    private String title;
    private String code;
    private String symbolLeft;
    private int  decimalPlaces;
    private double value;
    private String status;

    private Currency() {
    }

    public static ITitle get() {
        return new Currency();
    }
    //setters

    public ICode setTitle(String title) {
        this.title = title;
        return this;
    }

    public ISymbolLeft setCode(String code) {
        this.code = code;
        return this;
    }

    public IDecimalPlaces setSymbolLeft(String symbolLeft) {
        this.symbolLeft = symbolLeft;
        return this;
    }

    public IValue setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
        return this;
    }

    public IStatus setValue(double value) {
        this.value = value;
        return this;
    }

    public ICurrencyBuild setStatus(String status) {
        this.status = status;
        return this;
    }
    public ICurrency build(){
        return this;
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
