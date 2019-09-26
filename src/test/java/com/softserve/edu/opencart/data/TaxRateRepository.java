package com.softserve.edu.opencart.data;

public class TaxRateRepository {

    public static TaxRate getFixed() {
        return getTaxWithFixedAmountType();

    }

    public static TaxRate getPercentage() {
        return getTaxWithPercentageType();
    }

    private static TaxRate getTaxWithFixedAmountType() {
        return TaxRate.builder()
                .name("Fixed TestTax")
                .rate(20)
                .type("Fixed Amount")
                .geoZone("Australia ShippingZone")
                .build();

    }

    private static TaxRate getTaxWithPercentageType() {
        return TaxRate.builder()
                .name("Percentage TestTax")
                .rate(5)
                .type("Percentage")
                .geoZone("Australia ShippingZone")
                .build();

    }
}
