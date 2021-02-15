package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    private Boat boat;
    private LocalDate sailing;
    private double basicPrice;
    private List<Passenger> passengers;


    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
        this.passengers = new ArrayList<>();
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (passengers.size() == 5) {
            throw new IllegalArgumentException("Too many books");
        } else {
            passengers.add(passenger);
        }
    }

    public double getPriceForPassenger(Passenger passenger) {
        return passenger.getCruiseClass().getMultiplicationFactor()
                * getBasicPrice();
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (name.equals(passenger.getName())) {
                return passenger;
            }
        }
        return null;
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> nameOfPasssengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            nameOfPasssengers.add(passenger.getName());
        }
        Collections.sort(nameOfPasssengers);
        return nameOfPasssengers;
    }

    public double sumAllBookingsCharged() {
        double sum = 0.0;
        for (Passenger passenger : passengers) {
            double rate = passenger.getCruiseClass().getMultiplicationFactor();
            sum += this.basicPrice * rate;
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> map = new HashMap<>();

        for (Passenger passenger : passengers) {
            if (map.containsKey(passenger.getCruiseClass())) {
                int passengerNumber = map.get(passenger.getCruiseClass());
                passengerNumber++;
                map.replace(passenger.getCruiseClass(), passengerNumber);
            } else {
                map.put(passenger.getCruiseClass(), 1);
            }
        }
        return map;
    }
}
