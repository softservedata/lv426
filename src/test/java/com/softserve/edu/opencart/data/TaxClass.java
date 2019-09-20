package com.softserve.edu.opencart.data;

public class TaxClass {
    private String name;
    private String description;
    private String taxRate;

    public TaxClass(String name, String description, String taxRate) {
        this.name = name;
        this.description = description;
        this.taxRate = taxRate;

    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }
    //getters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTaxRate() {
        return taxRate;
    }
}
