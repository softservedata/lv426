package com.softserve.edu.opencart.data;

public class GeoZoneRepository {
    private GeoZoneRepository() {

    }

    public static GeoZone getDefault() {
        return getGeoZone();

    }
    public static GeoZone getGeoZone() {
        return new GeoZone("Australia ShippingZone", "New Shiping Zone", "Australia");
    }
}
