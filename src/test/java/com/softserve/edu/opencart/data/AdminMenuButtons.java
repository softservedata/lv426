package com.softserve.edu.opencart.data;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum AdminMenuButtons {

    CATALOG("menu-catalog"),
    CUSTOMERS("menu-customer"),
    SYSTEM("menu-system");

    private String value;

    AdminMenuButtons(String value) {
        this.value = value;
    }
}

