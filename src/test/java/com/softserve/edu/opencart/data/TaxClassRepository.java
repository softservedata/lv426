package com.softserve.edu.opencart.data;

public class TaxClassRepository {

    private TaxClassRepository() {

    }

    public static TaxClass getFixed() {
        return getFixedAmountClass();

    }

    public static TaxClass getPercentage() {
        return  getPercentageClass();
    }

    private static TaxClass getFixedAmountClass() {
        return TaxClass.builder()
                .name("Test Class")
                .description("New Test Class")
                .taxRate("Fixed TestTax")
                .build();

    }

    private static TaxClass getPercentageClass() {
        return TaxClass.builder()
                .name("Test Class")
                .description("New Test Class")
                .taxRate("Percentage TestTax")
                .build();

    }
}
