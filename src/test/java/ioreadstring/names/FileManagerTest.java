package ioreadstring.names;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    private final FileManager fileManager = new FileManager("src/test/resources/names.txt");

    @Test
    void createClassTest() {
        assertEquals("names.txt",fileManager.getMyFile().getFileName().toString());
        assertEquals(0, fileManager.getHumans().size());
    }


    @Test
    void readFromFileTest() {
        fileManager.readFromFile();
        assertEquals(2,fileManager.getHumans().size());
        assertEquals("John", fileManager.getHumans().get(1).getFirstName());

    }
}