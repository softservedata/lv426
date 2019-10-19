package com.softserve.edu.rest.data;

public class ItemsRepository {

    private ItemsRepository() {
    }

    public static Items firstItemGetting() {
        return Items.builder()
                .name("admin")
                .index("1234")
                .build();
    }

    public static Items secondItemGetting() {
        return Items.builder()
                .name("khalaktc")
                .index("9876")
                .build();
    }


}