package com.pavel.listingdetails.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class DetailsEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private UUID id;

    @Column(name = "session_id")
    private long sessionId;
    @Column(name = "advertiser_id")
    private long advertiserId;
    @Column(name = "country")
    private String country;
    @Column(name = "price")
    private double price;
    @Column(name = "event_type_id")
    private long event_typeId;
    @Column(name = "gdpr")
    private int gdpr;
    @Column(name = "min_cpm")
    private int minCpm;
    @Column(name = "priority")
    private double priority;
    @Column(name = "bid_price")
    private double bidPrice;

    public DetailsEntity(UUID id, long sessionId, long advertiserId, String country, double price, long event_typeId, int gdpr, int minCpm, double priority, double bidPrice) {
        this.id = id;
        this.sessionId = sessionId;
        this.advertiserId = advertiserId;
        this.country = country;
        this.price = price;
        this.event_typeId = event_typeId;
        this.gdpr = gdpr;
        this.minCpm = minCpm;
        this.priority = priority;
        this.bidPrice = bidPrice;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getSessionId() {
        return sessionId;
    }

    public void setSessionId(long sessionId) {
        this.sessionId = sessionId;
    }

    public long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getEvent_typeId() {
        return event_typeId;
    }

    public void setEvent_typeId(long event_typeId) {
        this.event_typeId = event_typeId;
    }

    public int getGdpr() {
        return gdpr;
    }

    public void setGdpr(int gdpr) {
        this.gdpr = gdpr;
    }

    public int getMinCpm() {
        return minCpm;
    }

    public void setMinCpm(int minCpm) {
        this.minCpm = minCpm;
    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(double priority) {
        this.priority = priority;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }



    @Override
    public String toString() {
        return "DetailsEntity{" +
                "id=" + id +
                ", sessionId=" + sessionId +
                ", advertiserId=" + advertiserId +
                ", country='" + country + '\'' +
                ", price=" + price +
                ", event_typeId=" + event_typeId +
                ", gdpr=" + gdpr +
                ", minCpm=" + minCpm +
                ", priority=" + priority +
                ", bidPrice=" + bidPrice +
                '}';
    }
}
