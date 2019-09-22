package com.softserve.edu.opencart.data.shop;

import java.util.List;

public class ShoppingCartTableElements {
    private List<CartTableFullOrderInfo> cartOrders;

    public ShoppingCartTableElements(List<CartTableFullOrderInfo> cartOrders) {
        this.cartOrders = cartOrders;
    }


    public List<CartTableFullOrderInfo> getCartTableElement() {
        return cartOrders;
    }

}
