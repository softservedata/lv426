package com.softserve.edu.opencart.data;

public class TaxRateRepository {
    public TaxRate getTaxWithFixedAmountType() {
        return new TaxRate("Fixed TestTax", 20, "Fixed Amount", "Australia ShippingZone");
    }

    public TaxRate getTaxWithPercentageType() {
        return new TaxRate("Percentage TestTax", 5, "Percentage", "Australia ShippingZone");
    }
}
