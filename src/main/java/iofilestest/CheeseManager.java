package iofilestest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CheeseManager {

    public void saveToFile(Path path, List<Cheese> cheeses) {
        if (path == null || cheeses == null) {
            throw new IllegalArgumentException("Missing data.");
        }
        try (DataOutputStream dataOutputStream = new DataOutputStream
                (new BufferedOutputStream
                        (Files.newOutputStream(path)))) {
            for (Cheese cheese : cheeses) {
                dataOutputStream.writeUTF(cheese.getName());
                dataOutputStream.writeDouble(cheese.getLactoseContent());
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file.", e);
        }
    }

    public Cheese findCheese(Path path, String searchedName) {
        if (path == null || searchedName == null) {
            throw new IllegalArgumentException("Missing data.");
        }
        try (DataInputStream dataInputStream = new DataInputStream
                (new BufferedInputStream
                        (Files.newInputStream(path)))) {
            while (dataInputStream.available() > 0) {
                String name = dataInputStream.readUTF();
                double lacoseContent = dataInputStream.readDouble();
                if (searchedName.equals(name)){
                    return new Cheese(name,lacoseContent);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.", e);
        }
        return null;
    }
}
