package com.softserve.edu.opencart.data;

public class Special {
    private int priority;
    private double price;
    private String startDate;
    private String endData;

    public Special(int priority, double price, String startDate, String endData) {
        this.priority = priority;
        this.price = price;
        this.startDate = startDate;
        this.endData = endData;
    }
    //setters

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }
    //getters

    public int getPriority() {
        return priority;
    }

    public double getPrice() {
        return price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndData() {
        return endData;
    }
}
