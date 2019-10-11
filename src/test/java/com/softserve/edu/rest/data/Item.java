package com.softserve.edu.rest.data;

public class Item {
    private String item;
    private String index;

    public Item(String item, String index) {
        this.item = item;
        this.index = index;
    }

    public Item setItem(String item) {
        this.item = item;
        return this;
    }

    public Item setIndex(String index) {
        this.index = index;
        return this;
    }

    public String getItem() {
        return item;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                ", index='" + index + '\'' +
                '}';
    }
}
