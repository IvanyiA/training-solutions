package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class BalatonStorm {

    private List<String> stationsWithStorm = new ArrayList<>();
    private String station;

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        reader.readLine();
        String line;
        while ((line = reader.readLine()) != null) {
            extractStations(line);
            extractLevels(line, station);
        }
        return stationsWithStorm;
    }

    private void extractStations(String line) {
        if (line.contains("allomas")) {
            String[] parts = line.split(":");
            station = parts[1].substring(2, parts[1].length()-2);
        }
    }

    private void extractLevels(String line, String station) {
        if (line.contains("level")) {
            String[] parts = line.split(":");
            int stormLevel = Integer.parseInt(parts[1].replace(",", "").trim());
            getSortedStationsByLevel(station, stormLevel);
        }
    }

    private void getSortedStationsByLevel(String station, int stormLevel) {
        if (stormLevel >= 3) {
            stationsWithStorm.add(station);
            stationsWithStorm.sort(Collator.getInstance(new Locale("hu", "HU")));
        }
    }

}


