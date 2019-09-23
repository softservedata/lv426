package com.softserve.edu.opencart.data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GeoZone {
    private String name;
    private String description;
    private String country;

}
