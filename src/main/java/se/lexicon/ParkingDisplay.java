
package se.lexicon;

import java.util.ArrayList;
import java.util.Scanner;
public class ParkingDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Reservation> reservations = new ArrayList<>();
        int nextReservationId = 1;
        ParkingSpace[] spaces = new ParkingSpace[20];
        for (int i = 0; i < spaces.length; i++) {
            spaces[i] = new ParkingSpace(i + 1);
        }
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("========================================");
            System.out.println("       PARKING RESERVATION SYSTEM");
            System.out.println("========================================");
            System.out.println();
            System.out.println("Welcome! Please choose an option.");
            System.out.println();
            System.out.println("[1] View parking spaces");
            System.out.println("[2] Make a reservation");
            System.out.println("[3] View reservations");
            System.out.println("[4] Complete a reservation");
            System.out.println("[0] Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a menu number.");
                continue;
            }
            switch (choice) {
                case 0:
                    System.out.println(
                            "Thank you for using the Parking Reservation System!");
                    running = false;
                    break;
                case 1:
                    System.out.println();
                    System.out.println("PARKING SPACE STATUS");
                    System.out.println("----------------------------------------");
                    for (ParkingSpace space : spaces) {
                        System.out.println(
                                "Space " + space.getSpaceNumber() + ": "
                                        + (space.isAvailable()
                                        ? "Available" : "Occupied"));
                    }
                    break;
                case 2:
                    System.out.println();
                    System.out.println("MAKE A RESERVATION");
                    System.out.println("----------------------------------------");
                    for (ParkingSpace space : spaces) {
                        System.out.println(
                                "Space " + space.getSpaceNumber() + ": "
                                        + (space.isAvailable()
                                        ? "Available" : "Occupied"));
                    }
                    System.out.print("Choose a parking space (1-20): ");
                    int chosenSpace;
                    try {
                        chosenSpace = Integer.parseInt(scanner.nextLine().trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                        break;
                    }
                    if (chosenSpace < 1 || chosenSpace > spaces.length) {
                        System.out.println(
                                "Invalid choice. Please choose a number from 1 to 20.");
                        break;
                    }
                    ParkingSpace selectedSpace = spaces[chosenSpace - 1];
                    if (!selectedSpace.isAvailable()) {
                        System.out.println(
                                "Sorry, that parking space is already occupied.");
                        break;
                    }
                    System.out.print("Enter your name: ");
                    String personName = scanner.nextLine();
                    System.out.print("Enter your phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter your vehicle registration: ");
                    String registrationNumber = scanner.nextLine();
                    Reservation reservation = new Reservation(
                            nextReservationId,
                            personName,
                            phoneNumber,
                            registrationNumber,
                            selectedSpace
                    );
                    reservations.add(reservation);
                    nextReservationId++;
                    selectedSpace.setAvailable(false);
                    System.out.println();
                    System.out.println("Reservation created successfully!");
                    System.out.println("----------------------------------------");
                    System.out.println(
                            "Reservation ID: " + reservation.getReservationId());
                    System.out.println(
                            "Name: " + reservation.getPersonName());
                    System.out.println(
                            "Parking space: " + selectedSpace.getSpaceNumber());
                    break;
                case 3:
                    System.out.println();
                    System.out.println("ACTIVE RESERVATIONS");
                    System.out.println("----------------------------------------");
                    if (reservations.isEmpty()) {
                        System.out.println("There are no active reservations.");
                    } else {
                        for (Reservation r : reservations) {
                            System.out.println(
                                    "Reservation ID: " + r.getReservationId());
                            System.out.println(
                                    "Name: " + r.getPersonName());
                            System.out.println(
                                    "Phone: " + r.getPhoneNumber());
                            System.out.println(
                                    "Vehicle: " + r.getRegistrationNumber());
                            System.out.println(
                                    "Parking space: "
                                            + r.getParkingSpace().getSpaceNumber());
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.println("COMPLETE A RESERVATION");
                    System.out.println("----------------------------------------");
                    if (reservations.isEmpty()) {
                        System.out.println("There are no active reservations.");
                        break;
                    }
                    System.out.print("Enter reservation ID to complete: ");
                    int completeReservation;
                    try {
                        completeReservation =
                                Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid reservation ID.");
                        break;
                    }
                    Reservation foundReservation = null;
                    for (Reservation r : reservations) {
                        if (r.getReservationId() == completeReservation) {
                            foundReservation = r;
                            break;
                        }
                    }
                    if (foundReservation != null) {
                        foundReservation.getParkingSpace().setAvailable(true);
                        reservations.remove(foundReservation);
                        System.out.println("Reservation completed successfully!");
                        System.out.println(
                                "Parking space "
                                        + foundReservation.getParkingSpace()
                                        .getSpaceNumber()
                                        + " is now available.");
                    } else {
                        System.out.println("Reservation ID not found.");
                    }
                    break;
                default:
                    System.out.println(
                            "Invalid option. Please choose a number from 0 to 4.");
            }
        }

        scanner.close();
    }
}

// Betty
// 0701234567
// ABC123