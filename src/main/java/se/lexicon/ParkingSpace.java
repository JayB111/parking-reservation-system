package se.lexicon;

public class ParkingSpace {
    private int spaceNumber;
    private boolean available;
    public ParkingSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.available = true;
    }
    public int getSpaceNumber() {
        return spaceNumber;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public boolean isAvailable() {
        return available;
    }
}