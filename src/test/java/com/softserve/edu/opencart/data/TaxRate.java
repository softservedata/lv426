package com.softserve.edu.opencart.data;

public class TaxRate {
    private String name;
    private double rate;
    private String type;
    private String geoZone;

    public TaxRate(String name, double rate, String type, String geoZone) {
        this.name = name;
        this.rate = rate;
        this.type = type;
        this.geoZone = geoZone;
    }
    //setters


    public void setName(String name) {
        this.name = name;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGeoZone(String geoZone) {
        this.geoZone = geoZone;
    }

    //getters

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public String getType() {
        return type;
    }

    public String getGeoZone() {
        return geoZone;
    }
}
