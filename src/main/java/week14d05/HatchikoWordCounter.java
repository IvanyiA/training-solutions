package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class HatchikoWordCounter {

    public Map<String, Integer> countWords(BufferedReader reader, String... words) {
        Map<String, Integer> result = new HashMap<>();
//        Map<String, Integer> result = loadMapWithZero(words);
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                for (String word : words) {
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        Integer prevalenceValue = result.get(word);
                        if (prevalenceValue == null) {
                            result.put(word, 1);
                        } else {
                            result.put(word, prevalenceValue + 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return result;
    }

    private void loadMapWithZero(String[] words) {
        Map<String, Integer> result = new HashMap<>();
        for (String word : words) {
            result.put(word, 0);
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("hachiko.srt"),
                Charset.forName("windows-1250"))) {

            System.out.println(new HatchikoWordCounter().countWords(reader, "Hach", "haza", "pályaudvar", "jó"));

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }

    }



    public Map<String, Integer> countWords2(String fileName, String... words) {
        Map<String, Integer> result = new HashMap<>();
        loadMapWithZero(words);

        InputStream inputStream =
                HatchikoWordCounter.class.
                        getResourceAsStream(fileName);

        try (BufferedReader bufferedReader = new BufferedReader
                (new InputStreamReader(inputStream))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                loadingMap(result, line, words);
                for (String word : words) {
                    if (line.toLowerCase().contains(word.toLowerCase())) {
                        Integer prevalenceValue = result.get(word);
                        if (prevalenceValue == null) {
                            result.put(word, 1);
                        } else {
                            result.put(word, prevalenceValue + 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return result;
    }

    private void loadingMap(Map<String, Integer> result, String line, String[] words) {
        for (String word : words) {
            if (line.contains(word)) {
                result.replace(word, result.get(word) + 1);
            }
        }
    }


}

