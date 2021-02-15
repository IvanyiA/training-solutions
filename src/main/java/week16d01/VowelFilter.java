package week16d01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VowelFilter {

//    private char[] vowelsSet = new char[]{'a', 'A', 'á', 'Á', 'e', 'E', 'é', 'É', 'i', 'I', 'í', 'Í', 'o', 'O', 'ó', 'Ó', 'ö', 'Ö', 'ő', 'Ő', 'u', 'U', 'ú', 'Ú', 'ü', 'Ü', 'ű', 'Ű'};

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("Aprócska.txt"))) {
            new VowelFilter().readLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public void readLines(BufferedReader reader) throws IOException {
        List<String> temp = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            String newLine = line.replaceAll("[aAáÁeEéÉiIíÍoOóÓöÖőŐuUúÚüÜűŰ]", "");
            temp.add(newLine);
        }
        for (String element : temp) {
            System.out.println(element);
        }
    }

}
