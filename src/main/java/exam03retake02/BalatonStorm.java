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
            if (line.contains("allomas")) {
                String[] parts = line.split(":");
                station = parts[1].substring(2, parts[1].length()-2);
            }
            if (line.contains("level\": 3,")) {
                String[] parts = line.split(":");
                stationsWithStorm.add(station);
                stationsWithStorm.sort(Collator.getInstance(new Locale("hu", "HU")));
            }
        }
        return stationsWithStorm;
    }

}


