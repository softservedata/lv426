package com.softserve.edu.opencart.data.checkout;

import com.softserve.edu.opencart.data.shop.FinalPriceTableTitleNotFoundException;

import java.util.List;

public class ConfirmOrderSumConclusionContainer {
    private List<ConfirmOrderSumConclusionComponents> listOfComponents;

    public ConfirmOrderSumConclusionContainer(List<ConfirmOrderSumConclusionComponents> listOfComponents) {
        this.listOfComponents = listOfComponents;
    }


    public List<ConfirmOrderSumConclusionComponents> getListOfConfirmOrderConlusionComponents() {
        return listOfComponents;
    }

    public ConfirmOrderSumConclusionComponents getCashSumByTitle(String title) {
        ConfirmOrderSumConclusionComponents order = null;
        for (ConfirmOrderSumConclusionComponents element : getListOfConfirmOrderConlusionComponents()) {
            if ((element.getTitleConfirmTable()).equals(title)) {
                order = element;
                break;
            }
        }
        if (order == null) {
            throw new FinalPriceTableTitleNotFoundException("The title" + title + "not found",
                    new RuntimeException());
        }

        return order;
    }
}
