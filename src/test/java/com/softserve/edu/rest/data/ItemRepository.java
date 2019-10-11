package com.softserve.edu.rest.data;

public class ItemRepository {

    private ItemRepository() {
    }

    public static Item getValidItem() {
        return new Item("computer", "1234");
    }

    public static Item getUpdateValidItem() {
        return new Item("phone", "1234");
    }

    public static Item getSecond() {
        return new Item("my second information", "2345");
    }
}
