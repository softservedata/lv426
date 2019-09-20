package com.softserve.edu.opencart.data;

public class GeoZone {
    private String name;
    private String description;
    private String country;

    public GeoZone(String name, String description, String country) {
        this.name = name;
        this.description = description;
        this.country = country;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

}
