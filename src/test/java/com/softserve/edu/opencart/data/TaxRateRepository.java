package com.softserve.edu.opencart.data;

public class TaxRateRepository {

    public static TaxRate getFixed() {
        return getTaxWithFixedAmountType();

    }

    public static TaxRate getPercentage() {
        return getTaxWithPercentageType();
    }

    public static TaxRate getTaxWithFixedAmountType() {
        return new TaxRate("Fixed TestTax", 20, "Fixed Amount", "Australia ShippingZone");
    }

    public static TaxRate getTaxWithPercentageType() {
        return new TaxRate("Percentage TestTax", 5, "Percentage", "Australia ShippingZone");
    }
}
