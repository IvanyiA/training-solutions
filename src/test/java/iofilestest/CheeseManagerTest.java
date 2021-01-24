package iofilestest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheeseManagerTest {


    @TempDir
    Path folder;

    @Test
    public void saveToFileTest() {
        CheeseManager cheeseManager = new CheeseManager();
        Path file = folder.resolve("cheese.dat");
        List<Cheese> cheeses = List.of(
                new Cheese("trappista", 0.27),
                new Cheese("Pannónia", 0.09));
        cheeseManager.saveToFile(file, cheeses);

        assertTrue(Files.exists(file));
    }

    @Test
    public void findCheeseTest() {
        CheeseManager cheeseManager = new CheeseManager();
        Path file = folder.resolve("cheese.dat");
        List<Cheese> cheeses = List.of(
                new Cheese("trappista", 0.27),
                new Cheese("Pannónia", 0.09));
        cheeseManager.saveToFile(file, cheeses);

        Cheese cheese = cheeseManager.findCheese(file, "trappista");
        assertEquals("trappista", cheese.getName());
        assertEquals(0.27, cheese.getLactoseContent());
    }


}