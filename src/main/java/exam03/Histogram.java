package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Histogram {

    public static final char NEW_CHAR = '*';
    public static final String LINE_BREAK = "\n";


    public String createHistogram(BufferedReader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            int numberOfStars = Integer.parseInt(line);
//            stringBuilder.append(changeNumberIn(line)).append("\n");
            for (int i = 0; i < numberOfStars; i++){
                stringBuilder.append(NEW_CHAR);
            }
            stringBuilder.append(LINE_BREAK);
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
