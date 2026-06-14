package com.travelgo.app.entities;

import com.travelgo.app.interfaces.Bookable;

public sealed abstract class Reservation implements Bookable permits FlightReservation, HotelReservation {

    protected Integer confirmationNumber;
    protected String customerName;
    protected String contact;

    public Reservation(Integer confirmationNumber, String customerName, String contact) {
        this.confirmationNumber = confirmationNumber;
        this.customerName = customerName;
        this.contact = contact;
    }

    public Integer getConfirmationNumber() {
        return confirmationNumber;
    }

    public abstract void display();
}
