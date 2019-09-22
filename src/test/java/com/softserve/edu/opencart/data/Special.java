package com.softserve.edu.opencart.data;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Special {
    private int priority;
    private double price;
    private String startDate;
    private String endData;


}
