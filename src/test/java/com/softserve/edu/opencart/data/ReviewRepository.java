package com.softserve.edu.opencart.data;

public class ReviewRepository {

    private static volatile ReviewRepository instance = null;

    private ReviewRepository() {

    }

    public static ReviewRepository get() {
        if (instance == null) {
            synchronized (ReviewRepository.class) {
                if (instance == null) {
                    instance = new ReviewRepository();
                }
            }
        }
        return instance;
    }

    public static IReviews getDefault() {
        return getNewReview();

    }

    public static IReviews getNewReview() {
        return Reviews.get()
                .setName("iva qwerty")
                .setReview("Very good product! I'll recommend it to all of my friends")
                .setRating("5")
                .build();
    }
}
