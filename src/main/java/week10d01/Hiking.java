package week10d01;

import java.util.List;

public class Hiking {

    public double getPlusElevation(List<Double> height) {
        double elevation = 0;
        for (int i = 1; i < height.size(); i++) {
            if (height.get(i) > height.get(i - 1)) {
                elevation += height.get(i) - height.get(i - 1);
            }
        }
        return elevation;
    }


}
