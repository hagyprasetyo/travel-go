package com.travelgo.app;

import com.travelgo.app.entities.Flight;
import com.travelgo.app.entities.Hotel;
import com.travelgo.app.exceptions.ReservationNotFoundException;
import com.travelgo.app.services.TravelBookingSystem;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TravelGoApplication {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelBookingSystem system =
                new TravelBookingSystem();

        while (true) {
            System.out.println("""
                    
                    ===== Travel Go Booking System =====
                    1. Search Flight
                    2. Search Hotel
                    3. Cancel Reservation
                    4. View Reservations
                    5. Exit
                    """);

            try {
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Origin: ");
                        String origin = sc.nextLine();

                        System.out.print("Destination: ");
                        String destination = sc.nextLine();

                        System.out.print("Date: ");
                        String date = sc.nextLine();

                        List<Flight> results = system.searchFlights(origin, destination, date);

                        if (results.isEmpty()) {
                            System.out.println("No flight available.");
                            break;
                        }

                        for (int i = 0; i < results.size(); i++) {
                            System.out.println((i + 1) + ". " + results.get(i));
                        }

                        System.out.print("Choose Flight: ");

                        int idx = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Contact: ");
                        String contact = sc.nextLine();

                        system.bookFlight(results.get(idx), name, contact);
                    }

                    case 2 -> {
                        System.out.print("Location: ");

                        String location = sc.nextLine();

                        List<Hotel> hotels = system.searchHotels(location);

                        if (hotels.isEmpty()) {
                            System.out.println("No hotel available.");
                            break;
                        }

                        for (int i = 0; i < hotels.size(); i++) {
                            System.out.println((i + 1) + ". " + hotels.get(i));
                        }

                        System.out.print("Choose Hotel: ");

                        int idx = sc.nextInt() - 1;
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Contact: ");
                        String contact = sc.nextLine();

                        system.bookHotel(hotels.get(idx), name, contact);
                    }

                    case 3 -> {
                        System.out.print("Confirmation Number: ");

                        int conf = sc.nextInt();

                        system.cancelReservation(conf);
                    }

                    case 4 -> system.viewReservations();

                    case 5 -> {
                        System.out.println("Goodbye.");
                        System.exit(0);
                    }

                    default -> System.out.println("Invalid Menu");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid Input.");

                sc.nextLine();

            } catch (ReservationNotFoundException e) {

                System.out.println(e.getMessage());

            } catch (Exception e) {

                System.out.println("Error : " + e.getMessage());
            }
        }
    }
}
