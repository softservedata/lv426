package com.softserve.edu.rest.data;

public class ItemRepository {

    private ItemRepository() {
    }

    public static Item getValidItem() {
        return Item.builder()
                .item("computer")
                .index("1234")
                .build();
    }

    public static Item getUpdateValidItem() {
        return Item.builder()
                .item("phone")
                .index("1234")
                .build();
    }

    public static Item getSecond() {
        return Item.builder()
                .item("information")
                .index("9876")
                .build();
    }
}
