package week07d05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SaveInputTest {

    @TempDir
    Path tempDirectory;

    @Test
    void testReadLines() {
        Scanner scanner = new Scanner("aaa\nbbb\nccc");
        SaveInput saveInput = new SaveInput(scanner);
        List<String> lines = saveInput.readLines();

        assertEquals(List.of("aaa", "bbb", "ccc"), lines);
    }

    @Test
    void testWrite() throws IOException {
        // létrehoz egy ideiglenes file-t, ami üres
        SaveInput saveInput = new SaveInput(new Scanner(System.in));

        Path file = tempDirectory.resolve("test.txt");
        System.out.println(file);

        System.out.println(tempDirectory);

        //When
        saveInput.write(file, List.of("alma", "korte"));

        //Than
        String result = Files.readString(file);
        assertEquals("alma\r\nkorte\r\n", result);
    }

}