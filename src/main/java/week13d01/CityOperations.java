package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CityOperations {

    public String findCityWithMaxLenght(BufferedReader reader) {
        try {
           return findCity(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.");
        }
    }


    public String findCity(BufferedReader reader) throws IOException {
        String maxCityName = "";
        int rowNumber = 0;
        String line;
        skipHeader(reader);
        rowNumber++;
        while ((line = reader.readLine()) != null) {
            rowNumber++;
            String name = getNameFromLine(line, rowNumber);
            if (name.length() > maxCityName.length()) {
                maxCityName = name;
            }
        }
        if ("".equals(maxCityName)) {
            throw new IllegalArgumentException("No city found.");
        }
        return maxCityName;
    }

    private String getNameFromLine(String line, int rowNumber) {
        String[] parts = line.split(";");
        if (parts.length <= 1) {
            throw new IllegalArgumentException("Illegal line." + rowNumber + ": " + line);
        }
        String name = parts[1];
        return name;
    }

    private void skipHeader(BufferedReader reader) throws IOException {
        reader.readLine();
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("iranyitoszamok-varosok-2021.txt"))) {
            String city = new CityOperations().findCityWithMaxLenght(bufferedReader);
            System.out.println(city);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.");
        }
    }
}
