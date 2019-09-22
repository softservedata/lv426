<<<<<<< HEAD
=======

>>>>>>> 17b0ba8a33654a5872c2086cd0844147a8a94678
package com.softserve.edu.opencart.data;

public enum Currencies {
    EURO("Euro"),
    POUND_STERLING("Pound Sterling"),
    US_DOLLAR("US Dollar");
    //
    private String name;

    private Currencies(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}