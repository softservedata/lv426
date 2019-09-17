package com.softserve.edu.opencart.data;

public class TaxClassRepository {


    public TaxClass getFixedAmountClass() {
        return new TaxClass("Test Class", "New Test Class", "Fixed TestTax");
    }

    public TaxClass getPercentageClass() {
        return new TaxClass("Test Class", "new Test Class", "Percentage TestTax");
    }
}
