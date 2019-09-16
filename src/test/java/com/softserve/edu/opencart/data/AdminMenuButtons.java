package com.softserve.edu.opencart.data;

import lombok.Getter;

public class AdminMenuButtons {
    @Getter
    public enum menuButtonsName {
        CATALOG("menu-catalog"),
        CUSTOMERS("menu-customer"),
        SYSTEM("menu-system");
        private String value;

        menuButtonsName(String value) {
            this.value = value;
        }
    }
}
