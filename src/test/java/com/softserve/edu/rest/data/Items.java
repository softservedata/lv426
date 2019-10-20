package com.softserve.edu.rest.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Items {
    private String name;
    private String index;

    public Items setItem(String item) {
        this.name = item;
        return this;
    }

    public Items setIndex(String index) {
        this.index = index;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", index='" + index + '\'' +
                '}';
    }
}

