package week15d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CovidStatistics {

    private List<CovidCaseByWeek> workCases = new ArrayList<>();

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("data.csv"))) {
            CovidStatistics covidStatistics = new CovidStatistics();
            covidStatistics.readFromFile(bufferedReader);
            System.out.println(covidStatistics.getWorkCases());
            System.out.println(covidStatistics.findFirstThree());
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot find file", ioe);
        }
    }

    public void readFromFile(BufferedReader bufferedReader) {
        try {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Hungary")) {
                    workCases.add(getWeekAndGetCasesFrom(line));
                }
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    private CovidCaseByWeek getWeekAndGetCasesFrom(String line) {
        String[] temp = line.split(",");
        int numberOfCases = Integer.parseInt(temp[2]);
        return new CovidCaseByWeek(temp[1], numberOfCases);
    }

    public List<String> findFirstThree() {
        List<CovidCaseByWeek> sorted = new ArrayList<>(workCases);
        Collections.sort(sorted);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {               //a három legmagasabb érték kivétele a csökkenő sor elejéről
            result.add(sorted.get(i).getWeek());
        }
        return result;
    }

    public List<CovidCaseByWeek> getWorkCases() {
        return new ArrayList<>(workCases);
    }


}
