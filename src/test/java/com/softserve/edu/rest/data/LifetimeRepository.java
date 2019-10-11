package com.softserve.edu.rest.data;

public class LifetimeRepository {
    private LifetimeRepository() {

    }

    public static Lifetime getDefault() {
        return Lifetime.builder()
                .time("300000")
                .build();
    }

    public static Lifetime getZeroLifetime() {
        return Lifetime.builder()
                .time("0")
                .build();
    }

    public static Lifetime getTextLifetime() {
        return Lifetime.builder()
                .time("test")
                .build();
    }

    public static Lifetime getSpecialSymbolLifetime() {
        return Lifetime.builder()
                .time(":{_]}{")
                .build();
    }

    public static Lifetime getNegativeDefault() {
        return Lifetime.builder()
                .time("-23324342")
                .build();
    }

    public static Lifetime getNewLifeTime() {
        return Lifetime.builder()
                .time("4000000")
                .build();
    }

    public static Lifetime getShortLifeTime() {
        return Lifetime.builder()
                .time("10000")
                .build();
    }


}
