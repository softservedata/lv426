package com.softserve.edu.opencart.data;

public enum ReturnsStatus {
    AWAITING("//select/option[text()='Awaiting Products']"),
    PENDING("//select/option[text()='Complete']"),
    COMPLETE("//select/option[text()='Pending']");

    private String value;

    private ReturnsStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
