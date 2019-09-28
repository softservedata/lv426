package com.softserve.edu.opencart.data.checkout;

import com.softserve.edu.opencart.data.shop.OrderNotFoundException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ConfirmOrderTableContainer {

    private WebDriver driver;
    private List<ConfirmOrderTableComponents> orderInfo;

    public ConfirmOrderTableContainer(List<ConfirmOrderTableComponents> orderInfo){
        this.orderInfo = orderInfo;
    }

    public List<ConfirmOrderTableComponents> getListWithConfirmOrderTableComponents(){
        return orderInfo;
    }

    public ConfirmOrderTableComponents getProductByNameConfirmOrderPage(String name ){
        ConfirmOrderTableComponents order = null;
        for(ConfirmOrderTableComponents current : getListWithConfirmOrderTableComponents() ){
            if((current.getProductNameFromConfirmPage()).equals(name)){
                order = current;
            }
        }
        if(order==null){
            throw new OrderNotFoundException("Product with name" + name + " not found", new RuntimeException());
        }
        return order;
    }



}
