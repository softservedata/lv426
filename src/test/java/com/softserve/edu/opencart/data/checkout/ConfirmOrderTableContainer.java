package com.softserve.edu.opencart.data.checkout;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class ConfirmOrderTableContainer {

    private WebDriver driver;
    private List<ConfirmOrderTableComponents> orderInfo;

    public ConfirmOrderTableContainer(List<ConfirmOrderTableComponents> orderInfo){
        this.orderInfo = orderInfo;
    }

}
