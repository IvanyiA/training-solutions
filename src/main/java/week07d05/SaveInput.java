package week07d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    private Scanner scanner;

    // Dependency injection, ha nincs példányosítva a konstruktorban az attributum, a függőséget kívülről kapja meg,ezáltel tesztelhető
    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Add meg a " + i + ". sort!");
            String line = scanner.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public Path readFilesNames() {
        System.out.println("Add meg a filenevet kiterjesztéssel együtt");
        String filename = scanner.nextLine();
        Path path = Path.of(filename);
        return path;

    }

    public void write(Path path, List<String> lines) {
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot write file", e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.readLines();
        Path file = saveInput.readFilesNames();

        saveInput.write(file, lines);


    }
}
