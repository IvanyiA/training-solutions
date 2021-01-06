package week10d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxTravel {


    public int getMaxIndex(List<Integer> numbers) {
        int[] counters = new int[30];
        for (Integer i : numbers) {
            counters[i]++;
        }
        System.out.println(Arrays.toString(counters));

        int index = 0;
        for (int i = 1; i < counters.length; i++) {
            if (counters[index] < counters[i]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new MaxTravel().getMaxIndex(List.of(12, 12, 0, 3, 4, 4, 12));
    }


    public int getMaxIndex2(List<Integer> stations) {
        parameterCheck(stations);
        List<Integer> sortedStations = new ArrayList<>(stations);
        Collections.sort(sortedStations);
        int maxStationNumber = sortedStations.get(0);
        int maxStart = 0;
        for (int i = 0; i < 30; i++) {
            int max = 0;
            for (Integer station : stations) {
                if (station == i) {
                    max++;
                    if (max > maxStart) {
                        maxStart = max;
                        maxStationNumber = i;
                    }
                }
            }
        }
        return maxStationNumber;
    }


    private void parameterCheck(List<Integer> stations) {
        if (stations == null || stations.size() < 1 || stations.size() > 30) {
            throw new IllegalArgumentException("Maximum 30 station can exist, but there have to be at least one.");
        }
    }

}




