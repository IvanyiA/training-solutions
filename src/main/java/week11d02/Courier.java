package week11d02;

import java.util.ArrayList;
import java.util.List;

public class Courier {

    private final List<Ride> rides = new ArrayList<>();

    public List<Ride> getRides() {
        return rides;
    }

    public void addRide(Ride ride) {
        int a = rides.size();
        if (a == 0) {
            if (ride.getRide() == 1) {
                rides.add(ride);
            } else {
                throw new IllegalArgumentException("Invalid ride");
            }
        }
        if (a != 0) {
            Ride last = rides.get(a - 1);
            if (last.getDay() == ride.getDay() &&
                    last.getRide() + 1 == ride.getRide()) {
                rides.add(ride);
            } else if (last.getDay() < ride.getDay() && ride.getRide() == 1) {
                rides.add(ride);
            } else {
                throw new IllegalArgumentException("Invalid ride");
            }
        }
    }

    public int noWork() {
        if (rides.get(0).getDay() > 1) {
            return 1;
        }

        for (int i = 1; i < rides.size(); i++) {
            if ((rides.get(i).getDay() - rides.get(i - 1).getDay()) > 1) {
                return rides.get(i - 1).getDay() + 1;
            }
        }
        if (rides.get(rides.size() - 1).getDay() < 8) {
            return rides.get(rides.size() - 1).getDay() + 1;
        } else {
            return -1;
        }
    }
}

