package com.travelgo.app.entities;

public final class HotelReservation extends Reservation {

    private Hotel hotel;

    public HotelReservation(int confirmationNumber, String customerName, String contact, Hotel hotel) {
        super(confirmationNumber, customerName, contact);
        this.hotel = hotel;
    }

    @Override
    public void book() {
        System.out.println("Hotel booked.");
    }

    @Override
    public void cancel() {
        System.out.println("Hotel booking cancelled.");
    }

    @Override
    public void display() {
        System.out.println("\nHOTEL RESERVATION");
        System.out.println("Confirmation : " + confirmationNumber);
        System.out.println("Guest         : " + customerName);
        System.out.println("Contact       : " + contact);
        System.out.println(hotel);
    }
}
