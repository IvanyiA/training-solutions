package ioreadstring.names;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final Path txtFile;
    private final List<Human> humans = new ArrayList<>();

    public FileManager(String path) {
        this.txtFile = Path.of(path);
    }

    public void readFromFile() {
        try {
            List<String> names = Files.readAllLines(txtFile, StandardCharsets.UTF_8);
            for (String name : names) {
                String[] row = name.split(" ");
                Human human = new Human (row[0], row[1]);
                humans.add(human);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    public Path getMyFile() {
        return txtFile;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
