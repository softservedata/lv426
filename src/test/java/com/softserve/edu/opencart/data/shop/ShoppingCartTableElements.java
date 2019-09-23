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

    public List<CartTableFullOrderInfo> getAllOrderFromTable() {
        return cartOrders;
    }

    public CartTableFullOrderInfo getOrderFromTableByName(String orderName) {
        CartTableFullOrderInfo order = null;
        for (CartTableFullOrderInfo current : getAllOrderFromTable()) {
            if (current.getProductName()
                    .equals(orderName)) {
                order = current;
                break;
            }
        }
        if (order == null) {
            throw new OrderNotFoundException("ProductName: " + orderName + " not Found.", new RuntimeException());
        }
        return order;
    }

    public String getOrderUnitPriceByName(String orderName){
        return  getOrderFromTableByName(orderName).getUnitPrice().getText();
    }

    public String getOrderTotalPriceByName(String orderName){
        return getOrderFromTableByName(orderName).getTotal().getText();
    }

    public String getOrderModelByName(String orderName){
        return getOrderFromTableByName(orderName).getModel().getText();
    }

    public String getOrderQuantityByName(String orderName){
        return getOrderFromTableByName(orderName).getQuantity().getText();
    }


}

