package se.lexicon;

public class Reservation {
    private int reservationId;
    private String personName;
    private String phoneNumber;
    private String registrationNumber;
    private ParkingSpace parkingSpace;
    public Reservation(int reservationId, String personName,
                       String phoneNumber, String registrationNumber,
                       ParkingSpace parkingSpace) {
        this.reservationId = reservationId;
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.registrationNumber = registrationNumber;
        this.parkingSpace = parkingSpace;
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
}
