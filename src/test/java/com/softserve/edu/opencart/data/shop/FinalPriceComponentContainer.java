package com.softserve.edu.opencart.data.shop;

import java.util.List;

public class FinalPriceComponentContainer {
    private List<FinalPriceTableComponent> listOfComponents;

    public FinalPriceComponentContainer(List<FinalPriceTableComponent> listOfComponents) {
        this.listOfComponents = listOfComponents;
    }


    public List<FinalPriceTableComponent> getListOfComponents() {
        return listOfComponents;
    }

    public FinalPriceTableComponent getCashSumByTitle(String title){
        FinalPriceTableComponent order = null;
        for(FinalPriceTableComponent element : getListOfComponents() ) {
            if ((element.getTitle()).equals(title)) {
                order = element;
                break;
            }
        }
            if(order==null){
                    throw new FinalPriceTableTitleNotFoundException("The title" + title + "not found",
                            new RuntimeException());
            }

        return order;
    }

//    public FinalPriceTableComponent getFinalPriceTable(){
//
//    }
}
