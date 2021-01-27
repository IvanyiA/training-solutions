package week13d01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CityOperationsTest {

    @Test
    public void findCityWithMaxLenghtTest() {
        try (BufferedReader file = Files.newBufferedReader(Path.of("iranyitoszamok-varosok-2021.txt"))) {

            assertEquals("Jászfelsőszentgyörgy", new CityOperations().findCityWithMaxLenght(file));
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file.");
        }
    }

}