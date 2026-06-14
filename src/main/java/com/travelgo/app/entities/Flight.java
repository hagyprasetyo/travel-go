package com.travelgo.app.entities;

import java.math.BigDecimal;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private String date;
    private Integer availableSeats;
    private BigDecimal price;

    public Flight(String flightNumber, String origin, String destination, String date, Integer availableSeats, BigDecimal price) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void reduceSeat() {
        availableSeats--;
    }

    @Override
    public String toString() {
        return String.format("%s | %s -> %s | %s | Seat:%d | Rp %.0f", flightNumber, origin, destination, date, availableSeats, price);
    }
}
