package week13d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Fly> flies = new ArrayList<>();

    public List<Fly> getFlies() {
        return new ArrayList<>(flies);
    }

    public void readFiles() {
        try (BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader
                        (Airport.class.getResourceAsStream("/cities.txt")))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitline = line.split(" ");
                flies.add(new Fly(splitline[0], splitline[1], splitline[2],
                        makeLocalTimeFromString(splitline[3])));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read line.", e);
        }
    }

    public LocalTime makeLocalTimeFromString(String s) {
        String[] time = s.split(":");
        return LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
    }

    public String whichIsMore() {
        int arrivals = 0;
        int departures = 0;
        for (Fly fly : flies) {
            if (fly.getType().equals("Arrival")) {
                arrivals++;
            } else {
                departures++;
            }
        }
        return arrivals > departures ? "Arrival" : "Departure";
    }

    public Fly searchFlyByRegNumber(String regNumber) {
        for (Fly fly : flies) {
            if (fly.getRegNumber().equals(regNumber)) {
                return fly;
            }
        }
        throw new IllegalArgumentException("Invalid fly registration number.");
    }

    public List<Fly> searchFliesByCity(String city, String type) {
        List<Fly> result = new ArrayList<>();
        for (Fly fly : flies) {
            if (fly.getCity().equals(city) && fly.getType().equals(type)) {
                result.add(fly);
            }
        }
        return result;
    }

    public Fly searchEarliestFly() {
        Fly earliestFly = firstArrival();
        for (Fly fly : flies) {
            if (fly.getType().equals("Departure") && fly.getTime().isBefore(earliestFly.getTime())) {
                earliestFly = fly;
            }
        }
        return earliestFly;
    }

    private Fly firstArrival() {
        for (Fly fly : flies) {
            if (fly.getType().equals("Departure")) {
                return fly;
            }
        }
        throw new IllegalStateException("No departure.");
    }

}
