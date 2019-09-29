package com.softserve.edu.opencart.data;

public enum ReturnReason {

    DEAD("//input[@name='return_reason_id' and @value=1]"),
    FAULTY("//input[@name='return_reason_id' and @value=4]"),
    ERROR("//input[@name='return_reason_id' and @value=3]"),
    OTHER("//input[@name='return_reason_id' and @value=5]"),
    RECEIVED("//input[@name='return_reason_id' and @value=2]");

    private String value;

    private ReturnReason(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
