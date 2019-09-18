package com.softserve.edu.opencart.data;

public class TaxClassRepository {

    private TaxClassRepository() {

    }

    public static TaxClass getFixed() {
        return getFixedAmountClass();

    }

    public static TaxClass getPercentage() {
        return getPercentageClass();
    }
    public static TaxClass getFixedAmountClass() {
        return new TaxClass("Test Class", "New Test Class", "Fixed TestTax");
    }

    public static TaxClass getPercentageClass() {
        return new TaxClass("Test Class", "new Test Class", "Percentage TestTax");
    }
}
