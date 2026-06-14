package com.travelgo.app.entities;

public final class FlightReservation extends Reservation {

    private Flight flight;

    public FlightReservation(int confirmationNumber, String customerName, String contact, Flight flight) {
        super(confirmationNumber, customerName, contact);
        this.flight = flight;
    }

    @Override
    public void book() {
        System.out.println("Flight booked.");
    }

    @Override
    public void cancel() {
        System.out.println("Flight booking cancelled.");
    }

    @Override
    public void display() {
        System.out.println("\nFLIGHT RESERVATION");
        System.out.println("Confirmation : " + confirmationNumber);
        System.out.println("Passenger    : " + customerName);
        System.out.println("Contact      : " + contact);
        System.out.println(flight);
    }
}
