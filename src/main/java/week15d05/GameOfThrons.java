package week15d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameOfThrons {


    public String getHouse(BufferedReader reader) throws IOException {
        reader.readLine();  //header eltüntetése
        Map<String, Integer> numberOfBattles = new HashMap<>();
        String line;
        int rowNumber = 0;
        while ((line = reader.readLine()) != null) {
            rowNumber++;       //hibás sor kiírásához ..
            System.out.println(rowNumber);

//            System.out.println(line);
            List<String> houses = getHousesFromLine(line);
//            System.out.println(houses);
            countHouses(numberOfBattles, houses);
        }
//        System.out.println(numberOfBattles);
        List<String> houses = new ArrayList<>(numberOfBattles.keySet());
        String house = houses.get(0);
        int max = numberOfBattles.get(house);
//        String house = null;
        house = getMax(numberOfBattles, max, house);
        return house;
    }

    private String getMax(Map<String, Integer> numberOfBattles, int max, String house) {
        for (Map.Entry<String, Integer> numberOfBattle : numberOfBattles.entrySet()) {
            if (numberOfBattle.getValue() > max) {
                max = numberOfBattle.getValue();
                house = numberOfBattle.getKey();
            }
        }
        return house;
    }

    private void countHouses(Map<String, Integer> numberOfBattles, List<String> houses) {
        for (String house : houses) {
            if (numberOfBattles.containsKey(house)) {
                numberOfBattles.put(house, numberOfBattles.get(house) + 1);
            } else {
                numberOfBattles.put(house, 1);
            }
        }
    }

    private List<String> getHousesFromLine(String line) {
        String[] parts = line.split(",");
        List<String> houses = new ArrayList<>();
        for (int i = 5; i <= 12; i++) {
            if (!parts[i].isBlank())
                houses.add(parts[i]);
        }
        return houses;
    }


    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("battles.csv"))) {
            String house = new GameOfThrons().getHouse(reader);
            System.out.println(house);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
