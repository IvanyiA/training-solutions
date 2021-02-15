package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Histogram {

    public static final char NEW_CHAR = '*';


    public String createHistogram(BufferedReader reader) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(changeNumberIn(line)).append("\n");
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");

        }
        return stringBuilder.toString();
    }

    private String changeNumberIn(String line) {
        int numberOfStars = Integer.parseInt(line);
        char[] result = new char[numberOfStars];
        Arrays.fill(result, NEW_CHAR);
        return String.valueOf(result);
    }

    private String changeNumberIn2(String line) {
        int numberOfStars = Integer.parseInt(line);
        return "*".repeat(Math.max(0, numberOfStars));
    }
}
