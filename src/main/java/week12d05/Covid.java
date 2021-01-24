package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class Covid {

    public int wordCounter(String word, BufferedReader bufferedReader) {
        try {
            String line;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.toLowerCase().contains(word)) {
                    counter++;
                }
            }
            return counter;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
    }

    public static void main(String[] args) {
//        Path file = Path.of("src/main/resources/index.html");
        Covid covid = new Covid();
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/main/resources/index.html"));
            System.out.println(covid.wordCounter("koronavírus", bufferedReader));
            bufferedReader = Files.newBufferedReader(Path.of("src/main/resources/index.html"));
            System.out.println(covid.wordCounter("biden", bufferedReader));
            bufferedReader = Files.newBufferedReader(Path.of("src/main/resources/index.html"));
            System.out.println(covid.wordCounter("trump", bufferedReader));
        }catch (IOException e){
       throw new IllegalStateException("Cannot read file.",e );
       }
    }

}
