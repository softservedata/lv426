package com.softserve.edu.opencart.data;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TaxClass {
    private String name;
    private String description;
    private String taxRate;


}
