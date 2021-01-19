package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {

    private final List<String> ids = new ArrayList<>();

    public void readIdsFromFile(String fileName) {

        Path file = Path.of("src/main/resources/" + fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(file)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ids.add(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't open file", ioe);
        }
    }

    public List<String> getIds() {
        return new ArrayList<>(ids);
    }

}
