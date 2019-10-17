package com.softserve.edu.rest.data;

public class ItemsRepository {

    private ItemsRepository() {
    }

    public static Items getValidItem() {
        return Items.builder()
                .name("iva")
                .index("1234")
                .build();
    }


}