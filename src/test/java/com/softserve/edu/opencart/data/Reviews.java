package com.softserve.edu.opencart.data;

interface IName {
    IFeedback setName(String name);
}
interface IFeedback {
    IRating setReview(String review);
}
interface IRating {
    IReviewsBuild setRating(Rating rating);
}

interface IReviewsBuild {
    IReviews build();
}

public class Reviews implements IName, IFeedback, IRating,IReviewsBuild, IReviews {

    private String name;
    private String feedback;
    private Rating rating;


    private Reviews() {
    }

    public static IName get() {
        return new Reviews();
    }
    //setters

    public IFeedback setName(String name) {
        this.name = name;
        return this;
    }

    public IRating setReview (String review){
        this.feedback = review;
        return this;
    }


    public IReviewsBuild setRating(Rating rating){
        this.rating = rating;
        return this;
    }

    //getters

    public String getName() {
        return name;
    }

    public String getFeedback() {
        return feedback;
    }

    public Rating getRating() {
        return rating;
    }



    public IReviews build() {
        return  this;
    }
}


