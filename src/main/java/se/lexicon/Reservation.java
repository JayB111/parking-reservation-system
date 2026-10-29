package se.lexicon;

import java.time.LocalDateTime;

public class Reservation {

    private int reservationId;
    private String personName;
    private String phoneNumber;
    private String registrationNumber;
    private ParkingSpace parkingSpace;
    private LocalDateTime startTime;
    private int parkingDurationHours;
    private LocalDateTime expectedEndTime;

    public Reservation(int reservationId, String personName,
                       String phoneNumber, String registrationNumber,
                       ParkingSpace parkingSpace, int parkingDurationHours) {

        this.reservationId = reservationId;
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.registrationNumber = registrationNumber;
        this.parkingSpace = parkingSpace;
        this.startTime = LocalDateTime.now();
        this.parkingDurationHours = parkingDurationHours;
        this.expectedEndTime = startTime.plusHours(parkingDurationHours);
    }

    public int getReservationId() {
        return reservationId;
    }

    public String getPersonName() {
        return personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getParkingDurationHours() {
        return parkingDurationHours;
    }

    public LocalDateTime getExpectedEndTime() {
        return expectedEndTime;
    }
}