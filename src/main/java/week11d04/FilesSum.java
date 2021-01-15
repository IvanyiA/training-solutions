package week11d04;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int readFile(String name) {
//        Path path = Path.of(name);
        try {
            String fileContent = Files.readString(Path.of(name));
            return Integer.parseInt(fileContent);
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        } catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Invalid number", nfe);
        }
    }


    public int sumNumbers() {
        int sum = 0;
//        number00.txt
        for (int i = 0; i < 100; i++) {
//            String filename = "number" + (i < 10 ? "0" + i : i) + ".txt";
//            String filename;
//            if (i < 10) {
//                filename = "number0" + i + ".txt";
//            } else {
//                filename = "number" + i + ".txt";
//            }
            String filename = String.format("number%02d.txt", i);
            System.out.println(filename);

            if (Files.isRegularFile(Path.of(filename))) {
                System.out.println("found");
                int number = readFile(filename);
                sum += number;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(new FilesSum().readFile("number20.txt"));
        System.out.println(new FilesSum().sumNumbers());
    }

}
