package com.pavel.listingdetails.dto;

public class RequestDTO {
    private double minPrice;
    private double maxPrice;
    private int minMinCpm;
    private int maxMaxCpm;

    public RequestDTO(double minPrice, double maxPrice, int minMinCpm, int maxMaxCpm) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.minMinCpm = minMinCpm;
        this.maxMaxCpm = maxMaxCpm;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getMinMinCpm() {
        return minMinCpm;
    }

    public void setMinMinCpm(int minMinCpm) {
        this.minMinCpm = minMinCpm;
    }

    public int getMaxMaxCpm() {
        return maxMaxCpm;
    }

    public void setMaxMaxCpm(int maxMaxCpm) {
        this.maxMaxCpm = maxMaxCpm;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", minMinCpm=" + minMinCpm +
                ", maxMaxCpm=" + maxMaxCpm +
                '}';
    }
}
