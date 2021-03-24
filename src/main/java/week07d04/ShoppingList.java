package week07d04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {

    public static final String LINE_SEPARATOR = ";";
    public static final int INDEX_OF_AMOUNT = 1;
    public static final int INDEX_OF_PRICE = 2;

    public long calculateSum(String stringPath) { //throws tovább engedem, tovább dobom
        long sum = 0;
        //lekezelem
        try {
            //Scanner-rel is meg lehet csinálni
            //String scanner = new Scanner(Path.of(stringPath), StandardCharsets.UTF_8);
            List<String> lines = Files.readAllLines(Path.of(stringPath), StandardCharsets.UTF_8);
            for (String line : lines) {
                long result = calculateLineSum(line);
                sum += result;
            }

        } catch (
                IOException e) {
            // e.printStackTrace(); lenaplózom
            //új kivételt dobok, ami nem kezelendő
            throw new IllegalStateException("Cannot read file", e);
        }
        return sum;
    }

    private long calculateLineSum(String line) {
        String[] parts = line.split(LINE_SEPARATOR);

        long amount = Long.parseLong(parts[INDEX_OF_AMOUNT]);
        long price = Long.parseLong(parts[INDEX_OF_PRICE]);

        long result = amount * price;
        return result;
    }

}


