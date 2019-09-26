package com.softserve.edu.opencart.data;

interface IName {
    IReview setName(String name);
}
interface IReview {
    IRating setReview(String review);
}
interface IRating {
    IReviewsBuild setRating(String rating);
}

interface IReviewsBuild {
    IReviews build();
}

public class Reviews implements IName, IReview, IRating,IReviewsBuild {

    private String name;
    private String review;
    private String rating;


    private Reviews() {
    }

    public static IName get() {
        return new Reviews();
    }
    //setters

    public IReview setName(String name) {
        this.name = name;
        return this;
    }

    public IRating setReview (String review){
        this.review = review;
        return this;
    }


    public IReviewsBuild setRating(String rating){
        this.rating = rating;
        return this;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getReview() {
        return review;
    }

    public String getRating() {
        return rating;
    }



    public IReviews build() {
        return (IReviews) this;
    }
}


