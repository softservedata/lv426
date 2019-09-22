package com.softserve.edu.opencart.data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TaxRate {
    private String name;
    private double rate;
    private String type;
    private String geoZone;


}
