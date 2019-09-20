package com.softserve.edu.opencart.data;

import java.util.List;

public class ShoppingCartTableElements {
    private CartTableFullOrderInfo elements;
    private List<CartTableFullOrderInfo> cartOrders;

    public ShoppingCartTableElements(List<CartTableFullOrderInfo> cartOrders) {
        this.cartOrders = cartOrders;
    }

    public ShoppingCartTableElements(CartTableFullOrderInfo elements) {
        this.elements = elements;
    }

    public List<CartTableFullOrderInfo> getCartTableElement() {
        return cartOrders;
    }

    public CartTableFullOrderInfo getElements() {
        return elements;
    }
}
