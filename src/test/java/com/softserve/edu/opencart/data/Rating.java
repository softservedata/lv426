package com.softserve.edu.opencart.data;

import lombok.Getter;

@Getter
public enum Rating {

    VERYBAD("1"),
    BAD("2"),
    NORMAL("3"),
    GOOD("4"),
    AMAZING("5");

    //VERYBAD("//input[@name='rating' and @value='1']"),
    //BAD("//input[@name='rating' and @value='2']"),
    //NORMAL("//input[@name='rating' and @value='3']"),
    //GOOD("//input[@name='rating' and @value='4']"),
    //AMAZING("//input[@name='rating' and @value='5']");

    private  String value;

    Rating(String value) {
        this.value = value;
    }

    public String toString() {

        return value;
    }
}