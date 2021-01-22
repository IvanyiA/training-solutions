package week12d04;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Enigma {


    public static void main(String[] args) {
        String result = new Enigma().printSecret(Path.of("secret.dat"));
        System.out.println(result);
    }

    public String printSecret2(Path path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            byte[] bytes = Files.readAllBytes(path);
            for (byte b : bytes) {
                char character = (char) (b + 10);
                stringBuilder.append(character);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return stringBuilder.toString();
    }

    public String printSecret(Path path) {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = Files.newInputStream(path)) {
            byte[] buffer = new byte[1000];
            int size;
            while ((size = inputStream.read(buffer)) > 0) {
                for (int i = 0; i < size; i++) {
                    char character = (char) (buffer[i] + 10);
                    stringBuilder.append(character);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        return stringBuilder.toString();
    }
}

