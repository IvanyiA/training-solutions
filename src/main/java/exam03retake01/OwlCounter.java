package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> numberOfOwlsByCounty = new HashMap<>();


    public void readFromFile(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            String county = parts[0];
            int owlNumber = Integer.parseInt(parts[1]);
            numberOfOwlsByCounty.put(county, owlNumber);
        }
    }

    public int getNumberOfOwls(String county) {
        return numberOfOwlsByCounty.get(county);
    }

}

