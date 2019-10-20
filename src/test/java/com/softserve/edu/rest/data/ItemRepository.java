package com.softserve.edu.rest.data;

public class ItemRepository {

    public static final String EXPECTED_EMPTY_ITEM_NAME = "empty";
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

    public static Item getInvalidItem() {
        return Item.builder()
                .item("")
                .index("9876")
                .build();
    }
}
