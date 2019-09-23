package com.softserve.edu.opencart.data;

public class GeoZoneRepository {
    private GeoZoneRepository() {

    }

    public static GeoZone getDefault() {
        return getGeoZone();

    }
    private static GeoZone getGeoZone() {
        return GeoZone.builder()
                .name("Australia ShippingZone")
                .description("New Shipping Zone")
                .country("Australia")
                .build();
    }
}
