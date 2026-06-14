package com.travelgo.app.services;

import com.travelgo.app.entities.Flight;
import com.travelgo.app.entities.Hotel;
import com.travelgo.app.exceptions.ReservationNotFoundException;
import com.travelgo.app.utils.ConfirmationGenerator;
import com.travelgo.app.entities.FlightReservation;
import com.travelgo.app.entities.HotelReservation;
import com.travelgo.app.entities.Reservation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelBookingSystem {
    private final List<Flight> flights = new ArrayList<>();
    private final List<Hotel> hotels = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public TravelBookingSystem() {
        loadDummyData();
    }

    private void loadDummyData() {
        flights.add(new Flight("GA101", "Jakarta", "Bali", "2026-07-01", 10, BigDecimal.valueOf(1500000)));
        flights.add(new Flight("JT202", "Jakarta", "Surabaya", "2026-07-01", 15, BigDecimal.valueOf(900000)));
        flights.add(new Flight("ID303", "Bandung", "Bali", "2026-07-02", 8, BigDecimal.valueOf(1200000)));

        hotels.add(new Hotel("H001", "Grand Bali", "Bali", BigDecimal.valueOf(800000)));
        hotels.add(new Hotel("H002", "Luxury Resort", "Bali", BigDecimal.valueOf(1200000)));
        hotels.add(new Hotel("H003", "Surabaya Inn", "Surabaya", BigDecimal.valueOf(500000)));
    }

    public List<Flight> searchFlights(String origin, String destination, String date) {
        return flights.stream()
                .filter(flight -> flight.getOrigin().equalsIgnoreCase(origin)
                                &&
                                flight.getDestination().equalsIgnoreCase(destination)
                                &&
                                flight.getDate().equalsIgnoreCase(date))
                .toList();
    }

    public List<Hotel> searchHotels(String location) {
        return hotels.stream()
                .filter(hotel ->
                        hotel.getLocation()
                                .equalsIgnoreCase(location))
                .toList();
    }

    public void bookFlight(Flight flight, String customer, String contact) {
        int confirmation = ConfirmationGenerator.generate();
        FlightReservation reservation = new FlightReservation(confirmation, customer, contact, flight);
        reservations.add(reservation);
        flight.reduceSeat();
        System.out.println("Booking Success. Confirmation Number : " + confirmation);
    }

    public void bookHotel(Hotel hotel, String customer, String contact) {
        int confirmation = ConfirmationGenerator.generate();
        HotelReservation reservation = new HotelReservation(confirmation, customer, contact, hotel);
        reservations.add(reservation);
        System.out.println("Booking Success. Confirmation Number : " + confirmation);
    }

    public void cancelReservation(int confirmation) throws ReservationNotFoundException {
        Reservation target = reservations.stream()
                .filter(reservation ->
                        reservation.getConfirmationNumber()
                                == confirmation)
                .findFirst()
                .orElse(null);

        if (target == null) throw new ReservationNotFoundException("Reservation Not Found");

        if (target instanceof FlightReservation flightReservation) flightReservation.cancel();
        else if (target instanceof HotelReservation hotelReservation) hotelReservation.cancel();

        reservations.remove(target);

        System.out.println("Reservation removed.");
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations.");
            return;
        }

        reservations.stream()
                .sorted(Comparator.comparingInt(
                        Reservation::getConfirmationNumber))
                .forEach(Reservation::display);
    }
}
