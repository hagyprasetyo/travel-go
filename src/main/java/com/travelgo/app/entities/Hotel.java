package com.travelgo.app.entities;

import java.math.BigDecimal;

public class Hotel {
    private String hotelId;
    private String hotelName;
    private String location;
    private BigDecimal pricePerNight;

    public Hotel(String hotelId, String hotelName, String location, BigDecimal pricePerNight) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | Rp %.0f", hotelId, hotelName, location, pricePerNight);
    }
}
