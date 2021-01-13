package week11d02;

public class Ride {

    private final int day;
    private final int ride;
    private final double km;

    public Ride(int day, int ride, double km) {
        if (day < 1 || day > 7) {
            throw new IllegalArgumentException("Invalid day");
        }
        this.day = day;
        this.ride = ride;
        if (km == 0.0) {
            throw new IllegalArgumentException("Invalid km.");
        }
        this.km = km;
    }

    public int getDay() {
        return day;
    }

    public int getRide() {
        return ride;
    }

    public double getKm() {
        return km;
    }
}
